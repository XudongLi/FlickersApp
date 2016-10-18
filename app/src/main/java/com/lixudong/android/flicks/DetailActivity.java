package com.lixudong.android.flicks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    TextView tvTitle;
    TextView tvDescribe;
    ImageView ivPoster;
    RatingBar rbDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTitle = (TextView) findViewById(R.id.tvTitleDetail);
        tvDescribe = (TextView) findViewById(R.id.tvDescribeDetail);
        ivPoster = (ImageView) findViewById(R.id.ivImageDetail);
        ivPoster.setImageResource(0);
        rbDetail = (RatingBar) findViewById(R.id.rbDetail);

        tvTitle.setText(getIntent().getStringExtra("tvTitle"));
        tvDescribe.setText(getIntent().getStringExtra("tvDescribe"));
        Picasso.with(this).load(getIntent().getStringExtra("ivPoster"))
                .placeholder(R.drawable.placeholder)
                .into(ivPoster);
        rbDetail.setNumStars((int)Double.parseDouble(getIntent().getStringExtra("rating")));
    }

    public void returnToMain(View view) {
        finish();
    }
}
