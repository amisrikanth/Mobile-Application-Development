package edu.neu.madcourse.numad22sp_srikanthbanagadi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class LocatorActivity extends AppCompatActivity implements LocationListener {
    LocationManager location_Manager;
    TextView latitudeValue;
    TextView longitudeValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locator);
        location_Manager = (LocationManager) getSystemService(LOCATION_SERVICE);
        latitudeValue = findViewById(R.id.latitude);
        longitudeValue = findViewById(R.id.longitude);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 100);
            return;
        }
        try {
            location_Manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 1, this);
            Location location = location_Manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (location != null) {
                latitudeValue.setText("Latitude:     " + location.getLatitude());
                longitudeValue.setText("Longitude:  " + location.getLongitude());
            }

        } catch (Exception e) {
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 100:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(LocatorActivity.this, "Location Access granted", Toast.LENGTH_LONG).show();
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    location_Manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 1, this);
                } else {
                    Toast.makeText(LocatorActivity.this, "Location Access Denied!", Toast.LENGTH_LONG).show();
                    finish();
                }
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        latitudeValue.setText("Latitude:     " + location.getLatitude());
        longitudeValue.setText("Longitude:  " + location.getLongitude());
    }

}