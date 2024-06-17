package com.example.prueba_java.backend;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import androidx.annotation.NonNull;

public class grafico extends View {
    public grafico(Context context){
        super(context);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        canvas.drawLine(10, 10, 50, 50, paint);
        for(int i=1; i<=500; i+=1){
            paint.setColor(Color.argb(150, 120, 60, 1));
            canvas.drawLine(10, 10, 510-i, 10+i, paint);
        }

        Paint paint3 = new Paint();
        paint3.setColor(Color.GRAY);
        canvas.drawCircle(500, 1400, 150, paint3);

        Paint paint2 = new Paint();
        paint2.setColor(Color.GREEN);
        canvas.drawCircle(700, 1500, 150, paint2);

        Paint paintLine = new Paint();
        paintLine.setColor(Color.WHITE);
        paintLine.setStrokeWidth(10);

        canvas.drawLine(500 - 150, 1400, 700 - 150, 1500, paintLine);
        canvas.drawLine(500 + 150, 1400, 700 + 150, 1500, paintLine);

    }
}
