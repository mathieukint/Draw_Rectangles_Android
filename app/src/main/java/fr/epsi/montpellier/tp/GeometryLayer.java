package fr.epsi.montpellier.tp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class GeometryLayer extends View {

    ArrayList<RectangleGeo> list = new ArrayList<>();

    public GeometryLayer(Context context) {
        super(context);
    }

    public GeometryLayer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public GeometryLayer(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void ajouterRectangle(RectangleGeo rG){
        list.add(rG);
        invalidate();
    }

    public void effacerList(){
        list.clear();
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        for(RectangleGeo myRg : list){

            Paint p = new Paint();
            p.setColor(0xFFFF0000);
            p.setStrokeWidth(5);
            p.setStyle(Paint.Style.STROKE);
            canvas.drawRect(myRg.getX(), myRg.getY(), myRg.getWidth(), myRg.getHeight() , p);

        }


    }
}

