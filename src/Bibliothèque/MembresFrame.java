package Bibliothèque;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Membres.Membre;

public class MembresFrame extends JFrame{
    private Bibliothèque bibliothèque;
    private LibraryFrame libraryFrame;
    private MembresFrame membresFrame;
    private JButton retourBtn;
    public MembresFrame(LibraryFrame libraryFrame) {
        this.libraryFrame = libraryFrame;
        bibliothèque = new Bibliothèque();
        bibliothèque.creerMembres();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        
        
        JButton retourBtn = new JButton("Retour à la liste des livres");
        retourBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	  dispose(); // Ferme la fenêtre actuelle (membresFrame)
            	  LibraryFrame libraryFrame = new LibraryFrame();
  				libraryFrame.setVisible(true); 
  				dispose();// Affiche la fenêtre précédente (LibraryFrame)
            }
        });

        List<Membre> membres = bibliothèque.getMembres();
        String[] columnNames = {"ID", "Nom", "Prénom"};
        Object[][] data = new Object[membres.size()][3];

        for (int i = 0; i < membres.size(); i++) {
            Membre membre = membres.get(i);
            data[i][0] = membre.getId();
            data[i][1] = membre.getNom();
            data[i][2] = membre.getPrenom();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        
        setLayout(new BorderLayout());
      add(scrollPane, BorderLayout.CENTER);
       add(retourBtn, BorderLayout.NORTH);
       pack();
      
      

        
    }
}
