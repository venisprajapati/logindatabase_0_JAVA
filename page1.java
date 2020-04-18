package com.example.logindatabase0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class page1 extends AppCompatActivity {

    Button bcklogin2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_page1 );

        bcklogin2=(Button)findViewById ( R.id.bcktologin2 );


        bcklogin2.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                Intent backlintent2=new Intent ( page1.this, MainActivity.class );
                startActivity ( backlintent2 );
                finish ();

            }
        } );

    }
}
