import java.util.Scanner;

public class ZombieDiceConsole {
    private ZombieDiceGame juego;
    private Scanner scanner;

    public ZombieDiceConsole() {
        juego = new ZombieDiceGame();
        scanner = new Scanner(System.in);
    }
    //Metodo que inicializa el juego
    public void iniciarJuego() {
        //Se pregunta al usuario si quiere iniciar partida
        System.out.println("===== ZOMBIE DICE =====");
        System.out.println("¿Deseas iniciar la partida?(S/N)");

        String iniciar = scanner.nextLine();
        //Si decide no continuar la partida presenta el mensaje y termina el juego
        if (iniciar.equalsIgnoreCase("n")) {
            System.out.println("Juego cancelado.");
            return;
        }
        //Si el usuario decide continuar se comienza pidiendo los jugadores
        pedirJugadores();

        boolean juegoTerminado = false;
        //Este while cumple con las funcion de continuar los turnos
        while (!juegoTerminado) {
            Jugador actual = juego.getJugadorActual();

            System.out.println("\n---------------------------------");
            System.out.println("Turno de: " + actual.getNombre());
            //System.out.println("Cerebros acumulados: " + actual.getCerebrosTotales());

            juego.iniciarTurno();

            boolean turnoTerminado = false;
            //While para que al terminar el turno nos muestre los resultados del turno
            while (!turnoTerminado) {
                juego.tirarDados();

                System.out.println("\nResultados del turno:");
                System.out.println("Cerebros obtenidos: " + juego.getCerebrosTurno());
                System.out.println("Disparos recibidos: " + juego.getDisparosTurno());
                //Este if sirve para poner un mensaje si se reciben 3 disparos
                if (juego.hayPerdida()) {
                    System.out.println("Has recibido 3 disparos.");
                    System.out.println("Pierdes todos los cerebros de este turno.");
                    turnoTerminado = true;
                } else {
                    //Este if sirve para que el usuario decida si lanzar o si decide plantarse
                    if (actual.esHumano()) {
                        System.out.println("¿Deseas seguir lanzando?(S/N)");

                        String opcion = scanner.nextLine();

                        if (opcion.equalsIgnoreCase("n")) {
                            juego.plantarse();
                            turnoTerminado = true;
                        }
                    } else {
                        if (juego.getCerebrosTurno() >= 2) {
                            System.out.println(actual.getNombre() + " decide plantarse.");
                            juego.plantarse();
                            turnoTerminado = true;
                        } else {
                            System.out.println(actual.getNombre() + " decide seguir lanzando.");
                        }
                    }
                }
            }

            if (juego.hayPerdida()) {
                juego.siguienteTurnoPorPerdida();
            }

            mostrarMarcador();

            if (juego.verificarGanador()) {
                juegoTerminado = true;
            }
        }

        mostrarGanador();
    }
    //Metodo para pedeir los jugadores, cantidad de humanos, bots y nombre del jugador humano.
    private void pedirJugadores() {
        int humanos;
        int computadoras;

        do {
            System.out.print("Cantidad de jugadores humanos: ");
            humanos = Integer.parseInt(scanner.nextLine());

            if (humanos < 1) {
                System.out.println("Debe haber al menos 1 jugador humano.");
            }

        } while (humanos < 1);

        System.out.print("Cantidad de jugadores computadora: ");
        computadoras = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < humanos; i++) {
            System.out.print("Nombre del jugador humano " + (i + 1) + ": ");
            String nombre = scanner.nextLine();

            juego.agregarJugador(nombre, true);
        }

        for (int i = 0; i < computadoras; i++) {
            juego.agregarJugador("CPU " + (i + 1), false);
        }
    }

    private void mostrarMarcador() {
        System.out.println("\n===== MARCADOR =====");

        for (int i = 0; i < juego.getCantidadJugadores(); i++) {
            Jugador jugador = juego.getJugador(i);

            System.out.println(jugador.getNombre() + ": "
                + jugador.getCerebrosTotales() + " cerebros");
        }
    }

    private void mostrarGanador() {
        System.out.println("\n===== FIN DEL JUEGO =====");

        Jugador ganador = juego.getJugador(0);

        for (int i = 1; i < juego.getCantidadJugadores(); i++) {
            Jugador actual = juego.getJugador(i);

            if (actual.getCerebrosTotales() > ganador.getCerebrosTotales()) {
                ganador = actual;
            }
        }

        System.out.println("Tenemos un ganador.");
        System.out.println("Ganador: " + ganador.getNombre());
        System.out.println("Cerebros obtenidos: " + ganador.getCerebrosTotales());
    }
}