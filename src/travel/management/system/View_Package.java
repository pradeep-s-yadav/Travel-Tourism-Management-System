package travel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class View_Package extends JFrame implements ActionListener {

	JButton back;

	public View_Package(String username) {

		setBounds(250, 200, 900, 450);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel text = new JLabel("VIEW PACKAGE DETAILS");
		text.setFont(new Font("Tahoma", Font.BOLD, 20));
		text.setBounds(60, 0, 300, 30);
		add(text);

		JLabel jlusername = new JLabel("Username");
		jlusername.setBounds(30, 50, 150, 25);
		add(jlusername);

		JLabel labelusername = new JLabel();
		labelusername.setBounds(220, 50, 150, 25);
		add(labelusername);

		JLabel jlpackage = new JLabel("Package");
		jlpackage.setBounds(30, 90, 150, 25);
		add(jlpackage);

		JLabel labelpackage = new JLabel();
		labelpackage.setBounds(220, 90, 150, 25);
		add(labelpackage);

		JLabel jlmembers = new JLabel("Total Members");
		jlmembers.setBounds(30, 130, 150, 25);
		add(jlmembers);

		JLabel labelmembers = new JLabel();
		labelmembers.setBounds(220, 130, 150, 25);
		add(labelmembers);

		JLabel jlid = new JLabel("Id");
		jlid.setBounds(30, 170, 150, 25);
		add(jlid);

		JLabel labelid = new JLabel();
		labelid.setBounds(220, 170, 150, 25);
		add(labelid);

		JLabel jlnumber = new JLabel("Number");
		jlnumber.setBounds(30, 210, 150, 25);
		add(jlnumber);

		JLabel labelnumber = new JLabel();
		labelnumber.setBounds(220, 210, 150, 25);
		add(labelnumber);

		JLabel jlphone = new JLabel("Phone");
		jlphone.setBounds(30, 250, 150, 25);
		add(jlphone);

		JLabel labelphone = new JLabel();
		labelphone.setBounds(220, 250, 150, 25);
		add(labelphone);

		JLabel jlprice = new JLabel("Price");
		jlprice.setBounds(30, 290, 150, 25);
		add(jlprice);

		JLabel labelprice = new JLabel();
		labelprice.setBounds(220, 290, 150, 25);
		add(labelprice);

		back = new JButton("Back");
		back.setBounds(130, 350, 100, 25);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);

		ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
		Image i = ic.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
		ImageIcon image = new ImageIcon(i);
		JLabel jlimage = new JLabel(image);
		jlimage.setBounds(400, 20, 500, 400);
		add(jlimage);

		try {

			String query = "select * from bookpackage where username='" + username + "'";

			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery(query);

			while (rs.next()) {

				labelusername.setText(rs.getString("username"));
				labelid.setText(rs.getString("id"));
				labelnumber.setText(rs.getString("number"));
				labelpackage.setText(rs.getString("package"));
				labelprice.setText(rs.getString("price"));
				labelphone.setText(rs.getString("phone"));
				labelmembers.setText(rs.getString("persons"));

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

		new View_Package("Pradeep");

	}

}
