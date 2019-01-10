package com.ybinsure.icar.user.wallet.util;

import com.ybinsure.icar.user.util.StrUtil;
import com.ybinsure.icar.user.wallet.dto.IObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class AygUtils {
	
	
	//templateId(模板id) 225：API返回链接，不发短信  219：【爱员工-电子签约】平台会发签约短信
	public static final String templateId = "225";
	
	//悦保给爱员工 extrSystemId(appId)
	public static final String YB_EXTRSYSTEM_ID = "ybinsure";
	
	//悦保的私钥  加密
	public static final String YB_PRIVATE_KEY = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAUuCSrT54uPTaMNkk8GdOSnB7gvVVpZgNYe+eECtZPFg5wF4uZTy0BSeGFxZZq4kUKSRnybPKhi9+jdmzLOMmu6hUb4Os+HOSk"
		+ "+7RVO9G9Ip0bLDqSWLiH4qS0kTB+TvPfe2WNBnfG6BbtLbiGSyGs0cCpXAxrk9WhgaF3jzQcFnAgMBAAECgYAy7ri1p3Lhl/iPlKNS6un+bWo6bTOZdPykd3IYVcudfkrfogG5TbkEgemyPpYVCUVOk4UFPGz2UjHgUy3"
		+ "+JAslY2Hu/ebmSgVCnMWrxiEUp8sKdXatjA70D/SiEjw+Kx8j163gIk0urgooi4KitEH2ZOzHhV+/AWgrFg4rJYt0SQJBAYTr/zOYFrPoK2oz9xOxeEzTMieVRVsKqSlxNZoQ90hGuMgew8krlpSL9aCEG4d5uD0WT2EKgtfra/"
		+ "6KKNaxb2UCQQDaNYfxaJ8e3pq+Vd4G7kJZRvS8fZC+jSJy6grBVx/oRhAaZXqtSGcpZpl1AW7ML3fNAAJ8iNHdE2+39R3HOT7bAkBHxT09Ci32WTvZx2krCy8GDltNDrDT0i3RZgDcQ5E+lz52P6clspOBKirTyk1CPOYQ79MKN2R"
		+ "Z8CnnuRs8M1Y5AkAW236nAg+Q+z54a6Q7U5/tnCosyHZuD3ipUuzXfdngyd4L9c9Y8Xmk85Nll0XU66//8F1SUD6zisKsIWgCI3P7AkAl7OHcPytzGYqRtfw3NzIsSHw/fCJZXJDJWS4WNvj6J/1BBzjcKOs3Jz56WlBglLeA2LZw5"
		+ "XYi74xM6pibc8iA";
	
	//爱员工给悦保提供 extrSystemId(appId)
	public static final String AYG_EXTRSYSTEM_ID = "ybinsure";

	//爱员工给悦保公钥 签名校验
	public static final String AYG_SIGN_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDgjEtwq/rfKCvpp4sgize3vpIViiPJM/KrBmX+oQtDFe32"
			+ "bQDwfPArwuZyB3n1mLEArU8i8UwMDv8PeNTFV1XlUU8FyHJOLfrxfixB3Ai/V9t7ibZXwzucbLE49OcrQlcnZvstJI5i0ZwLMjJp5OBr/3yGXCiR5wu9OCmU"
			+ "d4v2gQIDAQAB";
	
	// 请求超时时间
	private static int connectionRequestTimeout = 60000;
	
	// 连接超时时间，默认10秒
	private static int socketTimeout = 30000;
	
	// 传输超时时间，默认30秒
	private static int connectTimeout = 30000;
	
	public static String sendPostStr(String targetUrl, String str) {
        HttpResponse response = null;
		// CloseableHttpClient httpClient = null;
		HttpPost httpPost = null;
        String result = null;
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
			// httpClient = HttpClientBuilder.create().build();
            httpPost = new HttpPost(targetUrl);
            httpPost.setConfig(RequestConfig.custom().setConnectionRequestTimeout(connectionRequestTimeout)
                    .setConnectTimeout(connectTimeout).setSocketTimeout(socketTimeout).build());
            
            HttpEntity httpEntity = new StringEntity(str, "UTF-8");
            httpPost.addHeader("Content-Type", "application/json");
            httpPost.setEntity(httpEntity);
            response = httpClient.execute(httpPost);
            result = EntityUtils.toString(response.getEntity());
        } catch (ClientProtocolException e) {
           e.printStackTrace();
        } catch (IOException e) {
           e.printStackTrace();      
        } finally {
            if (null != httpPost) {
                httpPost.abort();
            }
            /*if (null != httpClient) {
                httpClient.getConnectionManager().shutdown();
            }*/
        }
        return result;
    }
	
	/**
	 * 签名算法
	 * 
	 * @param obj
	 * @param privateKey
	 * @return
	 * @date 2018年1月26日 上午11:26:38
	 */
	public static String digest(Object obj,String privateKey) {
        try {
            String signData = sign256(toSignStr(obj),privateKey);
            return signData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	/**
	 * SHA256运算
	 * 
	 * @throws NoSuchAlgorithmException 
	 * @throws SignatureException 
	 * @throws IOException 
	 * @throws InvalidKeySpecException 
	 * @throws InvalidKeyException 
	 */
	public static final String sign256(String data, String privateKey) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, InvalidKeySpecException, IOException {
		
	     System.out.println("签名字符串" + data);
		Signature signature = Signature.getInstance("SHA256withRSA");
		signature.initSign(getPrivateKey(privateKey));
		signature.update(data.getBytes("UTF-8"));
		return Base64.encodeBase64String(signature.sign());
	}
	
	/**
	 * 获取签名的字符串
	 * 
	 * @param bean
	 * @return
	 * @throws Exception
	 * @date 2018年1月26日 上午10:47:39
	 */
	public static String toSignStr(Object bean) {
        StringBuilder sb = new StringBuilder();
        try {
			buildSignStr(bean, sb, 1);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | IntrospectionException e) {
			e.printStackTrace();
		}
        String temp = sb.toString();
        return sb.toString();
    }

    /**
     * 生成签名字符串
     * @param bean
     * @param sb
     * @param level
     * @throws IntrospectionException 
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     * @date 2018年1月26日 上午10:46:54
     */
    private static void buildSignStr(Object bean, StringBuilder sb, int level) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
        if (bean==null) {
            return;
        }
        if(bean instanceof IObject) {
            Map<String, Object> map = transBean2Map(bean);
            Set<String> keySet = map.keySet();
            Iterator<String> iter = keySet.iterator();
            if (level != 1) {
                sb.append("{");
            }
            boolean isFirst = true;
            while (iter.hasNext()) {
                if(!isFirst) {
                    sb.append("&");
                }
                String key = iter.next();
                Object value = map.get(key);
                sb.append(key).append("=");
                buildSignStr(value, sb, level + 1);
                isFirst = false;
            }
            if (level != 1) {
                sb.append("}");
            }
        } else if(bean instanceof Iterable) {
            sb.append("[");
            Iterator<?> it = ((Iterable<?>)bean).iterator();
            boolean isFirst = true;
            while (it.hasNext()) {
                if(!isFirst) {
                    sb.append("&");
                }
                buildSignStr(it.next(), sb, level + 1);
                isFirst = false;
            }
            sb.append("]");
        } else {
            sb.append(bean);
        }
    }
	
	/**
	 * 获取公钥
	 * @param key 秘钥字符串(经过base64编码)
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @date 2018年1月31日 下午4:06:12
	 */
	private static PublicKey getPublicKey(String key) throws NoSuchAlgorithmException, InvalidKeySpecException {
		byte[] keyBytes = Base64.decodeBase64(key);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(keySpec);
		return publicKey;
	}
	
	/**
	 * 获取私钥
	 * @param key 秘钥字符串(经过base64编码)
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @date 2018年1月31日 下午4:11:19
	 */
	private static PrivateKey getPrivateKey(String key) throws NoSuchAlgorithmException, InvalidKeySpecException {
		byte[] keyBytes = Base64.decodeBase64(key);
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
		return privateKey;
	}
	
	/**
	 * 签名校验
	 * @param signString
	 * @param sign
	 * @param systemId
	 * @date 2018年1月31日 下午5:30:17
	 */
	public static final boolean check(String signString, String sign, String systemId, String publicKey) {
		boolean verify = false;
        if (StrUtil.isBlank(signString)) {
            throw new RuntimeException("签名对象不能为空");
        }

        if (sign == null || "".equals(sign)) {
            throw new RuntimeException("sign对象不能为空");
        }
        try {
            verify = verify256(signString, sign, publicKey);
        } catch (Exception e) {
            throw new RuntimeException("签名校验不通过");
        }
        return verify;
    }
	
	/**
	 * 签名验证
	 * 
	 * @param data
	 * @param sign
	 * @param publicKey
	 * @return
	 * @date 2018年1月26日 上午10:48:04
	 */
	private static final boolean verify256(String data, String sign, String publicKey) {
		if(data == null || sign == null || publicKey == null) {
			return false;
		}
		try {
			Signature signature= Signature.getInstance("SHA256withRSA");
			signature.initVerify(getPublicKey(publicKey));
			signature.update(data.getBytes("UTF-8"));
			return signature.verify(Base64.decodeBase64(sign.getBytes("UTF-8")));
		} catch (Exception e) {
			return false;
		}
	}
	
	
	/**
	 * 获取当前日期
	 * @return
	 * @date 2018年1月31日 下午12:12:45
	 */
	public static final String currentNowDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	/**
	 * 生成32位uuid
	 * @return
	 * @date 2018年2月1日 下午4:02:58
	 */
	public static final String randomUUID() {
		return java.util.UUID.randomUUID().toString().replace("-", "");
	}
	
	/**
	 * 生成签约系统订单号
	 */
	public static final String getSignOrderID(String userId) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		return sdf.format(date)+userId;
	}
	/**
	 * 生成系统订单号
	 */
	public static final String getPayOrderID(String userId) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date)+userId;
	}
	
	/**
	 * java bean转map
	 * @param obj
	 * @return
	 * @date 2018年1月31日 下午5:00:31
	 */
	public static Map<String, Object> transBean2Map(Object obj) {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new TreeMap<>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);
                    if (null != value && !StrUtil.isBlank(String.valueOf(value)) && !key.equalsIgnoreCase("sign") && !key.equalsIgnoreCase("signType")) {
                        map.put(key, value);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("bean2Map excption!");
        }
        return map;
    }
	
	/**
	 * map转java bean
	 * @param map
	 * @param beanClass
	 * @return
	 * @date 2018年2月1日 下午3:02:39
	 */
	public static Object transMap2Bean(Map<String, Object> map, Class<?> beanClass) {
		if(map == null) {
			return null;
		}
		try {
			Object obj = beanClass.newInstance();  
	        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());    
	        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();    
	        for (PropertyDescriptor property : propertyDescriptors) {  
	            Method setter = property.getWriteMethod();    
	            if (setter != null) {  
	                setter.invoke(obj, map.get(property.getName()));   
	            }  
	        } 
		    return obj;  
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("transMap2Bean exception");
		}
		
	}
	

	
	/** 
     * 从输入流中获取字节数组 
     * @return
     * @throws IOException 
     */  
    public static  byte[] readInputStream(String downUrl) throws IOException {    
    	URL url = new URL(downUrl); 
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();    
        //设置超时间为3秒  
        conn.setConnectTimeout(3*1000);  
        //防止屏蔽程序抓取而返回403错误  
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");  
        //得到输入流  
        InputStream inputStream = conn.getInputStream();    

        byte[] buffer = new byte[1024];    
        int len = 0;    
        ByteArrayOutputStream bos = new ByteArrayOutputStream();    
        while((len = inputStream.read(buffer)) != -1) {    
            bos.write(buffer, 0, len);    
        }    
        bos.close();    
        return bos.toByteArray();    
    }  
    
}
