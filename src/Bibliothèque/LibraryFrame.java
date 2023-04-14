package Bibliothèque;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Livres.Livre;

public class LibraryFrame extends JFrame {
    private Bibliothèque bibliothèque;
    private LibraryFrame libraryFrame;
    
    public LibraryFrame() {
        
    	 bibliothèque = new Bibliothèque();
         bibliothèque.creerLivres();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        JPanel searchPanel = new JPanel();
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Rechercher");
        JButton membresButton = new JButton("Afficher les membres");
        searchPanel.add(membresButton);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        
        
      
        
        
        
        
        membresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
                MembresFrame membreFrame = new MembresFrame(libraryFrame);
               membreFrame.setVisible(true);
               
            }
        });
        List<Livre> livres = bibliothèque.getLivres();
        String[] columnNames = {"ID", "Titre", "Auteur", "Disponible"};
        Object[][] data = new Object[livres.size()][4];

        for (int i = 0; i < livres.size(); i++) {
            Livre livre = livres.get(i);
            data[i][0] = livre.getId();
            data[i][1] = livre.getTitre();
            data[i][2] = livre.getAuteur();
            data[i][3] = livre.getDisponible();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        add(searchPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText().trim().toLowerCase();
                List<Livre> livres = bibliothèque.rechercherLivres(searchText);
                Object[][] data = new Object[livres.size()][4];

                for (int i = 0; i < livres.size(); i++) {
                    Livre livre = livres.get(i);
                    data[i][0] = livre.getId();
                    data[i][1] = livre.getTitre();
                    data[i][2] = livre.getAuteur();
                    data[i][3] = livre.getDisponible();
                }

                table.setModel(new DefaultTableModel(data, columnNames));
            }
        });

        table.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (event.getValueIsAdjusting()) {
                    return;
                }
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    return;
                }
                int idLivre = (int) table.getValueAt(selectedRow, 0);
                String titreLivre = (String) table.getValueAt(selectedRow, 1);
                String auteurLivre = (String) table.getValueAt(selectedRow, 2);
                boolean disponibleLivre = (boolean) table.getValueAt(selectedRow, 3);
                
                // Créer une nouvelle instance de LivreDetailsFrame et lui passer les informations du livre sélectionné
                LivreDetailsFrame detailsFrame = new LivreDetailsFrame(idLivre, titreLivre, auteurLivre, disponibleLivre);
                detailsFrame.setVisible(true);
                dispose();
            }
        });


    }

    public void enableAdminFeatures() {
        JPanel adminPanel = new JPanel();
        JButton addBookButton = new JButton("Ajouter un livre");
        JButton removeBookButton = new JButton("Supprimer un livre");
        JButton editBookButton = new JButton("Modifier un livre");
        adminPanel.add(addBookButton);
        adminPanel.add(removeBookButton);
        adminPanel.add(editBookButton);
        add(adminPanel, BorderLayout.SOUTH);

        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	
                // Créer une boîte de dialogue pour saisir les informations du nouveau livre
                JTextField idField = new JTextField(5);
                JTextField titreField = new JTextField(20);
                JTextField auteurField = new JTextField(20);
                
                JPanel panel = new JPanel();
                panel.add(new JLabel("ID:"));
                panel.add(idField);
                panel.add(new JLabel("Titre:"));
                panel.add(titreField);
                panel.add(new JLabel("Auteur:"));
                panel.add(auteurField);
          
                int result = JOptionPane.showConfirmDialog(null, panel, "Ajouter un livre",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    // Récupérer les informations saisies et créer un nouveau livre
                    int id = Integer.parseInt(idField.getText());
                    String titre = titreField.getText();
                    String auteur = auteurField.getText();
                    Livre livre = new Livre(id, titre, auteur, true);
                    bibliothèque.addLivre(livre);
                    System.out.println(livre);
                    System.out.println( bibliothèque.getLivres());
                    JOptionPane.showMessageDialog(null, "Le livre a été ajouté à la bibliothèque.");
                    // Mettre à jour la table des livres
                    List<Livre> livres = bibliothèque.getLivres(); 
                    String[] columnNames = {"ID", "Titre", "Auteur", "Disponible"};
                    Object[][] data = new Object[livres.size()][4];
                    for (int i = 0; i < livres.size(); i++) {
                        Livre l = livres.get(i);
                        data[i][0] = l.getId();
                        data[i][1] = l.getTitre();
                        data[i][2] = l.getAuteur();
                        data[i][3] = l.getDisponible();
                    }
                    
                    JTable table = new JTable(data, columnNames);
                    table.setModel(new DefaultTableModel(data, columnNames));	
                    add(table);
                   
                }
            }
        });

    
    }



   
}
