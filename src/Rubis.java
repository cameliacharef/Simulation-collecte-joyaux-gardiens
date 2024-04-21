//CHAREF CAMELIA 21202057
//BEN MIMOUN SARAH 28713241
public class Rubis extends Joyau {
    private int prix;
    public Rubis(int quantite) {
        super("Rubis",quantite);
        this.prix = generateRandomPrix();
    }


    public int getPrix() {
        return prix;
    }

}