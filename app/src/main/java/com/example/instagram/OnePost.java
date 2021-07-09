package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import org.parceler.Parcels;

import java.text.SimpleDateFormat;

public class OnePost extends AppCompatActivity {

    private TextView tvUsername;
    private TextView tvTime;
    private ImageView ivImage;
    private TextView tvDescription;
    Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_post);

        tvUsername = findViewById(R.id.tvUsername);
        tvTime = findViewById(R.id.tvTime);
        ivImage = findViewById(R.id.ivImage);
        tvDescription = findViewById(R.id.tvDescription);

        post = Parcels.unwrap(getIntent().getParcelableExtra(Post.class.getSimpleName()));

        tvUsername.setText(post.getUser().getUsername());
        tvTime.setText(new SimpleDateFormat("MM/dd/yyyy").format(post.getUser().getCreatedAt()));
        tvDescription.setText(post.getDescription());
        ParseFile image = post.getImage();
        if (image != null){
            Glide.with(this).load(post.getImage().getUrl()).into(ivImage);
        }
        else ivImage.setVisibility(View.GONE);

    }
}