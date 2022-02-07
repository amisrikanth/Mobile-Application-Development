package edu.neu.madcourse.numad22sp_srikanthbanagadi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void onButtonClick(View view) {
        Button button = (Button) view;
        TextView txt = (TextView) findViewById(R.id.textView2);
        txt.setText("Pressed: " + button.getText());
    }
}