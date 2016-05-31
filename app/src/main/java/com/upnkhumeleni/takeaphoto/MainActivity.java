package com.upnkhumeleni.takeaphoto;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.net.URI;

public class MainActivity extends AppCompatActivity {

    Button button;
    ImageView img;
    ImageButton butt;
    static final int CAM_REQUEST =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        butt = (ImageButton) findViewById(R.id.imageButton);
        img = (ImageView) findViewById(R.id.imageView);
        button.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(camera_intent, CAM_REQUEST);



            }
        });

        butt.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(camera_intent, CAM_REQUEST);



            }
        });

    }

    private File getFile(){
        File folder = new File("sdcard/camera_app");
        if(!folder.exists()){
            folder.mkdir();

        }
        File image_file = new File(folder, "cam_image.png");
        return image_file;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String path = "sdcard/camera_app/cam_image.png";

        //img.setImageDrawable(Drawable.createFromPath(path));
        butt.setImageDrawable(Drawable.createFromPath(path));
       // img.setImageBitmap(Drawable.createFromPath(path));



    }
}
