package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Book_Package extends JFrame implements ActionListener {

	Choice select_package;
	JTextField jtfpersons;
	String username;
	JLabel labelusername, labelid, labelnumber, labelphone, labeltotal;
	JButton checkprice, bookpackage, back;

	public Book_Package(String username) {

		this.username = username;
		setBounds(150, 120, 1100, 550);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		JLabel jlbook = new JLabel("BOOK PACKAGE");
		jlbook.setBounds(100, 10, 200, 30);
		jlbook.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(jlbook);

		JLabel jlusername = new JLabel("Username");
		jlusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlusername.setBounds(40, 70, 150, 20);
		add(jlusername);

		labelusername = new JLabel();
		labelusername.setBounds(250, 70, 100, 25);
		add(labelusername);

		JLabel jlpackage = new JLabel("Select Package");
		jlpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlpackage.setBounds(40, 110, 150, 20);
		add(jlpackage);

		select_package = new Choice();
		select_package.add("Gold Package");
		select_package.add("Silver Package");
		select_package.add("Bronze Package");
		select_package.setBounds(250, 110, 120, 25);
		add(select_package);

		JLabel jlpersons = new JLabel("Total Members");
		jlpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlpersons.setBounds(40, 150, 150, 20);
		add(jlpersons);

		jtfpersons = new JTextField("1");
		jtfpersons.setBounds(250, 150, 120, 25);
		add(jtfpersons);

		JLabel jlid = new JLabel("Id");
		jlid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlid.setBounds(40, 190, 150, 20);
		add(jlid);

		labelid = new JLabel();
		labelid.setBounds(250, 190, 100, 25);
		add(labelid);

		JLabel jlnumber = new JLabel("Number");
		jlnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlnumber.setBounds(40, 230, 150, 20);
		add(jlnumber);

		labelnumber = new JLabel();
		labelnumber.setBounds(250, 230, 100, 25);
		add(labelnumber);

		JLabel jlphone = new JLabel("Phone");
		jlphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlphone.setBounds(40, 270, 150, 20);
		add(jlphone);

		labelphone = new JLabel();
		labelphone.setBounds(250, 270, 100, 25);
		add(labelphone);

		JLabel jltotal = new JLabel("Total Price");
		jltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jltotal.setBounds(40, 310, 150, 20);
		add(jltotal);

		labeltotal = new JLabel();
		labeltotal.setBounds(250, 310, 100, 25);
		add(labeltotal);

		try {

			String query = "select * from " + "customer where username='" + username + "'";

			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery(query);

			while (rs.next()) {

				labelusername.setText(rs.getString("username"));
				labelid.setText(rs.getString("id"));
				labelnumber.setText(rs.getString("number"));
				labelphone.setText(rs.getString("phone"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		checkprice = new JButton("Check Price");
		checkprice.setBackground(Color.BLACK);
		checkprice.setForeground(Color.WHITE);
		checkprice.addActionListener(this);
		checkprice.setBounds(60, 380, 120, 25);

		add(checkprice);

		bookpackage = new JButton("Book Package");
		bookpackage.setBackground(Color.BLACK);
		bookpackage.setForeground(Color.WHITE);
		bookpackage.setBounds(200, 380, 120, 25);
		bookpackage.addActionListener(this);
		add(bookpackage);

		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(340, 380, 120, 25);
		back.addActionListener(this);
		add(back);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent a) {

		if (a.getSource() == checkprice) {

			String pack = select_package.getSelectedItem();
			int cost = 0;

			if (pack.equals("Gold Package")) {
				cost += 749;
			} else if (pack.equals("Silver Package")) {
				cost += 600;
			} else {
				cost += 500;
			}

			int persons = Integer.parseInt(jtfpersons.getText());
			cost *= persons;
			labeltotal.setText("$ " + cost);

		} else if (a.getSource() == bookpackage) {
			
			try {
				
				Conn c = new Conn();
				
				c.s.executeUpdate("insert into bookpackage values('" + labelusername.getText() +"', '" + select_package.getSelectedItem() + "', '" + jtfpersons.getText() + "', '" + labelid.getText() +"', '" + labelnumber.getText() + "', '" + labelphone.getText() + "', '" + labeltotal.getText()+ "')");
				
				JOptionPane.showMessageDialog(null, "Package Booked Successfully");
				setVisible(false);
			} catch (Exception e) {
					e.printStackTrace();
			}

		} else {
			setVisible(false);
		}

	}

	public static void main(String[] args) {

		new Book_Package("Pradeep");

	}

}
