package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.utils.Constants;

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
		this.setMinimumSize(new Dimension(1300 * WIDTH_FRAME / 1920, 800 * HEIGHT_FRAME / 1080));
		this.setLocationRelativeTo(null);
		this.setContentPane(jPanelMain);
		this.setVisible(true);
	}

	/**
	 * @param methodOne
	 */
	public void showMethod(String method, ArrayList<Object[]> info, String[] columnNames) {
		jPanelMain.showMethod(method, info, columnNames);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Constants.COMMAND_SWITCH_METHOD_ONE -> jPanelMain.changeToMethod(Constants.METHOD_ONE);
		case Constants.COMMAND_SWITCH_METHOD_TWO -> jPanelMain.changeToMethod(Constants.METHOD_TWO);
		case Constants.COMMAND_SWITCH_METHOD_THREE -> jPanelMain.changeToMethod(Constants.METHOD_THREE);
		case Constants.COMMAND_SWITCH_METHOD_FOUR -> jPanelMain.changeToMethod(Constants.METHOD_FOUR);
		case Constants.COMMAND_ACCORDION_CONGR_M1 -> jPanelMain.moveAccordion(0);
		case Constants.COMMAND_ACCORDION_CONGR_M2 -> jPanelMain.moveAccordion(1);
		}
	}

	public String getSeed() {
		return jPanelMain.getSeed();
	}

	public String getMinM1() {
		return jPanelMain.getMinM1();
	}

	public String getMaxM1() {
		return jPanelMain.getMaxM1();
	}

	public boolean getFill() {
		return jPanelMain.getFill();
	}

	public void alert(String message, String title, int type) {
		JOptionPane.showMessageDialog(this, message, title, type);
	}

	public void highlightM1(int index,int option) {
		jPanelMain.highlightM1(index ,option);
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

	public String getMinM2M1() {
		return jPanelMain.getMinM2M1();
	}

	public String getMaxM2M1() {
		return jPanelMain.getMaxM2M1();
	}

	public String getTM2() {
		return jPanelMain.getTM2();
	}

	public String getGM2() {
		return jPanelMain.getGM2();
	}

	public String getMinM2M2() {
		return jPanelMain.getMinM2M2();
	}

	public String getMaxM2M2() {
		return jPanelMain.getMaxM2M2();
	}

	public void highlightM2M1(int index, int option) {
		jPanelMain.highlightM2M1( index,  option);
	}
	public void highlightM2M2(int index, int option) {
		jPanelMain.highlightM2M2( index,  option);
	}
	
}
