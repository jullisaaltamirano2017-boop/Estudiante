package modelo;

public class Estudiante {
    private String cedula;
    private String nombre;
    private double[] notas;

    public Estudiante(String cedula, String nombre, double[] notas) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.notas = notas;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public double[] getNotas() {
        return notas;
    }

    public double calcularPromedio() {
        if (notas == null || notas.length == 0) {
            return 0.0;
        }
        double suma = 0.0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.length;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", promedio=" + String.format("%.2f", calcularPromedio()) +
                '}';
    }
}