package com.example.glassprogessview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class HeartView extends View {

    private Path path;

    private Paint paint;
    private float progess=1.0f;

    public HeartView(Context context) {
        super(context);

        path = new Path();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }


    public HeartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        path = new Path();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    }

    public HeartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        path = new Path();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    }

    public HeartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        path = new Path();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

        @Override
        protected void onDraw(Canvas canvas) {


            // Fill the canvas with background color
            //canvas.drawColor(Color.WHITE);
            paint.setShader(null);

            float width = getWidth();
            float height = getHeight();

            // Starting point
            path.moveTo(width / 2, height / 5);

            // Upper left path
            path.cubicTo(5 * width / 14, 0,
                    0, height / 15,
                    width / 28, 2 * height / 5);

            // Lower left path
            path.cubicTo(width / 14, 2 * height / 3,
                    3 * width / 7, 5 * height / 6,
                    width / 2, height);

            // Lower right path
            path.cubicTo(4 * width / 7, 5 * height / 6,
                    13 * width / 14, 2 * height / 3,
                    27 * width / 28, 2 * height / 5);

            // Upper right path
            path.cubicTo(width, height / 15,
                    9 * width / 14, 0,
                    width / 2, height / 5);
            paint.setStrokeWidth(5.0f);
            paint.setColor(Color.RED);
            paint.setStyle(Style.STROKE);

            canvas.drawPath(path, paint);
            RectF rectF=new RectF(0,(canvas.getHeight()*progess),getWidth(),getHeight());
            paint.setStyle(Style.FILL);
            canvas.clipPath(path);

            canvas.drawRect(rectF,paint);
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