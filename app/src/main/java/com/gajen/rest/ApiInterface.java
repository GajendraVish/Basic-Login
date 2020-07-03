package com.gajen.rest;

import com.gajen.request.LoginRequestBean;
import com.gajen.response.LoginResponseBean;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Owner on 04-Apr-17.
 */
public interface ApiInterface {

    @POST("index.php/Json/login/")
    Call<LoginResponseBean> userLogin(@Body LoginRequestBean requestBean);

}

