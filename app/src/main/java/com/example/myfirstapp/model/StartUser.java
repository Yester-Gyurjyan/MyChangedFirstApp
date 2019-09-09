package com.example.myfirstapp.model;

import android.widget.Button;
import android.widget.ImageView;

public class StartUser {
    private ImageView image;
    private Button start;
    public StartUser(ImageView image , Button start){
        this.image = image;
        this.start = start;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public Button getStart() {
        return start;
    }

    public void setStart(Button start) {
        this.start = start;
    }
}
