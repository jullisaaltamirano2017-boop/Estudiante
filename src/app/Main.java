
import java.util.Scanner;
import modelo.Estudiante;
import negocio.ListaSecuencial;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaSecuencial<Estudiante> lista = new ListaSecuencial<>(5);

        lista.insertarOrdenado(new Estudiante("1805000001", "ALTAMIRANO SEGOVIA JULLISA BRIGITTE", new double[]{9.50, 9.00, 9.80}));
        lista.insertarOrdenado(new Estudiante("1805000002", "CAIZA CURILLO EVELYN LIZBETH", new double[]{8.00, 7.50, 8.50}));
        lista.insertarOrdenado(new Estudiante("1805000003", "CAMACHO MONTA JOSUE JAMPIER", new double[]{6.50, 7.00, 6.00}));
        lista.insertarOrdenado(new Estudiante("1805000004", "CHAMBA PULLUPAXI JENNIFER ALEXANDRA", new double[]{8.50, 8.00, 9.00}));
        lista.insertarOrdenado(new Estudiante("1805000005", "CHICO YUNDA JUAN CARLOS", new double[]{7.00, 7.50, 8.00}));
        lista.insertarOrdenado(new Estudiante("1805000006", "CHIRIBOGA YANCHA ABEL SANTIAGO", new double[]{9.00, 8.80, 9.20}));
        lista.insertarOrdenado(new Estudiante("1805000007", "CUNALATA MENDOZA DAMIAN ALEXANDER", new double[]{5.50, 6.00, 5.80}));
        lista.insertarOrdenado(new Estudiante("1805000008", "ESPINOZA REYES KERLY MARGOTH", new double[]{8.20, 8.50, 8.70}));
        lista.insertarOrdenado(new Estudiante("1805000009", "GUANOQUIZA AGUAGUIÑA JUSTIN ALEXANDER", new double[]{7.80, 8.10, 7.90}));
        lista.insertarOrdenado(new Estudiante("1805000010", "JIJON VISCAINO GABRIEL SEBASTIAN", new double[]{6.00, 6.50, 7.00}));
        lista.insertarOrdenado(new Estudiante("1805000011", "JORDAN VEGA ANDRES SEBASTIAN", new double[]{9.10, 9.30, 9.50}));
        lista.insertarOrdenado(new Estudiante("1805000012", "LLAMUCA ABRAJAN ANDRES JOEL", new double[]{7.20, 7.00, 7.50}));
        lista.insertarOrdenado(new Estudiante("1805000013", "LUCERO URRESTA KAROL SULAMITH", new double[]{8.90, 9.00, 9.10}));
        lista.insertarOrdenado(new Estudiante("1805000014", "MAIGUA SHIGUI LENIN ALEXANDER", new double[]{6.80, 7.20, 6.90}));
        lista.insertarOrdenado(new Estudiante("1805000015", "MANOBANDA PUAQUIZA ITALO ESTEBAN", new double[]{7.50, 8.00, 7.80}));
        lista.insertarOrdenado(new Estudiante("1805000016", "MARIN LOPEZ EDWARD ISMAEL", new double[]{8.40, 8.60, 8.50}));
        lista.insertarOrdenado(new Estudiante("1805000017", "MERINO GUERRERO ROBERT ARQUIMIDES", new double[]{6.20, 6.00, 6.50}));
        lista.insertarOrdenado(new Estudiante("1805000018", "MOYOTA CHAVEZ KLEBER ANDRES", new double[]{9.00, 9.50, 9.20}));
        lista.insertarOrdenado(new Estudiante("1805000019", "ORTIZ YAUCAN EVERLY OSEAS", new double[]{7.10, 7.40, 7.60}));
        lista.insertarOrdenado(new Estudiante("1805000020", "OTO CUNDULLE CRISTOPHER RAUL", new double[]{8.80, 8.70, 8.90}));

        int opcion = 0;
        do {
            System.out.println("\n================ MENU PRINCIPAL ================");
            System.out.println("1. Registrar nuevo estudiante (Ordenado por cedula)");
            System.out.println("2. Mostrar todos los estudiantes");
            System.out.println("3. Obtener estudiante por posicion");
            System.out.println("4. Buscar estudiante por nombre");
            System.out.println("5. Contar aprobados");
            System.out.println("6. Mostrar estudiante con mayor promedio");
            System.out.println("7. Calcular promedio general del curso");
            System.out.println("8. Ver estado de la estructura (Capacidad/Cantidad)");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opcion: ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Opcion no valida. Intente de nuevo.");
                sc.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cedula: ");
                    String cedula = sc.nextLine();
                    System.out.print("Ingrese el nombre completo: ");
                    String nombre = sc.nextLine();
                    double[] notas = new double[3];
                    for (int i = 0; i < 3; i++) {
                        System.out.print("Ingrese la nota " + (i + 1) + ": ");
                        notas[i] = sc.nextDouble();
                    }
                    sc.nextLine();
                    lista.insertarOrdenado(new Estudiante(cedula, nombre, notas));
                    System.out.println("Estudiante registrado exitosamente.");
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE ESTUDIANTES ---");
                    if (lista.getCantidad() == 0) {
                        System.out.println("La lista esta vacia.");
                    } else {
                        for (int i = 0; i < lista.getCantidad(); i++) {
                            System.out.println("[" + i + "] " + lista.obtener(i));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingrese la posicion a consultar: ");
                    int pos = sc.nextInt();
                    sc.nextLine();
                    Estudiante estPos = lista.obtener(pos);
                    if (estPos != null) {
                        System.out.println("Estudiante en posicion " + pos + ": " + estPos);
                    } else {
                        System.out.println("Posicion fuera de rango.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el nombre del estudiante a buscar: ");
                    String nomBuscar = sc.nextLine();
                    Estudiante buscado = lista.buscarPorNombre(nomBuscar);
                    if (buscado != null) {
                        System.out.println("Estudiante encontrado: " + buscado);
                    } else {
                        System.out.println("No se encontro ningun estudiante con ese nombre.");
                    }
                    break;

                case 5:
                    System.out.print("Ingrese la nota minima para aprobar: ");
                    double min = sc.nextDouble();
                    sc.nextLine();
                    int aprobados = lista.contarAprobados(min);
                    System.out.println("Cantidad de estudiantes aprobados (>= " + min + "): " + aprobados);
                    break;

                case 6:
                    Estudiante mayor = lista.obtenerMayorPromedio();
                    if (mayor != null) {
                        System.out.println("Estudiante con mayor promedio: " + mayor);
                    } else {
                        System.out.println("No hay estudiantes registrados.");
                    }
                    break;

                case 7:
                    double promGen = lista.calcularPromedioGeneral();
                    System.out.println("Promedio general del curso: " + String.format("%.2f", promGen));
                    break;

                case 8:
                    System.out.println("Cantidad de elementos actuales: " + lista.getCantidad());
                    System.out.println("Capacidad actual del arreglo: " + lista.getCapacidad());
                    break;

                case 9:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        } while (opcion != 9);

        sc.close();
    }
}