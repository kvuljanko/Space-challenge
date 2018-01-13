import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception  {

        Simulation simulation = new Simulation();

        ArrayList<Item> items = new ArrayList<>();
        ArrayList<U1> u1rockets = new ArrayList<>();
        ArrayList<U2> u2rockets = new ArrayList<>();

        simulation.loadItemsIntoList(items, "phase-1.txt");
        simulation.loadItemsIntoList(items, "phase-2.txt");

        u1rockets.addAll(simulation.loadU1(items));
        u2rockets.addAll(simulation.loadU2(items));

        System.out.println("Number of U1 rockets: " + u1rockets.size());
        System.out.println("Number of U2 rockets: " + u2rockets.size());
        System.out.println("\n");

        simulation.runSimulation(u1rockets);
        simulation.runSimulation(u2rockets);

    }
}
