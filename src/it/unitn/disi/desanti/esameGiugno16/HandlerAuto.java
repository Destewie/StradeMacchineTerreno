/*
 * Progetto di Des :)
 */
package it.unitn.disi.desanti.esameGiugno16;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Des
 */
public class HandlerAuto implements EventHandler<MouseEvent>
{
    @Override
    public void handle(MouseEvent event) 
    {
        System.out.println("evento mouse su macchina");
    }
    
}
