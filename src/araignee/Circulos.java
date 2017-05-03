package araignee;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Circulos {
    
    private final int coordx,coordy,diametro;
    private Color cor;
    private boolean livre = true;
    private final List<Circulos> circadj = new ArrayList<>();
    
    public Circulos(int x, int y, int diam, Color couleur){
        
        coordx = x;
        coordy = y;
        diametro = diam;
        cor = couleur;
    }

    public int getCoordx(){
        return coordx;
    }

    public int getCoordy(){
        return coordy;
    }
    
    public int getDiam(){
        return diametro;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor){
        this.cor = cor;
    }
    
    public void setOcupado(){
        livre = false;
    }
    
    public void setLivre(){
        livre = true;
    }
    
    public void addAdj(Circulos c){
        circadj.add(c);
    }   

    public List<Circulos> getCircadj(){
        return circadj;
    }

    public boolean isLivre(){
        return livre;
    }
    
    
}
