package com.wind.simonarcview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhangcong on 2017/11/2.
 */

public class SimonArcView extends View {
    private Paint paint;
    private PointF startPoint,endPoint,controlPoint;
    private int width;
    private int height;
    private int ArcHeight=100;
    private Path path;
    private int startColor;
    private int endColor;
    private LinearGradient linearGradient;
    public SimonArcView(Context context) {
        super(context);
    }

    public SimonArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }



    public SimonArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void init() {
        paint=new Paint();
        paint.setAntiAlias(true);

        startPoint=new PointF(0,0);
        endPoint=new PointF(0,0);
        controlPoint=new PointF(0,0);
        path=new Path();

        startColor= Color.parseColor("#FF3A80");
        endColor=Color.parseColor("#FF3745");
    }



    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width=w;
        height=h;

        path.reset();

        path.moveTo(0,0);
        path.addRect(0,0,width,height-ArcHeight,Path.Direction.CCW);
        startPoint.x=0;
        startPoint.y=height-ArcHeight;

        endPoint.x=width;
        endPoint.y=height-ArcHeight;

        controlPoint.x=width/2;
        controlPoint.y=height+ArcHeight;

        linearGradient=new LinearGradient(width/2,0,width/2,height,startColor,endColor, Shader.TileMode.MIRROR);

        invalidate();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setShader(linearGradient);
        path.moveTo(startPoint.x,startPoint.y);
        path.quadTo(controlPoint.x,controlPoint.y,endPoint.x,endPoint.y);

        canvas.drawPath(path,paint);
    }
}
