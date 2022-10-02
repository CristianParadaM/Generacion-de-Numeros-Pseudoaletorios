package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Minimos_Cuadrados {
	private int seed;
	private boolean addLeft;
	private ArrayList<String[]> table;
	
	public Minimos_Cuadrados(int seed, boolean addLeft) {
		this.seed = seed;
		this.addLeft = addLeft;
		table = new ArrayList<>();
	}
	
	public ArrayList<String[]> generateNumbers() {
		int i = 0, x_i = seed, seed_lenght = (seed+"").length(), divisor = (int) Math.pow(10, seed_lenght);
		if (addLeft) {
			while (true) {
				String row[] = new String[6];
				i = generateRow(i, x_i, seed_lenght, divisor, row);
				if (isRepeated(row[5])) {
					break;
				}
				table.add(row);
				x_i = Integer.parseInt(row[4]);
			}
		}else {
			double R_i = -1;
			while (R_i != 0) {
				String row[] = new String[7];
				i = generateRow(i, x_i, seed_lenght, divisor, row);
				table.add(row);
				x_i = Integer.parseInt(row[4]);
				R_i = Double.parseDouble(row[5]);
			}
			table.remove(table.size()-1);
		}
		return table;
	}

	private int generateRow(int i, int x_i, int seed_lenght, int divisor, String[] row) {
		row[0] = (i++)+"";
		row[1] = x_i+"";
		String pow = x_i*x_i+"";
		row[3] = pow.length()+"";
		while (pow.length() < seed_lenght*2) {
			if (addLeft) {
				pow = "0"+pow;
			}else {
				pow = pow+"0";
			}
		}
		row[2] = pow;
		row[4] = pow.substring(seed_lenght/2, (seed_lenght/2)+seed_lenght);
		row[5] = (new BigDecimal(String.valueOf(Double.parseDouble(row[4])/divisor)).setScale(5, RoundingMode.FLOOR))+"";
		return i;
	}
	
	private boolean isRepeated(String number) {
		for (String[] integers : table) {
			for (int i = 0; i < integers.length; i++) {
				if (integers[5].equals(number)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public double[] getRi() {
		ArrayList<String[]> table = generateNumbers();
		double[] numbers = new double[table.size()];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Double.parseDouble(table.get(i)[5]);
		}
		return numbers;
	}
	
}
