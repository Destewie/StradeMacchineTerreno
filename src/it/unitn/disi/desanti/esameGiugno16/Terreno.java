/*
 * Progetto di Des :)
 */
package it.unitn.disi.desanti.esameGiugno16;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Des
 */
abstract class Terreno extends Rectangle
{
    static final int LATO = 50;
    public int x, y;
    
    public Terreno(int x, int y, WorldListener w)
    {
        super();
        
        this.x = x;
        this.y = y;
        
        this.setWidth(LATO);
        this.setHeight(LATO);
        this.setStroke(Color.BLACK);
        
        this.addEventFilter(MouseEvent.MOUSE_CLICKED, w);
    }
}
