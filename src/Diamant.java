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
