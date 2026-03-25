import java.util.Scanner;
import java.util.Random;

public class ZombieDiceConsole {
    private ZombieDiceGame juego;
    private Scanner lector;
    private Random azar;

    public ZombieDiceConsole() {
        this.juego = new ZombieDiceGame();
        this.lector = new Scanner(System.in);
        this.azar = new Random();
    }

    public void iniciar() {
        System.out.println("=============JUEGO INICIADO===============");

        configurarJugadores();
        System.out.println("Quieres empezar la partida?(S/N)");
        String confirmar="";
        if(lector.hasNext()){
            confirmar = lector.next();
        }
        
        if(confirmar.equalsIgnoreCase("S")){
            boolean hayGanador = false;
            while (!hayGanador) {
                ejecutarTurno();
            
            // Verificamos si alguien llegó a la meta (13 cerebros)
                if (juego.getJugadorActual().getCerebrosTotales() >= 13) {
                System.out.println(juego.getJugadorActual().getnombre() + " HA GANADO.");
                hayGanador = true;
                }
            }
        }else{
            System.out.println("Partida Terminada.");
        }
    }

    private void configurarJugadores() {
        System.out.print("¿Cuántos jugadores Humanos son?: ");
        int numHumanos = lector.nextInt();
        for (int i = 1; i <= numHumanos; i++) {
            System.out.print("Nombre del Jugador " + i + ": ");
            String nombre = lector.next();
            juego.agregarJudagor(nombre, true);
        }

        System.out.print("¿Cuántos jugadores BOTS son?: ");
        int numBots = lector.nextInt();
        for (int i = 1; i <= numBots; i++) {
            juego.agregarJudagor("Bot_Zombie_" + i, false);
        }
    }

    private void ejecutarTurno() {
        Jugador actual = juego.getJugadorActual();
        System.out.println("\n----------------------------------------");
        System.out.println("Turno de: " + actual.getnombre());
        System.out.println("Cerebros totales: " + actual.getCerebrosTotales());
        System.out.println("----------------------------------------");
        juego.iniciarTurno();
        
        boolean turnoActivo = true;

        while (turnoActivo) {
            
            
            System.out.println("\nLanzando dados...");
            juego.tirarDados();

            System.out.println("RESULTADO ACTUAL DEL TURNO:");
            System.out.println(" > Cerebros: " + juego.getCerebrosTurno());
            System.out.println(" > Disparos: " + juego.getDisparosTurno());

            if (juego.perdioTurno()) {
                System.out.println("3 disparos recibidos. Pierdes tus cerebros de este turno.");
                // Al perder, el juego automáticamente descarta los puntos y pasa al siguiente
                juego.plantarse(); 
                turnoActivo = false;
            } else {
                if (actual.esHumano()) {
                    System.out.print("¿Deseas lanzar de nuevo? (S/N): ");
                    String respuesta = lector.next();
                    if (respuesta.equalsIgnoreCase("N")) {
                        System.out.println("Te has plantado con " + juego.getCerebrosTurno() + " cerebros.");
                        juego.plantarse();
                        turnoActivo = false;
                    }
                } else {
                    // Lógica del Bot
                    turnoActivo = decisionBot(juego.getDisparosTurno(), juego.getCerebrosTurno());
                    if (!turnoActivo){
                        System.out.println("El Bot decide plantarse");
                        juego.plantarse();
                    }else{
                        System.out.println("El Bot decide arriesgarse");
                        
                    }
                }
            }
        }
    }
    
    private boolean decisionBot(int disparos, int cerebros){
        if(disparos == 2){
            return azar.nextInt(100) < 30;
        }
        
        if(cerebros >= 3){
            return azar.nextInt(100) > 70;
        }
        return true;
        
    }

}