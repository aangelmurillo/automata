import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.println(
                "Selecciona la opción que quieres elegir \n\t 1) Capturar cadena de entrada \n\t 2) Creditos \n\t 3) Salir");

        System.out.print("Opcion: ");
        String decision = in.nextLine();

        switch (decision) {
            case "1":
                System.out.print("Ingresa una cadena de texto: ");
                String cadena = in.nextLine();
                Automata auto = new Automata(cadena);

                auto.analizarCadena();
                break;

            case "2":
                credits();
                break;

            case "3":
                break;
        }

        in.close();
    }

    public static void credits() {
        System.out.println(
                "Los autores, son: \n\tJose Angel Murillo Verastegui 23170010 \n\t Adrian Alberto Gottfried Gutierrez 23170015 \n\t Angel Roberto Ibañez Chavez 21170138");
    }
}
