import org.junit.Before;
import org.junit.Test;

import java.text.Format;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestEtudiant {

  // Attributs
  private Formation formation;
  private Etudiant etu;

  @Before
  public void init(){
    formation = new Formation(12345);
    etu = new Etudiant(new Identite("123", "Jean", "Jack"), formation);
  }

  // Test méthode ajouterNoteMatiere
  @Test
  public void test_ajouterNoteMatiere(){
    // Préparation des données
    formation.ajouterMatiere(new String("maths"), 1);

    // Méthode testée
    etu.ajouterNoteMatiere("maths", 18);
    etu.ajouterNoteMatiere("maths", 14);

    // Vérification
    assertEquals(2, etu.getResultats().get("maths").size());
  }

  // Test méthode calculerMoyenne
  @Test
  public void test_calculerMoyenne(){
    // Préparation des données
    formation.ajouterMatiere(new String("maths"), 1);

    // Méthode testée
    etu.ajouterNoteMatiere("maths", 18);
    etu.ajouterNoteMatiere("maths", 14);

    // Vérification
    assertEquals(16.0, etu.calculerMoyenne("maths"), 0.01);
  }

  // Test méthode calculerMoyenne avec une matière inexistante
  @Test
  public void test_calculerMoyenne_matiere_inexistante(){
    // Méthode testée
    etu.calculerMoyenne("maths");

    // Vérification
    assertEquals(-1, etu.calculerMoyenne("maths"), 0.01);
  }

  // Test méthode calculerMoyenneGeneral
  @Test
  public void test_calculerMoyenneGeneral(){
    // Préparation des données
    formation.ajouterMatiere(new String("histoire"), 1);
    formation.ajouterMatiere(new String("maths"), 1);


    // Méthode testée
    etu.ajouterNoteMatiere("maths", 18);
    etu.ajouterNoteMatiere("maths", 14);
    etu.ajouterNoteMatiere("histoire", 10);
    etu.ajouterNoteMatiere("histoire", 10);

    // Vérification
    assertEquals(13, etu.calculerMoyenneGenerale(), 0.01);
  }
}
