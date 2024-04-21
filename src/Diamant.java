//CHAREF CAMELIA 21202057
//BEN MIMOUN SARAH 28713241
public class Diamant extends Joyau {
    private int prix;
    public Diamant(int quantite) {
        
        super("Diamant",quantite);
        this.prix = generateRandomPrix();
    }

    public int getPrix() {
        return prix;
    }

    

}