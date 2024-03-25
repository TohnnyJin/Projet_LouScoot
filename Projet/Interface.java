import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interface {
    public static ParcScooter parc = new ParcScooter(20);

    Interface() {

        // Parametre de la fenetre
        JFrame frame = new JFrame("LouScoot");
        frame.setSize(1280, 720);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menu de bouton (en haut)
        JPanel panelBouton = new JPanel();

        // Creation des boutons
        JButton[] boutons = {
                new JButton("Louer"),
                new JButton("Rendre"),
                new JButton("Examiner"),
                new JButton("Verifier"),
                new JButton("Information"),
                new JButton("Quitter")
        };

        // Dimension des boutons
        Dimension tailleBouton = new Dimension(100, 25);

        // Ajout et modification des boutons
        for (JButton bouton : boutons) {
            bouton.setPreferredSize(tailleBouton);
            panelBouton.add(bouton);
        }

        frame.add(panelBouton, BorderLayout.NORTH);

        // Zone de resultat (au centre)
        JPanel panelResult = new JPanel();
        JTextArea showResult = new JTextArea(20, 75);
        showResult.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(showResult);
        panelResult.add(scrollPane);

        frame.add(panelResult, BorderLayout.CENTER);

        // Zone de texte (en bas)
        JPanel panelText = new JPanel(new GridLayout(0, 1));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel showTextId = new JLabel("ID du Scoot :");
        JTextField zoneTextId = new JTextField(10);
        idPanel.add(showTextId);
        idPanel.add(zoneTextId);

        panelText.add(idPanel);

        JPanel kmPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel showTextKm = new JLabel("Kilometrage du Scoot :");
        JTextField zoneTextKm = new JTextField(10);
        kmPanel.add(showTextKm);
        kmPanel.add(zoneTextKm);

        panelText.add(kmPanel);

        frame.add(panelText, BorderLayout.SOUTH);

        // Bouton click event
        // Bouton Louer
        boutons[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int textIdTmp = Integer.parseInt(zoneTextId.getText());

                    showResult.setText(parc.louerScooter(textIdTmp));
                    showTextId.setText("ID du scoot :");
                } catch (NumberFormatException error) {
                    showTextId.setText("ID Invalide");
                }

            }
        });

        // Bouton Rendre
        boutons[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int textIdTmp = Integer.parseInt(zoneTextId.getText());
                    try {
                        double textKmTmp = Double.parseDouble(zoneTextKm.getText());
                        showResult.setText(parc.retournerScooter(textIdTmp, textKmTmp));
                        showTextId.setText("ID du scoot :");
                        showTextKm.setText("Km du scoot :");
                    } catch (NumberFormatException error) {
                        showTextKm.setText("Km Invalide");
                        showTextId.setText("ID du scoot :");
                    }
                } catch (NumberFormatException error) {
                    showTextId.setText("ID Invalide");
                    showTextKm.setText("Km du scoot :");
                }

            }
        });

        // Bouton Examiner
        boutons[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int textIdTmp = Integer.parseInt(zoneTextId.getText());

                    showResult.setText(parc.afficherEtatScooter(textIdTmp));
                    showTextId.setText("ID du scoot :");
                } catch (NumberFormatException error) {
                    showTextId.setText("ID Invalide");
                }
            }
        });

        // Bouton Verifier
        boutons[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showResult.setText(parc.afficherEtatParc());
            }
        });

        // Bouton Information
        boutons[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showResult.setText(parc.afficherResumeParc());
            }
        });

        // Bouton Quitter
        boutons[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parc.sauvegarderInformations();
                System.exit(0);

            }
        });

        parc.restaurerInformations();
        frame.setVisible(true);

    }

}
