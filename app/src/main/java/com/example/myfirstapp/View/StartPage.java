package com.example.myfirstapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myfirstapp.R;
import com.example.myfirstapp.model.StartUser;

public class StartPage extends AppCompatActivity implements StartView {

    private ImageView image;
    private Button start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initData();
        StartUser startUser = new StartUser(image , start);
        setImage();
        startNextPage();
    }
  
    private void initData(){
        image = findViewById(R.id.image);
        start = findViewById(R.id.start);
    }

    @Override
    public void startNextPage() {
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , ChoosePhotoPage.class);
                startActivity(intent);
                finish();
            }
        });

    }
    @Override
    public void setImage() {
        image.setImageResource(R.drawable.ic_image);
    }
}
