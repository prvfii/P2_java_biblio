package Bibliothèque;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Bibliothèque.LibraryFrame;
import Livres.Livre;
import Membres.Membre;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame{
	
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginBtn;
	private JLabel statusLabel;
	private LibraryFrame libraryFrame;
	private Bibliothèque bibliothèque;
	private Membre membre;

	


	public LoginFrame() {
		
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 150);
		setLocationRelativeTo(null);
		Bibliothèque bibliothèque = new Bibliothèque();
		this.bibliothèque = bibliothèque;

		bibliothèque.creerMembres();
	   
		JPanel panel = new JPanel(new GridLayout(3,2));
		
		
		panel.add(new JLabel("Username : "));
		usernameField = new JTextField();
		panel.add(usernameField);
		
		
		panel.add(new JLabel("Password : "));
		passwordField = new JPasswordField();
		panel.add(passwordField);
		
		loginBtn = new JButton("Login");
		panel.add(loginBtn);
		
		
		
		statusLabel = new JLabel();
		panel.add(statusLabel);
		
		add(panel);
		
		LibraryFrame libraryFrame = new LibraryFrame();

		
		
		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String username = usernameField.getText();
				String password = String.valueOf(passwordField.getPassword());
				membre = getMembre(username, password);
				if(membre != null) {
					statusLabel.setText("Login réussi");
					System.out.println(membre);
					if(membre.isAdmin()) {
						
						libraryFrame.enableAdminFeatures();
					}
					 libraryFrame.setVisible(true);
				        dispose();
					
				}else {
					System.out.println(membre);
					statusLabel.setText("Username ou password invalide");
				}
				
				
			}
			
		});
		
	}
	
	public void setLibraryFrame(LibraryFrame libraryFrame) {
		this.libraryFrame = libraryFrame;
		
		
	}
	
	public Membre getMembre(String username, String password) {

	    for (Membre membre : bibliothèque.getMembres()) {
	        if (membre.getUsername().equals(username) && membre.getPassword().equals(password)) {
	            return membre;
	        }
	    }
	    return null;
	}

	
	
	
	public static void main(String[] args) {
		
	
		
		//LoginFrame loginFrame = new LoginFrame();
		
		//loginFrame.setVisible(true);
		
	}

}
