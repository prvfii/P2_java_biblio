package Bibliothèque;
import Bibliothèque.Bibliothèque;
import Emprunt.Emprunt;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Livres.Livre;
import Membres.Membre;

public class LivreDetailsFrame extends JFrame {
    private Livre livre;
	private Bibliothèque bibliothèque;
	private Membre membre;
	

    public LivreDetailsFrame(int idLivre, String titre, String auteur, boolean disponible) {
    	 this.membre = membre;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setTitle("Détails du livre");
        this.livre = new Livre(idLivre, titre, auteur, disponible);
        JLabel idLabel = new JLabel("ID: " + idLivre);
        JLabel titreLabel = new JLabel("Titre: " + titre);
        JLabel auteurLabel = new JLabel("Auteur: " + auteur);
        JLabel disponibleLabel = new JLabel("Disponible: " + (disponible ? "Oui" : "Non"));
        JButton retourButton = new JButton("Retour à la liste des livres");
    
        retourButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Redirection vers la page précédente
                dispose(); // Ferme la fenêtre actuelle (LivresDetailsFrame)
                LibraryFrame libraryFrame = new LibraryFrame();
                libraryFrame.setVisible(true);
            
                if(membre.isAdmin()) {
                	
                	libraryFrame.enableAdminFeatures();
                }
              //  LibraryFrame libraryFrame = new LibraryFrame();
				//libraryFrame.setVisible(true); // Affiche la fenêtre précédente (LibraryFrame)
            }
        });
        JButton emprunterBtn = new JButton((disponible ? "Emprunter le livre" : "Retourner le livre" ));
        emprunterBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Bibliothèque bibliothèque = new Bibliothèque();
				System.out.println(bibliothèque);	
				System.out.println("LIVRE:" + livre);
				
				
				/* Emprunt success = bibliothèque.emprunterLivre(livre.getId(), membre);
				 System.out.println("LIVRE:" + livre.getId());
			        if (success != null) {
			            JOptionPane.showMessageDialog(LivreDetailsFrame.this, "Livre emprunté !");
			            emprunterBtn.setEnabled(false);
			            disponibleLabel.setText("Non disponible");
			        } else {
			            JOptionPane.showMessageDialog(LivreDetailsFrame.this, "Livre non disponible.");
			        }*/
				
			}
        	
        });

        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.add(idLabel);
        panel.add(titreLabel);
        panel.add(auteurLabel);
        panel.add(disponibleLabel);
        panel.add(retourButton);
        panel.add(emprunterBtn);
        add(panel);
    }


	
}
