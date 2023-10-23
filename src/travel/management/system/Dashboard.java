package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

	String username;
	JButton addPersonalDetails, viewDetails, updatePersonalDetails, checkPackages, bookPackage, viewPackage, viewHotels,
			destinations, bookHotel, viewBookedHotel, payments, calculator;

	Dashboard(String username) {

		this.username = username;
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(null);

		JPanel jp = new JPanel();
		jp.setLayout(null);
		jp.setBounds(0, 0, 1600, 65);
		jp.setBackground(new Color(0, 0, 102));
		add(jp);

		ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
		Image image = ic.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon ic2 = new ImageIcon(image);
		JLabel jl = new JLabel(ic2);
		jl.setBounds(5, 0, 70, 70);
		jp.add(jl);

		JLabel jldash = new JLabel("Dashboard");
		jldash.setForeground(Color.WHITE);
		jldash.setFont(new Font("TAHOMA", Font.BOLD, 30));
		jldash.setBounds(80, 10, 300, 40);
		jp.add(jldash);

		JPanel jp2 = new JPanel();
		jp2.setLayout(null);
		jp2.setBackground(new Color(0, 0, 102));
		jp2.setBounds(0, 65, 300, 900);
		add(jp2);

		addPersonalDetails = new JButton("Add Personal Details");
		addPersonalDetails.setBounds(0, 0, 300, 50);
		addPersonalDetails.setBackground(new Color(0, 0, 102));
		addPersonalDetails.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		addPersonalDetails.setMargin(new Insets(0, 0, 0, 60));
		addPersonalDetails.setForeground(Color.WHITE);
		addPersonalDetails.addActionListener(this);
		jp2.add(addPersonalDetails);

		updatePersonalDetails = new JButton("Update Personal Details");
		updatePersonalDetails.setBounds(0, 50, 300, 50);
		updatePersonalDetails.setBackground(new Color(0, 0, 102));
		updatePersonalDetails.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		updatePersonalDetails.setMargin(new Insets(0, 0, 0, 30));
		updatePersonalDetails.setForeground(Color.WHITE);
		updatePersonalDetails.addActionListener(this);
		jp2.add(updatePersonalDetails);

		viewDetails = new JButton("View Details");
		viewDetails.setBounds(0, 100, 300, 50);
		viewDetails.setBackground(new Color(0, 0, 102));
		viewDetails.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		viewDetails.setMargin(new Insets(0, 0, 0, 135));
		viewDetails.setForeground(Color.WHITE);
		viewDetails.addActionListener(this);
		jp2.add(viewDetails);

		JButton deleteDetails = new JButton("Delete Personal Details");
		deleteDetails.setBounds(0, 150, 300, 50);
		deleteDetails.setBackground(new Color(0, 0, 102));
		deleteDetails.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		deleteDetails.setMargin(new Insets(0, 0, 0, 35));
		deleteDetails.setForeground(Color.WHITE);
		jp2.add(deleteDetails);

		checkPackages = new JButton("Check Packages");
		checkPackages.setBounds(0, 200, 300, 50);
		checkPackages.setBackground(new Color(0, 0, 102));
		checkPackages.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		checkPackages.setMargin(new Insets(0, 0, 0, 100));
		checkPackages.setForeground(Color.WHITE);
		checkPackages.addActionListener(this);
		jp2.add(checkPackages);

		bookPackage = new JButton("Book Package");
		bookPackage.setBounds(0, 250, 300, 50);
		bookPackage.setBackground(new Color(0, 0, 102));
		bookPackage.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		bookPackage.setMargin(new Insets(0, 0, 0, 115));
		bookPackage.addActionListener(this);
		bookPackage.setForeground(Color.WHITE);
		jp2.add(bookPackage);

		viewPackage = new JButton("View Package");
		viewPackage.setBounds(0, 300, 300, 50);
		viewPackage.setBackground(new Color(0, 0, 102));
		viewPackage.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		viewPackage.setMargin(new Insets(0, 0, 0, 115));
		viewPackage.addActionListener(this);
		viewPackage.setForeground(Color.WHITE);
		jp2.add(viewPackage);

		viewHotels = new JButton("View Hotels");
		viewHotels.setBounds(0, 350, 300, 50);
		viewHotels.setBackground(new Color(0, 0, 102));
		viewHotels.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		viewHotels.setMargin(new Insets(0, 0, 0, 130));
		viewHotels.addActionListener(this);
		viewHotels.setForeground(Color.WHITE);
		jp2.add(viewHotels);

		bookHotel = new JButton("Book Hotel");
		bookHotel.setBounds(0, 400, 300, 50);
		bookHotel.setBackground(new Color(0, 0, 102));
		bookHotel.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		bookHotel.setMargin(new Insets(0, 0, 0, 140));
		bookHotel.setForeground(Color.WHITE);
		bookHotel.addActionListener(this);
		jp2.add(bookHotel);

		viewBookedHotel = new JButton("View Booked Hotel");
		viewBookedHotel.setBounds(0, 450, 300, 50);
		viewBookedHotel.setBackground(new Color(0, 0, 102));
		viewBookedHotel.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		viewBookedHotel.setMargin(new Insets(0, 0, 0, 70));
		viewBookedHotel.setForeground(Color.WHITE);
		viewBookedHotel.addActionListener(this);
		jp2.add(viewBookedHotel);

		destinations = new JButton("Destinations");
		destinations.setBounds(0, 500, 300, 50);
		destinations.setBackground(new Color(0, 0, 102));
		destinations.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		destinations.setMargin(new Insets(0, 0, 0, 125));
		destinations.setForeground(Color.WHITE);
		destinations.addActionListener(this);
		jp2.add(destinations);

		payments = new JButton("Payments");
		payments.setBounds(0, 550, 300, 50);
		payments.setBackground(new Color(0, 0, 102));
		payments.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		payments.setMargin(new Insets(0, 0, 0, 150));
		payments.setForeground(Color.WHITE);
		payments.addActionListener(this);
		jp2.add(payments);

		calculator = new JButton("Calculator");
		calculator.setBounds(0, 600, 300, 50);
		calculator.setBackground(new Color(0, 0, 102));
		calculator.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		calculator.setMargin(new Insets(0, 0, 0, 140));
		calculator.setForeground(Color.WHITE);
		calculator.addActionListener(this);
		jp2.add(calculator);

		ImageIcon ic3 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
		Image image1 = ic3.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
		ImageIcon ic4 = new ImageIcon(image1);
		JLabel jl3 = new JLabel(ic4);
		jl3.setBounds(0, 0, 1650, 1000);
		add(jl3);

		JLabel text = new JLabel("Travel And Tourism Management System");
		text.setBounds(400, 70, 1000, 70);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("SAN SERIF", Font.BOLD, 45));
		jl3.add(text);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent a) {
		if (a.getSource() == addPersonalDetails) {
			new Add_Customer(username);
		} else if (a.getSource() == viewDetails) {
			new View_Customer(username);
		} else if (a.getSource() == updatePersonalDetails) {
			new Update_Customer(username);
		} else if (a.getSource() == checkPackages) {
			new Check_Packages();
		} else if (a.getSource() == bookPackage) {
			new Book_Package(username);
		} else if (a.getSource() == viewPackage) {
			new View_Package(username);
		} else if (a.getSource() == viewHotels) {
			new Check_Hotels();
		} else if (a.getSource() == destinations) {
			new Destinations();
		} else if (a.getSource() == bookHotel) {
			new Book_Hotel(username);
		} else if (a.getSource() == viewBookedHotel) {
			new View_Booked_Hotel(username);
		} else if (a.getSource() == payments) {
			new Payment();
		} else if (a.getSource() == calculator) {
			try {
					Runtime.getRuntime().exec("calc.exe");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		new Dashboard("");

	}

}
