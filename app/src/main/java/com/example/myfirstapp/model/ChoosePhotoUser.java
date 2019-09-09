package com.example.myfirstapp.model;

import android.widget.ImageButton;

public class ChoosePhotoUser {
    private ImageButton camera;
    private ImageButton gallery;
    public ChoosePhotoUser(ImageButton camera , ImageButton gallery){
        this.camera = camera;
        this.gallery = gallery;
    }

    public ImageButton getCamera() {
        return camera;
    }

    public void setCamera(ImageButton camera) {
        this.camera = camera;
    }

    public ImageButton getGallery() {
        return gallery;
    }

    public void setGallery(ImageButton gallery) {
        this.gallery = gallery;
    }
}
