package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

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
				.getImage().getScaledInstance(900 * JFrameMain.WIDTH_FRAME / 1920, 300 * JFrameMain.HEIGHT_FRAME / 1080,
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

		changeMethodContent(".",null,null,null,null);
	}

	public void changeMethodContent(String option, ArrayList<Object[]> info, String[] columnNames, ArrayList<Double> x,ArrayList<Double> y) {
		removeComponents();
		switch (option) {
		case Constants.METHOD_ONE:
			this.jPanelContentMethodOne = new JPanelContentMethodOne(info, columnNames);
			this.add(jPanelContentMethodOne);
			break;
			case Constants.METHOD_TWO:
				JPanelContentMethodTwo jPanelContentMethodTwo = new JPanelContentMethodTwo(info, columnNames, x, y);
				this.add(jPanelContentMethodTwo);
				break;
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
