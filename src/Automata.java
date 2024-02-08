import java.util.Arrays;

public class Automata {
    private String cadena;
    private char[] cadenaArray;
    int estado = 1;
    boolean activo = true;

    private Character[] vocales = { 'a', 'e', 'i', 'o', 'u' };
    private Character[] consonantes = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm',
            'n', 'ñ', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z' };
    private Character[] digitos = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    Automata(String cadena) {
        this.cadena = cadena;
    }

    public void analizarCadena() {
        cadenaArray = cadena.toCharArray();
        int i = 0;

        try {
            if (cadenaArray.length == 0) {
                System.out.println("Cadena invalida, no acepto vacios");
            }
            while (!cadena.isEmpty() && activo) {
                switch (estado) {
                    case 1:
                        if (Arrays.asList(vocales).contains(cadenaArray[i])) {
                            estado = 2;
                            System.out.println("Estado 1, voy al estado... " + estado + " con..." + cadenaArray[i]
                                    + "... posicion: " + i);
                        } else if (Arrays.asList(consonantes).contains(cadenaArray[i])) {
                            estado = 2;
                            System.out.println("Estado 1, voy al estado... " + estado + " con..." + cadenaArray[i]
                                    + "... posicion: " + i);
                        } else {
                            System.out.println("Cadena invalida");
                            activo = false;
                        }
                        break;

                    case 2:
                        i++;
                        if (Arrays.asList(consonantes).contains(cadenaArray[i])
                                && Arrays.asList(vocales).contains(cadenaArray[i - 1])) {
                            estado = 7;
                            System.out.println("Estado 2 , voy al estado... " + estado + " con..." + cadenaArray[i]
                                    + "... posicion: " + i);
                        } else if (cadenaArray[i] == '2' || cadenaArray[i] == '6') {
                            estado = 3;
                            System.out.println("Estado 2 , voy al estado... " + estado + " con..." + cadenaArray[i]
                                    + "... posicion: " + i);
                        } else if (Arrays.asList(vocales).contains(cadenaArray[i])
                                && Arrays.asList(consonantes).contains(cadenaArray[i - 1])) {
                            estado = 7;
                            System.out.println("Estado 2 , voy al estado... " + estado + " con..." + cadenaArray[i]
                                    + "... posicion: " + i);
                        } else {
                            activo = false;
                            System.out.println("Cadena invalida");
                        }
                        break;

                    case 3:
                        i++;
                        if (Arrays.asList(digitos).contains(cadenaArray[i])) {
                            estado = 4;
                            System.out
                                    .println("Estoy en el estado 3, voy al estado " + estado + " con..."
                                            + cadenaArray[i] + "... posicion: " + i);
                        } else {
                            activo = false;
                            System.out.println("Cadena invalida");
                        }
                        break;

                    case 4:
                        i++;
                        if (Arrays.asList(digitos).contains(cadenaArray[i])) {
                            estado = 5;
                            System.out
                                    .println("Estoy en el estado 4, voy al estado " + estado + " con..."
                                            + cadenaArray[i] + "... posicion: " + i);
                        } else {
                            activo = false;
                            System.out.println("Cadena invalida");
                        }
                        break;

                    case 5:
                        if (Arrays.asList(digitos).contains(cadenaArray[i])) {
                            i++;
                            estado = 6;
                            System.out
                                    .println("Estoy en el estado 5, voy al estado " + estado + " con..."
                                            + cadenaArray[i] + "... posicion: " + i);

                            if (cadenaArray[i] == '3' || cadenaArray[i] == '9') {
                                estado = 5;

                                System.out
                                        .println("Estoy en el estado 5, voy al estado " + estado + " con..."
                                                + cadenaArray[i] + "... posicion: " + i);

                                if (Arrays.asList(consonantes).contains(cadenaArray[i + 1])) {
                                    estado = 7;
                                    System.out
                                            .println("Estoy en el estado 5, voy al estado " + estado + " con..."
                                                    + cadenaArray[i + 1] + "... posicion: " + i);
                                }

                                if (Arrays.asList(vocales).contains(cadenaArray[i + 1])) {
                                    estado = 7;
                                    System.out
                                            .println("Estoy en el estado 5, voy al estado " + estado + " con..."
                                                    + cadenaArray[i + 1] + "... posicion: " + i);
                                }
                            } else if (Arrays.asList(digitos).contains(cadenaArray[i])) {

                                estado = 5;
                                System.out
                                        .println("Estoy en el estado 5, voy al estado " + estado + " con..."
                                                + cadenaArray[i] + "... posicion: " + i);
                            } else {
                                activo = false;
                                System.out.println("Cadena invalida");
                            }
                        } else {
                            activo = false;
                            System.out.println("Cadena invalida");
                        }
                        break;

                    case 6:
                        i++;
                        if (Arrays.asList(consonantes).contains(cadenaArray[i])) {
                            estado = 7;
                            System.out
                                    .println("Estoy en el estado 6, voy al estado " + estado + " con..."
                                            + cadenaArray[i] + "... posicion: " + i);
                        } else {
                            activo = false;
                            System.out.println("Cadena invalida aaa");
                        }

                        break;

                    case 7:
                        if (cadenaArray.length >= 3) {
                            if (Arrays.asList(consonantes).contains(cadenaArray[2])
                                    || Arrays.asList(vocales).contains(cadenaArray[2])) {
                                System.out.println("Cadena invalida " + cadena);
                                return;
                            }
                            if (Arrays.asList(vocales).contains(cadenaArray[0])
                                    && Arrays.asList(consonantes).contains(cadenaArray[i + 1])) {
                                System.out.println("Cadena valida con " + cadena);
                                return;
                            } else {
                                System.out.println("Cadena invalida " + cadena);
                            }

                            if (Arrays.asList(consonantes).contains(cadenaArray[0])
                                    && Arrays.asList(vocales).contains(cadenaArray[i + 1])) {
                                System.out.println("Cadena valida con " + cadena);
                                return;
                            } else {
                                System.out.println("Cadena invalida " + cadena);
                            } 
                        }else {
                            System.out.println("Cadena valida con " + cadena);

                        }
                        activo = false;
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Cadena invalida " + e.getMessage() + "Personalizado");
        }
    }
}
