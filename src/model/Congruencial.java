package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Congruencial {
	private int k;
	private int c;
	private int g;
	private int t;
	private int min;
	private int max;
	
	public Congruencial(int k, int c, int g, int min, int max) {
		this.k = k;
		this.c = c;
		this.g = g;
		this.min = min;
		this.max = max;
	}
	
	public Congruencial(int t, int g, int min, int max) {
		this.t = t;
		this.g = g;
		this.min = min;
		this.max = max;
	}
	
	public ArrayList<Double[]> congruenciaLineal(){
		return generateTable(1+2*k, c, (int) Math.pow(2, g));
	}
	
	public ArrayList<Double[]> congruenciaMultiplicativo(){
		return generateTable(8*t+3, 0, (int) Math.pow(2, g));
	}

	private ArrayList<Double[]> generateTable(int a, int c, int m) {
		ArrayList<Double[]> table = new ArrayList<>();
		double x_i = 1;
		for (int i = 1; i <= (c!=0?m:m/4); i++) {
			Double[] row = new Double[4];
			row[0] = (double) i;
			row[1] = (double) ((a*x_i+c)%m);
			row[2] = Double.parseDouble(new BigDecimal(String.valueOf(row[1]/(m-1))).setScale(5, RoundingMode.FLOOR).toString());
			row[3] = min + (max-min)*row[2];
			if (row[2] != 1 && row[2] != 0) {
				table.add(row);
			}
			x_i = row[1];
		}
		return table;
	}

}
