/*
 * Progetto di Des :)
 */
package it.unitn.disi.desanti.esameGiugno16;

import java.io.IOException;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author Des
 */
public class HandlerInizia implements EventHandler
{
    EsameStradeMacchineTerreno es;
    
    public HandlerInizia(EsameStradeMacchineTerreno es)
    {
        this.es = es;
    }
    
    @Override
    public void handle(Event event) 
    {
        es.btnInizia.setDisable(true);
        
        CommandButton btnUp = new CommandButton("SU", 1, es);
        CommandButton btnSx = new CommandButton("SX", 2, es);
        CommandButton btnDx = new CommandButton("DX", 3, es); 
        CommandButton btnDwn = new CommandButton("GIU'", 4, es);
        
        
        AnchorPane apAncoraBottoni = new AnchorPane(btnUp, btnDx, btnSx, btnDwn);
        
        AnchorPane.setTopAnchor(btnUp, 50.0);
        AnchorPane.setLeftAnchor(btnUp, 100.0);
        
        AnchorPane.setTopAnchor(btnDx, 100.0);
        AnchorPane.setLeftAnchor(btnDx, 150.0);
        
        AnchorPane.setTopAnchor(btnSx, 100.0);
        AnchorPane.setLeftAnchor(btnSx, 50.0);
        
        AnchorPane.setTopAnchor(btnDwn, 150.0);
        AnchorPane.setLeftAnchor(btnDwn, 95.0);
        
        
        
        
        
        Stage finestraComandi = new Stage();
        finestraComandi.setTitle("Comandi auto");
        finestraComandi.setScene(new Scene(apAncoraBottoni, 220, 220));
        finestraComandi.show();
        
        // Hide this current window (if this is what you want)
//        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
}
