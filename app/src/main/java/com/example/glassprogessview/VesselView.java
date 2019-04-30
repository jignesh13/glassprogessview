package com.example.glassprogessview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class VesselView extends View {
    private Paint paint;
    private float progess=1.0f;
    public VesselView(Context context) {
        super(context);
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(8.0f);
    }

    public VesselView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(8.0f);
    }

    public VesselView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(8.0f);
    }

    public VesselView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(8.0f);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {


        // Fill the canvas with background color
        canvas.drawColor(Color.WHITE);
        // paint.setShader(null);
        Path path=new Path();
        paint.setColor(Color.BLACK);
        path.moveTo(0,0);
       // path.cubicTo(250, 150, 150, 700, 50, 1200);
        path.cubicTo(0,getHeight(),20,getHeight(),(getWidth()/2.0f),getHeight());
        path.cubicTo(getWidth()/1.0f,getHeight(),getWidth()/1.0f,getHeight()-20,getWidth(),0);
             // path.cubicTo(1030,50,1030,50,1030,50);
        path.lineTo(0,0);
       // path.cubicTo(800, 50, 750, 700, 950, 1400);
        //path.cubicTo(50,1400,400,1300,950,1400);
        paint.setAntiAlias(true);
        Rect rect = new Rect((int)(canvas.getWidth()*0),(int)(canvas.getHeight()*progess),(int) canvas.getWidth(), (int) canvas.getHeight());
        canvas.clipPath(path);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPath(path, paint);
        paint.setColor(Color.rgb(193,225,227));
        canvas.drawRect(rect,paint);
        paint.setColor(Color.BLACK); // Change the boundary color
        paint.setStrokeWidth(8);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, paint);

        super.onDraw(canvas);

    }
    public void setprogess(float newprogess){

        ValueAnimator valueAnimator=ValueAnimator.ofFloat(progess,newprogess).setDuration(600);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                progess = (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.start();
    }
}
