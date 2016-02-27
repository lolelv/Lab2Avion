/*ENTREGAR
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avion;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class FirstLab2 {

    /**
     * @param args the command line arguments
     */
    static String nombre, cedula, clase, ubicacion;
    static int[] ejecutiva = new int[8];
    static int[] economica = new int[42];
    static String[][] dato = new String[2][87];
    static int acuEj = 0;
    static String[] ubiEj = new String[8];
    static String[] ubiEc = new String[42];

    public static void ImprimirAvion() {
        int aux = 0;
        int aux2 = 0;
        for (int i = 0; i < 8; i++) {
            ejecutiva[i] = i + 1;
            aux = aux + 1;
            if (aux == 1 || aux == 4) {
                ubiEj[i] = "ventana";
                if (aux == 4) {
                    aux = 0;
                }
            } else {
                ubiEj[i] = "pasillo";
            }
        }
        for (int i = 0; i < 42; i++) {
            economica[i] = i + 9;
            aux2 = aux2 + 1;
            if (aux2 == 1 || aux2 == 6) {
                ubiEc[i] = "ventana";
                if (aux2 == 6) {
                    aux2 = 0;
                }
            } else if (aux2 == 2 || aux2 == 5) {
                ubiEc[i] = "centro";
            }
            if (aux2 == 3 || aux2 == 4) {
                ubiEc[i] = "pasillo";
            }
        }
    }

    public static void Mostrar() {
        int acu = 0;
        int acu2 = 0;
        System.out.println("Las sillas ocupadas están simbolizados con un cero (0).\n");
        System.out.print("      ");
        for (int i = 0; i < 8; i++) {
            System.out.print("|" + ejecutiva[i] + "|");
            acu = acu + 1;
            acu2 = acu2 + 1;
            if (acu == 2) {
                System.out.print("\t");
                acu = 0;
            }
            if (acu2 == 4) {
                System.out.print("\n      ");
                acu2 = 0;
            }
        }
        System.out.print("\n");
        for (int i = 0; i < 42; i++) {
            acu = acu + 1;
            acu2 = acu2 + 1;
            if (economica[i] == 9) {
                System.out.print("| " + economica[i] + "|");
            } else {
                System.out.print("|" + economica[i] + "|");
            }
            if (acu == 3) {
                System.out.print("\t");
                acu = 0;
            }
            if (acu2 == 6) {
                System.out.print("\n");
                acu2 = 0;
            }
        }
    }

    public static void Asigancion(String nombre, String cedula, String clase, String ubicacion) {
        if (clase.equals("ej") || clase.equals("Ej")) {
            for (int i = 0; i < 8; i++) {
                if (ubicacion.equals(ubiEj[i])) {
                    if (ejecutiva[i] != 0) {
                        ejecutiva[i] = 0;
                        dato[0][i] = nombre;
                        dato[1][i] = cedula;
                        acuEj = acuEj + 1;
                        break;
                    }
                }
            }
        }
        if (clase.equals("ec") || clase.equals("Ec")) {
            for (int i = 0; i < 42; i++) {
                if (ubicacion.equals(ubiEc[i])) {
                    if (economica[i] != 0) {
                        economica[i] = 0;
                        dato[0][i + 8] = nombre;
                        dato[1][i + 8] = cedula;
                        break;
                    }
                }
            }
        }
    }

    public static int UbiEco() {
        int sillaEc = 0;
        for (int i = 0; i < 42; i++) {
            if (economica[i] != 0) {
                sillaEc = sillaEc + i + 9;
                break;
            }
        }
        return sillaEc;
    }

    public static int UbiSilla(String cedula) {
        int silla = 0;
        for (int i = 0; i < 8; i++) {
            if (cedula.equals(dato[1][i])) {
                silla = silla + i + 1;
            }
        }
        for (int i = 0; i < 42; i++) {
            if (cedula.equals(dato[1][i + 8])) {
                silla = silla + i + 9;
            }
        }
        return silla;
    }

    public static int AutoAsigna(String nombre, String cedula) {
        int silla = 0;
        for (int i = 0; i < 42; i++) {
            if (economica[i] != 0) {
                economica[i] = 0;
                silla = silla + i + 9;
                dato[1][i + 8] = cedula;
                break;
            }
        }
        return silla;
    }

    public static int NumVentana() {
        int acu = 0;
        for (int i = 0; i < 42; i++) {
            if (economica[i] != 0) {
                if (ubiEc[i].equals("ventana")) {
                    acu = acu + 1;
                }
            }
        }
        return acu;
    }

    public static void Cancelar(String cedula) {
        for (int i = 0; i < 8; i++) {
            if (cedula.equals(dato[1][i])) {
                ejecutiva[i] = i + 1;
                dato[1][i] = "ninguna";
            }
        }
        for (int i = 0; i < 42; i++) {
            if (cedula.equals(dato[1][i + 8])) {
                economica[i] = i + 9;
                dato[1][i + 8] = "ninguna";
            }
        }
    }

    public static String Nombre() {
        String nombre = "ninguno";
        for (int i = 8; i < 49; i++) {
            for (int j = i + 1; j < 50; j++) {
                if (dato[0][i] != null && dato[0][i].equals(dato[0][j])) {
                    nombre = " ";
                    nombre = dato[0][i];
                    break;
                }

            }
        }
        return nombre;
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        ImprimirAvion();
        int opc;
        System.out.print("Bienvenido a su Aereolíniea de confianza.");
        System.out.println("A continuación se encontrará con ciertas preguntas para poder asignarle la silla de su preferencia.");
        System.out.println("Para responderlas con satisfacción tenga en cuenta las siguientes recomendaciones:");
        System.out.println(" # Los datos suministrados son de total confidencia. \n # A continuación tendrá un menú en el cual podrá acceder a lo que necesite.");
        do {

            System.out.println(" ");
            System.out.println(" 1. Visualizar el avión.\n 2. Asignar silla.\n 3. Sistema de reportes.\n 4. Salir");
            System.out.println("");
            opc = read.nextInt();
            switch (opc) {
                case 1:
                    Mostrar();
                    break;
                case 2:
                    System.out.println("INGRESO DE DATOS DEL PASAJERO:");
                    System.out.println("Ingrese el nombre:");
                    nombre = read.next();
                    System.out.println("Ingrese la cédula:");
                    cedula = read.next();
                    System.out.println("ASIGNACIÓN DE SILLA");
                    System.out.println("Ingrese la clase: 'ej' para la Clase Ejectuvia o 'ec' para la Clase Económica:");
                    clase = read.next();
                    System.out.println("Ingrese la ubicación, tenga en cuenta que existe ventana, centro o pasillo(si escogió la Clase Económica):");
                    ubicacion = read.next();
                    Asigancion(nombre, cedula, clase, ubicacion);
                    break;
                case 3:
                    int opc2;
                    System.out.println(" 1. Cantidad de sillas ejecutivas ocupadas."
                            + "\n 2. Localizar silla mediante la cédula del pasajero."
                            + "\n 3. Localizar silla económica disponible."
                            + "\n 4. Asignar un pasajero a una silla económica."
                            + "\n 5. Anular una reservación."
                            + "\n 6. Contar el número de sillas económicas disponibles que se encuentran en las ventanas."
                            + "\n 7. Buscar dos nombres iguales de personas que estén ocupando la clase económica");
                    opc2 = read.nextInt();
                    switch (opc2) {
                        case 1:
                            System.out.println("Hay en total " + acuEj + " sillas ejecutivas ocupadas.");
                            break;
                        case 2:
                            String cedula2;
                            System.out.println("Ingrese la cédula del pasajero");
                            cedula2 = read.next();
                            int silla = UbiSilla(cedula2);
                            System.out.println("La silla asociada con la cédula proporcionada es: " + silla);
                            break;
                        case 3:
                            int sillaec = UbiEco();
                            System.out.println("La silla " + sillaec + " de la clase económica se encuentra disponible.");
                            break;
                        case 4:
                            System.out.println("DATOS DEL PASAJERO");
                            System.out.println("Ingrese el nombre:");
                            nombre = read.next();
                            System.out.println("Ingrese la cédula:");
                            cedula = read.next();
                            int silla2 = AutoAsigna(nombre, cedula);
                            System.out.println("La silla asignada fue: " + silla2);
                            break;
                        case 5:
                            System.out.println("DATOS DEL PASAJERO QUE DESEA ANULAR LA RESERVA");
                            System.out.println("Ingrese la cédula:");
                            cedula = read.next();
                            Cancelar(cedula);
                            System.out.println("La reserva ha sido cancelada.");
                            break;
                        case 6:
                            int disponible = NumVentana();
                            System.out.println("Hay " + disponible + " sillas disponibles.");
                            break;
                        case 7:
                            String nombre2 = Nombre();
                            System.out.println("El nombre que se repite es: " + nombre2);
                            break;
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Ha ingresado una opción inválida. Vuelva a intentar: \n");
                    break;
            }
        } while (opc != 4);
        System.out.println("Gracias por usar nuestra aereolínea!");
    }

}
