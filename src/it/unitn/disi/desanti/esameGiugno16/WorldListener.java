/*
 * Progetto di Des :)
 */
package it.unitn.disi.desanti.esameGiugno16;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

/**
 * E' l'handler generale che risponde ai click del mouse sulla griglia di gioco
 * @author Des
 */
public class WorldListener implements EventHandler<MouseEvent> 
{

    EsameStradeMacchineTerreno es;

    int pressedX, pressedY;

    public WorldListener(EsameStradeMacchineTerreno es) 
    {
        this.es = es;
    }

    @Override
    public void handle(MouseEvent event) 
    {        
        if (event.getSource() instanceof Terreno) 
        {
            Terreno t = (Terreno) event.getSource(); //il pezzo di terreno in cui ho cliccato
            
            pressedX = t.x; //la coordinata x del quadratino della griglia cliccato
            pressedY = t.y; //la coordinata y del quadratino della griglia cliccato

            System.out.println("premuta la piastrella in (" + t.x + ", " + t.y + ")");

            if (t instanceof Prato && !es.mettoMacchina) //se il pezzo di terra è un prato
            {
                Node temp = null;
                for (Node terr : es.world.getChildren()) 
                {
                    if (terr instanceof Terreno && ((Terreno) terr).x == pressedX && ((Terreno) terr).y == pressedY) 
                    {
                        temp = terr;
                    }
                }
                if (temp != null) 
                {
                    es.world.getChildren().remove(temp);
                    es.world.add(new Strada(pressedX, pressedY, es.wl), pressedX, pressedY);
                    es.wm.Posiziona(pressedX, pressedY, 1);
                }
            } 
            else if (t instanceof Strada) //se il pezzo di terra è una strada
            {
                if (!es.mettoMacchina) //se il prossimo click non è per posizionare una macchina ma per cambiare tra strada e prato
                {
                    boolean autorizzazione1 = true; //è l'autorizzazione a togliere l'asfalto
                    
                    for (Node macchina : es.world.getChildren()) 
                    {
                        if (macchina instanceof Auto && pressedX == ((Auto) macchina).x && pressedY == ((Auto) macchina).y) 
                        {
                            autorizzazione1 = false; //se c'è una macchina sopra all'asfalto tolgo l'autorizzazione
                            System.out.println("Non puoi farlo, lì c'è una macchina!");
                        }

                    }

                    Node temp = null;
                    for (Node s : es.world.getChildren()) 
                    {
                        if (s instanceof Strada && ((Strada) s).x == pressedX && ((Strada) s).y == pressedY && autorizzazione1) 
                        {
                            temp = s;
                        }
                    }
                    if (temp != null) 
                    {
                        es.world.getChildren().remove(temp);
                        es.world.add(new Prato(pressedX, pressedY, es.wl), pressedX, pressedY);
                        es.wm.Posiziona(pressedX, pressedY, 0);
                    }
                }
                else //se il prossimo click è atto a posizionare una macchina
                {
                    if(es.autoDisponibili > 0)
                    {
                        boolean autorizzazione2 = true; //è l'autorizzazione a posizionare una macchina

                        for (Node macchina : es.world.getChildren()) 
                        {
                            if (macchina instanceof Auto && pressedX == ((Auto) macchina).x && pressedY == ((Auto) macchina).y) 
                            {
                                autorizzazione2 = false; //se c'è una macchina proprio dove ne vorrei mettere una, tolgo l'autorizzazione a posizionarne un'altra
                                System.out.println("Non puoi posizionare una macchina dove ce n'è già una!");
                            }
                        }

                        if(autorizzazione2)
                        {
                            es.world.add(new Auto(pressedX, pressedY), pressedX, pressedY);
                            es.wm.Posiziona(pressedX, pressedY, 2);
                            es.autoDisponibili--;
                            es.txtNumAuto.setText(Integer.toString(es.autoDisponibili));
                            es.mettoMacchina = false;
                        }

                    }
                }

            }

        }

    }

}
