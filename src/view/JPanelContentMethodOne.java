package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.utils.Constants;
import view.utils.JTableReports;

public class JPanelContentMethodOne extends JPanel {

	private JLabel jLabelTitle;
	private JTableReports jTableReports;
	private ArrayList<Object[]> info;
	private String[] columNames;
	private GridBagConstraints gbc;

	public JPanelContentMethodOne() {

		super(new GridBagLayout());
		gbc = new GridBagConstraints();
		ArrayList<Object[]> info = new ArrayList<>();
		info.add(new Object[] { 1, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 1, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 1, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 1, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 1, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 1, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 1, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 1, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 1, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 1, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 1, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 1, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 1, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 1, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 1, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 1, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 1, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 1, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 1, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 1, 2, 3, 4, 5, 6, 7 });
		info.add(new Object[] { 1, 2, 3, 4, 5, 6, 7 });
		String[] columNames = { "i", "Xi", "Xi^2", "Dig.", "Extracción", "Ri", "Ni" };
		this.jTableReports = new JTableReports(info, columNames);
		this.jLabelTitle = new JLabel(Constants.NUMEROS_PSEUDO_ALEATORIOS_GENERADOS, JLabel.CENTER);
		init();
	}

	private void init() {

		this.setOpaque(false);
		gbc.fill = 1;
		gbc.weightx = 1;
		gbc.insets = new Insets(25, 30, 0, 30);
		gbc.gridy = 2;
		this.add(jTableReports, gbc);

		configureLabel(jLabelTitle, Constants.FONT_SIZE_APP_TITLES, Font.BOLD);

		gbc.insets = new Insets(-90, 3, 0, 0);
		gbc.gridy = 1;
		this.add(jLabelTitle, gbc);
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
