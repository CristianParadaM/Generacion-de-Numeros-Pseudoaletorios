package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.Title;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;

import view.utils.Constants;
import view.utils.JTableMethod;

public class JPanelContentMethodOne extends JPanel {

	private JLabel jLabelTitle;
	private JTableMethod jTableReports;
	private GridBagConstraints gbc;

	public JPanelContentMethodOne(ArrayList<Object[]> info, String[] columnNames) {
		super(new GridBagLayout());
		this.gbc = new GridBagConstraints();
		this.jTableReports = new JTableMethod(info, columnNames);
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
		gbc.insets.bottom = 20;
		gbc.weighty = 1;
		this.add(jTableReports, gbc);
		gbc.weighty = 0;
		gbc.gridy = 2;
//		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//		dataset.addValue(1, "", "" + 1);
//		dataset.addValue(2, "", "" + 2);
//		dataset.addValue(3, "", "" + 3);
//		dataset.addValue(4, "", "" + 4);
//		dataset.addValue(5, "", "" + 5);
//		dataset.addValue(6, "", "" + 6);
//		JFreeChart chart = ChartFactory.createBarChart("", "", "", dataset, PlotOrientation.VERTICAL, false, false,
//				true);
//		chart.removeLegend();
//		CategoryPlot plot = chart.getCategoryPlot();
//        plot.setBackgroundPaint(Color.WHITE);
//        plot.setRangeGridlinePaint(Color.WHITE);
//        plot.setOutlineVisible(false);
//        plot.setAxisOffset(new RectangleInsets(0D, 0D, 0D, 0D));
//		BufferedImage img = chart.createBufferedImage(300, 300);
//		this.add(new JLabel(new ImageIcon(img)), gbc);

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
