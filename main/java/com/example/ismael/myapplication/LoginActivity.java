package com.example.ismael.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity{
    //declaramos las variables de tipo button y CallbackManager
    public LoginButton loginButton;
    public CallbackManager CManager;


    Button siguiente;

    EditText usuario;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        /*
        //CODIGO PARA INICIAR CON FACEBOOK

        CManager=CallbackManager.Factory.create();
        loginButton=(LoginButton) findViewById(R.id.loginButton);
        loginButton.registerCallback(CManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                  goMainScreen();
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), R.string.com_facebook_loginview_cancel_action, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
              Toast.makeText(getApplicationContext(),R.string.com_facebook_internet_permission_error_message,Toast.LENGTH_SHORT).show();
            }
        });
        siguiente = (Button)findViewById(R.id.btnAceptar);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View view) {

            String usuario = ((EditText)findViewById(R.id.txtNombre)).getText().toString();
            String password = ((EditText)findViewById(R.id.txtPassword)).getText().toString();

            if (usuario.equals("Usuario1") && password.equals("1234")){
                Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                startActivity(intent);
            }




            }

        */

    }


    private void goMainScreen()
    {
        Intent intent=new Intent(this, MenuActivity.class);//SI INICIO SESSION QUE LO MANDE A OTRA PANTALLA
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        //LOS FLAG_ACTIVITY EVITAN Q SI LE DAN ATRAS NO LO VUELVA MANDAR A LA LOGIN SI NO QUE SE DETENGA LA APP
        startActivity(intent);
    }
    @Override
    protected  void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        CManager.onActivityResult(requestCode,resultCode,data);

   }
}
