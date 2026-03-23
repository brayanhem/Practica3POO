import java.util.ArrayList;


public class ZombieDiceGame
{
    
        private Vaso vaso;
        private ArrayList<Jugador>jugadores;
        private ArrayList<ZombieDado> dadosEnMano;
        private boolean finTurno;
        
    public ZombieDiceGame(){
    }
    
    public void agregarJudagor(String nombre){
        //Añade a los jugadores
    }
    
    public void iniciarTurno(){
        //Saca 3 dadods del vaso
    }
    
    public void tirarDados(){
        //Lanza los 3 dados y actualiza el jugaddor depende lo que salga
    }
    
    public void plantarse(){
        //El jugador decide no arriesgar y guarad ssus puntos
    }
    
    public Jugador determinaGanador(){
        //Revisara que jugador tiene mas cerebros al final de la ronda
        return null;
    }
    
}