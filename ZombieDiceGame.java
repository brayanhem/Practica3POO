import java.util.ArrayList;

public class ZombieDiceGame {
    private Vaso vaso;
    private ArrayList<Jugador> jugadores;
    private ArrayList<ZombieDado> dadosEnMano;
    
    private int indiceJugadorActual;
    private int cerebrosTurno;
    private int disparosTurno;

    public ZombieDiceGame() {
        this.vaso = new Vaso();
        this.jugadores = new ArrayList<Jugador>();
        this.dadosEnMano = new ArrayList<ZombieDado>();
        this.indiceJugadorActual = 0;
    }

    public void agregarJudagor(String nombre, boolean esHumano) {
        jugadores.add(new Jugador(nombre, esHumano));
    }

    public void iniciarTurno() {
        this.cerebrosTurno = 0;
        this.disparosTurno = 0;
        this.dadosEnMano.clear();
        this.vaso.llenarVaso(); // Reiniciamos el vaso con los 13 dados
    }

    public void tirarDados() {
        //Completa la mano hasta que se tengan 3 dados
        int necesarios = 3 - dadosEnMano.size();
        ArrayList<ZombieDado> nuevos = vaso.tomarDados(necesarios);
        if(nuevos != null) {
            dadosEnMano.addAll(nuevos);
        }

        ArrayList<ZombieDado> paraRegresarAlVaso = new ArrayList<ZombieDado>();
        ArrayList<ZombieDado> seQuedanParaSiguienteTiro = new ArrayList<ZombieDado>();

        // Lanzar cada dado y procesara los resultado
        for (int i = 0; i < dadosEnMano.size(); i++) {
            ZombieDado d = dadosEnMano.get(i);
            d.getVista().moverDados(100 + (i * 110), 100); // Separarlos visualmente
            d.rodar();

            if (d.getCaraActual().equals("Pasos")) {
                seQuedanParaSiguienteTiro.add(d);
            } else {
                if (d.getCaraActual().equals("Cerebro")) {
                    cerebrosTurno++;
                } else {
                    disparosTurno++;
                }
                paraRegresarAlVaso.add(d);
            }
        }

        // Devolver los usados al vaso (Cerebros y Disparos no se vuelven a lanzar)
        vaso.devolverDado(paraRegresarAlVaso);
        this.dadosEnMano = seQuedanParaSiguienteTiro;
        
        if(disparosTurno >= 3){
            this.cerebrosTurno=0;
            
        }
    }

    public void plantarse() {
        Jugador actual = jugadores.get(indiceJugadorActual);
        
        actual.acumularCerebros(cerebrosTurno);
        
        // Limpiar mesa para el siguiente jugador
        vaso.devolverDado(dadosEnMano);
        dadosEnMano.clear();
        siguienteJugador();
    }

    private void siguienteJugador() {
        indiceJugadorActual = (indiceJugadorActual + 1) % jugadores.size();
    }

    // Getters para que la consola sepa qué imprimir
    public Jugador getJugadorActual() { 
        return jugadores.get(indiceJugadorActual); 
    }
    public int getCerebrosTurno() { 
        return cerebrosTurno; 
    }
    public int getDisparosTurno() { 
        return disparosTurno; 
    }
    public boolean perdioTurno() { 
        return disparosTurno >= 3; 
    }
}