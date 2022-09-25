package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import view.utils.Constants;

public class JPanelContent extends JPanel {

	private JPanelContentMethodOne jPanelContentMethodOne;

	public JPanelContent() {
		super(new GridLayout());
		this.jPanelContentMethodOne = new JPanelContentMethodOne();
		init();
	}

	private void init() {
		this.setBackground(Constants.COLOR_BACKGROUND_CONTENT);
		changeMethodLateral(Constants.METHOD_ONE);
	}

	public void changeMethodLateral(String option) {
		removeComponents();
		switch (option) {
		case Constants.METHOD_ONE:
			jPanelContentMethodOne.setVisible(true);
			this.add(jPanelContentMethodOne, BorderLayout.CENTER);
			break;
//			case Constants.METHOD_TWO: 
//				jPanelLateralMethodOne.setVisible(true);
//				this.add(jPanelLateralMethodOne);
//				break;
//			case Constants.METHOD_THREE: 
//				jPanelLateralMethodOne.setVisible(true);
//				this.add(jPanelLateralMethodOne);
//				break;
//			case Constants.METHOD_FOUR: 
//				jPanelLateralMethodOne.setVisible(true);
//				this.add(jPanelLateralMethodOne);
//				break;
		}
	}

	public void removeComponents() {
		for (int i = 0; i < this.getComponentCount(); i++) {
			this.getComponent(i).setVisible(false);
		}
		this.removeAll();
	}
}
