/*
 * Progetto di Des :)
 */
package it.unitn.disi.desanti.esameGiugno16;

/**
 * Diciamo che mi viene più facile vedere i surroundings di ogni cella con una matrice rispetto che con una gridpane. <br>
 * 
 * Questa matrice sarà una sorta di replica della gridpane ma con i numeri <br><br>
 * 
 * 0 = Prato <br>
 * 1 = Strada <br>
 * 2 = Macchina (che dà per scontato il fatto che sotto ci sia una strada) <br>
 * 
 * @author Des
 */
public class WorldMatrix 
{
    int[][] matrix;
    EsameStradeMacchineTerreno es;
    
    public WorldMatrix(EsameStradeMacchineTerreno es) 
    {
        this.matrix = new int[EsameStradeMacchineTerreno.NUMRIGHE][EsameStradeMacchineTerreno.NUMCOLONNE];
        this.es = es;
    }
    
    /**
     * Mi permette di configurare la matrice. <br>
     * Visto che tutti i controlli sono già stati fatti guardando direttamente la gridpane, non serve che li replichi qui <br>
     * 
     * @param x posizione x del pezzo da posizionare
     * @param y posizione x del pezzo da posizionare
     * @param codiceTerreno 0 = Prato; 1 = Strada; 2 = Macchina;
     */
    public void Posiziona(int x, int y, int codiceTerreno)  
    {
        matrix[x][y] = codiceTerreno;
    }
    
    /**
     * Torna il tipo di un determinato blocco della matrice
     */
    public int TypeOf(int x, int y)
    {
        if(x>=0 && x <=7 && y>=0 && y <=7)
            return matrix[x][y];
        else
            return -1;
    }
    
    /**
     * Serve a controllare che il movimento in una data direzione sia consentito
     * @param dir è un intero che rappresenta la direzione: 1 = su; 2 = sx; 3= dx; 4 = giù;
     */
    public void ControllaMovimento(int dir)
    {
        switch(dir)
        {
            case 1:
                System.out.println("Muovo le macchine verso l'alto!");
                for(int i = 0; i < EsameStradeMacchineTerreno.NUMRIGHE; i ++)
                {       
                    for(int j = 0; j < EsameStradeMacchineTerreno.NUMCOLONNE; j ++)
                    {
                        if(TypeOf(i,j)==2)   //se in questa posizione c'è una macchina
                        {
                            if(TypeOf(i,j-1)==1 || TypeOf(i,j-1)==2)    //controllo che sopra ci sia il via libera
                            {
                                matrix[i][j] = 1;
                                matrix[i][j-1] = 2;
                                System.out.println("Muovo la macchina da (" + i + ", " + j + ") a ("+ i + ", " + (j-1) + ")");
                                es.MuoviMacchina(i, j, i, j-1);
                            }
                        }
                    }
                }

                break;

            case 2:
                System.out.println("Muovo le macchine a sinistra!");
                for(int i = 0; i < EsameStradeMacchineTerreno.NUMRIGHE; i ++)
                {       
                    for(int j = 0; j < EsameStradeMacchineTerreno.NUMCOLONNE; j ++)
                    {
                        if(TypeOf(i,j)==2)  //se in questa posizione c'è una macchina
                        {
                            if(TypeOf(i-1,j)==1 || TypeOf(i-1,j)==2)    //controllo che a sinistra ci sia il via libera
                            {
                                matrix[i][j] = 1;
                                matrix[i-1][j] = 2;
                                System.out.println("Muovo la macchina da (" + i + ", " + j + ") a ("+ (i-1) + ", " + j + ")");
                                es.MuoviMacchina(i, j, i-1, j);
                            }
                        }
                    }
                }
                
                break;

            case 3:
                System.out.println("Muovo le macchine a destra!");
                for(int i = EsameStradeMacchineTerreno.NUMRIGHE-1; i >= 0; i --)
                {       
                    for(int j = EsameStradeMacchineTerreno.NUMCOLONNE-1; j >= 0 ; j --)
                    {
                        if(TypeOf(i,j)==2)  //se in questa posizione c'è una macchina
                        {
                            if(TypeOf(i+1,j)==1 || TypeOf(i+1,j)==2)    
                            {
                                matrix[i][j] = 1;
                                matrix[i+1][j] = 2;
                                System.out.println("Muovo la macchina da (" + i + ", " + j + ") a ("+ (i+1) + ", " + j + ")");
                                es.MuoviMacchina(i, j, i+1, j);
                            }
                        }
                    }
                }
                
                break;

            case 4:
                System.out.println("Muovo le macchine verso il basso!");
                for(int i = EsameStradeMacchineTerreno.NUMRIGHE-1; i >= 0; i --)
                {       
                    for(int j = EsameStradeMacchineTerreno.NUMCOLONNE-1; j >= 0 ; j --)
                    {
                        if(TypeOf(i,j)==2)  //se in questa posizione c'è una macchina
                        {
                            if(TypeOf(i,j+1)==1 || TypeOf(i,j+1)==2)    
                            {
                                matrix[i][j] = 1;
                                matrix[i][j+1] = 2;
                                System.out.println("Muovo la macchina da (" + i + ", " + j + ") a ("+ i + ", " + (j+1) + ")");
                                es.MuoviMacchina(i, j, i, j+1);
                            }
                        }
                    }
                }
                
                break;
        }   
        
    }
    
    
    public int ContaAuto()
    {
        int n = 0;
        
        for(int i = 0; i < EsameStradeMacchineTerreno.NUMRIGHE; i ++)
        {       
            for(int j = 0; j < EsameStradeMacchineTerreno.NUMCOLONNE; j ++)
            {
                if(TypeOf(i,j)==2)   //se in questa posizione c'è una macchina
                {
                    n++;
                }
            }
        }
        
        return n;
    }
    
    
}