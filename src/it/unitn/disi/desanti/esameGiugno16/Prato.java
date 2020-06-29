/*
 * Progetto di Des :)
 */
package it.unitn.disi.desanti.esameGiugno16;

import static java.awt.Color.GREEN;
import javafx.scene.paint.Paint;

/**
 *
 * @author Des
 */
public class Prato extends Terreno
{
    
    public Prato(int x, int y, WorldListener w) 
    {
        super(x, y, w);
        
        this.setFill(Paint.valueOf("GREEN"));
    }
    
}
