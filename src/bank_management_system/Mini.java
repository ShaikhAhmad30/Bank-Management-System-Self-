package bank_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mini extends JFrame implements ActionListener{
	
	String pin;
	
	JButton button;
	
	Mini(String pin){
		
		this.pin = pin;
		
		
		JLabel label1 = new JLabel();
		label1.setBounds(20, 160, 400, 190);
		add(label1);
		
		JLabel label2 = new JLabel("BANK OF GANDEVI");
		label2.setFont(new Font("System",Font.BOLD,15));
		label2.setBounds(125, 20, 200, 20);
		add(label2);
		
		JLabel label3 = new JLabel();
		label3.setBounds(20, 80, 350, 20);
		//label3.setFont(new Font("System",Font.BOLD,14));
		add(label3);
		
		JLabel label4 = new JLabel();
		label4.setBounds(20, 400, 300, 20);
		add(label4);
		
		
		try {
			
			Conn c = new Conn();
			ResultSet resultSet = c.statement.executeQuery("select * from login where pin = '"+pin+"'");
			
			while(resultSet.next()) {
				label3.setText("Card Number:  "+ resultSet.getString("card_number").substring(0,4) + "XXXXXXXX"+ resultSet.getString("card_number").substring(12));
			}	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		try {
			
			int balance = 0;
			Conn c = new Conn();
			ResultSet  resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
			while(resultSet.next()) {
				label1.setText(label1.getText() + "<html>"+ resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+ "<br><br><html>");
				
				if(resultSet.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(resultSet.getString("amount"));
				}else {
					balance -= Integer.parseInt(resultSet.getString("amount"));
				}
			
			}
			
			label4.setText("Your Total Balance is Rs: "+balance);
		
	}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		button = new JButton("EXIT");
		button.setBounds(20, 500, 100, 25);
		button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);
		button.addActionListener(this);
		add(button);
		
		
		
		
		getContentPane().setBackground(new Color(173, 216,230));
		setSize(400,600);
		setLocation(0,0);
		setUndecorated(true);
		setLayout(null);
		setVisible(true);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		
	}
	
	
	
	
	
	
	public static void main(String[] args ) {
		new Mini("");
	}

}
