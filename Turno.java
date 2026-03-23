import java.util.ArrayList;

public class Turno {
    
    private ArrayList<ZombieDado> dadosCerebro; //Dado que se apartan y no regresan al vaso en el turno
    private ArrayList<ZombieDado> dadosDisparo; //Dados de disparo que te quedaras hasta llegar a 3 y perder turno 
                                                //o hasta que te plantes se regresan al vaso.
    private ArrayList<ZombieDado> dadosHuellas; //Dados que te quedas en mano para cada tiro
    private ArrayList<ZombieDado> dadosEnMano;  //LOs 3 dados que se estaran lanzando
    
    private Vaso vaso; 
    
    public Turno(Vaso vaso){
        //Constructor que recibira el vaso y inicializa
    }
    
    public void prepararMano(){
        //Utilizara el metodo rodar de los dados que esten en juego y los clasificara
    }
    
    public void lanzaYClasifica(){
        //Si sale Cerebro ira a nuestra ArrayList de dadosCerebro
        //Si sale Disparo ira a nuestra ArratList de dadosDisparo
        //Si sale Huellas ira a nuestra lista dadosHuellas
    }
    
    public boolean estaMuerto(){
        return false;
    }
    
    public int conteoCerebrosDeTurno(){
        return 0;
    }
    
    public void reinicioTurno(){
        
    }
    
     
}