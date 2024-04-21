//CHAREF CAMELIA 21202057
//BEN MIMOUN SARAH 28713241


public class TeleportableGardien extends Gardien implements Teleportable{

    public TeleportableGardien(int quantite){
        super(quantite);
    }

    public void teleporter(int newX, int newY, double chanceTeleportation) { 

        if (Math.random()< chanceTeleportation) {
            this.setPosition(newX, newY);
        }
    }
}
