package travel.management.system;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class View_Customer extends JFrame implements ActionListener {

	JButton back;

	public View_Customer(String username) {

		setBounds(250, 130, 870, 575);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel jlusername = new JLabel("Username");
		jlusername.setBounds(30, 50, 150, 25);
		add(jlusername);

		JLabel labelusername = new JLabel();
		labelusername.setBounds(220, 50, 150, 25);
		add(labelusername);

		JLabel jlid = new JLabel("Id");
		jlid.setBounds(30, 110, 150, 25);
		add(jlid);

		JLabel labelid = new JLabel();
		labelid.setBounds(220, 110, 150, 25);
		add(labelid);

		JLabel jlnumber = new JLabel("Number");
		jlnumber.setBounds(30, 170, 150, 25);
		add(jlnumber);

		JLabel labelnumber = new JLabel();
		labelnumber.setBounds(220, 170, 150, 25);
		add(labelnumber);

		JLabel jlname = new JLabel("Name");
		jlname.setBounds(30, 230, 150, 25);
		add(jlname);

		JLabel labelname = new JLabel();
		labelname.setBounds(220, 230, 150, 25);
		add(labelname);

		JLabel jlgender = new JLabel("Gender");
		jlgender.setBounds(30, 290, 150, 25);
		add(jlgender);

		JLabel labelgender = new JLabel();
		labelgender.setBounds(220, 290, 150, 25);
		add(labelgender);

		JLabel jlcountry = new JLabel("Country");
		jlcountry.setBounds(500, 50, 150, 25);
		add(jlcountry);

		JLabel labelcountry = new JLabel();
		labelcountry.setBounds(690, 50, 150, 25);
		add(labelcountry);

		JLabel jladdress = new JLabel("Address");
		jladdress.setBounds(500, 110, 150, 25);
		add(jladdress);

		JLabel labeladdress = new JLabel();
		labeladdress.setBounds(690, 110, 150, 25);
		add(labeladdress);

		JLabel jlphone = new JLabel("Phone");
		jlphone.setBounds(500, 170, 150, 25);
		add(jlphone);

		JLabel labelphone = new JLabel();
		labelphone.setBounds(690, 170, 150, 25);
		add(labelphone);

		JLabel jlemail = new JLabel("Email");
		jlemail.setBounds(500, 230, 150, 25);
		add(jlemail);

		JLabel labelemail = new JLabel();
		labelemail.setBounds(690, 230, 150, 25);
		add(labelemail);

		back = new JButton("Back");
		back.setBounds(350, 350, 100, 25);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);

		ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
		Image i = ic.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
		ImageIcon image = new ImageIcon(i);
		JLabel jlimage = new JLabel(image);
		jlimage.setBounds(120, 400, 600, 200);
		add(jlimage);

		try {

			String query = "select * from " + "customer where username='" + username + "'";

			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery(query);

			while (rs.next()) {

				labelusername.setText(rs.getString("username"));
				labelid.setText(rs.getString("id"));
				labelnumber.setText(rs.getString("number"));
				labelname.setText(rs.getString("name"));
				labelgender.setText(rs.getString("gender"));
				labelcountry.setText(rs.getString("country"));
				labeladdress.setText(rs.getString("address"));
				labelphone.setText(rs.getString("phone"));
				labelemail.setText(rs.getString("email"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent a) {
		
		setVisible(false);
		
	}

	public static void main(String[] args) {

		new View_Customer("Pradeep");

	}

}
