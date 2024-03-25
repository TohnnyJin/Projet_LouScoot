public class Location {
    private String dateDebut;
    private String dateRetour;
    private double kilometrageDebut;
    private double kilometrageFin;

    public Location(String dateDebut, double kilometrageDebut) {
        this.dateDebut = dateDebut;
        this.kilometrageDebut = kilometrageDebut;
    }

    public void setDateRetour(String dateRetour) {
        this.dateRetour = dateRetour;
    }

    public void setKilometrageFin(double kilometrageFin) {
        this.kilometrageFin = kilometrageFin;
    }

    public double calculerKilometrageParcouru() {
        return kilometrageFin - kilometrageDebut;
    }
}

