package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import controller.Controller;
import model.TextPrompt;
import view.utils.Constants;

public class JPanelLateralMethodTwo extends JScrollPane {

	private JPanel jPanelContainer;
	private JButton jLabelAccordionM1;
	private JButton jLabelAccordionM2;

	// AC1
	private JPanel jPanelContainerM1;
	private JLabel jLabelTitleM1;
	private JLabel jLabelNumberKM1;
	private JLabel jLabelNumberCM1;
	private JLabel jLabelNumberGM1;
	private JLabel jLabelRangeMinM1;
	private JLabel jLabelRangeMaxM1;
	private JTextField jTextFieldNumberKM1;
	private JTextField jTextFieldNumberCM1;
	private JTextField jTextFieldNumberGM1;
	private JTextField jTextFieldRangeMinM1;
	private JTextField jTextFieldRangeMaxM1;
	private JButton buttonGenerateM1;

	// AC2
	private JPanel jPanelContainerM2;
	private JLabel jLabelTitleM2;
	private JLabel jLabelNumberTM2;
	private JLabel jLabelNumberGM2;
	private JLabel jLabelRangeMinM2;
	private JLabel jLabelRangeMaxM2;
	private JTextField jTextFieldNumberTM2;
	private JTextField jTextFieldNumberGM2;
	private JTextField jTextFieldRangeMinM2;
	private JTextField jTextFieldRangeMaxM2;
	private JButton buttonGenerateM2;

	private GridBagConstraints gbc;

	public JPanelLateralMethodTwo() {
		super();
		this.gbc = new GridBagConstraints();
		this.jPanelContainer = new JPanel();
		this.buttonGenerateM1 = new JButton(Constants.GENERATE);
		this.buttonGenerateM2 = new JButton(Constants.GENERATE);
		this.jLabelAccordionM1 = new JButton(Constants.CONGRUENCIAL_LINEAL);
		this.jLabelAccordionM2 = new JButton(Constants.CONGRUENCIAL_MULTIPLICATIVO);
		this.jPanelContainerM1 = new JPanel(new GridBagLayout());
		this.jLabelTitleM1 = new JLabel(Constants.ENTRIES, JLabel.CENTER);
		this.jLabelNumberKM1 = new JLabel(Constants.NUMBER_K);
		this.jLabelNumberCM1 = new JLabel(Constants.NUMBER_C);
		this.jLabelNumberGM1 = new JLabel(Constants.NUMBER_G);
		this.jLabelRangeMinM1 = new JLabel(Constants.RANGE_MIN);
		this.jLabelRangeMaxM1 = new JLabel(Constants.RANGE_MAX);
		this.jTextFieldNumberKM1 = new JTextField();
		this.jTextFieldNumberCM1 = new JTextField();
		this.jTextFieldNumberGM1 = new JTextField();
		this.jTextFieldRangeMinM1 = new JTextField();
		this.jTextFieldRangeMaxM1 = new JTextField();
		this.jPanelContainerM2 = new JPanel(new GridBagLayout());
		this.jLabelTitleM2 = new JLabel(Constants.ENTRIES, JLabel.CENTER);
		this.jLabelNumberTM2 = new JLabel(Constants.NUMBER_T);
		this.jLabelNumberGM2 = new JLabel(Constants.NUMBER_G);
		this.jLabelRangeMinM2 = new JLabel(Constants.RANGE_MIN);
		this.jLabelRangeMaxM2 = new JLabel(Constants.RANGE_MAX);
		this.jTextFieldNumberTM2 = new JTextField();
		this.jTextFieldNumberGM2 = new JTextField();
		this.jTextFieldRangeMinM2 = new JTextField();
		this.jTextFieldRangeMaxM2 = new JTextField();
		init();
	}

