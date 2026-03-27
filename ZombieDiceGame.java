import java.util.ArrayList;

public class ZombieDiceGame {
    private Vaso vaso;
    private ArrayList<Jugador> jugadores;
    private int indiceActual;
    private Turno turnoActual;

    public ZombieDiceGame() {
        vaso = new Vaso();
        jugadores = new ArrayList<Jugador>();
        indiceActual = 0;
    }

    public void agregarJugador(String nombre, boolean esHumano) {
        jugadores.add(new Jugador(nombre, esHumano));
    }

    public void iniciarTurno() {
        vaso.llenarVaso();
        turnoActual = new Turno();
    }

    public void tirarDados() {
        if (turnoActual != null) {
            turnoActual.lanzar(vaso);
        }
    }

    public void plantarse() {
        Jugador actual = jugadores.get(indiceActual);

        actual.acumularCerebros(turnoActual.getCerebros());

        vaso.devolverDado(turnoActual.getDadosRestantes());

        if (actual.getCerebrosTotales() < 13) {
            siguienteJugador();
        }
    }

    private void siguienteJugador() {
        indiceActual = (indiceActual + 1) % jugadores.size();
    }

    public void siguienteTurnoPorPerdida() {
        siguienteJugador();
    }

    public Jugador getJugadorActual() {
        return jugadores.get(indiceActual);
    }

    public boolean jugadorActualEsHumano() {
        return getJugadorActual().esHumano();
    }

    public int getCerebrosTurno() {
        return turnoActual.getCerebros();
    }

    public int getDisparosTurno() {
        return turnoActual.getDisparos();
    }

    public boolean hayPerdida() {
        return turnoActual.perdioPorDisparos();
    }

    public boolean verificarGanador() {
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getCerebrosTotales() >= 13) {
                return true;
            }
        }

        return false;
    }

    public int getCantidadJugadores() {
        return jugadores.size();
    }

    public Jugador getJugador(int indice) {
        return jugadores.get(indice);
    }
}