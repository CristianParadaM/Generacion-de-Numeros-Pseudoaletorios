package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Minimos_Cuadrados {
	private int seed;
	private boolean addLeft;
	private ArrayList<Object[]> table;

	public Minimos_Cuadrados(int seed, boolean addLeft) {
		this.seed = seed;
		this.addLeft = addLeft;
		table = new ArrayList<>();
	}

	public ArrayList<Object[]> generateNumbers() {
		int i = 0, x_i = seed, seed_lenght = (seed + "").length(), divisor = (int) Math.pow(10, seed_lenght);
		if (addLeft) {
			double r_i = -1;
			while (r_i !=0) {
				String row[] = new String[6];
				i = generateRow(i, x_i, seed_lenght, divisor, row);
				String pow = row[5]+"";
				if (isRepeated(pow)) {
					table.add(row);
					break;
				}
				table.add(row);
				x_i = Integer.parseInt(row[4]);
				r_i = Double.parseDouble(row[5]);
			}
		} else {
			while (true) {
				String row[] = new String[7];
				i = generateRow(i, x_i, seed_lenght, divisor, row);
				String pow = row[5]+"";
				while (pow.length() < 7) {
					pow = pow + "0";
				}
				if (isRepeated(pow)) {
					table.add(row);
					break;
				}
				table.add(row);
				x_i = Integer.parseInt(row[4]);
			}
			table.remove(table.size() - 1);
		}
		if (Double.parseDouble((String)table.get(table.size()-1)[5]) == 0.0) {
			table.remove(table.size()-1);
		}
		return table;
	}

	private int generateRow(int i, int xi, int seed_lenght, int divisor, String[] row) {
		row[0] = (i++) + "";
		row[1] = xi + "";
		String pow = ((long)Math.pow(xi, 2))+ "";
		row[3] = pow.length() + "";
		while (pow.length() < seed_lenght * 2) {
			if (addLeft) {
				pow = "0" + pow;
			} else {
				pow = pow + "0";
			}
		}
		row[2] = pow;
		row[4] = pow.substring(seed_lenght / 2, (seed_lenght / 2) + seed_lenght);
		row[5] = (new BigDecimal(String.valueOf(Double.parseDouble(row[4]) / divisor)).setScale(5, RoundingMode.FLOOR))
				+ "";
		return i;
	}

	private boolean isRepeated(String number) {
		for (Object[] integers : table) {
			for (int i = 0; i < integers.length; i++) {
				if (((String) integers[5]).equals(number)) {
					return true;
				}
			}
		}
		return false;
	}

	public double[] getRi() {
		ArrayList<Object[]> table = generateNumbers();
		double[] numbers = new double[table.size()];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Double.parseDouble((String) table.get(i)[5]);
		}
		return numbers;
	}

}
