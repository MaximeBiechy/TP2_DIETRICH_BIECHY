import java.util.*;

public class Etudiant {

    //Attributs
    private Identite id;
    private Formation formation;
    private HashMap<String, ArrayList<Integer>> resultats;

    //Constructeur

    public Etudiant(Identite id, Formation formation) {
        this.id = id;
        this.formation = formation;
        this.resultats = new HashMap<String, ArrayList<Integer>>();
    }

    //méthode ajouterNoteMatiere
    public void ajouterNoteMatiere(String m, int note) {
        if (formation.getMatiere().containsKey(m)) {
            if ((note>=0) && (note<=20)) {
                if (!resultats.containsKey(m)) {
                    resultats.put(m, new ArrayList<>());
                }
                resultats.get(m).add(note);
            } else {
                System.out.println("La note doit être comprise entre 0 et 20.");
            }
        } else {
            System.out.println("La matière " + m + " n'est pas dans la formation.");
        }
    }

    //méthode calculerMoyenne
    public double calculerMoyenne(String m) {
        double res = -1;
        if (resultats.containsKey(m)) {
            res = 0;
            for (int i = 0; i < this.resultats.get(m).size(); i++) {
                res += this.resultats.get(m).get(i);
            }
            res = res/this.resultats.get(m).size();
        } else {
            System.out.println("L'étudiant n'a pas de note dans cette matière");
        }
        return res;
    }

    //méthode calculerMoyenneGenerale
    public double calculerMoyenneGenerale() {
        double res = 0;
        for (int i = 0; i < this.resultats.size(); i++) {
            Set<String> cles = resultats.keySet();
            List<String> listeCles = new ArrayList<>(cles);
            String m = listeCles.get(i);
            res += this.calculerMoyenne(m);
        }
        return res/this.resultats.size();
    }

    // GETTER
    public HashMap<String, ArrayList<Integer>> getResultats() {
        return resultats;
    }
}
