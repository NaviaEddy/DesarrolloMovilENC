package com.example.prueba_java.backend;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import java.util.Random;

import androidx.annotation.NonNull;

public class grafico2 extends View {
    private Random random;

    public grafico2(Context context){
        super(context);
        random = new Random();
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);

        Paint paint1 = new Paint();

        int maxRadius = 50;

        for(int i = 0; i < 30; i++){
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);
            paint1.setColor(Color.rgb(r, g, b));
            float radius = random.nextInt(maxRadius);
            float x = random.nextInt(canvas.getWidth() - (int) (2 * radius)) + radius;
            float y = random.nextInt(canvas.getHeight() - (int) (2 * radius)) + radius;
            canvas.drawCircle(x, y, radius, paint1);
        }

    }


}
