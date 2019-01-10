package com.ybinsure.icar.user.wallet.servlet;

import com.ybinsure.icar.user.util.JsonUtil;
import com.ybinsure.icar.user.wallet.dto.SignRspCommonParam;
import com.ybinsure.icar.user.wallet.util.AygUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 佳灯的爱员工模块
 * 上传身份证正反面
 * Servlet implementation class uploadIdentityServlet
 */
@WebServlet("/uploadIdentity")
public class UploadIdentityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadIdentityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpResponse resp = null;
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        String flag = "1";
        String msg = "";
        try {

            String auth = (String) request.getAttribute("auth");
            String extrSystemId = AygUtils.YB_EXTRSYSTEM_ID;
            String identity = (String) request.getAttribute("identity");
            String identityType = (String) request.getAttribute("identityType");
            String name = (String) request.getAttribute("name");
            System.out.println("userId " + auth + name + "  " + identity + "  " + identityType);
            Map<String, String> param = new HashMap<String, String>();
            Enumeration<String> em = request.getAttributeNames();
            while (em.hasMoreElements()) {
                String emName = em.nextElement();
                param.put(emName, (String) request.getAttribute(name));
            }

            //文件保存位置
            String storePath = request.getServletContext().getRealPath("/WEB-INF/upload");
            //文件保存位置
            File saveDir = new File(storePath);
            if (!saveDir.exists()) {
                saveDir.mkdir();
            }

            System.out.println("frontfile " + request.getAttribute("frontfile") + "  " + request.getAttribute("frontfile_path"));
            System.out.println("path " + param.get("frontfile_path"));
            //省份证正面照
            String frontpath = (String) request.getAttribute("frontfile_path");
            String frontPath = frontpath.replace("/s/files", "http://ybinsure.com");
            String frontName = (String) request.getAttribute("frontfile_name");
            String frontSize = (String) request.getAttribute("frontfile_size");
            String frontMd5 = (String) request.getAttribute("frontfile_md5");
            System.out.println(saveDir + File.separator + frontpath.split("/")[5] + ".jpg");
            byte[] frontData = AygUtils.readInputStream(frontPath);
            File frontFile = new File(saveDir + File.separator + frontpath.split("/")[5] + ".jpg");
            FileOutputStream frontFos = new FileOutputStream(frontFile);
            frontFos.write(frontData);
            if (frontFos != null) {
                frontFos.close();
            }

            //省份证反面照
            String backpath = (String) request.getAttribute("backfile_path");
            String backPath = backpath.replace("/s/files", "http://ybinsure.com");
            String backName = (String) request.getAttribute("backfile_name");
            String backSize = (String) request.getAttribute("backfile_size");
            String backMd5 = (String) request.getAttribute("backfile_md5");
            byte[] backData = AygUtils.readInputStream(backPath);
            File backFile = new File(saveDir + File.separator + backpath.split("/")[5] + ".jpg");
            FileOutputStream backFos = new FileOutputStream(backFile);
            backFos.write(backData);
            if (backFos != null) {
                backFos.close();
            }

            Charset utf8 = Charset.forName("UTF-8");
            ConnectionConfig connectionConfig = ConnectionConfig.custom().setCharset(utf8).build();
            httpClient = HttpClients.custom().setDefaultConnectionConfig(connectionConfig).build();

            StringBuilder sb = new StringBuilder();
            sb.append(extrSystemId).append("&" + name).append("&" + identity).append("&" + identityType).append("&" + DigestUtils.md5Hex(FileUtils.readFileToByteArray(frontFile))).append("&" + DigestUtils.md5Hex(FileUtils.readFileToByteArray(backFile)));
            String sign = AygUtils.sign256(sb.toString(), AygUtils.YB_PRIVATE_KEY);
            System.out.println("sign " + sign);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE).setCharset(utf8);
            ContentType contentType = ContentType.create("multipart/form-data", utf8);
            builder.setContentType(contentType);

            //设置上传参数
            builder.addPart("extrSystemId", new StringBody(extrSystemId, ContentType.TEXT_PLAIN));
            builder.addPart("name", new StringBody(name, ContentType.TEXT_PLAIN));
            builder.addPart("identity", new StringBody(identity, ContentType.TEXT_PLAIN));
            builder.addPart("identityType", new StringBody(identityType, ContentType.TEXT_PLAIN));
            builder.addPart("sign", new StringBody(sign, ContentType.TEXT_PLAIN));
            builder.addPart("frontfile", new FileBody(frontFile));
            builder.addPart("backfile", new FileBody(backFile));

            HttpEntity reqEntity = builder.build();
            // httpPost = new HttpPost(AygUtils.SIGN_UPLOAD_IDENTITY_URL);
            httpPost.setEntity(reqEntity);
            httpPost.addHeader(new BasicHeader(HttpHeaders.ACCEPT_CHARSET, "utf-8"));
            httpPost.addHeader(new BasicHeader(HttpHeaders.ACCEPT_LANGUAGE, "zh-cn"));
            httpPost.addHeader(new BasicHeader(HttpHeaders.EXPECT, "100-continue"));
            resp = httpClient.execute(httpPost);
            String code = resp.getStatusLine().getStatusCode() + "";

            if ("200".equals(code)) {
                String resultJson = EntityUtils.toString(resp.getEntity());
                SignRspCommonParam commParam = JsonUtil.toPojo(resultJson, SignRspCommonParam.class).orElseGet(SignRspCommonParam::new);
                System.out.println("证件上传" + resultJson);
                // map.put("msg",commParam.getResultMessage());
                if ("ACCEPTED".equals(commParam.getResultCode())) {
                    //map.put("code", "0");
                    flag = "0";
                }
                frontFile.delete();
                backFile.delete();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        String temp = "{\"code\":\"" + flag + "\",\"msg\":" + "\"" + msg + "\"}";
        writer.write(temp);
        writer.flush();
        writer.close();

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
