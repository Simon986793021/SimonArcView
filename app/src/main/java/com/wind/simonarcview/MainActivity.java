package com.wind.simonarcview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wind.arcview.SimonArcView;

public class MainActivity extends AppCompatActivity {
    private HomeBanner homeBanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeBanner= (HomeBanner) findViewById(R.id.arc_view_pager);
        homeBanner.setImagesRes(new int[]{R.drawable.banner3,R.drawable.banner2,R.drawable.banner1});
    }
}
