
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class ParcScooter {
    private Scooter[] scooters;
    private int nombreScooters;
    private int capacite;

    public ParcScooter(int capacite) {
        scooters = new Scooter[capacite];
        nombreScooters = 0;
        this.capacite = capacite;
    }

    public void ajouterScooter(Scooter scooter) {
        if (nombreScooters < capacite) {
            scooters[nombreScooters] = scooter;
            nombreScooters++;
        } else {
            System.out.println("Capacité maximale du parc atteinte.");
        }
    }

    public Scooter trouverScooter(int numeroIdentification) {
        for (int i = 0; i < nombreScooters; i++) {
            if (scooters[i] != null && scooters[i].getNumeroIdentification() == numeroIdentification) {
                return scooters[i];
            }
        }
        return null;
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

    public String afficherEtatParc() {
        String resultat = "";
        for (int i = 0; i < scooters.length; i++) {
            if (scooters[i] == null) {
                break;
            }
            resultat = (resultat + "ID : " + scooters[i].getNumeroIdentification() +
                    " | Modele: " + scooters[i].getModele() +
                    " | Kilometrage: " + scooters[i].getKilometrage() +
                    " | Disponible: " + (scooters[i].isDisponible() ? "Oui" : "Non") +
                    ("\n"));
        }
        return resultat;
    }

    public String afficherResumeParc() {
        int totalScooters = 0;
        int scootersEnLocation = 0;
        int scootersDisponibles = 0;
        double totalKilometrage = 0;

        String listeDispo = "";
        String listeNonDispo = "";

        for (int i = 0; i < scooters.length; i++) {
            if (scooters[i] == null) {
                break;
            }
            if (scooters[i].isDisponible()) {
                scootersDisponibles++;
                listeDispo = listeDispo + (scooters[i].getNumeroIdentification() + "\n");
            } else {
                scootersEnLocation++;
                listeNonDispo = listeNonDispo + (scooters[i].getNumeroIdentification() + "\n");
            }
            totalScooters++;
            totalKilometrage += scooters[i].getKilometrage();
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
                        + scooter.getKilometrage() + "," + scooter.isDisponible() + "\n");
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
