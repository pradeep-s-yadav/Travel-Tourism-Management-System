package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	
	JButton login, signup, forgetpassword;
	JTextField jtfusername, jtfpassword;
	
	Login(){
		
		setSize(900, 400);
		setLocation(350, 200);
		setLayout(null);
		
		getContentPane().setBackground(Color.WHITE);
		
		JPanel jp = new JPanel();
		jp.setBackground(new Color(131, 191, 233));
		jp.setBounds(0, 0, 450, 400);
		jp.setLayout(null);
		add(jp);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
		Image image = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(image);
		JLabel jl = new JLabel(i2);
		jl.setBounds(120, 60, 200, 200);
		jp.add(jl);
		
		JPanel jp2 = new JPanel();
		jp2.setLayout(null);
		jp2.setBounds(400, 30, 450, 300);
		add(jp2);
		
		JLabel jlusername = new JLabel("Username");
		jlusername.setBounds(80, 20, 100, 25);
		jlusername.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
		jp2.add(jlusername);
		
		jtfusername = new JTextField();
		jtfusername.setBounds(80, 60, 300, 30);
		jtfusername.setBorder(BorderFactory.createEmptyBorder());
		jp2.add(jtfusername);
		
		JLabel jlpassword = new JLabel("Password");
		jlpassword.setBounds(80, 100, 100, 25);
		jlpassword.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
		jp2.add(jlpassword);
		
		jtfpassword = new JTextField();
		jtfpassword.setBounds(80, 140, 300, 30);
		jtfpassword.setBorder(BorderFactory.createEmptyBorder());
		jp2.add(jtfpassword);
		
		login = new JButton("Login");
		login.setBounds(80, 180, 100, 25);
		login.setBackground(new Color(131, 191, 233));
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		login.setBorder(BorderFactory.createEmptyBorder());
		jp2.add(login);
		
		signup = new JButton("Signup");
		signup.setBounds(280, 180, 100, 25);
		signup.setBackground(new Color(131, 191, 233));
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		signup.setBorder(BorderFactory.createEmptyBorder());
		jp2.add(signup);
		
		forgetpassword = new JButton("Forget Password");
		forgetpassword.setBounds(170, 220, 120, 25);
		forgetpassword.setBackground(new Color(131, 191, 233));
		forgetpassword.setForeground(Color.WHITE);
		forgetpassword.addActionListener(this);
		forgetpassword.setBorder(BorderFactory.createEmptyBorder());
		jp2.add(forgetpassword);
		
		JLabel jl2 = new JLabel("Trouble In Login?");
		jl2.setBounds(320, 220, 100, 25);
		jl2.setForeground(Color.RED); 
		jp2.add(jl2);
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent a) {
		
		if(a.getSource() == login) {
			try {
				String query = "select * from account where username = '" + jtfusername.getText() + "' AND "
						+ "password = '" + jtfpassword.getText() + "'";
				
				Conn c = new Conn();
			 ResultSet rs =	c.s.executeQuery(query);
			 
			 if(rs.next()) {
				 setVisible(false);
				 new Loading(jtfusername.getText());
			 } else {
				 JOptionPane.showMessageDialog(null, "Invalid username or password");
			 }
			} catch(Exception e) {
				
			}
		} else if(a.getSource() == signup) {
			setVisible(false);
			new Signup();
		} else {
			setVisible(false);
			new ForgetPassword();
		}
	}
	
	public static void main(String[] args) {
	
		Login login = new Login();
		
		
		
	}

}
