/**
 * 
 */
package com.imooc.security.core.social;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author zhailiang
 * 
 * 可以查看当前关联的社交帐号信息
 * 比如我们登陆了一个第三方后台   同时 之前我们也用社交帐号进行了关联 
 * 我们就可以在第三方后台看到绑定的社交账号 同时也可以对其进行解绑操作
 * springSocial为我们提供了一个默认的org.springframework.social.connect.web.ConnectController
 * 其对以上功能都以实现 只是未展示相关视图页面  所以我们定义就好了
 * 在此类中org.springframework.social.connect.web.ConnectController.connectionStatus(NativeWebRequest, Model)
 * 中会返回一个视图 即当前我们类中@Component注入的值"connect/status"
 * 
 */
@Component("connect/status")
public class ImoocConnectionStatusView extends AbstractView {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.view.AbstractView#renderMergedOutputModel(java.util.Map, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 * org.springframework.social.connect.web.ConnectController.connectionStatus(NativeWebRequest, Model)
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Map<String, List<Connection<?>>> connections = (Map<String, List<Connection<?>>>) model.get("connectionMap");
		
		Map<String, Boolean> result = new HashMap<>();
		for (String key : connections.keySet()) {
			result.put(key, CollectionUtils.isNotEmpty(connections.get(key)));
		}
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(objectMapper.writeValueAsString(result));
	}

}
