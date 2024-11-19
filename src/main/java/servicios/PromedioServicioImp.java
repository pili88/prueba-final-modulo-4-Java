package servicios;

import java.util.List;

public class PromedioServicioImp {
    public static double calcularPromedio(List<Double> notas) {
        if (notas == null || notas.isEmpty()) {
            return 0;
        }
        double suma = 0;
        for (Double nota : notas) {
            suma += nota;
        }
        return suma / notas.size();
    }
}
