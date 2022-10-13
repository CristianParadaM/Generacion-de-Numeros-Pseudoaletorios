package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * 
 * Clase que se encarga de la generacion de numeros pseudoaleatorios que sigan
 * una distribucion uniforme.
 *
 * @author Cristian David Parada Martinez, Daniel Felipe Suarez Bohorquez
 *         ,Julian Steven Huertas Henao
 */
public class DistribucionUniforme {
    public static final int NUMBER_OF_INTERVALS = 10;
    private int min;
    private int max;
    private double[] ri;

    /**
     * Metodo constructor de la clase que recibe 3 numeros, dos de ellos
     * corresponden a los limites superiores e inferiores y el tercero los Ri
     * 
     * @param min
     * @param max
     * @param numbers
     */
    public DistribucionUniforme(int min, int max, double[] numbers) {
        this.min = min;
        this.max = max;
        this.ri = numbers;
    }
    
    /**
     * metodo que genera numeros pseudoaleatorios
     * @return retorna un arreglo de doubles, los cuales serán los numeros pseudoaleatorios
     */
    public double[] generatePseudorandomNumbers() {
        double[] numbers = new double[this.ri.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new BigDecimal(String.valueOf(min + (max - min) * this.ri[i])).setScale(5, RoundingMode.FLOOR)
                    .doubleValue();
        }
        return numbers;
    }
    
    /**
     * Metodo que genera los intervalos necesarios para la distribucion
     * 
     * @return ArrayList de arreglos de doubles con los intervalos generados
     */
    public ArrayList<Double[]> generateIntervals() {
        ArrayList<Double[]> intervals = new ArrayList<>();
        double inicio = min;
        for (int i = 0; i < NUMBER_OF_INTERVALS; i++) {
            Double[] aux = new Double[] { inicio,
                    Double.parseDouble(
                            new BigDecimal(String.valueOf(inicio + ((max - min) / (double) NUMBER_OF_INTERVALS)))
                                    .setScale(5, RoundingMode.FLOOR).toString()) };
            intervals.add(aux);
            inicio = aux[1];
        }
        return intervals;
    }
    
    /**
     * Metodo que determina las frecuencias segun los intervalos
     * @return retorna un linkedHashMap de onjetos de tipo String e Innteger
     */
    public LinkedHashMap<String, Integer> calculateFrequencies() {
        double[] numbers = generatePseudorandomNumbers();
        ArrayList<Double[]> intervals = generateIntervals();
        LinkedHashMap<String, Integer> frecuencies = new LinkedHashMap<>();
        for (Double[] interval : intervals) {
            frecuencies.put(interval[0] + " - " + interval[1], 0);
        }
        for (Double number : numbers) {
            for (Double[] interval : intervals) {
                if (number > interval[0] && number < interval[1]) {
                    frecuencies.put(interval[0] + " - " + interval[1],
                            frecuencies.get(interval[0] + " - " + interval[1]) + 1);
                    break;
                }
            }
        }
        return frecuencies;
    }

}
