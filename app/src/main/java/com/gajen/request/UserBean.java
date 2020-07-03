package com.gajen.request;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Owner on 04-Apr-17.
 */
public class UserBean implements Serializable {

    @SerializedName("users_id")
    private String users_id;
    @SerializedName("users_name")
    private String users_name;
    @SerializedName("users_mobile")
    private String users_mobile;
    @SerializedName("users_email")
    private String users_email;
    @SerializedName("users_password")
    private String users_password;
    @SerializedName("users_type")
    private String users_type;
    @SerializedName("users_android_id")
    private String users_android_id;
    @SerializedName("users_status")
    private String users_status;

    public String getUsers_id() {
        return users_id;
    }

    public void setUsers_id(String users_id) {
        this.users_id = users_id;
    }

    public String getUsers_name() {
        return users_name;
    }

    public void setUsers_name(String users_name) {
        this.users_name = users_name;
    }

    public String getUsers_mobile() {
        return users_mobile;
    }

    public void setUsers_mobile(String users_mobile) {
        this.users_mobile = users_mobile;
    }

    public String getUsers_email() {
        return users_email;
    }

    public void setUsers_email(String users_email) {
        this.users_email = users_email;
    }

    public String getUsers_password() {
        return users_password;
    }

    public void setUsers_password(String users_password) {
        this.users_password = users_password;
    }

    public String getUsers_type() {
        return users_type;
    }

    public void setUsers_type(String users_type) {
        this.users_type = users_type;
    }

    public String getUsers_android_id() {
        return users_android_id;
    }

    public void setUsers_android_id(String users_android_id) {
        this.users_android_id = users_android_id;
    }

    public String getUsers_status() {
        return users_status;
    }

    public void setUsers_status(String users_status) {
        this.users_status = users_status;
    }
}
