package tp1;
import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.*;

public class projet {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		NewPage.inscription(f);
		f.setVisible(true);
		
	}

}
