package com.wind.simonarcview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private SimonArcView simonArcView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simonArcView= (SimonArcView) findViewById(R.id.arcview);
        simonArcView.setColor("#11cd6e","#cccccc");
        simonArcView.setArcHeight(50);
    }
}
