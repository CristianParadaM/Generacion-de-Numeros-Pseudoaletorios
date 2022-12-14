package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

import controller.Controller;
import model.TextPrompt;
import view.utils.Constants;

@SuppressWarnings("deprecation")
public class JPanelLateralMethodOne extends JPanel {

	private JLabel jLabelTitle;
	private JLabel jLabelSeed;
	private JLabel jLabelAutoFill;

	private JTextField jTextFieldSeed;

	private JRadioButton jRadioButtonIz;
	private JRadioButton jRadioButtonDer;
	private ButtonGroup buttonGroup;

	private JButton jButtonGenerate;
	private GridBagConstraints gbc;

	public JPanelLateralMethodOne(String actionCommandB) {

		super(new GridBagLayout());
		this.jButtonGenerate = new JButton(Constants.GENERATE);
		this.gbc = new GridBagConstraints();
		this.jLabelTitle = new JLabel(Constants.ENTRIES, JLabel.CENTER);
		this.jLabelSeed = new JLabel(Constants.INITIAL_SEED);
		this.jLabelAutoFill = new JLabel(Constants.AUTOFILL);
		this.jTextFieldSeed = new JTextField("");
		this.jRadioButtonIz = new JRadioButton(Constants.RADIO_BUTTON_IZQ);
		this.jRadioButtonDer = new JRadioButton(Constants.RADIO_BUTTON_DER);
		this.buttonGroup = new ButtonGroup();
		buttonGroup.add(jRadioButtonIz);
		buttonGroup.add(jRadioButtonDer);
		init(actionCommandB);
	}

	private void init(String actionCommandB) {
		this.setOpaque(false);
		configureLabel(jLabelTitle, Constants.FONT_SIZE_APP_TITLES, Font.BOLD);
		configureLabel(jLabelSeed, Constants.FONT_SIZE_APP_LABELS, Font.PLAIN);
		configureLabel(jLabelAutoFill, Constants.FONT_SIZE_APP_LABELS, Font.PLAIN);
		configureTextField(jTextFieldSeed, Constants.PLACEHOLDER_SEED);
		configureRadioButton(jRadioButtonIz);
		configureRadioButton(jRadioButtonDer);
		configureButton(jButtonGenerate);
		jRadioButtonIz.setSelected(true);
		addComponents();
		jButtonGenerate.addActionListener(Controller.getInstance());
		jButtonGenerate.setActionCommand(actionCommandB);
		jRadioButtonIz.setMnemonic(1);
		jRadioButtonDer.setMnemonic(2);
	}

	private void addComponents() {
		int insets_width_sides_button = 80 * JFrameMain.WIDTH_FRAME / 1920;
		int insets_width_sides = 20 * JFrameMain.WIDTH_FRAME / 1920;
		int insets_width_top = 16 * JFrameMain.HEIGHT_FRAME / 1080;
		int insets_width_top_button = 30 * JFrameMain.HEIGHT_FRAME / 1080;
		gbc.fill = 1;
		gbc.weightx = 1;
		gbc.insets.left = insets_width_sides;
		gbc.insets.right = insets_width_sides;
		gbc.insets.top = insets_width_top;
		this.add(jLabelTitle, gbc);
		gbc.gridy = 1;
		this.add(jLabelSeed, gbc);
		gbc.gridy = 2;
		gbc.insets.top = 0;
		this.add(jTextFieldSeed, gbc);
		gbc.gridy = 3;
		gbc.insets.top = insets_width_top;
		this.add(jLabelAutoFill, gbc);
		gbc.gridy = 4;
		gbc.insets.top = 0;
		this.add(jRadioButtonIz, gbc);
		gbc.gridy = 5;
		this.add(jRadioButtonDer, gbc);
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		gbc.insets.top = insets_width_top_button;
		gbc.insets.left = insets_width_sides_button;
		gbc.insets.right = insets_width_sides_button;
		this.add(jButtonGenerate, gbc);
		gbc.gridy = 7;
		gbc.weighty = 1;
		this.add(Box.createRigidArea(new Dimension(0, 0)), gbc);
	}

	private void configureButton(JButton jButton) {
		jButton.setFont(new Font(Constants.FONT_APP, Font.PLAIN, Constants.FONT_SIZE_APP_PLACEHOLDER));
		jButton.setForeground(Color.WHITE);
		jButton.setFocusPainted(false);
		jButton.setContentAreaFilled(false);
		jButton.setBorder(new LineBorder(Color.WHITE));
		jButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jButton.setBorder(new LineBorder(new Color(253, 124, 18)));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jButton.setBorder(new LineBorder(Color.WHITE));
			}
		});
	}

	private void configureRadioButton(JRadioButton jRadioButton) {
		jRadioButton.setFont(new Font(Constants.FONT_APP, Font.PLAIN, Constants.FONT_SIZE_APP_PLACEHOLDER));
		jRadioButton.setForeground(Color.WHITE);
		jRadioButton.setFocusPainted(false);
		jRadioButton.setOpaque(false);
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
		jTextField.setPreferredSize(new Dimension(0, 30 * JFrameMain.HEIGHT_FRAME / 1080));
		TextPrompt textPrompt = new TextPrompt(placeholder, jTextField);
		textPrompt.changeAlpha(0.35f);
		textPrompt.changeStyle(Font.ITALIC);
		InputMap map2 = jTextField.getInputMap(JTextField.WHEN_FOCUSED);
	    map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		jTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if ((int)e.getKeyChar() != 8 && (!Character.isDigit(e.getKeyChar()) || jTextField.getText().length() > 7)) {
					e.consume();
					return;
				}
			}
		});
	}

	public String getSeed() {
		return jTextFieldSeed.getText();
	}

	public boolean getFill() {
		return buttonGroup.getSelection().getMnemonic() == 1;
	}

	public void highlight(int index, int option) {
		switch (index) {
		case 0:
			if (option == 0) {
				jTextFieldSeed.setBorder(new LineBorder(Constants.COLOR_BORDER));
			} else {
				jTextFieldSeed.setBorder(new LineBorder(Color.RED));
			}
			break;
		}
	}

}
