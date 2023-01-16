package com.test.testaves.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.test.testaves.R;
import com.test.testaves.api.ApiUtil;
import com.test.testaves.datamodels.ImageDataModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImagesAdapter adapter;
    private ArrayList<ImageDataModel> imageList;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerV_images);
        progressBar = findViewById(R.id.progress_bar);

        imageList = new ArrayList<>();
        adapter = new ImagesAdapter(MainActivity.this, imageList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressBar.setVisibility(View.VISIBLE);

        getData();
    }

    private void getData() {
        ApiUtil.getInterface().getImages(1,7).enqueue(new Callback<List<ImageDataModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<ImageDataModel>> call, @NonNull Response<List<ImageDataModel>> response) {
                if (response.body() != null) {
                    imageList.addAll(response.body());
                    recyclerView.setAdapter(adapter);
                    progressBar.setVisibility(View.GONE);
                } else {
                    progressBar.setVisibility(View.GONE);
                }
                Log.i("response", response.body().toString());

            }

            @Override
            public void onFailure(@NonNull Call<List<ImageDataModel>> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this, "Error:" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.i("error", t.getMessage() + "localized" + t.getLocalizedMessage());
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}