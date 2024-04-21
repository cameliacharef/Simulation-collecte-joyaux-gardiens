
public class TestSimulation {
    public static void main(String[] args) {

        Grille grille = new Grille(5,5);
        

        try {
            Simulation simulation = new Simulation(100, grille);

            System.out.println("Initial State:");
            System.out.println(simulation.toString());

            simulation.lance(100);
            

            System.out.println("Final State:");
            System.out.println(simulation.toString());
        } catch (DeplacementIncorrectException e){ 
            System.out.println(e);
        }
        catch (CaseNonPleineException e){
            System.out.println(e);
        }
        catch (CoordonneesIncorrectesException e){ 
            System.out.println(e);
        }
    }
}
