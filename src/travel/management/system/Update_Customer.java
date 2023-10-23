package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update_Customer extends JFrame implements ActionListener {

	JLabel jlabelusername, jlabelname;
	JTextField jtfnumber, jtfcountry, jtfaddress, jtfphone, jtfemail, jtfgender, jtfid;
	JRadioButton jmale, jfemale;
	JButton add, back;

	Update_Customer(String username) {

		setBounds(450, 100, 750, 550);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel update = new JLabel("UPDATE CUSTOMER DETAILS");
		update.setBounds(200, 10, 300, 25 );
		update.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(update);

		JLabel jlusername = new JLabel("Username");
		jlusername.setBounds(30, 50, 150, 25);
		add(jlusername);

		jlabelusername = new JLabel();
		jlabelusername.setBounds(220, 50, 150, 25);
		add(jlabelusername);

		JLabel jlid = new JLabel("Id");
		jlid.setBounds(30, 90, 150, 25);
		add(jlid);
		
		jtfid = new JTextField();
		jtfid.setBounds(220, 90, 150, 25);
		jtfid.setBackground(Color.WHITE);
		add(jtfid);

		jtfgender = new JTextField("Gender");
		jtfgender.setBounds(220, 210, 150, 25);
		jtfgender.setBackground(Color.WHITE);
		add(jtfgender);

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

		add = new JButton("Update");
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

		ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
		Image img = icon1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
		ImageIcon icon = new ImageIcon(img);
		JLabel jlicon = new JLabel(icon);
		jlicon.setBounds(350, 40, 450, 300);
		add(jlicon);

		try {

			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer where username='Pradeep'");
			while (rs.next()) {
				jlabelusername.setText(rs.getString("username"));
				jlabelname.setText(rs.getString("name"));
				jtfid.setText(rs.getString("id"));
				jtfgender.setText(rs.getString("gender"));
				jtfnumber.setText(rs.getString("number"));
				jtfaddress.setText(rs.getString("address"));
				jtfcountry.setText(rs.getString("country"));
				jtfphone.setText(rs.getString("phone"));
				jtfemail.setText(rs.getString("email"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		setVisible(true);

	}

	public void actionPerformed(ActionEvent a) {

		if (a.getSource() == add) {

			String username = jlabelusername.getText();
			String id = jtfid.getText();
			String number = jtfnumber.getText();
			String name = jlabelname.getText();
			String gender = jtfgender.getText();
			String country = jtfcountry.getText();
			String address = jtfaddress.getText();
			String phone = jtfphone.getText();
			String email = jtfemail.getText();

			try {

				Conn c = new Conn();
				String query = "Update customer set username = '" + username + "' , id =  '" + id + "', number = '" + number + "', name ='" + name
						+ "', gender = '" + gender + "', country = '" + country + "', address ='" + address + "', phone ='" + phone + "', email = '" + email + "'";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Customer Updated Successfully");
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
		new Update_Customer("Pradeep");
	}

}
