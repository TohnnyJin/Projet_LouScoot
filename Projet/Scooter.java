public class Scooter {
    private String modele;
    private int numeroIdentification;
    private double kilometrage;
    private boolean disponible;

    public Scooter(String modele, int numeroIdentification, double kilometrage, boolean disponible) {
        this.modele = modele;
        this.numeroIdentification = numeroIdentification;
        this.kilometrage = kilometrage;
        this.disponible = disponible;
    }

    public String getModele() {
        return modele;
    }

    public int getNumeroIdentification() {
        return numeroIdentification;
    }

    public double getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
