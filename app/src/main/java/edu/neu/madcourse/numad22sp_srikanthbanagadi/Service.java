package edu.neu.madcourse.numad22sp_srikanthbanagadi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import edu.neu.madcourse.numad22sp_srikanthbanagadi.databinding.ActivityServiceBinding;

public class Service extends AppCompatActivity {

    ActivityServiceBinding binding;
    ArrayList<String> universityList;
    ArrayAdapter<String> universityAdapter;
    Handler serviceHandler = new Handler();
    ProgressDialog LoadDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        binding = ActivityServiceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setUp();
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new fetchData().start();
            }

        });
    }

    private void setUp() {
        universityList = new ArrayList<>();
        universityAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, universityList);
        binding.UniversityList.setAdapter(universityAdapter);
    }

    class fetchData extends Thread{

        String JsonData="";
        @Override
        public void run() {
            serviceHandler.post(new Runnable() {
                @Override
                public void run() {
                    LoadDialog = new ProgressDialog(Service.this);
                    LoadDialog.setMessage("Fetching Data");
                    LoadDialog.setCancelable(false);
                    LoadDialog.show();

                }
            });
            try {
                EditText input = (EditText) findViewById(R.id.country);
                universityList.clear();
                URL url = new URL("http://universities.hipolabs.com/search?country=" + input.getText().toString());
                HttpURLConnection httpURLConnection =(HttpURLConnection)  url.openConnection();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                String jsonInput;
                while ((jsonInput = bufferedReader.readLine()) != null){
                    JsonData = JsonData + jsonInput;
                }
                if(!JsonData.isEmpty()){
                    JSONArray Universities = new JSONArray(JsonData);
                    for (int i = 0; i < Universities.length(); i++) {
                        String name = Universities.getJSONObject(i).getString("name");
                        universityList.add(name);
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (JSONException ex) {
                ex.printStackTrace();
            }
            serviceHandler.post(new Runnable() {
                @Override
                public void run() {
                    if(LoadDialog.isShowing()){
                        LoadDialog.dismiss();
                        universityAdapter.notifyDataSetChanged();
                    }
                }
            });

        }
    }

}