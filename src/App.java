import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Character na;
        mostrarMenu();
        System.out.print("Opcion: ");
        String op = in.nextLine();

        do {
            switch (op) {
                case "1":
                    limpiarConsola();
                    System.out.print("Ingresa una cadena de texto: ");
                    String cadena = in.nextLine();
                    Automata auto = new Automata(cadena);

                    System.out.println(auto.analizarCadena()); 

                    System.out.print("Deseas ingresar otra cadena (s/n)? ");
                    na = in.nextLine().charAt(0);
                    if (na == 's') {
                        limpiarConsola();
                        op = "1";
                        limpiarConsola();
                    } else {
                        limpiarConsola();
                        mostrarMenu();
                        System.out.print("Opcion: ");
                        op = in.nextLine();
                        limpiarConsola();
                    }
                    break;
                case "2":
                    credits();
                    System.out.print("Deseas ir al menu (s/n)? ");
                    na = in.nextLine().charAt(0);
                    if (na == 's') {
                        mostrarMenu();
                        System.out.print("Opcion: ");
                        op = in.nextLine();
                        limpiarConsola();
                    } else {
                        op = "3";
                    }
                    break;
                case "3":
                    op = "3";
                    limpiarConsola();
                    break;
            }
        } while (op != "3");

        in.close();
    }

    public static void mostrarMenu() {
        System.out.println("==== Selecciona la opción que quieres elegir ====");
        System.out.println("\t 1. Capturar cadena de entrada");
        System.out.println("\t 2. Créditos");
        System.out.println("\t 3. Salir");
    }

    public static void credits() {
        System.out.println(
                "Los autores, son: \n\tJose Angel Murillo Verastegui 23170010 \n\t Adrian Alberto Gottfried Gutierrez 23170015 \n\t Angel Roberto Ibañez Chavez 21170138");
    }

    public static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
