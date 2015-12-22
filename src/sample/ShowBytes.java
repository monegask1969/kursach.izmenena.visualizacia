package sample;

import com.sun.javafx.geom.RoundRectangle2D;
import com.sun.javafx.jmx.HighlightRegion;
import javafx.scene.effect.Blend;
import javafx.scene.effect.Bloom;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;

public class ShowBytes {
    public static Rectangle[] rectangles(byte[] array, int length) {
        if (length > array.length) throw new ArrayIndexOutOfBoundsException();
        final int width = 20;
        Rectangle[] rec = new Rectangle[array.length];
        for (int i = 0, j = 20; i < rec.length; i++, j+=width) {
            rec[i] = new Rectangle();
            if (array[i] < 0){
                rec[i].setHeight(Math.abs(array[i]));
                rec[i].setY(200);
                rec[i].setFill(Color.RED);
                rec[i].setStroke(Color.RED);
            } else {
                rec[i].setHeight(array[i]);
                rec[i].setY(200 - array[i]);
                rec[i].setStroke(Color.GREEN);
                rec[i].setFill(Color.GREEN);
                rec[i].setStrokeLineCap(StrokeLineCap.ROUND);
            }
            rec[i].setWidth(10);
            rec[i].setX(j);
        }
        return rec;
    }
}
