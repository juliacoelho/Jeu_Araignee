package araignee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
--------------------------------------------------------------------------------
LES COMMENTAIRES DU CODE AINSI QUE LES EXPLICATIONS CONCERNANTS LA METHODOLOGIE
ADOPTEE SONT DANS LE RAPPORT CI JOINT
--------------------------------------------------------------------------------
Julia COELHO SANTOS
Vinicius PODENCE NATIVIO
*/


public class Araignee {

    public static void main(String[] args) {
        
        JFrame f = new JFrame("Araignée");
        f.setSize(520, 560);
        Tabuleiro t = new Tabuleiro();
        f.setContentPane(t);
        f.setLayout(null);
        
        JLabel Placar1 = new JLabel();
        JLabel Placar2 = new JLabel();
        JButton Botao = new JButton("Nouveau Jeu");
        JButton Fermer = new JButton("Fermer"); 
        
        Serveur s = new Serveur(t, Placar1, Placar2, Botao);
        t.addMouseListener(s);
        
        Botao.addActionListener(new ActionListener() { 
        @Override
        public void actionPerformed(ActionEvent e) { 
        s.resetServeur();
        }});
        
        Fermer.addActionListener(new ActionListener() { 
        @Override
        public void actionPerformed(ActionEvent e) { 
        System.exit(0);
        }});
        
        Placar1.setLocation(200, 430);
        Placar1.setSize(100,100);
        t.add(Placar1);
        Placar2.setLocation(200, 450);
        Placar2.setSize(100,100);
        t.add(Placar2);
        Botao.setLocation(300, 470);
        Botao.setSize(150,30);
        Fermer.setLocation(50, 475);
        Fermer.setSize(80,30);
        t.add(Fermer);
                
        f.setVisible(true);
    }
    
}
