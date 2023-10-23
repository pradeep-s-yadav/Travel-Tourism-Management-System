package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Book_Hotel extends JFrame implements ActionListener {

	Choice select_hotel, cac, cafood;
	JTextField jtfpersons, jtfdays;
	String username;
	JLabel labelusername, labelid, labelnumber, labelphone, labeltotal;
	JButton checkprice, bookhotel, back;

	public Book_Hotel(String username) {

		this.username = username;

		setBounds(150, 100, 1100, 600);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		JLabel jlbook = new JLabel("BOOK HOTEL");
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

		JLabel jlpackage = new JLabel("Select Hotel");
		jlpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlpackage.setBounds(40, 110, 150, 20);
		add(jlpackage);

		select_hotel = new Choice();
		select_hotel.setBounds(250, 110, 120, 25);
		add(select_hotel);

		try {

			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from hotel");

			while (rs.next()) {
				select_hotel.add(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel jlpersons = new JLabel("Total Members");
		jlpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlpersons.setBounds(40, 150, 150, 20);
		add(jlpersons);

		jtfpersons = new JTextField("1");
		jtfpersons.setBounds(250, 150, 120, 25);
		add(jtfpersons);

		JLabel jldays = new JLabel("No. of Days");
		jldays.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jldays.setBounds(40, 190, 150, 20);
		add(jldays);

		jtfdays = new JTextField("1");
		jtfdays.setBounds(250, 190, 120, 25);
		add(jtfdays);

		JLabel jlac = new JLabel("AC/Non AC");
		jlac.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlac.setBounds(40, 230, 150, 20);
		add(jlac);

		cac = new Choice();
		cac.add("AC");
		cac.add("Non AC");
		cac.setBounds(250, 230, 150, 25);
		add(cac);

		JLabel jlfood = new JLabel("Food Included");
		jlfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlfood.setBounds(40, 270, 150, 20);
		add(jlfood);

		cafood = new Choice();
		cafood.add("Yes");
		cafood.add("No");
		cafood.setBounds(250, 270, 150, 25);
		add(cafood);

		JLabel jlid = new JLabel("Id");
		jlid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlid.setBounds(40, 310, 150, 20);
		add(jlid);

		labelid = new JLabel();
		labelid.setBounds(250, 310, 100, 25);
		add(labelid);

		JLabel jlnumber = new JLabel("Number");
		jlnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlnumber.setBounds(40, 350, 150, 20);
		add(jlnumber);

		labelnumber = new JLabel();
		labelnumber.setBounds(250, 350, 100, 25);
		add(labelnumber);

		JLabel jlphone = new JLabel("Phone");
		jlphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlphone.setBounds(40, 390, 150, 20);
		add(jlphone);

		labelphone = new JLabel();
		labelphone.setBounds(250, 390, 100, 25);
		add(labelphone);

		JLabel jltotal = new JLabel("Total Price");
		jltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jltotal.setBounds(40, 430, 150, 20);
		add(jltotal);

		labeltotal = new JLabel();
		labeltotal.setBounds(250, 430, 100, 25);
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
		checkprice.setBounds(60, 490, 120, 25);
		checkprice.addActionListener(this);
		add(checkprice);

		bookhotel = new JButton("Book Hotel");
		bookhotel.setBackground(Color.BLACK);
		bookhotel.setForeground(Color.WHITE);
		bookhotel.setBounds(200, 490, 120, 25);
		bookhotel.addActionListener(this);
		add(bookhotel);

		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(340, 490, 120, 25);
		back.addActionListener(this);
		add(back);

		ImageIcon imageicon1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
		Image jimage = imageicon1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
		ImageIcon imageicon2 = new ImageIcon(jimage);
		JLabel label = new JLabel(imageicon2);
		label.setBounds(550, 50, 600, 400);
		add(label);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent a) {

		if (a.getSource() == checkprice) {
			try {

				Conn c = new Conn();
				ResultSet rs = c.s
						.executeQuery("select * from hotel where name ='" + select_hotel.getSelectedItem() + "'");

				while (rs.next()) {

					int cost = Integer.parseInt(rs.getString("costperperson"));
					int ac = Integer.parseInt(rs.getString("acroom"));
					int food = Integer.parseInt(rs.getString("foodincluded"));
					int persons = Integer.parseInt(jtfpersons.getText());
					int days = Integer.parseInt(jtfdays.getText());

					String acselected = cac.getSelectedItem();
					String foodselected = cafood.getSelectedItem();

					if (persons * days > 0) {
						int total = 0;
						total += acselected.equals("AC") ? ac : 0;
						total += foodselected.equals("Yes") ? food : 0;
						total += cost;
						total = total * persons * days;
						labeltotal.setText("$ " + total);
					} else {

						JOptionPane.showMessageDialog(null, "Please enter a valid number");

					}

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (a.getSource() == bookhotel) {

			try {

				Conn c = new Conn();

				c.s.executeUpdate("insert into bookhotel values('" + labelusername.getText() + "', '"
						+ select_hotel.getSelectedItem() + "', '" + jtfpersons.getText() + "', '" + jtfdays.getText()
						+ "', '" + cac.getSelectedItem() + "', '" + cafood.getSelectedItem() + "', '"
						+ labelid.getText() + "', '" + labelnumber.getText() + "', '" + labelphone.getText() + "', '"
						+ labeltotal.getText() + "')");

				JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");

				setVisible(false);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			setVisible(false);
		}

	}

	public static void main(String[] args) {

		new Book_Hotel("Pradeep");

	}

}
