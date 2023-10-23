package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Payment extends JFrame implements ActionListener{
	
	JButton pay, back;

	Payment(){
		
		setBounds(300, 100, 800, 600);
		setLayout(null);
		
		ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
		Image im = ic.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
		ImageIcon image = new ImageIcon(im);
		JLabel jl = new JLabel(image);
		jl.setBounds(0, 0, 800, 600);
		add(jl);
		
		pay = new JButton("Pay");
		pay.setBounds(420, 0, 80, 40);
		pay.addActionListener(this);
		jl.add(pay);
		
		back = new JButton("Back");
		back.setBounds(520, 0, 80, 40);
		back.addActionListener(this);
		jl.add(back);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent a) {
		
		if(a.getSource()== pay) {
			setVisible(false);
			new Paytm();
		} else {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		
	new Payment();	

	}

}
