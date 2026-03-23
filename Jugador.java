public class Jugador{
    private String nombre;
    private int cerebrosTotales;
    private boolean esHumano;
    
    public Jugador(String nombre){
        this.nombre=nombre;
        this.cerebrosTotales=0;
        this.esHumano = esHumano;
        
    }
    
    public void acumularCerebros(int cantidad){
        //Aqui va la suma de los cerebros totales del turno
        this.cerebrosTotales += cantidad;
    }
    
    public String getnombre(){
        return nombre;
        
    }
    
    public int getCerebrosTotales(){
        return cerebrosTotales;
    }
    
    public void resetearCont(){
        //Se pondran los cerebrosTurno en 0 y los disparosTurno tambien
    }
    
    public boolean esHumano(){
        return esHumano;
    }
    
    
}