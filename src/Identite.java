public class Identite {

    //Attributs
    private String nip;
    private String nom;
    private String prenom;

    //Constructeur
    public Identite(String nip, String nom, String prenom) {
        this.nip = nip;
        this.nom = nom;
        this.prenom = prenom;
    }

    //GETTER
    public String getNip() {
        return this.nip;
    }
}
