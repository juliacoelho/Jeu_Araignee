package araignee;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Serveur implements MouseListener{
    
    private final Tabuleiro t;
    private boolean gagnee;
    private boolean premier;
    private Circulos playerTurn;
    private int pt1,pt2;
    private final JLabel placar1, placar2;
    private final JButton botao;
    
    public Serveur(Tabuleiro tab, JLabel p1, JLabel p2, JButton bot){
        t = tab;
        placar1 = p1;
        placar2 = p2;
        botao = bot;
        gagnee = false;
        premier = true;
        pt1 = 0;
        pt2 = 0;        
        getPtj1();
        getPtj2();
    }
    
    public void getPtj1(){
        placar1.setText("Joueur 1 : " + Integer.toString(pt1));
    }
    
    public void getPtj2(){
        placar2.setText("Joueur 2 : " + Integer.toString(pt2));
    }
    
    public void mousePressed(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point pt;
        pt = e.getPoint();
        for (Circulos c : t.getListCercles()){
            if ((Math.sqrt(((c.getCoordx()+10)-pt.x)*((c.getCoordx()+10)-pt.x) + ((c.getCoordy()+10)-pt.y)*((c.getCoordy()+10)-pt.y)) < 10)&&c.isLivre()&&(t.getNbPignons()<6)){
                c.setCor(t.setcolorUser(premier));
                c.setOcupado();
                setJoueur();
                t.setNbPignons();
            }
            if ((Math.sqrt(((c.getCoordx()+10)-pt.x)*((c.getCoordx()+10)-pt.x) + ((c.getCoordy()+10)-pt.y)*((c.getCoordy()+10)-pt.y)) < 10)&&(!c.isLivre())&&(t.getNbPignons()>5)&&((premier&&c.getCor()==t.getAzul())||(!premier&&c.getCor()==t.getAmarelo()))){
                t.sansRouge();
                t.adjLivre(c);
                playerTurn = c;
            }
            if ((Math.sqrt(((c.getCoordx()+10)-pt.x)*((c.getCoordx()+10)-pt.x) + ((c.getCoordy()+10)-pt.y)*((c.getCoordy()+10)-pt.y)) < 10)&&(c.getCor() == t.getVermelho())){
                c.setCor(playerTurn.getCor());
                t.sansRouge();
                playerTurn.setCor(t.getTransparente());
                playerTurn.setLivre();
                c.setOcupado();
                setJoueur();
                
            }
        }
            t.repaint();
            gagner();
            if (gagnee){
                for (Circulos c : t.getListCercles()){
                    c.setCor(t.setcolorUser(!premier));                    
                }
                t.add(botao);
                getPtj1();
                getPtj2();
            }
        
    }
    

    public void mouseMoved(MouseEvent e) {
    } 
   
    public void gagner(){        
        if(((t.getListCercles().get(0).getCor()==t.getListCercles().get(1).getCor())&&(t.getListCercles().get(2).getCor()==t.getListCercles().get(1).getCor())&&(t.getListCercles().get(0).getCor()==t.getAmarelo()))||((t.getListCercles().get(3).getCor()==t.getListCercles().get(4).getCor())&&(t.getListCercles().get(5).getCor()==t.getListCercles().get(4).getCor())&&(t.getListCercles().get(3).getCor()==t.getAmarelo()))||((t.getListCercles().get(6).getCor()==t.getListCercles().get(7).getCor())&&(t.getListCercles().get(8).getCor()==t.getListCercles().get(7).getCor())&&(t.getListCercles().get(6).getCor()==t.getAmarelo()))||((t.getListCercles().get(0).getCor()==t.getListCercles().get(3).getCor())&&(t.getListCercles().get(6).getCor()==t.getListCercles().get(3).getCor())&&(t.getListCercles().get(0).getCor()==t.getAmarelo()))||((t.getListCercles().get(1).getCor()==t.getListCercles().get(4).getCor())&&(t.getListCercles().get(7).getCor()==t.getListCercles().get(4).getCor())&&(t.getListCercles().get(1).getCor()==t.getAmarelo()))||((t.getListCercles().get(2).getCor()==t.getListCercles().get(5).getCor())&&(t.getListCercles().get(8).getCor()==t.getListCercles().get(5).getCor())&&(t.getListCercles().get(2).getCor()==t.getAmarelo()))||((t.getListCercles().get(0).getCor()==t.getListCercles().get(4).getCor())&&(t.getListCercles().get(8).getCor()==t.getListCercles().get(4).getCor())&&(t.getListCercles().get(0).getCor()==t.getAmarelo()))||((t.getListCercles().get(2).getCor()==t.getListCercles().get(4).getCor())&&(t.getListCercles().get(6).getCor()==t.getListCercles().get(4).getCor())&&(t.getListCercles().get(2).getCor()==t.getAmarelo()))){
            gagnee = true;
            pt2 = pt2 + 1;
            //amarelo ganhou
        }
        else if(((t.getListCercles().get(0).getCor()==t.getListCercles().get(1).getCor())&&(t.getListCercles().get(2).getCor()==t.getListCercles().get(1).getCor())&&(t.getListCercles().get(0).getCor()==t.getAzul()))||((t.getListCercles().get(3).getCor()==t.getListCercles().get(4).getCor())&&(t.getListCercles().get(5).getCor()==t.getListCercles().get(4).getCor())&&(t.getListCercles().get(3).getCor()==t.getAzul()))||((t.getListCercles().get(6).getCor()==t.getListCercles().get(7).getCor())&&(t.getListCercles().get(8).getCor()==t.getListCercles().get(7).getCor())&&(t.getListCercles().get(6).getCor()==t.getAzul()))||((t.getListCercles().get(0).getCor()==t.getListCercles().get(3).getCor())&&(t.getListCercles().get(6).getCor()==t.getListCercles().get(3).getCor())&&(t.getListCercles().get(0).getCor()==t.getAzul()))||((t.getListCercles().get(1).getCor()==t.getListCercles().get(4).getCor())&&(t.getListCercles().get(7).getCor()==t.getListCercles().get(4).getCor())&&(t.getListCercles().get(1).getCor()==t.getAzul()))||((t.getListCercles().get(2).getCor()==t.getListCercles().get(5).getCor())&&(t.getListCercles().get(8).getCor()==t.getListCercles().get(5).getCor())&&(t.getListCercles().get(2).getCor()==t.getAzul()))||((t.getListCercles().get(0).getCor()==t.getListCercles().get(4).getCor())&&(t.getListCercles().get(8).getCor()==t.getListCercles().get(4).getCor())&&(t.getListCercles().get(0).getCor()==t.getAzul()))||((t.getListCercles().get(2).getCor()==t.getListCercles().get(4).getCor())&&(t.getListCercles().get(6).getCor()==t.getListCercles().get(4).getCor())&&(t.getListCercles().get(2).getCor()==t.getAzul()))){
            gagnee = true;
            pt1 = pt1 + 1;
            //azul ganhou
        }
    }
    
    public void setJoueur(){
        premier = !premier;
    }
    
    public void resetServeur(){
        gagnee = false;
        premier = true;
        t.resetCercles();
        t.repaint();
        t.remove(botao);
    }
}
