package com.example.myfirstapp.presentor;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class GetPhotoFromIntent_uri implements IGetPhotoFromIntent_uri {
    Context context;
    Intent intent;
    Bitmap bitmap;
   public GetPhotoFromIntent_uri(Context context , Intent intent , Bitmap bitmap){
        this.context = context;
        this.intent = intent;
        this.bitmap = bitmap;
    }

    @Override
    public Bitmap getPhotoFromIntent() {
        String uriString = intent.getStringExtra("picture");
        Uri uri = Uri.parse(uriString);
        InputStream imageStream = null;
        try {
            imageStream = context.getContentResolver().openInputStream(uri);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bitmap = BitmapFactory.decodeStream(imageStream);
        return bitmap;
    }
}
