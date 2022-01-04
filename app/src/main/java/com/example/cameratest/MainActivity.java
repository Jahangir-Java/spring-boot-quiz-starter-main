package com.example.cameratest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    Button button;
    ImageView imageView;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageView);
        videoView=findViewById(R.id.videoView);



    }
    public void takePhoto(View view){
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(intent,1);

        }catch (Exception e){

        }

    }
    public void takeVideo(View view){
        Intent intent=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        try {
            startActivityForResult(intent,1);

        }catch (Exception e){

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode == RESULT_OK ){
            Bundle bundle=data.getExtras();
            Bitmap bitmap= (Bitmap) bundle.get("data");
            imageView.setImageBitmap(bitmap);

        }

        if(requestCode==1 && resultCode == RESULT_OK ){

          Uri uriVideo=data.getData();
          videoView.setVideoURI(uriVideo);

        }
    }






}