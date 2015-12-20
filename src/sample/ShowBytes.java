package sample;

import javafx.scene.shape.Rectangle;

public class ShowBytes {
    public static Rectangle[] rectangles(byte[] array, int length) {
        if (length > array.length) throw new ArrayIndexOutOfBoundsException();
        final int width = 5;
        Rectangle[] rect = new Rectangle[array.length];
        for (int i = 0, j = 10; i < rect.length; i++, j+=width) {
            rect[i] = new Rectangle();
            if (array[i] < 0){
                rect[i].setHeight(Math.abs(array[i]));
                rect[i].setY(200);
            } else {
                rect[i].setHeight(array[i]);
                rect[i].setY(200 - array[i]);
            }
            rect[i].setWidth(5);
            rect[i].setX(j);
        }
        return rect;
    }
}
