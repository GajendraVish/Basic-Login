package com.gajen.request;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Owner on 04-Apr-17.
 */
public class LoginRequestBean implements Serializable {
    @SerializedName("user_mobile")
    private String users_mobile;

    @SerializedName("user_password")
    private String password;

    public String getUsers_mobile() {
        return users_mobile;
    }

    public void setUsers_mobile(String users_mobile) {
        this.users_mobile = users_mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
