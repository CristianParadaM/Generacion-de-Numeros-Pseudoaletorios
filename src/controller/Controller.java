package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.JFrameMain;

public class Controller implements ActionListener{
    
    private JFrameMain view;
    private static Controller controller = null;
    
    public static Controller getInstance() {
    	if (controller == null) {
			controller = new Controller();
		}
    	return controller;
    }
    
    public void initApp() {
    	view = new JFrameMain();
    }
    
	public static void main(String[] args) {
        Controller.getInstance().initApp();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
