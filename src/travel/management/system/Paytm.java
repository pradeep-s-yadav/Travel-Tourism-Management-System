package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paytm extends JFrame implements ActionListener {

	Paytm() {

		setBounds(300, 100, 800, 600);

		JEditorPane pane = new JEditorPane();
		pane.setEditable(false);
		try {
			pane.setPage("https://paytm.com/rent-payment");
		} catch (Exception e) {
			pane.setContentType("text/html");
			pane.setText("<html>404 Error </html>");
		}

		JScrollPane jsp = new JScrollPane(pane);
		getContentPane().add(jsp);

		JButton back = new JButton("Back");
		back.setBounds(610, 20, 80, 40);
		back.addActionListener(this);
		pane.add(back);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent a) {

		setVisible(false);
		new Payment();

	}

	public static void main(String[] args) {

		new Paytm();

	}

}
