package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import view.JFrameMain;
import view.utils.Constants;

public class Controller implements ActionListener {
	private JFrameMain view;
	private static Controller controller = null;
	ArrayList<Object[]> info = new ArrayList<>();
	ArrayList<Double> x = new ArrayList<>();
	ArrayList<Double> y = new ArrayList<>();
	String[] columNames = { "i", "Xi", "Xi^2", "Dig.", "Extraccion", "Ri" };
	
	public static Controller getInstance() {
		if (controller == null) {
			controller = new Controller();
		}
		return controller;
	}

	public void initApp() {
		view = JFrameMain.getInstance();
		view.init();
		info.add(new Object[] { 0, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 1, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 2, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 3, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 4, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 5, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 6, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 7, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 8, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 9, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6 });

		x.add(1.0);
		x.add(2.0);
		x.add(3.0);
		x.add(4.0);
		x.add(5.0);
		x.add(6.0);
		x.add(7.0);
		x.add(8.0);
		x.add(9.0);
		x.add(10.0);
		
		y.add(1.0);
		y.add(2.0);
		y.add(3.0);
		y.add(4.0);
		y.add(5.0);
		y.add(6.0);
		y.add(7.0);
		y.add(8.0);
		y.add(9.0);
		y.add(10.0);
	}

	public static void main(String[] args) {
		Controller.getInstance().initApp();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Constants.COMMAND_GENERATE_METHOD_ONE -> generateMethodOne();
		case Constants.COMMAND_GENERATE_CONGR_M1 -> generateMethodTwoM1();
		case Constants.COMMAND_GENERATE_CONGR_M2 -> generateMethodOneM2();
		case Constants.COMMAND_GENERATE_METHOD_ONE_U -> generateMethodOneU();
		case Constants.COMMAND_GENERATE_CONGR_U_M1 -> generateCongrUM1();
		case Constants.COMMAND_GENERATE_CONGR_U_M2 -> generateCongrUM2();
		}
	}

	private void generateCongrUM1() {
		try {
			int min = Integer.parseInt(view.getMinU());
			int max = Integer.parseInt(view.getMaxU());
			int k = Integer.parseInt(view.getKU());
			int c = Integer.parseInt(view.getCU());
			int g = Integer.parseInt(view.getGU1());

			if (min < max) {
				if (min != max) {
					if (c % 2 != 0) {
						if (g > k && g > c) {
								view.showMethod(Constants.METHOD_TWO, info, columNames, x, y);
						} else {
							view.alert(Constants.ERROR_G, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
						}
					} else {
						view.alert(Constants.ERROR_IMPAR, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
					}
				} else {
					view.alert(Constants.ERROR_MIN_MAX_I, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
				}
			} else {
				view.alert(Constants.ERROR_MIN_MAX, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException e) {
			view.alert(Constants.ERROR_EMPTY_TEXT, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void generateCongrUM2() {
		try {
			int min = Integer.parseInt(view.getMinU());
			int max = Integer.parseInt(view.getMaxU());
			int t = Integer.parseInt(view.getTU());
			int g = Integer.parseInt(view.getGU2());

			if (min < max) {
				if (min != max) {
					if (g > t) {
						// model
						view.showMethod(Constants.METHOD_TWO, info, columNames, x, y);
					} else {
						view.alert(Constants.ERROR_G, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
					}
				} else {
					view.alert(Constants.ERROR_MIN_MAX_I, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
				}
			} else {
				view.alert(Constants.ERROR_MIN_MAX, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException e) {
			view.alert(Constants.ERROR_EMPTY_TEXT, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void generateMethodOneU() {
		try {
			int min = Integer.parseInt(view.getMinU());
			int max = Integer.parseInt(view.getMaxU());
			int seed = Integer.parseInt(view.getSeedU());
			boolean fill = view.getFillU();
			if (min < max) {
				if (min != max) {
					if (seed + "".length() > 3) {
						// model
						view.showMethod(Constants.METHOD_TWO, info, columNames, x, y);
					} else {
						view.alert(Constants.ERROR_SEED, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
					}
				} else {
					view.alert(Constants.ERROR_MIN_MAX_I, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
				}
			} else {
				view.alert(Constants.ERROR_MIN_MAX, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException e) {
			view.alert(Constants.ERROR_EMPTY_TEXT, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void generateMethodTwoM1() {
		try {
			int k = Integer.parseInt(view.getKM1());
			int c = Integer.parseInt(view.getCM1());
			int g = Integer.parseInt(view.getGM1());

			if (c % 2 != 0) {
				view.highlightM2M1(1, 0);
				if (g > k && g > c) {
					view.highlightM2M1(0, 0);
					view.highlightM2M1(1, 0);
					view.highlightM2M1(2, 0);
					view.highlightM2M1(3, 0);
					view.highlightM2M1(4, 0);
					// model
						view.showMethod(Constants.METHOD_ONE, info, columNames, x, y);
				} else {
					view.highlightM2M1(0, 1);
					view.highlightM2M1(1, 1);
					view.highlightM2M1(2, 1);
					view.alert(Constants.ERROR_G, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
				}
			} else {
				view.highlightM2M1(1, 1);
				view.alert(Constants.ERROR_IMPAR, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException e) {
			view.highlightM2M1(0, 1);
			view.highlightM2M1(1, 1);
			view.highlightM2M1(2, 1);
			view.alert(Constants.ERROR_EMPTY_TEXT, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void generateMethodOneM2() {
		try {
			int t = Integer.parseInt(view.getTM2());
			int g = Integer.parseInt(view.getGM2());
			if (g > t) {
				view.highlightM2M2(0, 0);
				view.highlightM2M2(1, 0);
				view.highlightM2M2(2, 0);
				view.highlightM2M2(3, 0);
				// model
					view.showMethod(Constants.METHOD_ONE, info, columNames, x, y);
			} else {
				view.highlightM2M2(0, 1);
				view.highlightM2M2(1, 1);
				view.alert(Constants.ERROR_G, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException e) {
			view.highlightM2M2(0, 1);
			view.highlightM2M2(1, 1);
			view.alert(Constants.ERROR_EMPTY_TEXT, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void generateMethodOne() {
		try {
			int seed = Integer.parseInt(view.getSeed());
			boolean fill = view.getFill();
			if (seed + "".length() > 3 && seed % 2 == 0) {
				view.highlightM1(0, 0);
				view.highlightM1(1, 0);
				view.highlightM1(2, 0);
				// model
				view.showMethod(Constants.METHOD_ONE, info, columNames, x, y);
			} else {
				view.highlightM1(0, 1);
				view.alert(Constants.ERROR_SEED, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException e) {
			view.highlightM1(0, 1);
			view.alert(Constants.ERROR_EMPTY_TEXT, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
		}

	}
}
