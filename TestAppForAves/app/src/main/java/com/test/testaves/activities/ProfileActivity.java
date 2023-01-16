package com.test.testaves.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.test.testaves.R;
import com.test.testaves.datamodels.UserModel;

import java.util.Objects;

public class ProfileActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView bio, name, location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        UserModel user = (UserModel) getIntent().getSerializableExtra("image");

        imageView = findViewById(R.id.profileImageViewP);
        name = findViewById(R.id.userNameP);
        bio = findViewById(R.id.userBioP);
        location = findViewById(R.id.userLocP);

        String name1 = user.getName();

        Objects.requireNonNull(getSupportActionBar()).setTitle(name1+"'s Profile");
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Glide.with(this).load(user.getProfile_image().getLarge()).apply(new RequestOptions().placeholder(R.drawable.bulb_girl))
                .into(imageView);

        name.setText(name1);
        bio.setText(user.getBio());
        location.setText(user.getLocation());

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}