package edu.neu.madcourse.numad22sp_srikanthbanagadi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view) {
        Intent intent = new Intent(this,AboutMe.class);
        startActivity(intent);
    }

    public void onClickClickyClicky(View view) {
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

    public void onClickLinkCollector(View view) {
        Intent intent = new Intent(this,MainActivity3.class);
        startActivity(intent);
    }

    public void onClickLocator(View view) {
        Intent intent = new Intent(this,LocatorActivity.class);
        startActivity(intent);
    }

    public void onServiceClick(View view) {
        Intent intent = new Intent(this,Service.class);
        startActivity(intent);
    }



}