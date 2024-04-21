import java.util.ArrayList;

public class Agent5 {
    private int posX;
    private int posY;
    private Grille grille;
    private ArrayList<Joyau> sac;
    private static final Agent5 INS = new Agent5(); 

    private Agent5() {
        sac = new ArrayList<>();
        posX = 0;
        posY = 0;
    }

    public void setGrille(Grille g) {
        grille = g;
    }

    public static Agent5 getInst() {
        return INS;
    }


    public static Agent5 getInst(Grille grille) {
        INS.setGrille(grille);
        return INS;
    }

    public void seDeplacer(int xnew, int ynew) throws DeplacementIncorrectException, CaseNonPleineException, CoordonneesIncorrectesException {
        if (grille.sontValides(xnew,ynew)) {
            Contenu contenu = grille.getCase(xnew, ynew);
            if (contenu instanceof Joyau) {
                grille.videCase(xnew, ynew);
                sac.add((Joyau) contenu);
            }
            else if (contenu instanceof Gardien) {
                sac.clear();
            }
            this.posX = xnew;
            this.posY = ynew;
        } else {
            throw new DeplacementIncorrectException("Dépassement");
        }
    }

    public void seDeplacer(int xnew, int ynew, int f) throws DeplacementIncorrectException, CaseNonPleineException, CoordonneesIncorrectesException {
        if (grille.sontValides(xnew,ynew)) {
            // Déplacement valide
            Contenu contenu = grille.getCase(xnew, ynew);

            if (contenu instanceof Joyau) {
                grille.videCase(xnew, ynew);
                sac.add((Joyau) contenu);
                
            } else if (contenu instanceof Gardien) {
                if (((Gardien) contenu).getPointVie() > f) {
                   sac.clear();
                    ((Gardien) contenu).diminuer(f);
                    
                } else  {
                    grille.videCase(xnew, ynew);
                    
                }
            }

            this.posX = xnew;
            this.posY = ynew;
        } else {
            throw new DeplacementIncorrectException("Dépassement");
        }
    }

    public int fortune() {
        int sum = 0;
        for (Joyau j : sac) {
            sum = sum + j.getPrix();
        }
        return sum;
    }

    public String contenuSac() {
        String sacContent = "";
        
        if(sac.size()!=0){
            for (Joyau j : sac) {
                 sacContent=sacContent+j.toString()+"  ";
                }
            
            return sacContent;
        }
        else{
            return "sac est vide";
        }
 
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int x){
        posX=x;
    }
    public void setPosY(int y){
        posY=y;
    }
}
