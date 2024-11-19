package servicios;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class PromedioServicioImpTest {
    PromedioServicioImp ps = new PromedioServicioImp();

    @Test
    public void testPromedioConNumerosPositivos() {
        List<Double> notas = Arrays.asList(8.0, 9.5, 10.0);
        Double resultado = ps.calcularPromedio(notas);
        assertEquals(9.1667, resultado, 0.0001); // Tolerancia de 0.0001 para decimales
    }

    @Test
    public void testPromedioConUnSoloElemento() {

        List<Double> notas = Collections.singletonList(7.5);
        Double resultado = ps.calcularPromedio(notas);
        assertEquals(7.5, resultado, 0.0001);
    }

    @Test
    public void testPromedioConNumerosNegativos() {

        List<Double> notas = Arrays.asList(-2.0, -3.0, -4.0);
        Double resultado = ps.calcularPromedio(notas);
        assertEquals(-3.0, resultado, 0.0001);
    }

    @Test
    public void testPromedioConListaVacia() {
        List<Double> listaVacia = new ArrayList<>();
        // Verificamos que el promedio devuelto es 0 cuando la lista está vacía
        double resultado = PromedioServicioImp.calcularPromedio(listaVacia);
        assertEquals(0, resultado, 0.001); // El tercer parámetro es la tolerancia para la comparación de decimales
    }



    @Test
    public void testPromedioConNumerosMixtos() {

        List<Double> notas = Arrays.asList(-3.0, 0.0, 3.0);
        Double resultado = ps.calcularPromedio(notas);
        assertEquals(0.0, resultado, 0.0001);
    }

}

