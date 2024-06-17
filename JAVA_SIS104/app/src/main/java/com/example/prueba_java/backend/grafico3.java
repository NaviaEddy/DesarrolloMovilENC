package com.example.prueba_java.backend;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.Random;

public class grafico3 extends View{

    private Random random;

    public grafico3(Context context){
        super(context);
        random = new Random();
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);

        Paint trunkPaint = new Paint();
        trunkPaint.setColor(Color.rgb(139, 69, 19));

        Paint leavesPaint = new Paint();
        leavesPaint.setColor(Color.rgb(0, 128, 0));

        Paint circlePaint = new Paint();
        circlePaint.setColor(Color.YELLOW);

        int width = getWidth();
        int height = getHeight();

        int trunkWidth = width / 4;
        int trunkHeight = height / 3;
        canvas.drawRect((width - trunkWidth) / 2, height - trunkHeight, (width + trunkWidth) / 2, height, trunkPaint);

        int x1 = width / 2;
        int y1 = 0;
        int x2 = 0;
        int y2 = height / 3;
        int x3 = width - 80;
        int y3 = height / 3;

        canvas.drawVertices(Canvas.VertexMode.TRIANGLES, 6,
                new float[]{x1, y1, x2, y2, x3, y3}, 0, null, 0, null, 0, null, 0, 0, leavesPaint);
    }

}