	private void init() {
		this.setOpaque(false);
		this.setViewportView(jPanelContainer);
		this.getViewport().setOpaque(false);
		this.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
		this.jPanelContainer.setLayout(null);
		this.jPanelContainer.setOpaque(false);
		this.jPanelContainerM1.setOpaque(false);
		this.jPanelContainerM2.setOpaque(false);
		this.jPanelContainer
				.setPreferredSize(new Dimension(300 * JFrameMain.WIDTH_FRAME / 1920, 960));
		configureLabelAccordion(jLabelAccordionM1);
		configureLabelAccordion(jLabelAccordionM2);

		configureLabel(jLabelTitleM1, Constants.FONT_SIZE_APP_TITLES, Font.BOLD);
		configureLabel(jLabelNumberKM1, Constants.FONT_SIZE_APP_LABELS, Font.PLAIN);
		configureLabel(jLabelNumberCM1, Constants.FONT_SIZE_APP_LABELS, Font.PLAIN);
		configureLabel(jLabelNumberGM1, Constants.FONT_SIZE_APP_LABELS, Font.PLAIN);
		configureLabel(jLabelRangeMinM1, Constants.FONT_SIZE_APP_LABELS, Font.PLAIN);
		configureLabel(jLabelRangeMaxM1, Constants.FONT_SIZE_APP_LABELS, Font.PLAIN);

		configureTextField(jTextFieldNumberKM1, Constants.PLACEHOLDER_NUMERO_K);
		configureTextField(jTextFieldNumberCM1, Constants.PLACEHOLDER_NUMERO_C);
		configureTextField(jTextFieldNumberGM1, Constants.PLACEHOLDER_NUMERO_G);
		configureTextField(jTextFieldRangeMinM1, Constants.PLACEHOLDER_RANGE_MIN);
		configureTextField(jTextFieldRangeMaxM1, Constants.PLACEHOLDER_RANGE_MAX);

		configureLabel(jLabelTitleM2, Constants.FONT_SIZE_APP_TITLES, Font.BOLD);
		configureLabel(jLabelNumberTM2, Constants.FONT_SIZE_APP_LABELS, Font.PLAIN);
		configureLabel(jLabelNumberGM2, Constants.FONT_SIZE_APP_LABELS, Font.PLAIN);
		configureLabel(jLabelRangeMinM2, Constants.FONT_SIZE_APP_LABELS, Font.PLAIN);
		configureLabel(jLabelRangeMaxM2, Constants.FONT_SIZE_APP_LABELS, Font.PLAIN);

		configureTextField(jTextFieldNumberTM2, Constants.PLACEHOLDER_NUMERO_K);
		configureTextField(jTextFieldNumberGM2, Constants.PLACEHOLDER_NUMERO_G);
		configureTextField(jTextFieldRangeMinM2, Constants.PLACEHOLDER_RANGE_MIN);
		configureTextField(jTextFieldRangeMaxM2, Constants.PLACEHOLDER_RANGE_MAX);

		configureButton(buttonGenerateM1, Constants.COMMAND_GENERATE_CONGR_M1);
		configureButton(buttonGenerateM2, Constants.COMMAND_GENERATE_CONGR_M2);

		addItemsPanels();
		addItems();
	}

	private void addItemsPanels() {
		int insets_width_sides_button = 80 * JFrameMain.WIDTH_FRAME / 1920;
		int insets_width_sides = 20 * JFrameMain.WIDTH_FRAME / 1920;
		int insets_width_top = 16 * JFrameMain.HEIGHT_FRAME / 1080;
		int insets_width_top_button = 30 * JFrameMain.HEIGHT_FRAME / 1080;
		gbc.fill = 1;
		gbc.weightx = 1;
		gbc.insets.top = 5 * JFrameMain.HEIGHT_FRAME / 1080;
		gbc.insets.left = insets_width_sides;
		gbc.insets.right = insets_width_sides;
		this.jPanelContainerM1.add(jLabelTitleM1, gbc);
		gbc.gridy = 1;
		gbc.insets.top = insets_width_top;
		this.jPanelContainerM1.add(jLabelNumberKM1, gbc);
		gbc.gridy = 2;
		gbc.insets.top = 0;
		gbc.insets.top = 0;
		this.jPanelContainerM1.add(jTextFieldNumberKM1, gbc);
		gbc.gridy = 3;
		gbc.insets.top = insets_width_top;
		this.jPanelContainerM1.add(jLabelNumberCM1, gbc);
		gbc.gridy = 4;
		gbc.insets.top = 0;
		this.jPanelContainerM1.add(jTextFieldNumberCM1, gbc);
		gbc.gridy = 5;
		gbc.insets.top = insets_width_top;
		this.jPanelContainerM1.add(jLabelNumberGM1, gbc);
		gbc.gridy = 6;
		gbc.insets.top = 0;
		this.jPanelContainerM1.add(jTextFieldNumberGM1, gbc);
		gbc.gridy = 7;
		gbc.insets.top = insets_width_top;
		this.jPanelContainerM1.add(jLabelRangeMinM1, gbc);
		gbc.gridy = 8;
		gbc.insets.top = 0;
		this.jPanelContainerM1.add(jTextFieldRangeMinM1, gbc);
		gbc.gridy = 9;
		gbc.insets.top = insets_width_top;
		this.jPanelContainerM1.add(jLabelRangeMaxM1, gbc);
		gbc.gridy = 10;
		gbc.insets.top = 0;
		this.jPanelContainerM1.add(jTextFieldRangeMaxM1, gbc);
		gbc.insets.top = insets_width_top_button;
		gbc.insets.left = insets_width_sides_button;
		gbc.insets.right = insets_width_sides_button;
		gbc.gridy = 11;
		gbc.gridwidth = 2;
		this.jPanelContainerM1.add(buttonGenerateM1, gbc);
		gbc.gridy = 12;
		gbc.weighty = 1;
		this.jPanelContainerM1.add(Box.createRigidArea(new Dimension(0,0)), gbc);

		gbc.weighty = 0;
		gbc.fill = 1;
		gbc.weightx = 1;
		gbc.insets.top = 5 * JFrameMain.HEIGHT_FRAME / 1080;
		gbc.insets.left = insets_width_sides;
		gbc.insets.right = insets_width_sides;
		gbc.gridy = 0;
		this.jPanelContainerM2.add(jLabelTitleM2, gbc);
		gbc.gridy = 1;
		gbc.insets.top = insets_width_top;
		this.jPanelContainerM2.add(jLabelNumberTM2, gbc);
		gbc.gridy = 2;
		gbc.insets.top = 0;
		this.jPanelContainerM2.add(jTextFieldNumberTM2, gbc);
		gbc.gridy = 3;
		gbc.insets.top = insets_width_top;
		this.jPanelContainerM2.add(jLabelNumberGM2, gbc);
		gbc.gridy = 4;
		gbc.insets.top = 0;
		this.jPanelContainerM2.add(jTextFieldNumberGM2, gbc);
		gbc.gridy = 5;
		gbc.insets.top = insets_width_top;
		this.jPanelContainerM2.add(jLabelRangeMinM2, gbc);
		gbc.gridy = 6;
		gbc.insets.top = 0;
		this.jPanelContainerM2.add(jTextFieldRangeMinM2, gbc);
		gbc.gridy = 7;
		gbc.insets.top = insets_width_top;
		this.jPanelContainerM2.add(jLabelRangeMaxM2, gbc);
		gbc.gridy = 8;
		gbc.insets.top = 0;
		this.jPanelContainerM2.add(jTextFieldRangeMaxM2, gbc);
		gbc.insets.top = insets_width_top_button;
		gbc.insets.left = insets_width_sides_button;
		gbc.insets.right = insets_width_sides_button;
		gbc.gridy = 9;
		gbc.gridwidth = 2;
		this.jPanelContainerM2.add(buttonGenerateM2, gbc);
		gbc.gridy = 10;
		gbc.weighty = 1;
		this.jPanelContainerM2.add(Box.createRigidArea(new Dimension(0,0)), gbc);
	}

