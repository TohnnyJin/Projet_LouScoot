/*

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

class ParcScooters {
    public ArrayList<Scooter> scooters = new ArrayList<>();

    public void ajouterScooter(Scooter scooter) {
        scooters.add(scooter);
    }

    public Scooter trouverScooter(int numeroIdentification) {
        for (Scooter scooter : scooters) {
            if (scooter.getNumeroIdentification() == numeroIdentification) {
                return scooter;
            }
        }
        return null;
    }

    public String louerScooter(int numeroIdentification) {
        Scooter scooter = trouverScooter(numeroIdentification);
        if (scooter != null) {
            if (scooter.isDisponible()) {
                scooter.setDisponible(false);
                return ("Scooter loue avec succes.");
            } else {
                return ("Le scooter est dejà en location.");
            }
        } else {
            return ("Scooter non trouve.");
        }
    }

    public String retournerScooter(int numeroIdentification, double kilometrageEffectue) {
        Scooter scooter = trouverScooter(numeroIdentification);
        if (scooter != null) {
            if (!scooter.isDisponible()) {
                scooter.setDisponible(true);
                scooter.setKilometrage(scooter.getKilometrage() + kilometrageEffectue);
                return ("Scooter retourne avec succes.");
            } else {
                return ("Le scooter n'etait pas en location.");
            }
        } else {
            return ("Scooter non trouve.");
        }
    }

    public String afficherEtatScooter(int numeroIdentification) {
        Scooter scooter = trouverScooter(numeroIdentification);
        if (scooter != null) {
            return ("Modele : " + scooter.getModele() +
                    " | ID : " + scooter.getNumeroIdentification() +
                    " | Kilometrage : " + scooter.getKilometrage() +
                    " | Disponible : " + (scooter.isDisponible() ? "Oui" : "Non"));
        } else {
            return ("Scooter non trouve.");
        }
    }

    public String afficherEtatParc() {
        String resultat = "";
        for (Scooter scooter : scooters) {
            resultat = (resultat + "ID : " + scooter.getNumeroIdentification() +
                    " | Modele: " + scooter.getModele() +
                    " | Kilometrage: " + scooter.getKilometrage() +
                    " | Disponible: " + (scooter.isDisponible() ? "Oui" : "Non") +
                    ("\n"));
        }
        return resultat;
    }

    public String afficherResumeParc() {
        int totalScooters = scooters.size();
        int scootersEnLocation = 0;
        int scootersDisponibles = 0;
        double totalKilometrage = 0;

        String listeDispo = "";
        String listeNonDispo = "";

        for (Scooter scooter : scooters) {
            if (scooter.isDisponible()) {
                scootersDisponibles++;
                listeDispo = listeDispo + (scooter.getNumeroIdentification() + "\n");
            } else {
                scootersEnLocation++;
                listeNonDispo = listeNonDispo + (scooter.getNumeroIdentification() + "\n");
            }
            totalKilometrage += scooter.getKilometrage();
        }

        double kilometrageMoyen = totalKilometrage / totalScooters;

        return ("Nombre total de scooters: " + totalScooters +
                "\nNombre de scooters en location: " + scootersEnLocation +
                "\nNombre de scooters disponibles: " + scootersDisponibles +
                "\nKilometrage moyen: " + kilometrageMoyen +
                "\n\n Liste ID des scooters disponible : \n" + listeDispo +
                "\n\n Liste ID des scooters disponible : \n" + listeNonDispo);
    }

    public void sauvegarderInformations() {
        try {
            FileWriter dbFile = new FileWriter("dbScoot.txt");
            for (Scooter scooter : scooters) {
                dbFile.write(scooter.getModele() + "," + scooter.getNumeroIdentification() + ","
                        + scooter.getKilometrage() + "," + scooter.isDisponible()+"\n");
            }
            dbFile.close();
        } catch (IOException error) {
        }
    }

    public void restaurerInformations() {
        try {
            File dbFile = new File("dbScoot.txt");
            Scanner ScanFile = new Scanner(dbFile);
            while (ScanFile.hasNextLine()) {

                String line = ScanFile.nextLine();

                String[] scooterData = line.split(",");

                String modele = scooterData[0];
                int numeroIdentification = Integer.parseInt(scooterData[1]);
                double kilometrage = Double.parseDouble(scooterData[2]);
                boolean disponible = Boolean.parseBoolean(scooterData[3]);

                Scooter data = new Scooter(modele, numeroIdentification, kilometrage, disponible);

                // Ajouter le scooter à votre parc
                this.ajouterScooter(data);
            }
            ScanFile.close();
        } catch (FileNotFoundException e) {
        }
    }
}
*/
