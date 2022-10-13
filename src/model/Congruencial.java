package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * 
 * Clase que se encarga de la generacion de numeros pseudoaleatorios por medio
 * de los metodos congruencial linea y congruencial multiplicativo.
 *
 * @author Cristian David Parada Martinez, Daniel Felipe Suarez Bohorquez
 *         ,Julian Steven Huertas Henao
 */
public class Congruencial {
    private int k;
    private int c;
    private int g;
    private int t;

    /**
     * metodo constructor que recibe por parameteos los valores necesarios para
     * aplicar el metodo congruencial lineal
     * 
     * @param k
     * @param c
     * @param g
     */
    public Congruencial(int k, int c, int g) {
        this.k = k;
        this.c = c;
        this.g = g;
    }

    /**
     * metodo constructor que recibe por parametros los valores necesarios para
     * aplicar el metodo congruencial multipicativo
     * 
     * @param t
     * @param g
     */
    public Congruencial(int t, int g) {
        this.t = t;
        this.g = g;
    }

    /**
     * Metodo que obtiene los procedimiento para la congruencia lineal
     * 
     * @return ArrayList de objetos obtenidos en el procedimiento para el metodo
     *         congruencial multiplicativo
     */
    public ArrayList<Object[]> congruenciaLineal() {
        return generateTable(1 + 2 * k, c, (int) Math.pow(2, g));
    }

    /**
     * Metodo que obtiene los procedimiento para la congruencia multiplicativa
     * 
     * @return ArrayList de objetos obtenidos en el procedimiento para el metodo
     *         congruencial multiplicativo
     */
    public ArrayList<Object[]> congruenciaMultiplicativo() {
        return generateTable(8 * t + 3, 0, (int) Math.pow(2, g));
    }

    /**
     * Metodo que obtiene los Ri
     * 
     * @return los Ri como un arreglo de double
     */
    public double[] getRi() {
        ArrayList<Object[]> table = t != 0 ? congruenciaMultiplicativo() : congruenciaLineal();
        double[] numbers = new double[table.size()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (double) table.get(i)[2];
        }
        return numbers;
    }

    /**
     * metodo genera la tabla de procedimientos para generae los Ri
     * 
     * @param a
     * @param c
     * @param m
     * @return ArrayList de arreglo de objetos(cada arreglo es una fila de la tabla)
     *         con el procedimiento
     */
    private ArrayList<Object[]> generateTable(int a, int c, int m) {
        ArrayList<Object[]> table = new ArrayList<>();
        double x_i = 1;
        for (int i = 1; i <= (c != 0 ? m : m / 4); i++) {
            Double[] row = new Double[3];
            row[0] = (double) i;
            row[1] = (double) ((a * x_i + c) % m);
            row[2] = Double.parseDouble(
                    new BigDecimal(String.valueOf(row[1] / (m - 1))).setScale(5, RoundingMode.FLOOR).toString());
            if (row[2] != 1 && row[2] != 0) {
                table.add(row);
            }
            x_i = row[1];
        }
        return table;
    }
}
