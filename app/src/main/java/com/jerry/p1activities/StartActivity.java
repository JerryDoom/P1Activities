package com.jerry.p1activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;


public class StartActivity extends Activity {

    //Variables
    String name, surname, age = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnNameOnClick (View v) {
        //1.- Get the reference to the button
        Button btn1 = (Button) findViewById(R.id.btnName);
        EditText tvName = (EditText) findViewById(R.id.txtNombre);
        name = tvName.getText().toString();
        Intent i = new Intent(StartActivity.this, NameActivity.class);
        i.putExtra("name",name);
        startActivity(i);
    }

    public void btn2OnClick (View v){
        //Button btn2 = (Button) findViewById(R.id.btnSurname);
        EditText tvSurname = (EditText) findViewById(R.id.txtSurname);
        surname = tvSurname.getText().toString();
        Intent i = new Intent(this, Surname.class);
        i.putExtra("surname",surname);
        startActivity(i);
    }

    public void btn3OnClick (View v){
        EditText tvAge = (EditText) findViewById(R.id.txtAge);
        age = tvAge.getText().toString();
        Intent i = new Intent(this, Age.class);
        i.putExtra("age",age);
        startActivity(i);
    }

    public void btn4OnClick (View v){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image);
        ByteArrayOutputStream arrOutput = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, arrOutput);
        byte[] b = arrOutput.toByteArray();

        Intent intent = new Intent(this, ImageActivity.class);
        intent.putExtra("picture", b);
        startActivity(intent);
    }
}
