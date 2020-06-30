/*
 * Progetto di Des :)
 */
package it.unitn.disi.desanti.esameGiugno16;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 *
 * @author Des
 */
public class Auto extends Circle
{
    static final double RAGGIO = 15.0;
    
    public int x, y;
    
    public Auto(int x, int y)
    {
        super(Terreno.LATO/2, Terreno.LATO/2, RAGGIO);  //Non so come centrare la macchina all'interno di un riquadro nella gridpane
        
        this.x = x;
        this.y = y;
        
        this.setFill(Paint.valueOf("RED"));
        this.setStroke(Paint.valueOf("DARKRED"));
        this.setStrokeWidth(3);
        
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new HandlerAuto());
    }
}
