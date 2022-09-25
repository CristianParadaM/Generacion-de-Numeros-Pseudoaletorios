package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.utils.Constants;
import view.utils.JTableMethod;

public class JPanelContentMethodOne extends JPanel {

	private JLabel jLabelTitle;
	private JTableMethod jTableReports;
	private ArrayList<Object[]> info;
	private String[] columNames;
	private GridBagConstraints gbc;

	public JPanelContentMethodOne() {
		super(new GridBagLayout());
		gbc = new GridBagConstraints();
		ArrayList<Object[]> info = new ArrayList<>();
		info.add(new Object[] { 0, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 1, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 2, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 3, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 4, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 5, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 6, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 7, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 8, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 9, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 10, 2, 3, 4, 5, 6, 7 });
		String[] columNames = { "i", "Xi", "Xi^2", "Dig.", "Extraccion", "Ri", "Ni" };
		this.jTableReports = new JTableMethod(info, columNames);
		this.jLabelTitle = new JLabel(Constants.NUMEROS_PSEUDO_ALEATORIOS_GENERADOS, JLabel.CENTER);
		init();
	}

	private void init() {
		this.setOpaque(false);
		configureLabel(jLabelTitle, Constants.FONT_SIZE_APP_TITLES, Font.BOLD);
		addComponents();
	}

	private void addComponents() {
		gbc.fill = 1;
		gbc.weightx = 1;
		gbc.insets = new Insets(10 * JFrameMain.HEIGHT_FRAME / 1080, 0, 0, 0);
		this.add(jLabelTitle, gbc);
		gbc.insets = new Insets(25 * JFrameMain.HEIGHT_FRAME / 1080, 30 * JFrameMain.WIDTH_FRAME / 1920, 0,
				30 * JFrameMain.WIDTH_FRAME / 1920);
		gbc.gridy = 1;
		this.add(jTableReports, gbc);
		gbc.gridy = 2;
		gbc.weighty = 1;
		this.add(Box.createRigidArea(new Dimension(0, 0)), gbc);
	}

	private void configureLabel(JLabel jLabel, int fontSize, int style) {
		jLabel.setFont(new Font(Constants.FONT_APP, style, fontSize));
		jLabel.setForeground(Color.WHITE);
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.WHITE);
		g2d.drawLine(20 * JFrameMain.WIDTH_FRAME / 1920, 50 * JFrameMain.HEIGHT_FRAME / 1080,
				getWidth() - (20 * JFrameMain.WIDTH_FRAME / 1920), (50 * JFrameMain.HEIGHT_FRAME / 1080));
		super.paint(g);
	}

}
