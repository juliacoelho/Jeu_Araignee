package araignee;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

public class Tabuleiro extends JPanel{
    
    private final List<Circulos> listCercles = new ArrayList<>();
    private final Color amarelo = Color.YELLOW;
    private final Color azul = Color.BLUE;
    private final Color vermelho = new Color(255, 200, 200, 200);
    private final Color preto = Color.BLACK;
    private final Color transparente = new Color(255, 200, 200, 0);
    private Color colorUser;
    private int nbPignons;

    
    public Tabuleiro() {
        
        super();
        nbPignons = 0;
        colorUser = amarelo;
        Circulos circ0 = new Circulos(40,40,20,transparente);
        Circulos circ1 = new Circulos(240,40,20,transparente);
        Circulos circ2 = new Circulos(440,40,20,transparente);
        Circulos circ3 = new Circulos(40,240,20,transparente);
        Circulos circ4 = new Circulos(240,240,20,transparente);
        Circulos circ5 = new Circulos(440,240,20,transparente);
        Circulos circ6 = new Circulos(40,440,20,transparente);
        Circulos circ7 = new Circulos(240,440,20,transparente);
        Circulos circ8 = new Circulos(440,440,20,transparente);
        
        listCercles.add(circ0);
        listCercles.add(circ1);
        listCercles.add(circ2);
        listCercles.add(circ3);
        listCercles.add(circ4);
        listCercles.add(circ5);
        listCercles.add(circ6);
        listCercles.add(circ7);
        listCercles.add(circ8);
              
        circ0.addAdj(circ1);circ0.addAdj(circ3);circ0.addAdj(circ4);
        circ1.addAdj(circ0);circ1.addAdj(circ2);circ1.addAdj(circ4);
        circ2.addAdj(circ1);circ2.addAdj(circ4);circ2.addAdj(circ5);
        circ3.addAdj(circ0);circ3.addAdj(circ4);circ3.addAdj(circ6);
        circ4.addAdj(circ0);circ4.addAdj(circ1);circ4.addAdj(circ2);
        circ4.addAdj(circ3);circ4.addAdj(circ5);circ4.addAdj(circ6);
        circ4.addAdj(circ7);circ4.addAdj(circ8);
        circ5.addAdj(circ2);circ5.addAdj(circ4);circ5.addAdj(circ8);
        circ6.addAdj(circ3);circ6.addAdj(circ4);circ6.addAdj(circ7);
        circ7.addAdj(circ4);circ7.addAdj(circ6);circ7.addAdj(circ8);
        circ8.addAdj(circ4);circ8.addAdj(circ5);circ8.addAdj(circ7);
    }

    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        g.setColor(preto);
        g.drawLine(50,50,250,50);
        g.drawLine(250,50,450,50);
        g.drawLine(50,250,250,250);
        g.drawLine(250,250,450,250);
        g.drawLine(50,450,250,450);
        g.drawLine(250,450,450,450);
        g.drawLine(50,50,50,250);
        g.drawLine(50,250,50,450);
        g.drawLine(250,50,250,250);
        g.drawLine(250,250,250,450);
        g.drawLine(450,50,450,250);
        g.drawLine(450,250,450,450);
        g.drawLine(50,50,250,250);
        g.drawLine(250,250,450,50);
        g.drawLine(50,450,250,250);
        g.drawLine(250,250,450,450);
        for (Circulos c : listCercles){
            g.setColor(c.getCor());
            g.fillOval(c.getCoordx(), c.getCoordy(), c.getDiam(), c.getDiam());
        }
    }
    public Color setcolorUser(boolean b){
        if (b){
            return azul;
        }
        return amarelo;
    }
    
    public int getNbPignons() {
        return nbPignons;
    }

    public void setNbPignons() {
        nbPignons = nbPignons+1;
    }
    
    public void adjLivre(Circulos c){
        for (Circulos o : c.getCircadj()){
            if(o.isLivre()){
                o.setCor(vermelho);
            }
        }      
    }
    
    public void sansRouge(){
        for (Circulos o : listCercles){
            if(o.getCor() == vermelho){
                o.setCor(transparente);
            }
        }
    }
    
    public void resetCercles(){
        for (Circulos o : listCercles){
            o.setCor(transparente);
            o.setLivre();
        }
        nbPignons = 0;
        colorUser = amarelo;
    }

    public List<Circulos> getListCercles() {
        return listCercles;
    }

    public Color getTransparente() {
        return transparente;
    }

    public Color getVermelho() {
        return vermelho;
    }

    public Color getAzul() {
        return azul;
    }

    public Color getAmarelo() {
        return amarelo;
    }
    
    
    
    
}