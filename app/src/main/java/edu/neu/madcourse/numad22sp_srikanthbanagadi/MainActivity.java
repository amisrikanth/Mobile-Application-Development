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
        Toast.makeText(MainActivity.this, "Srikanth Banagadi \n " +
                "banagadi.s@northeastern.edu", Toast.LENGTH_SHORT).show();
    }

    public void onClickClickyClicky(View view) {
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

}