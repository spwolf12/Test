package com.itwillbs.test3_mybatis.service;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class KakaoApiService {

    @Value("b507d285a6568de1e8400dd27526b528")
    private String kakaoRestApiKey;
    
    @Value("https://localhost:8082")
    private String kakaoRedirectUri;

    public String getAccessToken(String authorizationCode) throws IOException {
        String apiUrl = "https://kauth.kakao.com/oauth/token";

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(apiUrl);

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("grant_type", "authorization_code"));
        params.add(new BasicNameValuePair("client_id", kakaoRestApiKey));
        params.add(new BasicNameValuePair("redirect_uri", kakaoRedirectUri));
        params.add(new BasicNameValuePair("code", authorizationCode));

        httpPost.setEntity(new UrlEncodedFormEntity(params));

        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();

        BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }

        return stringBuilder.toString();
    }
    
    public void sendMessage(String recipientId, String message) throws IOException {
        String accessToken = "YOUR_ACCESS_TOKEN";

        String url = "https://kapi.kakao.com/v2/api/talk/memo/default/send";

        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);

        post.setHeader("Content-Type", "application/x-www-form-urlencoded");
        post.setHeader("Authorization", "Bearer " + accessToken);

        String payload = "template_object={\n" +
                "    \"object_type\": \"text\",\n" +
                "    \"text\": \"" + message + "\",\n" +
                "    \"link\": {\n" +
                "        \"web_url\": \"https://developers.kakao.com\",\n" +
                "        \"mobile_web_url\": \"https://developers.kakao.com\"\n" +
                "    },\n" +
                "    \"button_title\": \"바로 확인\"\n" +
                "}";

        post.setEntity(new StringEntity(payload));

        HttpResponse response = client.execute(post);

        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder result = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            result.append(line);
        }

        System.out.println(result.toString());
    }
    
    
}
