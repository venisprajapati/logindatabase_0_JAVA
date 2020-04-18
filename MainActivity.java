package com.example.logindatabase0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper logindata;

    EditText usname;
    EditText passwd;
    Button login;
    Button cancel;
    TextView newacc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        logindata = new DatabaseHelper ( this ) ;

        usname=(EditText)findViewById ( R.id.nusname1 );
        passwd=(EditText)findViewById ( R.id.npasswd1 );
        login=(Button)findViewById ( R.id.ndone1 );
        cancel=(Button)findViewById ( R.id.blogin1 );
        newacc=(TextView)findViewById ( R.id.newacc1 );

        newacc.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                Intent newaccintent = new Intent ( MainActivity.this, new_acc_1.class );
                startActivity ( newaccintent );
                finish ();


            }

        });

        login.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {


                String user = usname.getText ().toString ().trim () ;
                String pwd = passwd.getText ().toString ().trim () ;

                Boolean res = logindata.checkUser ( user, pwd ) ;
                
                if(res == true)
                {
                    Intent topage1=new Intent ( MainActivity.this , page1.class );
                    startActivity ( topage1 );

                    Toast.makeText ( MainActivity.this, "You Are Logged In..", Toast.LENGTH_SHORT ).show ();
                }
                else
                {
                    Toast.makeText ( MainActivity.this, "Incorrect Credential.", Toast.LENGTH_SHORT ).show ();
                }


            }
        } );

        cancel.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                finish ();

            }
        } );

    }
}
