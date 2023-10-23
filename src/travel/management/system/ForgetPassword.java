package travel.management.system;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ForgetPassword extends JFrame implements ActionListener{
	
	JLabel jlusername, jlname, jlquestion, jlanswer, jlpassword;
	JTextField jtfusername, jtfname, jtfquestion, jtfanswer, jtfpassword;
	JButton search, retrieve, back;
	
	ForgetPassword(){
		
		setBounds(350, 200, 850, 400);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel jp = new JPanel();
		jp.setLayout(null);
		jp.setBounds(30, 30, 500, 300);
		add(jp);
		
		
		ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
		Image image = ic.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon ic2 = new ImageIcon(image);
		JLabel jl = new JLabel(ic2);
		jl.setBounds(580, 70, 200, 200);
		add(jl);
		
		jlusername = new JLabel("Username");
		jlusername.setBounds(40, 20, 100, 25);
		jlusername.setFont(new Font("SAN SERIF", Font.BOLD, 14));
		jp.add(jlusername);
		
		jtfusername = new JTextField();
		jtfusername.setBorder(BorderFactory.createEmptyBorder());
		jtfusername.setBounds(220, 20, 150, 25);
		jp.add(jtfusername);
		
		search = new JButton("Search");
		search.setForeground(Color.WHITE);
		search.setBackground(Color.GRAY);
		search.addActionListener(this);
		search.setBounds(380, 20, 100, 25);
		jp.add(search);
		
		jlname = new JLabel("Name");
		jlname.setBounds(40, 60, 100, 25);
		jlname.setFont(new Font("SAN SERIF", Font.BOLD, 14));
		jp.add(jlname);
		
		jtfname = new JTextField();
		jtfname.setBorder(BorderFactory.createEmptyBorder());
		jtfname.setBounds(220, 60, 150, 25);
		jp.add(jtfname);
		
		jlquestion = new JLabel("Security Question");
		jlquestion.setBounds(40, 100, 200, 25);
		jlquestion.setFont(new Font("SAN SERIF", Font.BOLD, 14));
		jp.add(jlquestion);
		
		jtfquestion = new JTextField();
		jtfquestion.setBorder(BorderFactory.createEmptyBorder());
		jtfquestion.setBounds(220, 100, 150, 25);
		jp.add(jtfquestion);
		
		jlanswer = new JLabel("Answer");
		jlanswer.setBounds(40, 140, 200, 25);
		jlanswer.setFont(new Font("SAN SERIF", Font.BOLD, 14));
		jp.add(jlanswer);
		
		jtfanswer = new JTextField();
		jtfanswer.setBorder(BorderFactory.createEmptyBorder());
		jtfanswer.setBounds(220, 140, 150, 25);
		jp.add(jtfanswer);
		
		retrieve = new JButton("Retrieve");
		retrieve.setForeground(Color.WHITE);
		retrieve.setBackground(Color.GRAY);
		retrieve.addActionListener(this);
		retrieve.setBounds(380, 140, 100, 25);
		jp.add(retrieve);
		
		jlpassword = new JLabel("Password");
		jlpassword.setBounds(40, 180, 200, 25);
		jlpassword.setFont(new Font("SAN SERIF", Font.BOLD, 14));
		jp.add(jlpassword);
		
		jtfpassword = new JTextField();
		jtfpassword.setBorder(BorderFactory.createEmptyBorder());
		jtfpassword.setBounds(220, 180, 150, 25);
		jp.add(jtfpassword);
		
		back = new JButton("Back");
		back.setForeground(Color.WHITE);
		back.setBackground(Color.GRAY);
		back.addActionListener(this);
		back.setBounds(150, 240, 100, 25);
		jp.add(back);
		
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent a) {
		
		if(a.getSource() == search) {
			try {
				String query = "select * from account where username = '" + jtfusername.getText() + "'" ;
				
				Conn c = new Conn();
				ResultSet rs =c.s.executeQuery(query);
				
				while(rs.next()) {
				jtfname.setText(rs.getString("name"));
				jtfquestion.setText(rs.getString("question"));
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(a.getSource() == retrieve) {
			
			try {
				String query = "select * from account where username = '" + jtfusername.getText() + "' AND "
						+ "answer = '" + jtfanswer.getText() + "'" ;
				
				Conn c = new Conn();
				ResultSet rs =c.s.executeQuery(query);
				
				while(rs.next()) {
				jtfpassword.setText(rs.getString("password"));
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} else {
			setVisible(false);
			new Login();
		}
	}

	public static void main(String[] args) {
		
		
		new ForgetPassword();

	}

}
