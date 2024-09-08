package io.litmuschaos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import io.litmuschaos.auth.http.LitmusHttpClient;
import io.litmuschaos.auth.model.ApiToken;
import io.litmuschaos.auth.model.User;
import io.litmuschaos.auth.request.*;
import io.litmuschaos.auth.response.CommonResponse;
import io.litmuschaos.auth.response.LoginResponse;
import io.litmuschaos.auth.response.PasswordUpdateResponse;
import io.litmuschaos.auth.response.TokenCreateResponse;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// TODO - logging
public class LitmusAuthClient implements AutoCloseable{

    private String token;
    private String host;


    private final LitmusHttpClient httpClient = new LitmusHttpClient();
    private final Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

    public LitmusAuthClient(String host, String username, String password) throws IOException {
        this.host = host;
        LoginResponse credential = this.authenticate(username, password);
        this.token = credential.getAccessToken();
    }

    @Override
    public void close() throws Exception {
        // TODO
    }

    // TODO - @Suyeon Jung : host, port config to LitmusAuthConfig class
    public LoginResponse authenticate(String username, String password) throws IOException {
        LoginRequest request = LoginRequest.builder().username(username).password(password).build();
        Response response = httpClient.post(host + "/login", request);
        LoginResponse loginResponse = gson.fromJson(response.body().string(), LoginResponse.class);
        this.token = loginResponse.getAccessToken();
        return loginResponse;
    }

    // TODO - define Response dto
    public Response createProject(String projectName) throws IOException {
        Map<String, String> request = new HashMap<>();
        request.put("projectName", projectName);
        return httpClient.post(host + "/create_project", token, request);
    }

    // TODO - define Response dto
    public Response capabilities() throws IOException {
        return httpClient.get(host + "/capabilities");
    }

    public CommonResponse logout() throws IOException {
        Response response = httpClient.post(host + "/logout", token);
        CommonResponse commonResponse = gson.fromJson(response.body().string(), CommonResponse.class);
        this.token = "";
        return commonResponse;
    }

    public Response getApiTokens(String userId) throws IOException {
        Response response = httpClient.get(host + "/token/" + userId);
        Type tokenListType = new TypeToken<List<ApiToken>>(){}.getType();
        return gson.fromJson(response.body().toString(), tokenListType);
    }

    public TokenCreateResponse createApiToken(TokenCreateRequest request) throws IOException {
        Response response = httpClient.post(host + "/create_token", request);
        return gson.fromJson(response.body().toString(), TokenCreateResponse.class);
    }

    public CommonResponse removeApiToken(String token) throws IOException {
        Response response = httpClient.post(host + "/remove_token", token);
        return gson.fromJson(response.body().toString(), CommonResponse.class);
    }

    public User getUser(String userId) throws IOException {
        Response response = httpClient.get(host + "/users/" + userId);
        return gson.fromJson(response.body().toString(), User.class);
    }

    public List<User> getUsers() throws IOException {
        Response response = httpClient.get(host + "/users");
        Type userListType = new TypeToken<List<User>>(){}.getType();
        return gson.fromJson(response.body().toString(), userListType);
    }

    public PasswordUpdateResponse updatePassword(PasswordUpdateRequest request) throws IOException {
        Response response = httpClient.post(host + "/update/password", request);
        return gson.fromJson(response.body().toString(), PasswordUpdateResponse.class);
    }

    public User createUser(UserCreateRequest request) throws IOException {
        Response response = httpClient.post(host + "/create_user", request);
        return gson.fromJson(response.body().toString(), User.class);
    }

    public CommonResponse resetPassword(PasswordResetRequest request) throws IOException {
        Response response = httpClient.post(host + "/reset/password", request);
        return gson.fromJson(response.body().toString(), CommonResponse.class);
    }

    public CommonResponse updateUser(UserUpdateRequest request) throws IOException {
        Response response = httpClient.post(host + "/update/details", request);
        return gson.fromJson(response.body().toString(), CommonResponse.class);
    }

    public CommonResponse updateUserState(UserStateUpdateRequest request) throws IOException {
        Response response = httpClient.post(host + "/reset/state", request);
        return gson.fromJson(response.body().toString(), CommonResponse.class);
    }
}