package com.defold.push;

import java.io.PrintStream;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.Manifest;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;

import androidx.appcompat.app.AppCompatActivity;

public class PushPermissionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int requestCode = getIntent().getIntExtra("requestCode", -1);
        if (requestCode != -1) {
            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.POST_NOTIFICATIONS },
                    requestCode);
        } else {
            // Handle error condition
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == requestCode) {
            boolean granted = grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED;

            // Send the permission result back to your native extension
            sendPermissionResultToNativeExtension(granted);
        }
    }

    private void sendPermissionResultToNativeExtension(boolean granted) {
        // Assuming you have a method to send the result back to your native extension
        // You need to implement this method in your native extension
        Log.e(Push.TAG, "EREWRW");
    }

}
