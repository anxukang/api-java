package secret;//
//  Created by  fred on 2017/1/12.
//  Copyright © 2016年 Alibaba. All rights reserved.
//

import com.alibaba.cloudapi.sdk.client.ApacheHttpClient;
import com.alibaba.cloudapi.sdk.enums.Scheme;
import com.alibaba.cloudapi.sdk.enums.HttpMethod;
import com.alibaba.cloudapi.sdk.model.ApiRequest;
import com.alibaba.cloudapi.sdk.model.ApiResponse;
import com.alibaba.cloudapi.sdk.model.ApiCallback;
import com.alibaba.cloudapi.sdk.model.HttpClientBuilderParams;


public class HttpApiClientservice_mdm extends ApacheHttpClient{
    public final static String HOST = "mm.api.harmay.com";
    static HttpApiClientservice_mdm instance = new HttpApiClientservice_mdm();
    public static HttpApiClientservice_mdm getInstance(){return instance;}

    public void init(HttpClientBuilderParams httpClientBuilderParams){
        httpClientBuilderParams.setScheme(Scheme.HTTPS);
        httpClientBuilderParams.setHost(HOST);
        super.init(httpClientBuilderParams);
    }




    public void mdm_api(ApiCallback callback) {
        String path = "/mm/v1/*";
        ApiRequest request = new ApiRequest(HttpMethod.POST_BODY , path,new byte[]{});
        


        sendAsyncRequest(request , callback);
    }

    public ApiResponse mdm_apiSyncMode() {
        String path = "/mm/v1/*";
        ApiRequest request = new ApiRequest(HttpMethod.POST_BODY , path,new byte[]{});
        


        return sendSyncRequest(request);
    }

}