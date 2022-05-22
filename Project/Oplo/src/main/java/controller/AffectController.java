package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.AssociateProjectXMember;

/**
 *
 * @author gaeta
 */
public class AffectController extends MouseAdapter {
    
    private String titreProjet;
    
    public AffectController(String titreProjet) {
        this.titreProjet = titreProjet;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        new AssociateProjectXMember(titreProjet).setVisible(true);
    }
}
