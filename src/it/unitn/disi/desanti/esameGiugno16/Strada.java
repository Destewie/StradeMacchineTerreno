/*
 * Progetto di Des :)
 */
package it.unitn.disi.desanti.esameGiugno16;

import javafx.scene.paint.Paint;

/**
 *
 * @author Des
 */
public class Strada extends Terreno
{
    
    public Strada(int x, int y, WorldListener w) 
    {
        super(x, y, w);
        this.setFill(Paint.valueOf("LIGHTGREY"));
    }
    
}
