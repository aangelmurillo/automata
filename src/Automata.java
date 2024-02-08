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

    public boolean analizarCadena() {
        cadenaArray = cadena.toCharArray();
        int i = 0;

        try {
            // if (cadenaArray.length == 0) {
            //     System.out.println("Cadena invalida, no acepto vacios");
            // }
            while (!cadena.isEmpty() && activo) {
                switch (estado) {
                    case 1:
                        if (Arrays.asList(vocales).contains(cadenaArray[i])) {
                            estado = 2;
                        } else if (Arrays.asList(consonantes).contains(cadenaArray[i])) {
                            estado = 2;
                        } else {
                            activo = false;
                            return false;
                        }
                        break;

                    case 2:
                        i++;
                        if (Arrays.asList(consonantes).contains(cadenaArray[i])
                                && Arrays.asList(vocales).contains(cadenaArray[i - 1])) {
                            estado = 7;
                        } else if (cadenaArray[i] == '2' || cadenaArray[i] == '6') {
                            estado = 3;
                        } else if (Arrays.asList(vocales).contains(cadenaArray[i])
                                && Arrays.asList(consonantes).contains(cadenaArray[i - 1])) {
                            estado = 7;
                        } else {
                            activo = false;
                            return false;
                        }
                        break;

                    case 3:
                        i++;
                        if (Arrays.asList(digitos).contains(cadenaArray[i])) {
                            estado = 4;
                        } else {
                            activo = false;
                            return false;
                        }
                        break;

                    case 4:
                        i++;
                        if (Arrays.asList(digitos).contains(cadenaArray[i])) {
                            estado = 5;
                        } else {
                            activo = false;
                            return false;
                        }
                        break;

                    case 5:
                        if (Arrays.asList(digitos).contains(cadenaArray[i])) {
                            i++;
                            estado = 6;

                            if (cadenaArray[i] == '3' || cadenaArray[i] == '9') {
                                estado = 5;

                                if (Arrays.asList(consonantes).contains(cadenaArray[i + 1])) {
                                    estado = 7;
                                }

                                if (Arrays.asList(vocales).contains(cadenaArray[i + 1])) {
                                    estado = 7;
                                }
                            } else if (Arrays.asList(digitos).contains(cadenaArray[i])) {

                                estado = 5;
                            } else {
                                activo = false;
                                return false;
                            }
                        } else {
                            activo = false;
                            return false;
                        }
                        break;

                    case 6:
                        i++;
                        if (Arrays.asList(consonantes).contains(cadenaArray[i])) {
                            estado = 7;
                        } else {
                            activo = false;
                            return false;
                        }

                        break;

                    case 7:
                        if (cadenaArray.length >= 3) {
                            if (Arrays.asList(consonantes).contains(cadenaArray[2])
                                    || Arrays.asList(vocales).contains(cadenaArray[2])) {

                                return false;
                            }
                            if (Arrays.asList(vocales).contains(cadenaArray[0])
                                    && Arrays.asList(consonantes).contains(cadenaArray[i + 1])) {
                                Character comparar;
                                if (i + 2 < cadenaArray.length) {
                                    comparar = cadenaArray[i + 1];
                                    if (comparar.toString().isEmpty()) {
                                        return false;
                                    }
                                } else {
                                    return true;
                                }
                            } else if (Arrays.asList(consonantes).contains(cadenaArray[0])
                                    && Arrays.asList(vocales).contains(cadenaArray[i + 1])) {
                                Character comparar;
                                if (i + 2 < cadenaArray.length) {
                                    comparar = cadenaArray[i + 1];
                                    if (comparar.toString().isEmpty()) {
                                        return true;
                                    }
                                } else {
                                    return true;
                                }
                            } else {
                                return false;
                            }
                        } else {
                            return true;
                        }
                        activo = false;
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Cadena invalida " + e.getMessage() + "Personalizado");
        }
        return false;
    }
}
