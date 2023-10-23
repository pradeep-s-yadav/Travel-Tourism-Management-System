package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {

	Thread thread;

	Splash() {
//		setSize(1000, 600);
//		setLocation(100,100);

		ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/Main_Image.jpg"));
		Image image = icon1.getImage().getScaledInstance(1100, 600, Image.SCALE_DEFAULT);
		ImageIcon icon2 = new ImageIcon(image);
		JLabel label = new JLabel(icon2);
		add(label);
		setVisible(true);
		thread = new Thread(this);
		thread.start();

	}

	public void run() {
		try {
			Thread.sleep(7000);
			setVisible(false);
		} catch (Exception e) {

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Splash frame = new Splash();

		int x = 1;
		for (int i = 0; i <= 500; x += 7, i += 6) {
			frame.setLocation(700 - (x + i) / 2, 400 - (i / 2));
			frame.setSize(x + i, i);
			try {
				Thread.sleep(10);
			} catch (Exception e) {

			}
		}
	}

}
