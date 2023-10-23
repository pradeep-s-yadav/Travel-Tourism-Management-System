package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Check_Packages extends JFrame{
	
	public Check_Packages() {
		
		setBounds(250, 100, 900, 600);
		
		String[] package1 = {"Gold Package", "6 Days and 7 Nights", "Airport Pickup", "Free Golfing", "Noon And Night Buffet", "Soft Drinks Free" ,"Island Cruise", "English Speaking Guide", "BOOK NOW", "Special Offer - 749$ Only", "package1.jpg"};
		String[] package2 = {"Silver Package", "5 Days and 6 Nights", "Free Entrance Tickets", "City Tour", "Free Clubbing", "Welcome Drinks", "Night Safari", "Cruise with Dinner", "BOOK NOW", "600$ Only", "package2.jpg"};
		String[] package3 = {"Bronze Pacakge", "4 Days and 5 Nights", "Airfare Reimburse", "Free Horse Riding And Other Outdoor Games", "Hard Drinks On The House", "Night Buffet", "BBQ Dinner", "", "BOOK NOW", "500$ Only", "package3.jpg"};
		
		JTabbedPane tab = new JTabbedPane();
		JPanel jp = createPackage(package1);
		tab.addTab("Gold Package", null, jp);
		
		JPanel jp2 = createPackage(package2);
		tab.addTab("Silver Package", null, jp2);
		
		JPanel jp3 = createPackage(package3);
		tab.addTab("Bronze Package", null, jp3);
		
		add(tab);
		
		
		
		setVisible(true);
	}

	public JPanel createPackage(String[] pack) {
		
		JPanel jp = new JPanel();
		jp.setLayout(null);
		jp.setBackground(Color.WHITE);
		
		JLabel jl1 = new JLabel(pack[0]);
		jl1.setBounds(50, 10, 300, 30);
		jl1.setForeground(Color.YELLOW);
		jl1.setFont(new Font("TAHOMA", Font.BOLD, 30));
		jp.add(jl1);
		
		JLabel jl2 = new JLabel(pack[1]);
		jl2.setBounds(30, 60, 300, 30);
		jl2.setForeground(Color.GREEN);
		jl2.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		jp.add(jl2);
		
		JLabel jl3 = new JLabel(pack[2]);
		jl3.setBounds(30, 110, 300, 30);
		jl3.setForeground(Color.BLUE);
		jl3.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		jp.add(jl3);
		
		JLabel jl4 = new JLabel(pack[3]);
		jl4.setBounds(30, 160, 300, 30);
		jl4.setForeground(Color.GREEN);
		jl4.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		jp.add(jl4);
		
		JLabel jl5 = new JLabel(pack[4]);
		jl5.setBounds(30, 210, 300, 30);
		jl5.setForeground(Color.BLUE);
		jl5.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		jp.add(jl5);
		
		JLabel jl6 = new JLabel(pack[5]);
		jl6.setBounds(30, 260, 300, 30);
		jl6.setForeground(Color.GREEN);
		jl6.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		jp.add(jl6);
		
		JLabel jl7 = new JLabel(pack[6]);
		jl7.setBounds(30, 310, 300, 30);
		jl7.setForeground(Color.BLUE);
		jl7.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		jp.add(jl7);
		
		JLabel jl8 = new JLabel(pack[7]);
		jl8.setBounds(30, 360, 300, 30);
		jl8.setForeground(Color.GREEN);
		jl8.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		jp.add(jl8);
		
		JLabel jl9 = new JLabel(pack[8]);
		jl9.setBounds(60, 430, 300, 30);
		jl9.setForeground(Color.RED);
		jl9.setFont(new Font("TAHOMA", Font.BOLD, 25));
		jp.add(jl9);
		
		JLabel jl10 = new JLabel(pack[9]);
		jl10.setBounds(430, 430, 400, 30);
		jl10.setForeground(Color.BLUE);
		jl10.setFont(new Font("TAHOMA", Font.BOLD, 25));
		jp.add(jl10);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/" + pack[10]));
		Image i = i1.getImage().getScaledInstance(500, 360, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i);
		JLabel image = new JLabel(i2);
		image.setBounds(320, 30, 500, 360);
		jp.add(image);
		
		return jp;
		
	}
	
	public static void main(String[] args) {
		
		new Check_Packages();
	}

}
