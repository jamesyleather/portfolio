package com.portfolio.biz.auth;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.portfolio.biz.user.dto.UserVO;

public class SNSLogin {
	private OAuth20Service oauthService;
	private SnsValue sns;

	public SNSLogin(SnsValue sns) {
		this.oauthService = new ServiceBuilder(sns.getClientId()).apiSecret(sns.getClientSecret())
				.callback(sns.getRedirectUrl()).scope("profile").build(sns.getApi20Instance());

		this.sns = sns;
	}

	public String getNaverAuthURL() {
		return this.oauthService.getAuthorizationUrl();
	}

	public UserVO getUserProfile(String code) throws Exception {
		OAuth2AccessToken accessToken = oauthService.getAccessToken(code);

		OAuthRequest request = new OAuthRequest(Verb.GET, this.sns.getProfileUrl());
		oauthService.signRequest(accessToken, request);

		Response response = oauthService.execute(request);
		return parseJson(response.getBody());
	}

	private UserVO parseJson(String body) throws Exception {
		System.out.println("===========================\n" + body + "\n=========================");
		UserVO user = new UserVO();

		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(body);

		if (this.sns.isGoogle()) {
			String id = rootNode.get("id").asText();
			if (sns.isGoogle()) {
				user.setId(id);
			}
			String displayName = rootNode.get("displayName").asText();
			JsonNode nameNode = rootNode.path("name");
			String name = nameNode.get("familyName").asText() + nameNode.get("giveName").asText();
			user.setName(name);

			Iterator<JsonNode> iterEmails = rootNode.path("emails").elements();
			while (iterEmails.hasNext()) {
				JsonNode emailNode = iterEmails.next();
				String type = emailNode.get("type").asText();
				if (StringUtils.equals(type, "account")) {
					user.setEmail(emailNode.get("value").asText());
					break;
				}
			}
		} else if(this.sns.isNaver()){
			JsonNode resNode = rootNode.get("response");
			user.setId(resNode.get("id").asText());
			user.setEmail(resNode.get("email").asText());
			user.setName(resNode.get("name").asText());
		}

		return user;
	}
}
