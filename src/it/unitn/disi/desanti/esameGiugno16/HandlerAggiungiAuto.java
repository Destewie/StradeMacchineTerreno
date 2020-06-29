/*
 * Progetto di Des :)
 */
package it.unitn.disi.desanti.esameGiugno16;

import javafx.event.Event;
import javafx.event.EventHandler;


/**
 *
 * @author Des
 */
public class HandlerAggiungiAuto implements EventHandler
{
    EsameStradeMacchineTerreno es;
    
    public HandlerAggiungiAuto(EsameStradeMacchineTerreno es)
    {
        this.es = es;
    }

    @Override
    public void handle(Event event) 
    {
        if(es.autoDisponibili > 0)
        {
            es.mettoMacchina = true;
        }
        
        if(es.autoDisponibili == 1)
        {
            es.btnAggiungiAuto.setDisable(true);
        }
    }
}