	private void addItems() {
		this.jPanelContainer.add(jLabelAccordionM1).setBounds(0, 35 * JFrameMain.HEIGHT_FRAME / 1080,
				320 * JFrameMain.WIDTH_FRAME / 1920, 35 * JFrameMain.HEIGHT_FRAME / 1080);
		this.jPanelContainer.add(jPanelContainerM1).setBounds(0, 70 * JFrameMain.HEIGHT_FRAME / 1080,
				320 * JFrameMain.WIDTH_FRAME / 1920, 420 * JFrameMain.HEIGHT_FRAME / 1080);
		this.jPanelContainer.add(jLabelAccordionM2).setBounds(0, 500 * JFrameMain.HEIGHT_FRAME / 1080,
				320 * JFrameMain.WIDTH_FRAME / 1920, 35 * JFrameMain.HEIGHT_FRAME / 1080);
		this.jPanelContainer.add(jPanelContainerM2).setBounds(0, 535 * JFrameMain.HEIGHT_FRAME / 1080,
				320 * JFrameMain.WIDTH_FRAME / 1920, 420 * JFrameMain.HEIGHT_FRAME / 1080);
	}

	private void configureLabelAccordion(JButton jLabelAccordion) {
		jLabelAccordion.setFont(new Font(Constants.FONT_APP, Font.PLAIN, Constants.FONT_SIZE_APP_PLACEHOLDER));
		jLabelAccordion.setForeground(Color.WHITE);
		jLabelAccordion.setBackground(Constants.COLOR_BUTTONS_METHODS_HOVER);
		jLabelAccordion.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.WHITE));
		jLabelAccordion.setFocusPainted(false);
	}

	private void configureButton(JButton jButton, String actionCommand) {
		jButton.setFont(new Font(Constants.FONT_APP, Font.PLAIN, Constants.FONT_SIZE_APP_PLACEHOLDER));
		jButton.setForeground(Color.WHITE);
		jButton.setFocusPainted(false);
		jButton.setContentAreaFilled(false);
		jButton.setBorder(new LineBorder(Color.WHITE));
		jButton.addActionListener(Controller.getInstance());
		jButton.setActionCommand(actionCommand);
		jButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jButton.setBorder(new LineBorder(Color.BLUE));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jButton.setBorder(new LineBorder(Color.WHITE));
			}
		});
	}

	private void configureLabel(JLabel jLabel, int fontSize, int style) {
		jLabel.setFont(new Font(Constants.FONT_APP, style, fontSize));
		jLabel.setForeground(Color.WHITE);
	}

	private void configureTextField(JTextField jTextField, String placeholder) {
		jTextField.setFont(new Font(Constants.FONT_APP, Font.PLAIN, Constants.FONT_SIZE_APP_PLACEHOLDER));
		jTextField.setBorder(new LineBorder(Color.WHITE));
		jTextField.setOpaque(false);
		jTextField.setForeground(Color.WHITE);
		jTextField.setPreferredSize(new Dimension(0, 30));
		TextPrompt textPrompt = new TextPrompt(placeholder, jTextField);
		textPrompt.changeAlpha(0.35f);
		textPrompt.changeStyle(Font.ITALIC);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(220, 10, 10, 0));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
}
