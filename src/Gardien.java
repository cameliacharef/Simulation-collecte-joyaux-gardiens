//CHAREF CAMELIA 21202057
//BEN MIMOUN SARAH 28713241
public class Gardien extends Contenu{
    private int points;
    public Gardien(int quantite){
        super("Gardien",quantite);
        this.points = (int)(Math.random()*200);
    }
    public Gardien(Gardien other) {
        super(other.type, other.getQuantite());
        this.points = other.points;
    }

    public int getPointVie(){
        return points;
    }

    public void diminuer(int f){
        points=points-f;
    }
}