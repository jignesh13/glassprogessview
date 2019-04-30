package com.example.glassprogessview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class LeterScaleView extends View {

    private Paint paint;
    private float progess=1.0f;
    private float strokewidth=5.0f;
    public LeterScaleView(Context context) {
        super(context);
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokewidth);
        paint.setTextSize(40);
    }

    public LeterScaleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokewidth);
        paint.setTextSize(40);

    }

    public LeterScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokewidth);
        paint.setTextSize(40);

    }

    public LeterScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokewidth);
        paint.setTextSize(40);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int k=10;
        int liter=0;
        float part=(getHeight()-60)/8.0f;
        part=part/10;
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawLine(getWidth()-30,getHeight(),getWidth(),getHeight(),paint);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText("0L",0,getHeight(),paint);
        for (int j=getHeight();j>0;j-=part){
            k++;
            if (k%10==0){
                liter+=250;
                paint.setStyle(Paint.Style.STROKE);
                canvas.drawLine(getWidth()-30,j,getWidth(),j,paint);
                paint.setStyle(Paint.Style.FILL);
                canvas.drawText(""+liter/1000.0f+"L",0,j+20,paint);
            }
            else {
                paint.setStyle(Paint.Style.STROKE);
                canvas.drawLine(getWidth()-10,j,getWidth(),j,paint);
            }
        }
    }
}
