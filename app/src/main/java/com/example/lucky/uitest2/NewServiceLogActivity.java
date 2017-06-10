package com.example.lucky.uitest2;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class NewServiceLogActivity extends Activity {
    private Button bt_openAlbum,bt_saveLog,bt_exit_log;
    private ImageView imgview;
    private Bitmap bmp = null;
    private int cram = 3;
    private File sdcardTempFile = new File("/mnt/sdcard/",
            "tmp_pic_" + SystemClock.currentThreadTimeMillis() + ".jpg");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_service_log);
        bt_exit_log = (Button) findViewById(R.id.bt_no_save_log);
        bt_saveLog = (Button) findViewById(R.id.bt_save_log);
        bt_openAlbum = (Button)findViewById(R.id.bt_open_photo);
        imgview = (ImageView) findViewById(R.id.list_img1);
        bt_exit_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bt_saveLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NewServiceLogActivity.this, "Save Data", Toast.LENGTH_SHORT).show();
            }
        });
        bt_openAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            Bitmap image = BitmapFactory.decodeFile(sdcardTempFile.getAbsolutePath());
            bmp = Bitmap.createScaledBitmap(image, 72, 72, true);
            imgview.setImageBitmap(bmp);
    }
}
