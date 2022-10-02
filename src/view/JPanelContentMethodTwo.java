package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;

import view.utils.Constants;
import view.utils.JTableMethod;

public class JPanelContentMethodTwo extends JScrollPane {

	private JLabel jLabelTitle;
	private JLabel jLabelTitle2;
	private JTableMethod jTableReports;
	private JFreeChart jFreeChartBar;
	private JPanel jPanelContent;

	public JPanelContentMethodTwo(ArrayList<Object[]> info, String[] columnNames, ArrayList<Double> x,
			ArrayList<Double> y) {
		super();
		this.jTableReports = new JTableMethod(info, columnNames);
		this.jLabelTitle = new JLabel(Constants.NUMEROS_PSEUDO_ALEATORIOS_GENERADOS, JLabel.CENTER);
		this.jLabelTitle2 = new JLabel(Constants.GRAPHIC, JLabel.CENTER);
		this.jPanelContent = new JPanel();
		init(x, y);
	}

	private void fillDataSet(DefaultCategoryDataset dataset, ArrayList<Double> x, ArrayList<Double> y) {
		for (int i = 0; i < x.size(); i++) {
			dataset.addValue(x.get(i), "", y.get(i));
		}
	}

	private void init(ArrayList<Double> x, ArrayList<Double> y) {
		this.jPanelContent.setOpaque(false);
		this.jPanelContent.setLayout(null);
		this.jPanelContent.setPreferredSize(new Dimension(960, 1100));
		this.jLabelTitle.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		this.jLabelTitle2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		this.setOpaque(false);
		this.setViewportView(jPanelContent);
		this.getViewport().setOpaque(false);
		this.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		fillDataSet(dataset, x, y);
		jFreeChartBar = ChartFactory.createBarChart("", "", "", dataset, PlotOrientation.VERTICAL, false, false, true);
		jFreeChartBar.removeLegend();
		CategoryPlot plot = jFreeChartBar.getCategoryPlot();
		plot.setBackgroundPaint(Color.WHITE);
		plot.setRangeGridlinePaint(Color.WHITE);
		plot.setOutlineVisible(false);
		plot.setAxisOffset(new RectangleInsets(0D, 0D, 0D, 0D));
		BufferedImage img = jFreeChartBar.createBufferedImage(800 * JFrameMain.WIDTH_FRAME / 1920,
				300 * JFrameMain.HEIGHT_FRAME / 1080);
		configureLabel(jLabelTitle, Constants.FONT_SIZE_APP_TITLES, Font.BOLD);
		configureLabel(jLabelTitle2, Constants.FONT_SIZE_APP_TITLES, Font.BOLD);
		addComponents(img);
	}

	private void addComponents(Image img) {
		this.jPanelContent.add(jLabelTitle).setBounds(40 * JFrameMain.WIDTH_FRAME / 1920, 0,
				880 * JFrameMain.WIDTH_FRAME / 1920, 50 * JFrameMain.HEIGHT_FRAME / 1080);
		this.jPanelContent.add(jTableReports).setBounds(40 * JFrameMain.WIDTH_FRAME / 1920,
				70 * JFrameMain.HEIGHT_FRAME / 1080, 880 * JFrameMain.WIDTH_FRAME / 1920,
				600 * JFrameMain.HEIGHT_FRAME / 1080);
		this.jPanelContent.add(jLabelTitle2).setBounds(40 * JFrameMain.WIDTH_FRAME / 1920,
				690 * JFrameMain.HEIGHT_FRAME / 1080, 880 * JFrameMain.WIDTH_FRAME / 1920,
				50 * JFrameMain.HEIGHT_FRAME / 1080);
		this.jPanelContent.add(new JLabel(new ImageIcon(img))).setBounds(20 * JFrameMain.WIDTH_FRAME / 1920,
				760 * JFrameMain.HEIGHT_FRAME / 1080, 880 * JFrameMain.WIDTH_FRAME / 1920,
				300 * JFrameMain.HEIGHT_FRAME / 1080);
	}

	private void configureLabel(JLabel jLabel, int fontSize, int style) {
		jLabel.setFont(new Font(Constants.FONT_APP, style, fontSize));
		jLabel.setForeground(Color.WHITE);
	}

}
