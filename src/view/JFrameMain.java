package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

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
	public void showMethod(String method) {
		jPanelMain.showMethod(method);
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
	
}
