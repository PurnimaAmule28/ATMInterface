package pack1;

import java.awt.Font;

import javax.swing.*;


public class Login extends JFrame {
Login(){
	setTitle("AUTOMATED TELLER MACHINE");
	setLayout(null);
	
	JLabel text =new JLabel("Welcome to ATM");
	text.setFont(new Font("osward",Font.BOLD,28));
	text.setBounds(200,40,400,40);
	text.setBackground(getForeground());
	
	
	setSize(800,480);
	setVisible(true);
}
public static void main(String args[]) {
	new Login();
}
	
}
