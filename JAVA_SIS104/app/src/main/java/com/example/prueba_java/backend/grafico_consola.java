package com.example.prueba_java.backend;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

public class grafico_consola extends View {
    private static final String TAG = "Grafico";
    private static final String TAG1 = "Y";
    private static final String TAG2 = "Xt";

    public grafico_consola(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.BLACK);
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);

        int ancho = canvas.getWidth();
        int alto = canvas.getHeight();
        Log.d(TAG, "ancho:" + ancho + "alto:" + alto);
        canvas.drawLine(0, alto/2, ancho, alto/2, paint);
        canvas.drawLine(ancho/2, 0, ancho/2, alto, paint);
        canvas.drawLine(ancho, 0, 0, alto, paint);

        for(float j=0; j<=10; j+=0.03){
            float limitInfX = -20+j;
            float limitSupX = 20+j;
            float LimitInfY = -20+j;
            float LimitSupY = 20+j;


            for (float x = limitInfX; x <= limitSupX; x += 0.1) {
                double Y = fx(x);
                double xt = ((x - limitInfX) / (limitSupX - limitInfX)) * ancho;
                double yt = alto - ((Y - LimitInfY) / (LimitSupY - LimitInfY)) * alto;
                //ouble zt = ((x - limitInfZ) / (limitSupZ - limitInfZ)) * ancho;
                paint.setColor(Color.YELLOW);
                canvas.drawCircle((float) xt, (float) yt, 3, paint);
            }
        }



    }

    double fx(float x){
        return x*x;
    }

}
