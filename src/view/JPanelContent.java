package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.utils.Constants;

public class JPanelContent extends JPanel {

	private JPanelContentMethodOne jPanelContentMethodOne;

	private JLabel jLabelImgLogo;
	private JPanel jPanelContentDefault;
	private GridBagConstraints gbc;

	public JPanelContent() {
		super(new GridLayout());
		this.gbc = new GridBagConstraints();
		this.jLabelImgLogo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource(Constants.PATH_IMG_LOGO))
				.getImage().getScaledInstance(900 * JFrameMain.WIDTH_FRAME / 1920, 400 * JFrameMain.HEIGHT_FRAME / 1080,
						Image.SCALE_SMOOTH)));
		this.jPanelContentDefault = new JPanel(new GridBagLayout());
		init();
	}

	private void init() {
		this.jPanelContentDefault.setOpaque(false);
		this.setOpaque(true);

		gbc.fill = 1;
		gbc.weightx = 1;

		this.jPanelContentDefault.add(jLabelImgLogo, gbc);

		changeMethodContent(".");
	}

	public void changeMethodContent(String option) {
		removeComponents();
		switch (option) {
		case Constants.METHOD_ONE:
			this.jPanelContentMethodOne = new JPanelContentMethodOne();
			this.add(jPanelContentMethodOne);
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
		default:
			jPanelContentDefault.setVisible(true);
			this.add(jPanelContentDefault);
			break;
		}
	}

	public void removeComponents() {
		for (int i = 0; i < this.getComponentCount(); i++) {
			this.getComponent(i).setVisible(false);
		}
		this.removeAll();
	}

}
