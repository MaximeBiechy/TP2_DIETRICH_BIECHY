import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFormation {
    @Test
    public void testAjouterMatiere() {
        Formation f = new Formation(1);
        String m = "Maths";
        f.ajouterMatiere(m, 1);
        assertEquals(f.getMatiere().size(), 1, "La matière n'est pas ajoutée à la collection.");
    }

    @Test
    public void testSupprimerMatiere() {
        Formation f = new Formation(1);
        String m = "Maths";
        String m2 = "Français";
        f.ajouterMatiere(m, 1);
        f.ajouterMatiere(m2, 1);
        f.supprimerMatiere(m);
        assertEquals(f.getMatiere().size(), 1, "La matière n'a pas été supprimée.");
    }

    @Test
    public void testSupprimerNonPrésent() {
        Formation f = new Formation(1);
        String m = "Maths";
        String m2 = "Français";
        f.ajouterMatiere(m, 1);
        f.ajouterMatiere(m2, 1);
        String m3 = "EPS";
        f.supprimerMatiere(m3);
        assertEquals(f.getMatiere().size(), 2, "La matière a été supprimée alors qu'elle ne fait pas partie de la collection.");
    }

    @Test
    public void testConnaitreCoeff() {
        Formation f = new Formation(1);
        String m = "Maths";
        String m2 = "Français";
        f.ajouterMatiere(m, 1);
        assertEquals(1, f.connaitreCoeff(m), "Le coefficient retourné n'est pas le bon.");
    }

    @Test
    public void testConnaitreCoeffNonPrésent() {
        Formation f = new Formation(1);
        String m = "Maths";
        String m2 = "Français";
        f.ajouterMatiere(m, 1);
        assertEquals(-1, f.connaitreCoeff(m2), "Le coefficient retourné est bon alors que la matière n'est pas dans la collection.");
    }
}
