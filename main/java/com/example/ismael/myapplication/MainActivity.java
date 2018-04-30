package com.example.ismael.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if(AccessToken.getCurrentAccessToken()==null){
             goLoginScreen();
        }
    }
    private  void goLoginScreen(){
        Intent intent=new Intent(this, LoginActivity.class);//SI INICIO SESSION QUE LO MANDE A OTRA PANTALLA
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        //LOS FLAG_ACTIVITY EVITAN Q SI LE DAN ATRAS NO LO VUELVA MANDAR A LA LOGIN SI NO QUE SE DETENGA LA APP
        startActivity(intent);
    }
    public void logout(View view){
       //linea para cerrar session
        LoginManager.getInstance().logOut();
        goLoginScreen();//invocamos metodo para ir a la pantalla login

    }
}
