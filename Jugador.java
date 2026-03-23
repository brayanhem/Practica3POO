public class Jugador {
    private String nombre;
    private int cerebrosTotales;
    private boolean esHumano; //para distinguir de los bots

    public Jugador(String nombre, boolean esHumano) {
        this.nombre = nombre;
        this.esHumano = esHumano;
        this.cerebrosTotales = 0;
    }

 
    public void acumularCerebros(int puntos) {
        this.cerebrosTotales = this.cerebrosTotales + puntos;
    }

    public String getnombre() { 
        return this.nombre;
    }

    public int getCerebrosTotales() {
        return this.cerebrosTotales;
    }

    public boolean esHumano() {
        return this.esHumano;
    }
}