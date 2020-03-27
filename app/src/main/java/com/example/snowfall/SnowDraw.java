package com.example.snowfall;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class SnowDraw extends View {
    Snowflake[] snowflakes = new Snowflake[250];
    Paint p = new Paint();
    private static final java.util.Random RANDOM = new java.util.Random();

    public int getRandom(int lower, int upper) {
        int min = Math.min(lower, upper);
        int max = Math.max(lower, upper);
        return getRandom(max - min) + min;
    }

    public int getRandom(int upper) {
        return RANDOM.nextInt(upper);
    }


    public SnowDraw(Context context) {
        super(context);

        for (int i = 0; i < snowflakes.length; i++) {
            snowflakes[i] = new Snowflake();
        }
    }

    public SnowDraw(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        canvas.drawColor(Color.BLUE);
        p.setColor(Color.WHITE);
        for (Snowflake i : snowflakes) {
            canvas.drawCircle(i.x, i.y, i.r, p);
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        for (int i = 0; i < 250; i++) {
            snowflakes[i].move();
        }

        invalidate();
        return true;

    }

    class Snowflake {
        int x;
        int y;
        int r;
        int speed;


        public Snowflake() {
            x = getRandom(1500);
            y = getRandom(1300);
            r = getRandom(5, 13);
            speed = getRandom(1, 3);
        }

        void move() {
            x = x + speed;
            if (x > 1440) {
                x = 0;
            }

            y = y + speed;
            if (y > 2560) {
                y = 0;
            }
        }
    }
}

