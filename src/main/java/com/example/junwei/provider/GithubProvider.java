package com.example.junwei.provider;

import com.alibaba.fastjson.JSON;
import com.example.junwei.dto.AccessTokenDTO;
import com.example.junwei.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * created by junwei on 2020/03/17
 * 如果参数超过五个就包装成对象去做
 */
@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){

         MediaType mediaType = MediaType.get("application/json; charset=utf-8");

         OkHttpClient client = new OkHttpClient();

        //String post(String url, String json) throws IOException {
            RequestBody body = RequestBody.create(JSON.toJSONString(accessTokenDTO), mediaType);
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String string = response.body().string();
                String token = string.split("&")[0].split("=")[1];
                return token;
            } catch (IOException e) {
                e.printStackTrace();
            }
        return null;
    }

    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.github.com/user?access_token="+ accessToken)
                    .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;


    }

}
