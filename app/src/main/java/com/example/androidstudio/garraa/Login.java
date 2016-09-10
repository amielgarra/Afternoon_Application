package com.example.androidstudio.garraa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

/**
 * Created by androidstudio on 10/09/16.
 */
public class Login extends AppCompatActivity{
    EditText uNameTxt;
    EditText passwordTxt;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        uNameTxt = (EditText) findViewById(R.id.uNameText);
        passwordTxt = (EditText) findViewById(R.id.pwText);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Pattern.compile("^admin$").matcher(uNameTxt.getText()).matches() && Pattern.compile("^test$").matcher(passwordTxt.getText()).matches())
                {

                        Intent intent = new Intent(Login.this, MainActivity.class );
                        startActivity(intent);

                }
                else
                {
                    Toast.makeText(getBaseContext(),"Invalid username or password.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }



    @Override
    protected  void onPause(){
        super.onPause();
        finish(

        );
    }

}
