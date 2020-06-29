/*
 * Progetto di Des :)
 */
package it.unitn.disi.desanti.esameGiugno16;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * Mi permette di implementare delle informazioni aggiuntive ad un bottone, come il codice direzione <br>
 * 
 * 1 = su; 2 = sx; 3 = dx; 4 = giù;
 * 
 * @author Des
 */
public class CommandButton extends Button
{
    int codiceDirezione;
    EsameStradeMacchineTerreno es;
    
    public CommandButton(String label, int cod, EsameStradeMacchineTerreno es)
    {
        super(label);
        
        this.es = es;
        
        codiceDirezione = cod;
        
        HandlerBottoniDirezioni hbd = new HandlerBottoniDirezioni(es);
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, hbd);
    }
}
