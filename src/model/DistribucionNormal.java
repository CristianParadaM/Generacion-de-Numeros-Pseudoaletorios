package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.commons.math3.distribution.NormalDistribution;

/**
 * 
 * Clase que se encarga de la generacion de numeros pseudoaleatorios que siguen
 * la distribucion normal.
 *
 * @author Cristian David Parada Martinez, Daniel Felipe Suarez Bohorquez
 *         ,Julian Steven Huertas Henao
 */
public class DistribucionNormal {
    public static final int NUMBER_OF_INTERVALS = 10;
    private double media;
    private double desviacion_estandar;
    private double[] ri;

    /**
     * constructor de la clase que recibe los parametros necesarios para determinar
     * la distribucion normal
     * 
     * @param media
     * @param desviacion_estandar
     * @param numbers
     */
    public DistribucionNormal(double media, double desviacion_estandar, double[] numbers) {
        this.media = media;
        this.desviacion_estandar = desviacion_estandar;
        this.ri = numbers;
    }

    /**
     * Metodo que genera los Ni
     * 
     * @return un arreglo de doubles, los cuales son los Ni generados
     */
    public double[] generateNi() {
        double[] numbers = new double[this.ri.length];
        NormalDistribution distribution = new NormalDistribution(media, desviacion_estandar);
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new BigDecimal(String.valueOf(distribution.inverseCumulativeProbability(ri[i])))
                    .setScale(5, RoundingMode.FLOOR).doubleValue();
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
        double[] numbers = generateNi();
        double[] limits = searchLimits(numbers);
        double inicio = limits[0];
        for (int i = 0; i < NUMBER_OF_INTERVALS; i++) {
            Double[] aux = new Double[] { inicio, Double.parseDouble(
                    new BigDecimal(String.valueOf(inicio + ((limits[1] - limits[0]) / (double) NUMBER_OF_INTERVALS)))
                            .setScale(5, RoundingMode.FLOOR).toString()) };
            intervals.add(aux);
            inicio = aux[1];
        }
        return intervals;
    }

    /**
     * Metodo que se encarga de que los numeros se encuentren entre dos numeros que
     * funcionan como los limites establecidos
     * 
     * @param numbers
     * @return retorna un arreglo de doubles, el valor minimo y maximo
     */
    private double[] searchLimits(double[] numbers) {
        double min = numbers[0], max = 0;
        for (int i = 0; i < numbers.length; i++) {
            min = min > numbers[i] ? numbers[i] : min;
            max = max < numbers[i] ? numbers[i] : max;
        }
        return new double[] { min, max };
    }
    
    /**
     * Metodo que determina las frecuencias segun los intervalos
     * @return retorna un linkedHashMap de onjetos de tipo String e Innteger
     */
    public LinkedHashMap<String, Integer> calculateFrequencies() {
        double[] numbers = generateNi();
        ArrayList<Double[]> intervals = generateIntervals();
        LinkedHashMap<String, Integer> frecuencies = new LinkedHashMap<>();
        for (Double[] interval : intervals) {
            frecuencies.put(interval[0] + "-" + interval[1], 0);
        }
        for (Double number : numbers) {
            for (Double[] interval : intervals) {
                if (number > interval[0] && number < interval[1]) {
                    frecuencies.put(interval[0] + "-" + interval[1],
                            frecuencies.get(interval[0] + "-" + interval[1]) + 1);
                    break;
                }
            }
        }
        return frecuencies;
    }
}
