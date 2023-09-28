import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMoyenneGroupe {

  // Attributs
  private Formation formation;
  private Etudiant etu1, etu2, etu3;
  private Groupe g;

  @BeforeEach
  public void init() throws Exception {
    formation = new Formation(12345);
    etu1 = new Etudiant(new Identite("123", "Jean", "Jack"), formation);
    etu2 = new Etudiant(new Identite("345", "Gerard", "Jugnot"), formation);
    etu3 = new Etudiant(new Identite("678", "Patrice", "Patoche"), formation);
    formation.ajouterMatiere("maths", 1);
    formation.ajouterMatiere("histoire", 1);
    g = new Groupe(formation);
    g.ajouterEtudiant(etu1);
    g.ajouterEtudiant(etu2);
    g.ajouterEtudiant(etu3);
  }

  @Test
  public void test_calculerMoyenne(){
    // Préparation des données
    etu1.ajouterNoteMatiere("maths", 18);
    etu1.ajouterNoteMatiere("maths", 14);
    etu2.ajouterNoteMatiere("maths", 5);
    etu2.ajouterNoteMatiere("maths", 8);
    etu3.ajouterNoteMatiere("maths", 20);
    etu3.ajouterNoteMatiere("maths", 10);


    // Vérification
    assertEquals(12.5, g.calculerMoyenne("maths"));
  }

  @Test
  public void test_calculerMoyenneGeneral(){
    // Préparation des données
    etu1.ajouterNoteMatiere("maths", 18);
    etu1.ajouterNoteMatiere("histoire", 14);
    etu2.ajouterNoteMatiere("maths", 5);
    etu2.ajouterNoteMatiere("histoire", 8);
    etu3.ajouterNoteMatiere("maths", 20);
    etu3.ajouterNoteMatiere("histoire", 10);
    
    // Vérification
    assertEquals(12.5, g.calculerMoyenneGenerale());
  }
}
