package com.example.myfirstapp.model;

import android.widget.ImageButton;
import android.widget.ImageView;

public class EditUser {
    private ImageView photo;
    private ImageButton save;
    private ImageButton send;

   public EditUser (ImageView photo , ImageButton save , ImageButton send){
        this.photo = photo;
        this.save = save;
        this.send = send;
    }
    public ImageView getPhoto() {
        return photo;
    }
    public void setPhoto(ImageView photo) {
        this.photo = photo;
    }

    public ImageButton getSave() {
        return save;
    }

    public void setSave(ImageButton save) {
        this.save = save;
    }

    public ImageButton getSend() {
        return send;
    }

    public void setSend(ImageButton send) {
        this.send = send;
    }
}
