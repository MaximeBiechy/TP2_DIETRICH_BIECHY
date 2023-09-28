import java.util.HashMap;

public class Formation {

  // Attributs
  private int identifiant;
  private HashMap<String, Integer> matiere;

  // Constructeur
  public Formation(int identifiant) {
    this.identifiant = identifiant;
    this.matiere = new HashMap<String, Integer>();
  }

  // Methode ajouterMatiere
  public void ajouterMatiere(String nom, int coeff) throws Exception {
    if (coeff <= 0){
      throw new Exception("Coeff négatif");
    }
    this.matiere.put(nom, coeff);
  }

  // Methode supprimerMatiere
  public void supprimerMatiere(String nom){
    if(this.matiere.containsKey(nom)) {
      this.matiere.remove(nom);
    }
  }

  // Methode connaitreCoeff
  public int connaitreCoeff(String nom){
    if(this.matiere.containsKey(nom)){
      return this.matiere.get(nom);
    } else return -1;
  }

  //méthode getMatiere
  public HashMap<String, Integer> getMatiere() {
    return this.matiere;
  }
}
