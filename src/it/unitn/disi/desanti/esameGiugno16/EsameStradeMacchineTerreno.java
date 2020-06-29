/*
 * Progetto di Des :)
 */
package it.unitn.disi.desanti.esameGiugno16;


import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author Des
 */
public class EsameStradeMacchineTerreno extends Application {

    static final int NUMRIGHE = 8;
    static final int NUMCOLONNE = 8;
    static final int NUMAUTO = 3;
    
    
    WorldListener wl;  
    GridPane world;
    
    WorldMatrix wm = new WorldMatrix(this);
    
    int autoDisponibili = NUMAUTO;
    boolean mettoMacchina = false;
    boolean inGame = false;
    
    Label txtNumAuto;
    Button btnAggiungiAuto;
    Button btnInizia;
    

    @Override
    public void start(Stage primaryStage) 
    {
        
        wl = new WorldListener(this);
        
        //preparazione mondo di gioco -- gridpane
        world = new GridPane();

        for (int i = 0; i < NUMRIGHE; i++) 
        {
            for (int j = 0; j < NUMCOLONNE; j++) 
            {
                if (i == 0 || i == NUMRIGHE - 1 || j == 0 || j == NUMCOLONNE - 1) 
                {
                    world.add(new Strada(i, j, wl), i, j);
                    wm.Posiziona(i,j,1);
                } else 
                {
                    world.add(new Prato(i, j, wl), i, j);
                    wm.Posiziona(i,j,0);
                }
            }
        }

        //Preparazione parte sulla destra
        Label txtAutoDisponibili = new Label("Auto disponibili:");
        txtNumAuto = new Label(Integer.toString(autoDisponibili));
        
        btnAggiungiAuto = new Button("Aggiungi Auto");
        HandlerAggiungiAuto haa = new HandlerAggiungiAuto(this);
        btnAggiungiAuto.setOnAction(haa);
        
        btnInizia = new Button("Inizia!");
        HandlerInizia hi = new HandlerInizia(this);
        btnInizia.setOnAction(hi);
       
        //Preparazione ancoraggio del tutto
        AnchorPane gui = new AnchorPane(world, txtAutoDisponibili, txtNumAuto, btnAggiungiAuto, btnInizia);
        
        AnchorPane.setTopAnchor(world, 0.0);
        AnchorPane.setLeftAnchor(world, 0.0);
        
        AnchorPane.setTopAnchor(txtAutoDisponibili, 70.0);
        AnchorPane.setRightAnchor(txtAutoDisponibili, 180.0);
        
        AnchorPane.setTopAnchor(txtNumAuto, 70.0);
        AnchorPane.setRightAnchor(txtNumAuto, 150.0);
        
        AnchorPane.setTopAnchor(btnAggiungiAuto, 100.0);
        AnchorPane.setRightAnchor(btnAggiungiAuto, 150.0);
        
        AnchorPane.setTopAnchor(btnInizia, 140.0);
        AnchorPane.setRightAnchor(btnInizia, 150.0);
        

        //-----------------------------------------------------------
        Scene scene = new Scene(gui, Terreno.LATO * this.NUMCOLONNE + this.NUMCOLONNE + 300, Terreno.LATO * this.NUMRIGHE + this.NUMRIGHE);

        primaryStage.setTitle("Esame sulle macchine!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }

    /**
     * Metodo per far muovere graficamente le macchine
     * @param xPos x attuale della macchina
     * @param yPos y attuale della macchina
     * @param xNewPos nuova x della macchina
     * @param yNewPos nuova y della macchina
     * @return Se c'è stato un crash o meno
     */
    public boolean MuoviMacchina(int xPos, int yPos, int xNewPos, int yNewPos)
    {
        boolean crash = false;
        
        int nMacchineIniz = NUMAUTO - autoDisponibili; 
        int nMacchineFin;
        
        Auto aMuovi = null;
        for(Node a : world.getChildren())
        {
            if(a instanceof Auto)
            {
                if(((Auto)a).x == xPos  && ((Auto)a).y == yPos)
                {
                    aMuovi = (Auto)a;
                }
            }
        }
        
        world.getChildren().remove(aMuovi);
        world.add(new Auto(xNewPos, yNewPos), xNewPos, yNewPos);
        System.out.println("Creo una nuova macchina in (" + xNewPos + ", " + yNewPos + ")");
        
        nMacchineFin = wm.ContaAuto();
        
        if(nMacchineIniz != nMacchineFin)
        {
            crash = true;
            System.out.println("CRASH!");
            Crash();
        }
        
        return crash;
    }
    
    public void Crash()
    {
        Circle c = new Circle(30);
        c.setStroke(Color.DARKRED);
        c.setFill(Color.RED);
        
        Label l = new Label("CRASH!");
        
        StackPane sp = new StackPane(c, l);
        
        Scene s = new Scene(sp, 200, 200);
        Stage crashStage = new Stage();
        crashStage.setTitle("CRASH!");
        crashStage.setScene(s);
        crashStage.show();
    }
}
