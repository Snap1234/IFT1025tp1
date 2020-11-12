package tp1;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		JPanel pane= (JPanel)f.getContentPane();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		NewPage.initialisation(f,pane);
		f.setVisible(true);
	}
}

