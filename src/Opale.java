
public class Opale extends Joyau {
    private int prix;
    public Opale(int quantite) {
        super("Opale",quantite);
        this.prix = generateRandomPrix();
        
    }

    public int getPrix() {
        return prix;
    }
}
