package com.example.myfirstapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;

import com.example.myfirstapp.R;
import com.example.myfirstapp.presentor.OpenCameraandGallery;

import java.io.ByteArrayOutputStream;

public class ChoosePhotoPage extends AppCompatActivity implements ChoosePhotoView {
    public static final int GALLERY_CODE = 1;
    public static final int CAMERA_CODE = 2;
    private static final int STORAGE_PERMISSION = 1;

    private ImageButton camera;
    private ImageButton gallery;
    private OpenCameraandGallery getPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        initData();
        getPhoto = new OpenCameraandGallery(this);
        openCameraButton();
        openGalleryButton();
    }
    private void initData() {
        camera = findViewById(R.id.camera);
        gallery = findViewById(R.id.gallery);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_CODE && resultCode == RESULT_OK) {
            sendGalleryPhoto(data);
        }
        if (requestCode == CAMERA_CODE && resultCode == RESULT_OK) {
            sendCameraPhoto(data);
        }
    }

    private void sendGalleryPhoto(Intent data) {
        sendSelectedPhoto(data.getData());
    }

    private void sendCameraPhoto(Intent data) {
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        sendSelectedPhoto(getImageUri(this , bitmap));
    }
    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    private void sendSelectedPhoto(Uri uri) {
        Intent intent = new Intent(this, EditPage.class);
        intent.putExtra("picture", uri.toString());
        if (isGrantExternalRW(this)) {
            startActivity(intent);
        }
        finish();
    }
    public static boolean isGrantExternalRW(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && (context.checkSelfPermission(
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)) {

            ((Activity) context).requestPermissions(new String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, STORAGE_PERMISSION);

            return false;
        }

        return true;
    }
    @Override
    public void openCameraButton() {
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               getPhoto.openCamera();
            }
        });
    }

    @Override
    public void openGalleryButton() {
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               getPhoto.openGallery();

            }
        });
    }
}


