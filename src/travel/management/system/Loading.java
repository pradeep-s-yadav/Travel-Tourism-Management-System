package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {

	Thread t;
	JProgressBar bar;
	String username;

	Loading(String username) {
		
		this.username = username;
		
		t= new Thread(this);

		setBounds(500, 200, 650, 400);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel text = new JLabel("Travel and Tourism Application");
		text.setFont(new Font("Tahoma", Font.BOLD, 35));
		text.setForeground(Color.BLUE);
		text.setBounds(50, 20, 600, 40);
		add(text);

		bar = new JProgressBar();
		bar.setBounds(150, 100, 300, 30);
		bar.setStringPainted(true);
		add(bar);

		JLabel loading = new JLabel("Loading.....Please Wait");
		loading.setFont(new Font("Tahoma", Font.BOLD, 16));
		loading.setForeground(Color.RED);
		loading.setBounds(200, 140, 250, 30);
		add(loading);

		JLabel jlusername = new JLabel("Welcome " + username);
		jlusername.setFont(new Font("Tahoma", Font.BOLD, 16));
		jlusername.setForeground(Color.RED);
		jlusername.setBounds(20, 320, 400, 40);
		add(jlusername);

		setVisible(true);
		t.start();
	}

	public void run() {
		try {

			for (int i = 1; i <= 101; i++) {

				int max = bar.getMaximum();
				int value = bar.getValue();

				if (value < max) {
					bar.setValue(bar.getValue() + 1);
				} else {
					setVisible(false);
					new Dashboard(username);
				}
				Thread.sleep(50);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Loading("");

	}

}
