/*
 * Clase para guardar los datos del jugador, tambien nos ayuda con la
 * verificacion de si es Humano o es Bot, se guarda informacion como la cantidad
 * de cerebros totales.
 */
public class Jugador {
    private String nombre;
    private boolean esHumano;
    private int cerebrosTotales;

    public Jugador(String nombre, boolean esHumano) {
        this.nombre = nombre;
        this.esHumano = esHumano;
        this.cerebrosTotales = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean esHumano() {
        return esHumano;
    }

    public int getCerebrosTotales() {
        return cerebrosTotales;
    }

    public void acumularCerebros(int cantidad) {
        cerebrosTotales += cantidad;
    }
}