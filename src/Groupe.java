import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Groupe {

    //attributs
    private HashMap<Integer, Etudiant> etudiants;
    private Formation formation;

    //constructeur
    public Groupe(Formation f) {
        this.formation = f;
        this.etudiants = new HashMap<Integer, Etudiant>();
    }

    //méthode ajouterEtudiant
    public void ajouterEtudiant(Etudiant e) {
        if (this.formation == e.getFormation()) {
                if (this.etudiants == null) {
                    this.etudiants.put(1, e);
                } else {
                    Set<Integer> cles = etudiants.keySet();
                    List<Integer> listeCles = new ArrayList<>(cles);
                    boolean trouve = false;
                    int i = 0;
                    while ((trouve == false) && (i<this.etudiants.size())) {
                        Integer etu = listeCles.get(i);
                        if (this.etudiants.get(etu).getIdentite().getNip().equals(e.getIdentite().getNip())) {
                            trouve = true;
                        }
                        i++;
                    }
                    if (trouve == false) {
                        this.etudiants.put(this.etudiants.size()+1, e);
                    }
                }
        }
    }

    public void supprimerEtudiant(String nip) {
        Set<Integer> cles = etudiants.keySet();
        List<Integer> listeCles = new ArrayList<>(cles);
        boolean trouve = false;
        int i = 0;
        while ((trouve == false) && (i<this.etudiants.size())) {
            Integer etu = listeCles.get(i);
            if (this.etudiants.get(etu).getIdentite().getNip() == nip) {
                trouve = true;
                this.etudiants.remove(etu);
            }
            i++;
        }
    }

    public double calculerMoyenne(String m){
        Set<Integer> cles = etudiants.keySet();
        List<Integer> listeCles = new ArrayList<>(cles);
        double res = 0;
        for (int i = 0; i < etudiants.size(); i++){
            Integer etu = listeCles.get(i);
            res += etudiants.get(etu).calculerMoyenne(m);
        }
        return res/etudiants.size();
    }

    public double calculerMoyenneGenerale(){
        Set<Integer> cles = etudiants.keySet();
        List<Integer> listeCles = new ArrayList<>(cles);
        double res = 0;
        for (int i = 0; i < etudiants.size(); i++){
            Integer etu = listeCles.get(i);
            res += etudiants.get(etu).calculerMoyenneGenerale();
        }
        return res/ etudiants.size();
    }

    //GETTER
    public HashMap<Integer, Etudiant> getEtudiants() {
        return this.etudiants;
    }
}
