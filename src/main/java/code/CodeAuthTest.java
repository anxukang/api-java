package code;

import com.alibaba.cloudapi.sdk.enums.HttpMethod;
import okhttp3.*;

import java.io.IOException;

/**
 * @author Eric
 * @since 2020/12/8
 */
public class CodeAuthTest {

    public static final String AUTHORIZATION = "APPCODE d7d97bf1278248b5a25af5ab2b9d20bf";

    /**
     * code鉴权模式post请求
     * @param url
     * @param bodyContent
     * @return
     * @throws IOException
     */
    public static Response postReq(String url, String bodyContent) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, bodyContent);
        Request request = new Request.Builder()
                .url(url)
                .method("POST", body)
                .addHeader("Authorization", AUTHORIZATION)
                .addHeader("Content-Type", "application/json")
                .build();
        return client.newCall(request).execute();
    }

    public static void main(String[] args) {
        String reqUrl = "https://flipos.api.harmay.com/vip/coupon/tp/list";
        String bodyContent = "{\"page_no\": 1,\"page_size\": 10}";
        Response response;
        try {
            response = postReq(reqUrl, bodyContent);
            System.out.println(response.body().string());
        } catch (IOException e) {
            //error
            System.err.println("req error:" + e.getMessage());
        }

    }
}
