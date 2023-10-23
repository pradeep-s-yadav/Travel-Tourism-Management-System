package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Add_Customer extends JFrame implements ActionListener {

	JLabel jlabelusername, jlabelname;
	JComboBox comboid;
	JTextField jtfnumber, jtfcountry, jtfaddress, jtfphone, jtfemail;
	JRadioButton jmale, jfemale;
	JButton add, back;

	Add_Customer(String username) {

		setBounds(350, 100, 750, 550);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		JLabel jlusername = new JLabel("Username");
		jlusername.setBounds(30, 50, 150, 25);
		add(jlusername);

		jlabelusername = new JLabel();
		jlabelusername.setBounds(220, 50, 150, 25);
		add(jlabelusername);

		JLabel jlid = new JLabel("Id");
		jlid.setBounds(30, 90, 150, 25);
		add(jlid);

		comboid = new JComboBox(new String[] { "Driving Licence", "Health Card", "Passport" });
		comboid.setBounds(220, 90, 150, 25);
		comboid.setBackground(Color.WHITE);
		add(comboid);

		JLabel jlnumber = new JLabel("Number");
		jlnumber.setBounds(30, 130, 150, 25);
		add(jlnumber);

		jtfnumber = new JTextField();
		jtfnumber.setBounds(220, 130, 150, 25);
		jtfnumber.setBackground(Color.WHITE);
		add(jtfnumber);

		JLabel jlname = new JLabel("Name");
		jlname.setBounds(30, 170, 150, 25);
		add(jlname);

		jlabelname = new JLabel();
		jlabelname.setBounds(220, 170, 150, 25);
		add(jlabelname);

		JLabel jlgender = new JLabel("Gender");
		jlgender.setBounds(30, 210, 150, 25);
		add(jlgender);

		jmale = new JRadioButton("Male");
		jmale.setBounds(220, 210, 70, 25);
		add(jmale);

		jfemale = new JRadioButton("Female");
		jfemale.setBounds(300, 210, 70, 25);
		add(jfemale);

		ButtonGroup bg = new ButtonGroup();
		bg.add(jmale);
		bg.add(jfemale);

		JLabel jlcountry = new JLabel("Country");
		jlcountry.setBounds(30, 250, 150, 25);
		add(jlcountry);

		jtfcountry = new JTextField();
		jtfcountry.setBounds(220, 250, 150, 25);
		jtfcountry.setBackground(Color.WHITE);
		add(jtfcountry);

		JLabel jladdress = new JLabel("Address");
		jladdress.setBounds(30, 290, 150, 25);
		add(jladdress);

		jtfaddress = new JTextField();
		jtfaddress.setBounds(220, 290, 150, 25);
		jtfaddress.setBackground(Color.WHITE);
		add(jtfaddress);

		JLabel jlemail = new JLabel("Email");
		jlemail.setBounds(30, 330, 150, 25);
		add(jlemail);

		jtfemail = new JTextField();
		jtfemail.setBounds(220, 330, 150, 25);
		jtfemail.setBackground(Color.WHITE);
		add(jtfemail);

		JLabel jlphone = new JLabel("Phone");
		jlphone.setBounds(30, 370, 150, 25);
		add(jlphone);

		jtfphone = new JTextField();
		jtfphone.setBounds(220, 370, 150, 25);
		jtfphone.setBackground(Color.WHITE);
		add(jtfphone);

		add = new JButton("Add");
		add.setBounds(70, 430, 100, 25);
		add.setBackground(Color.BLACK);
		add.setForeground(Color.WHITE);
		add.addActionListener(this);
		add(add);

		back = new JButton("Back");
		back.setBounds(220, 430, 100, 25);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);

		ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
		Image img = icon1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
		ImageIcon icon = new ImageIcon(img);
		JLabel jlicon = new JLabel(icon);
		jlicon.setBounds(350, 40, 450, 420);
		add(jlicon);

		try {

			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from account where username='" + username + "'");
			while (rs.next()) {
				jlabelusername.setText(rs.getString("username"));
				jlabelname.setText(rs.getString("name"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		setVisible(true);

	}

	public void actionPerformed(ActionEvent a) {

		if (a.getSource() == add) {

			String username = jlabelusername.getText();
			String id = (String) comboid.getSelectedItem();
			String number = jtfnumber.getText();
			String name = jlabelname.getText();
			String gender = null;
			if (jmale.isSelected()) {
				gender = "Male";
			} else {
				gender = "Female";
			}
			String country = jtfcountry.getText();
			String address = jtfaddress.getText();
			String phone = jtfphone.getText();
			String email = jtfemail.getText();

			try {

				Conn c = new Conn();
				String query = "insert into customer values('" + username + "' , '" + id + "','" + number + "','" + name
						+ "', '" + gender + "','" + country + "','" + address + "','" + phone + "','" + email + "')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
				setVisible(false);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Add_Customer("");
	}

}
