package com.wind.simonarcview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Shader;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import com.wind.arcview.SimonArcView;

/**
 * Created by zhangcong on 2017/11/7.
 */

public class ArcImageView extends android.support.v7.widget.AppCompatImageView {
    private Paint paint;
    private PointF startPoint;
    private PointF endPoint;
    private PointF controlPoint;
    private int width;
    private int height;
    private int ArcHeight = 50;
    private Path path;
    private String startColor;
    private String endColor;
    private Bitmap bitmap;
    public ArcImageView(Context context) {
        super(context);
    }

    public ArcImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public ArcImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void init() {
        Log.i(">>>>>","222222");
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.startPoint = new PointF(0.0F, 0.0F);
        this.endPoint = new PointF(0.0F, 0.0F);
        this.controlPoint = new PointF(0.0F, 0.0F);
        this.path = new Path();
        this.startColor = "#11cd6e";
        this.endColor = "#92EFC0";
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.width = w;
        this.height = h;
        this.path.reset();
        this.path.moveTo(0.0F, 0.0F);
        this.path.addRect(0.0F, 0.0F, (float)this.width, (float)(this.height - this.ArcHeight), Path.Direction.CCW);
        this.startPoint.x = 0.0F;
        this.startPoint.y = (float)(this.height - this.ArcHeight);
        this.endPoint.x = (float)this.width;
        this.endPoint.y = (float)(this.height - this.ArcHeight);
        this.controlPoint.x = (float)(this.width / 2);
        this.controlPoint.y = (float)(this.height + this.ArcHeight);
        this.invalidate();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (bitmap!=null)
        {
            Shader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            paint.setShader(shader);
            this.path.moveTo(this.startPoint.x, this.startPoint.y);
            this.path.quadTo(this.controlPoint.x, this.controlPoint.y, this.endPoint.x, this.endPoint.y);
            canvas.drawPath(this.path,this.paint);
            Log.i(">>>>>","333333");
        }

    }
    @Override
    public void setImageResource(@DrawableRes int resId) {
        bitmap = BitmapFactory.decodeResource(getResources(),resId);
        Log.i(">>>>>",">>>>");
    }
}
