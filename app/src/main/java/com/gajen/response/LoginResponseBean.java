package com.gajen.response;

import com.gajen.request.UserBean;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginResponseBean implements Serializable {

    @SerializedName("error")
    private String error;

    @SerializedName("msg")
    private String msg;

    @SerializedName("user_info")
    private UserBean userBean;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
}

