package com.wind.simonarcview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    private HomeBanner homeBanner;
    private ArcImageView arcImageView;
    private SimonArcView simonArcView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeBanner= (HomeBanner) findViewById(R.id.arc_view_pager);
        homeBanner.setImagesRes(new int[]{R.drawable.banner5,R.drawable.banner5,R.drawable.banner5});
        arcImageView= new ArcImageView(this);
        //调节缩放比例 （0-1）
        arcImageView.setScale(0.8f);

        simonArcView= (SimonArcView) findViewById(R.id.sav_img);
        simonArcView.setArcHeight(50);
    }
}
