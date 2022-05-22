package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.AssociateProjectXMember;

/**
 *
 * @author gaeta
 */
public class AffectController extends MouseAdapter {
    
    @Override
    public void mousePressed(MouseEvent e) {
        new AssociateProjectXMember().setVisible(true);
    }
}
