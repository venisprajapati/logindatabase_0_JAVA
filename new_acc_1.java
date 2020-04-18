package com.example.logindatabase0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class new_acc_1 extends AppCompatActivity {

    DatabaseHelper regdata;

    EditText nusname;
    EditText npasswd1;
    EditText npasswd2;
    //EditText nmoredetail1;
    Button done;
    Button blogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_new_acc_1 );

        regdata = new DatabaseHelper ( this );

        nusname=(EditText)findViewById ( R.id.nusname1 );
        npasswd1=(EditText)findViewById ( R.id.npasswd1 );
        npasswd2=(EditText)findViewById ( R.id.npasswd2 );
        //nmoredetail1=(EditText)findViewById ( R.id.ndetail1 );
        done=(Button)findViewById ( R.id.ndone1 );
        blogin=(Button)findViewById ( R.id.blogin1 );

        blogin.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                Intent backlintent=new Intent ( new_acc_1.this, MainActivity.class );
                startActivity ( backlintent );
                finish ();

            }
        } );

        done.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                String user = nusname.getText ().toString ().trim () ;
                String pwd1 = npasswd1.getText ().toString ().trim ();
                String pwd2 = npasswd2.getText ().toString ().trim ();
                //String mdet1 = nmoredetail1.getText ().toString ().trim ();

                if(pwd1.equals ( pwd2 ))
                {

                    long val = regdata.adduser ( user, pwd1);

                    if(val>0)
                    {
                        Toast.makeText ( new_acc_1.this, "You Are Created Your New Account..", Toast.LENGTH_SHORT ).show ();
                        Intent nloginintent = new Intent ( new_acc_1.this, MainActivity.class );
                        startActivity ( nloginintent );
                        finish ();
                    }
                    else
                    {
                        Toast.makeText ( new_acc_1.this, "Plz Write Properly..", Toast.LENGTH_SHORT ).show ();
                    }

                }
                else
                {
                    Toast.makeText ( new_acc_1.this, "Incorrect Password..", Toast.LENGTH_SHORT ).show ();

                }

            }
        } );

    }
}