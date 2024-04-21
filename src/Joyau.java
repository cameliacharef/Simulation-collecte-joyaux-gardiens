
public abstract class Joyau extends Contenu {

    public static final int X = 5;
    public Joyau(String type, int quantite) {
        super(type, quantite);
    }

    protected int generateRandomPrix() {
        return (int) (Math.random() * (X * 1000) + 1);
    }

    public abstract int getPrix() ;

    public static Joyau getRandomJoyau() {
        int randType = (int) (Math.random() * 3); 

        switch (randType) {
            case 0:
                return new Diamant(1); 
            case 1:
                return new Rubis(1);
            case 2:
                return new Opale(1);
            default:
                return new Diamant(1); 
        }
    }

}
