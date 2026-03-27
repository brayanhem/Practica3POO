import java.util.Random;

public class ZombieDado
{
    private String color;
    private String caraActual;
    private ZombieDadoView vista;
    private Random random;
    
    //Constructor del Dado
    public ZombieDado(String color){
        this.color = color;
        this.random= new Random();
        this.vista = new ZombieDadoView(color);
        this.caraActual = "";
    }
    
    //Metodo para girar el dado, esta basado en la probabilidad real dell juego
    public void rodar(){
        int r = random.nextInt(6);
        if (color.equals("green")) {
            if (r <= 2) 
                caraActual = "Cerebro";
            else if (r <= 4)
                caraActual = "Pasos";
            else 
                caraActual = "Disparo";
        } else if (color.equals("yellow")) {
            if (r <= 1)
                caraActual = "Cerebro";
            else if (r <= 3) 
                caraActual = "Pasos";
            else 
                caraActual = "Disparo";
        } else { // Color rojo(red)
            if (r == 0)     
                caraActual = "Cerebro";
            else if (r <= 2) 
                caraActual = "Pasos";
            else 
                caraActual = "Disparo";
        }
        actualizarImagen();
    }
    
    //Ayuda a actualizar la imagen del juego cada que se tira el dado
    private void actualizarImagen(){
        if (caraActual.equals("Cerebro")) vista.mostrarCerebro();
        else if (caraActual.equals("Pasos")) vista.mostrarPasos();
        else vista.mostrarDisparo();
    }
    
    public String getColor(){
        return color;
    }
    
    public String getCaraActual(){
        return caraActual;
    }
    
    public void mover(int x, int y){
        vista.moverDados(x,y);
    }
    
    public void ocultar(){
        vista.hacerInvisible();
    }
    
    public ZombieDadoView getVista(){
        return vista;
    }
    
    
    public String toString() {
    return "Dado " + color + " -> " + caraActual;
    }
}