package com.gajen.myapplication;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gajen.request.LoginRequestBean;
import com.gajen.response.LoginResponseBean;
import com.gajen.rest.ApiClient;
import com.gajen.rest.ApiInterface;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText ed_username, ed_password;
    TextView txt_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txt_signup = (TextView) findViewById(R.id.txt_signup);
        ed_username = (EditText) findViewById(R.id.ed_username);
        ed_password = (EditText) findViewById(R.id.ed_password);
        TextView btn_submit = (TextView) findViewById(R.id.txt_signin);
        ImageView img_back = (ImageView) findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = ed_username.getText().toString().trim();
                String password = ed_password.getText().toString().trim();
                if (username.length() <= 0) {

                    showTost(v, getString(R.string.msg_enter_username));

                } else if (password.length() <= 0) {
                    showTost(v, getString(R.string.msg_enter_password));
                } else {
                    LoginRequestBean loginRequestBean = new LoginRequestBean();
                    loginRequestBean.setUsers_mobile(username);
                    loginRequestBean.setPassword(password);
                    userLogin(loginRequestBean);
                }


            }
        });

    }


    public void showTost(View view, String msg) {
        final Snackbar snack = Snackbar.make(view, msg, Snackbar.LENGTH_LONG);
        View view2 = snack.getView();
        TextView tv = (TextView) view2.findViewById(R.id.snackbar_text);
        tv.setTextColor(Color.WHITE);
        snack.setAction(getString(R.string.btn_dismiss), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snack.dismiss();
            }
        });
        snack.show();
    }

    public void showAlertDialog(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setTitle(getResources().getString(R.string.app_name));
        builder.setMessage(msg);
        builder.setCancelable(false);

        builder.setPositiveButton(getString(R.string.btn_ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setCancelable(false);
        builder.show();
    }


    public void userLogin(LoginRequestBean requestBean) {
        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setMessage(getString(R.string.progress_message));
        progressDialog.show();
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<LoginResponseBean> call = apiService.userLogin(requestBean);
        call.enqueue(new Callback<LoginResponseBean>() {
            @Override
            public void onResponse(Call<LoginResponseBean> call, Response<LoginResponseBean> response) {
                LoginResponseBean loginResponseBeenList = response.body();
                if (loginResponseBeenList != null) {
                    if (loginResponseBeenList.getError().trim().equalsIgnoreCase("0")) {
                        //    setPreference(LoginActivity.this, loginResponseBeenList.getUserBean());
//                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                        finish();

                        showAlertDialog(loginResponseBeenList.getMsg());
                    } else {
                        showAlertDialog(loginResponseBeenList.getMsg());
                    }
                }
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }

            }

            @Override
            public void onFailure(Call<LoginResponseBean> call, Throwable t) {
                // Log error here since request failed
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();

                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
            }
        });
    }
}
