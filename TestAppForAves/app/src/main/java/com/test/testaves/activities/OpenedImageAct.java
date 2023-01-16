package com.test.testaves.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jsibbold.zoomage.ZoomageView;
import com.test.testaves.R;
import com.test.testaves.datamodels.ImageDataModel;

import java.util.Objects;

public class OpenedImageAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opened_image);

        ImageDataModel image = (ImageDataModel) getIntent().getSerializableExtra("image");

        ZoomageView zoomageView = findViewById(R.id.myZoomageView);
        TextView textView = findViewById(R.id.openImageDesText);

        Objects.requireNonNull(getSupportActionBar()).setTitle("");
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        if (image.getDescription() != null)
            textView.setText(image.getDescription());
        else if (image.getAlt_description() != null)
            textView.setText(image.getAlt_description());
        else
            textView.setText("Description");

        Glide.with(this).load(image.getUrls().getRegular()).apply(new RequestOptions().placeholder(R.drawable.bulb_girl))
                .into(zoomageView);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}