
import java.util.ArrayList;

public class Simulation{
    private Agent5 agent;
    private Grille grille;
    private Contenu[] contenus;

    public Simulation(int m, Grille grille) throws CoordonneesIncorrectesException {
        this.grille = grille;
        this.agent = Agent5.getInst(grille);
        this.agent.setPosX(0); 
        this.agent.setPosY(0);   
        contenus = new Contenu[m];

        for (int i = 0; i < m; i++) {
            int x = (int) (Math.random() * grille.nbLignes);
            int y = (int) (Math.random() * grille.nbColonnes);

            Joyau randomJoyau = Joyau.getRandomJoyau(); 
            if (Math.random() < 0.6) {
                contenus[i] = randomJoyau;
            } else {
                contenus[i] = new Gardien((int) (Math.random() * 10));
            }

            grille.setCase(x, y, contenus[i]);
        }
    }


    public String toString() {
        String result = "";

        result += "Contenu de la grille:\n";
        ArrayList<Contenu> grilleContenus = grille.lesContenus();
        for (Contenu contenu : grilleContenus) {
            result += contenu.toString() + "\n";
        }
  
        result += "Information sur l'agent:\n";
        result += "Position de l'agent: (" + agent.getPosX() + ", " + agent.getPosY() + ")\n";
        result += "Fortune de l'agent: " + agent.fortune() + "\n";
        result += "Contenu du sac de l'agent: " +agent.contenuSac() + "\n";
    
        return result;
    }

    public void lance(int nbEtapes) throws DeplacementIncorrectException, CaseNonPleineException, CoordonneesIncorrectesException {
        for (int i = 0; i < nbEtapes; i++) {

            int xNew;
            int yNew;
            int force = 0;

            if (Math.random() < 0.3) {
                // 30% de chance de faire un déplacement avec force
                force = (int) (Math.random() * 91) + 10; 
            }

            // Choisir une case voisine aléatoire
            do {
                xNew = agent.getPosX() + (int) (Math.random() * 3) - 1; // -1, 0, ou 1
                yNew = agent.getPosY() + (int) (Math.random() * 3) - 1; // -1, 0, ou 1
            } while (!grille.sontValides(xNew, yNew));


            if (force!=0){
                agent.seDeplacer(xNew, yNew, force);
            }
            else{
                agent.seDeplacer(xNew, yNew);
            }

 
            System.out.println("Étape " + (i + 1) + ":");
            System.out.println("Déplacement de l'agent vers la position (" + xNew + ", " + yNew + ")");
            System.out.println("Force utilisée: " + force);
            System.out.println("Nouvelle position de l'agent: (" + agent.getPosX() + ", " + agent.getPosY() + ")");
            System.out.println("Fortune de l'agent: " + agent.fortune());
            System.out.println("Contenu du sac de l'agent: " );
            System.out.println(agent.contenuSac());

            
}
            
        }
    }


