package view;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.utils.Constants;
/**
 * 
 * Frame principal de la aplicacion, donde se inicializan los paneles de la vista
 *
 * @author Cristian David Parada Martinez, Daniel Felipe Suarez Bohorquez
 *         ,Julian Steven Huertas Henao
 */
public class JFrameMain extends JFrame implements ActionListener {

	public static final int WIDTH_FRAME = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int HEIGHT_FRAME = Toolkit.getDefaultToolkit().getScreenSize().height;
	private JPanelMain jPanelMain;
	private static JFrameMain jFrameMain = null;

	public static JFrameMain getInstance() {
		if (jFrameMain == null) {
			jFrameMain = new JFrameMain();
		}
		return jFrameMain;
	}

	public JFrameMain() {
		super("Generacion de numeros Pseudoaletarios por distintos metodos");
	}

	public void init() {
		this.jPanelMain = new JPanelMain();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1300 * WIDTH_FRAME / 1920, 800 * HEIGHT_FRAME / 1080);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setContentPane(jPanelMain);
		this.setVisible(true);
	}

	/**
	 * @param methodOne
	 */
	public void showMethod(String method, ArrayList<Object[]> info, String[] columnNames, ArrayList<Double> x,
			ArrayList<Double> y) {
		jPanelMain.showMethod(method, info, columnNames, x, y);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Constants.COMMAND_SWITCH_METHOD_ONE -> jPanelMain.changeToMethod(Constants.METHOD_ONE,
				Constants.COMMAND_GENERATE_METHOD_ONE);
		case Constants.COMMAND_SWITCH_METHOD_TWO -> jPanelMain.changeToMethod(Constants.METHOD_TWO,
				Constants.COMMAND_ACCORDION_CONGR_M1, Constants.COMMAND_ACCORDION_CONGR_M2,
				Constants.COMMAND_GENERATE_CONGR_M1, Constants.COMMAND_GENERATE_CONGR_M2);
		case Constants.COMMAND_SWITCH_METHOD_THREE -> jPanelMain.changeToMethod(Constants.METHOD_THREE);
		case Constants.COMMAND_SWITCH_METHOD_FOUR -> jPanelMain.changeToMethod(Constants.METHOD_FOUR);
		case Constants.COMMAND_ACCORDION_CONGR_M1 -> jPanelMain.moveAccordion(0);
		case Constants.COMMAND_ACCORDION_CONGR_M2 -> jPanelMain.moveAccordion(1);
		case Constants.COMMAND_ACCORDION_UNI_C_M1 -> jPanelMain.moveAccordionUniC(0);
		case Constants.COMMAND_ACCORDION_UNI_C_M2 -> jPanelMain.moveAccordionUniC(1);
		case Constants.COMMAND_ACCORDION_UNI_M1 -> jPanelMain.moveAccordionUni(0);
		case Constants.COMMAND_ACCORDION_UNI_M2 -> jPanelMain.moveAccordionUni(1);
		case Constants.COMMAND_ACCORDION_NOR_M1 -> jPanelMain.moveAccordionNor(0);
		case Constants.COMMAND_ACCORDION_NOR_M2 -> jPanelMain.moveAccordionNor(1);
		case Constants.COMMAND_ACCORDION_NOR_C_M1 -> jPanelMain.moveAccordionNorC(0);
		case Constants.COMMAND_ACCORDION_NOR_C_M2 -> jPanelMain.moveAccordionNorC(1);
		}
	}

	public String getSeed() {
		return jPanelMain.getSeed();
	}

	public boolean getFill() {
		return jPanelMain.getFill();
	}

	public void alert(String message, String title, int type) {
		JOptionPane.showMessageDialog(this, message, title, type);
	}

	public void highlightM1(int index, int option) {
		jPanelMain.highlightM1(index, option);
	}

	public String getKM1() {
		return jPanelMain.getKM1();
	}

	public String getCM1() {
		return jPanelMain.getCM1();
	}

	public String getGM1() {
		return jPanelMain.getGM1();
	}

	public String getTM2() {
		return jPanelMain.getTM2();
	}

	public String getGM2() {
		return jPanelMain.getGM2();
	}

	public void highlightM2M1(int index, int option) {
		jPanelMain.highlightM2M1(index, option);
	}

	public void highlightM2M2(int index, int option) {
		jPanelMain.highlightM2M2(index, option);
	}

	public String getMinU() {
		return jPanelMain.getMinU();
	}

	public String getMaxU() {
		return jPanelMain.getMaxU();
	}

	public String getSeedU() {
		return jPanelMain.getSeedU();
	}

	public boolean getFillU() {
		return jPanelMain.getFillU();
	}

	public String getKU() {
		return jPanelMain.getKU();
	}

	public String getCU() {
		return jPanelMain.getCU();
	}

	public String getGU1() {
		return jPanelMain.getGU1();
	}

	public String getGU2() {
		return jPanelMain.getGU2();
	}

	public String getTU() {
		return jPanelMain.getTU();
	}

	public String getMean() {
		return jPanelMain.getMean();
	}

	public String getSD() {
		return jPanelMain.getSD();
	}

	public String getSeedN() {
		return jPanelMain.getSeedN();
	}

	public boolean getFillN() {
		return jPanelMain.getFillN();
	}

	public String getKN() {
		return jPanelMain.getKN();
	}

	public String getCN() {
		return jPanelMain.getCN();
	}

	public String getGN1() {
		return jPanelMain.getGN1();
	}

	public String getGN2() {
		return jPanelMain.getGN2();
	}

	public String getTN() {
		return jPanelMain.getTN();
	}

}
