package travel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;

import javax.swing.*;

public class Signup extends JFrame implements ActionListener {

	JButton create_Account, back;
	JTextField jtfname, jtfusername, jtfpassword, jtfanswer;
	Choice choice;

	Signup() {

		setBounds(350, 200, 900, 400);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JPanel jp = new JPanel();
		jp.setBackground(new Color(133, 193, 233));
		jp.setBounds(0, 0, 500, 400);
		add(jp);
		jp.setLayout(null);

		JLabel jlusername = new JLabel("Username");
		jlusername.setBounds(50, 30, 150, 25);
		jlusername.setFont(new Font("SAN SERIF", Font.BOLD, 16));
		jp.add(jlusername);

		jtfusername = new JTextField();
		jtfusername.setBounds(150, 30, 200, 25);
		jtfusername.setBorder(BorderFactory.createEmptyBorder());
		jp.add(jtfusername);

		JLabel jlname = new JLabel("Name");
		jlname.setBounds(50, 70, 150, 25);
		jlname.setFont(new Font("SAN SERIF", Font.BOLD, 16));
		jp.add(jlname);

		jtfname = new JTextField();
		jtfname.setBorder(BorderFactory.createEmptyBorder());
		jtfname.setBounds(150, 70, 200, 25);
		jp.add(jtfname);

		JLabel jlpassword = new JLabel("Password");
		jlpassword.setBounds(50, 110, 150, 25);
		jlpassword.setFont(new Font("SAN SERIF", Font.BOLD, 16));
		jp.add(jlpassword);

		jtfpassword = new JTextField();
		jtfpassword.setBorder(BorderFactory.createEmptyBorder());
		jtfpassword.setBounds(150, 110, 200, 25);
		jp.add(jtfpassword);

		JLabel jlsecurity = new JLabel("Security Question");
		jlsecurity.setBounds(50, 150, 100, 25);
		jlsecurity.setFont(new Font("SAN SERIF", Font.BOLD, 16));
		jp.add(jlsecurity);

		choice = new Choice();
		choice.add("Favourite sports in school");
		choice.add("Favourite place to visit");
		choice.add("Favourite hobby");
		choice.setBounds(150, 150, 200, 25);
		jp.add(choice);

		JLabel jlanswer = new JLabel("Answer");
		jlanswer.setBounds(50, 190, 150, 25);
		jlanswer.setFont(new Font("SAN SERIF", Font.BOLD, 16));
		jp.add(jlanswer);

		jtfanswer = new JTextField();
		jtfanswer.setBorder(BorderFactory.createEmptyBorder());
		jtfanswer.setBounds(150, 190, 200, 25);
		jp.add(jtfanswer);

		create_Account = new JButton("Create Account");
		create_Account.setBackground(Color.WHITE);
		create_Account.setForeground(new Color(133, 193, 233));
		create_Account.setFont(new Font("SAN SERIF", Font.BOLD, 12));
		create_Account.setBounds(50, 260, 150, 30);
		create_Account.addActionListener(this);
		jp.add(create_Account);

		back = new JButton("Back");
		back.setBackground(Color.WHITE);
		back.setForeground(new Color(133, 193, 233));
		back.setFont(new Font("SAN SERIF", Font.BOLD, 12));
		back.setBounds(250, 260, 100, 30);
		back.addActionListener(this);
		jp.add(back);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
		Image image = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(image);
		JLabel jl = new JLabel(i2);
		jl.setBounds(600, 60, 200, 200);
		add(jl);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent a) {
		if (a.getSource() == create_Account) {

			String username = jtfusername.getText();
			String name = jtfname.getText();
			String password = jtfpassword.getText();
			String answer = jtfanswer.getText();
			String question = choice.getSelectedItem();

			String query = "insert into account values('" + username + "', '" + name + "', '" + password + "', '"
					+ question + "', '" + answer + "')";

			try {

				Conn c = new Conn();
				c.s.executeUpdate(query);

				JOptionPane.showMessageDialog(null, "Account created successfully!");
				setVisible(false);
				new Login();

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (a.getSource() == back) {
			setVisible(false);
			new Login();
		}

	}

	public static void main(String[] args) {

		new Signup();

	}

}
