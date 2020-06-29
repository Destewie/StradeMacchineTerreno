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
public class HandlerBottoniDirezioni implements EventHandler<MouseEvent>
{
    EsameStradeMacchineTerreno es;
    int dir;
           
            
    public HandlerBottoniDirezioni(EsameStradeMacchineTerreno es)
    {
        this.es = es;
    }
    
    @Override
    public void handle(MouseEvent event) 
    {
        dir = ((CommandButton)event.getSource()).codiceDirezione;
        es.wm.ControllaMovimento(dir);
    }
    
}
