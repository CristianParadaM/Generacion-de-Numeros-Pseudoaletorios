package view;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class JFrameMain extends JFrame {
    
	public static final int WIDTH_FRAME = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static final int HEIGHT_FRAME = Toolkit.getDefaultToolkit().getScreenSize().height;
    private JPanelMain jPanelMain;
    
    public JFrameMain() {
    	super("Generacion de numeros Pseudoaletarios por distintos metodos");
    	this.jPanelMain = new JPanelMain();
    	init();
    }

	private void init() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1300 * WIDTH_FRAME / 1920, 800 * HEIGHT_FRAME / 1080);
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

	
}
