package negocio;

import modelo.Estudiante;

public class ListaSecuencial<T> {
    private T[] datos;
    private int cantidad;
    private int capacidad;

    @SuppressWarnings("unchecked")
    public ListaSecuencial(int capacidadInicial) {
        this.capacidad = capacidadInicial;
        this.cantidad = 0;
        this.datos = (T[]) new Object[capacidadInicial];
    }

    public T obtener(int posicion) {
        if (posicion < 0 || posicion >= cantidad) {
            return null;
        }
        return datos[posicion];
    }

    @SuppressWarnings("unchecked")
    private void redimensionar() {
        int nuevaCapacidad = capacidad * 2;
        T[] nuevoArreglo = (T[]) new Object[nuevaCapacidad];
        System.arraycopy(datos, 0, nuevoArreglo, 0, cantidad);
        datos = nuevoArreglo;
        capacidad = nuevaCapacidad;
    }

    public void insertarOrdenado(T elemento) {
        if (cantidad == capacidad) {
            redimensionar();
        }

        if (elemento instanceof Estudiante) {
            Estudiante nuevoEstudiante = (Estudiante) elemento;
            int pos = 0;
            while (pos < cantidad) {
                Estudiante actual = (Estudiante) datos[pos];
                if (actual.getCedula().compareTo(nuevoEstudiante.getCedula()) > 0) {
                    break;
                }
                pos++;
            }
            if (pos < cantidad) {
                System.arraycopy(datos, pos, datos, pos + 1, cantidad - pos);
            }
            datos[pos] = elemento;
            cantidad++;
        } else {
            datos[cantidad] = elemento;
            cantidad++;
        }
    }

    public int contarAprobados(double minimo) {
        int aprobados = 0;
        for (int i = 0; i < cantidad; i++) {
            if (datos[i] instanceof Estudiante) {
                Estudiante est = (Estudiante) datos[i];
                if (est.calcularPromedio() >= minimo) {
                    aprobados++;
                }
            }
        }
        return aprobados;
    }

    public T buscarPorNombre(String nombre) {
        for (int i = 0; i < cantidad; i++) {
            if (datos[i] instanceof Estudiante) {
                Estudiante est = (Estudiante) datos[i];
                if (est.getNombre().equalsIgnoreCase(nombre)) {
                    return datos[i];
                }
            }
        }
        return null;
    }

    public Estudiante obtenerMayorPromedio() {
        if (cantidad == 0) {
            return null;
        }
        Estudiante mayor = null;
        double maxPromedio = -1.0;

        for (int i = 0; i < cantidad; i++) {
            if (datos[i] instanceof Estudiante) {
                Estudiante est = (Estudiante) datos[i];
                double promedioActual = est.calcularPromedio();
                if (promedioActual > maxPromedio) {
                    maxPromedio = promedioActual;
                    mayor = est;
                }
            }
        }
        return mayor;
    }

    public double calcularPromedioGeneral() {
        if (cantidad == 0) {
            return 0.0;
        }
        double sumaPromedios = 0.0;
        int contadorEstudiantes = 0;

        for (int i = 0; i < cantidad; i++) {
            if (datos[i] instanceof Estudiante) {
                Estudiante est = (Estudiante) datos[i];
                sumaPromedios += est.calcularPromedio();
                contadorEstudiantes++;
            }
        }

        if (contadorEstudiantes == 0) {
            return 0.0;
        }
        return sumaPromedios / contadorEstudiantes;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getCapacidad() {
        return capacidad;
    }
}