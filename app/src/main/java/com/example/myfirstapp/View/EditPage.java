package com.example.myfirstapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.myfirstapp.R;
import com.example.myfirstapp.presentor.PhotoSaveandShare;
import com.example.myfirstapp.presentor.GetPhotoFromIntent_uri;

public class EditPage extends AppCompatActivity implements EditView {

    private ImageView photo;
    private ImageButton young;
    private ImageButton original;
    private ImageButton old;
    private ImageButton save;
    private ImageButton send;

    private Bitmap bitmap;
    private Intent intent;

    private PhotoSaveandShare photoGallery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        initData();
        savePhotoButton();
        sendPhotoButton();
        intent = getIntent();
        GetPhotoFromIntent_uri getPhoto = new GetPhotoFromIntent_uri(this , intent , bitmap);

        bitmap = getPhoto.getPhotoFromIntent();
        photo.setImageBitmap(bitmap);
        photoGallery = new PhotoSaveandShare(this , bitmap);
    }
    private void sendPhotoButton() {
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendImage();
            }
        });
    }

    private void savePhotoButton() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               saveImageGallery();

            }
        });
    }
    private void initData(){
        photo = findViewById(R.id.photo);
        young = findViewById(R.id.young);
        original = findViewById(R.id.original);
        old = findViewById(R.id.old);
        save = findViewById(R.id.save);
        send = findViewById(R.id.send);
    }
    public void sendImage(){
        photoGallery.sharePhoto();
    }
     public void saveImageGallery() {
         photoGallery.savePhotoGallery();
    }
}



