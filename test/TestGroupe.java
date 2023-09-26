import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestGroupe {

    @Test
    public void test_ajouterEtudiants() {
        Formation formation = new Formation(12345);
        Etudiant e = new Etudiant(new Identite("123", "Jean", "Jack"), formation);
        Groupe g = new Groupe(formation);
        g.ajouterEtudiant(e);
        assertEquals(e, g.getEtudiants().get(1), "L'étudiant n'a pas été ajouté.");
    }

    @Test
    public void test_ajouterDoublon() {
        Formation formation = new Formation(12345);
        Etudiant e = new Etudiant(new Identite("123", "Jean", "Jack"), formation);
        Etudiant e2 = new Etudiant(new Identite("123", "Jean", "Jack"), formation);
        Groupe g = new Groupe(formation);
        g.ajouterEtudiant(e);
        g.ajouterEtudiant(e2);
        assertEquals(1, g.getEtudiants().size(), "L'étudiant a été ajouté.");
    }

    @Test
    public void test_supprimerEtudiant() {
        Formation formation = new Formation(12345);
        Etudiant e = new Etudiant(new Identite("123", "Jean", "Jack"), formation);
        Groupe g = new Groupe(formation);
        g.ajouterEtudiant(e);
        g.supprimerEtudiant("123");
        assertEquals(0, g.getEtudiants().size(), "L'étudiant n'a pas été supprimé.");
    }

    @Test
    public void test_supprimerNonExistant() {
        Formation formation = new Formation(12345);
        Etudiant e = new Etudiant(new Identite("123", "Jean", "Jack"), formation);
        Groupe g = new Groupe(formation);
        g.ajouterEtudiant(e);
        g.supprimerEtudiant("124");
        assertEquals(1, g.getEtudiants().size(), "L'étudiant a été supprimé.");
    }
}
