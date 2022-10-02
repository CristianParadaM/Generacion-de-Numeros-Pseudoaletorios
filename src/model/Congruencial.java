package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Congruencial {
	private int k;
	private int c;
	private int g;
	private int t;
	
	public Congruencial(int k, int c, int g) {
		this.k = k;
		this.c = c;
		this.g = g;
	}
	
	public Congruencial(int t, int g) {
		this.t = t;
		this.g = g;
	}
	
	public ArrayList<Double[]> congruenciaLineal(){
		return generateTable(1+2*k, c, (int) Math.pow(2, g));
	}
	
	public ArrayList<Double[]> congruenciaMultiplicativo(){
		return generateTable(8*t+3, 0, (int) Math.pow(2, g));
	}
	
	public double[] getRi() {
		ArrayList<Double[]> table = t != 0?congruenciaMultiplicativo():congruenciaLineal();
		double[] numbers = new double[table.size()];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = table.get(i)[2];
		}
		return numbers;
	}

	private ArrayList<Double[]> generateTable(int a, int c, int m) {
		ArrayList<Double[]> table = new ArrayList<>();
		double x_i = 1;
		for (int i = 1; i <= (c!=0?m:m/4); i++) {
			Double[] row = new Double[3];
			row[0] = (double) i;
			row[1] = (double) ((a*x_i+c)%m);
			row[2] = Double.parseDouble(new BigDecimal(String.valueOf(row[1]/(m-1))).setScale(5, RoundingMode.FLOOR).toString());
			if (row[2] != 1 && row[2] != 0) {
				table.add(row);
			}
			x_i = row[1];
		}
		return table;
	}

}
