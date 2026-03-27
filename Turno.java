import java.util.ArrayList;

public class Turno {
    private int cerebros;
    private int disparos;
    private ArrayList<ZombieDado> dadosEnMano;

    public Turno() {
        this.cerebros = 0;
        this.disparos = 0;
        this.dadosEnMano = new ArrayList<ZombieDado>();
    }
    
    //lanza los dados con ayuda de la implementacion de la clase Vaso
    public void lanzar(Vaso vaso) {
    int cuantosFaltan = 3 - dadosEnMano.size();
        //Este if nos ayuda a tener solo 3 dados en mano y verificar si es asi.
        if (cuantosFaltan > 0) {
            ArrayList<ZombieDado> nuevos = vaso.tomarDados(cuantosFaltan);

            if (nuevos != null) {
            dadosEnMano.addAll(nuevos);
            }
        }
        //Estos ArrayList nos ayudan a regresar al vaso o decidir si se quedan
        //en el siguiente tiro que hara el jugador
        ArrayList<ZombieDado> paraRegresarAlVaso = new ArrayList<ZombieDado>();
        ArrayList<ZombieDado> seQuedanParaSiguienteTiro = new ArrayList<ZombieDado>();

        System.out.println("\n LANZAMIENTO DE DADOS:");

        for (int i = 0; i < dadosEnMano.size(); i++) {
            ZombieDado d = dadosEnMano.get(i);

            int posicionX = 100 + (i * 110);
            d.mover(posicionX, 100);

            d.rodar();

            String color = d.getColor();
            String cara = d.getCaraActual();

            System.out.println("Dado " + (i + 1) + ": " + color + " - " + cara);

            if (cara.equals("Pasos")) {
            seQuedanParaSiguienteTiro.add(d);
            } else {
                if (cara.equals("Cerebro")) {
                cerebros++;
                } else if (cara.equals("Disparo")) {
                disparos++;
                }   

                paraRegresarAlVaso.add(d);
            }
        }

        for (int i = 0; i < paraRegresarAlVaso.size(); i++) {
            paraRegresarAlVaso.get(i).ocultar();
        }

        vaso.devolverDado(paraRegresarAlVaso);

        dadosEnMano = seQuedanParaSiguienteTiro;

        if (disparos >= 3) {
        cerebros = 0;
        }
    //Utilce estos print para ver la acumulacion y saber si se cuentan bien
    //los cerebros y disparos.
        //System.out.println("Cerebros acumulados: " + cerebros);
        //System.out.println("Disparos acumulados: " + disparos);
    }
    
    public int getCerebros() { 
        return cerebros; 
    }
    
    public int getDisparos() { 
        return disparos; 
    }
    
    public boolean perdioPorDisparos() { 
        return disparos >= 3; 
    }
    
    public ArrayList<ZombieDado> getDadosRestantes() { 
        return dadosEnMano; 
    }
}