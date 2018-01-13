import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Simulation {

    void loadItemsIntoList(ArrayList<Item> itemList, String file) throws Exception {

        String line;

        try {
            Scanner scanner = new Scanner(new File(file));
            System.out.println("File " + file + " loaded.");
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                int i = line.indexOf("=");
                Item item = new Item(line.substring(0, i), Integer.parseInt(line.substring(i + 1)));
                itemList.add(item);
            }
            scanner.close();
            System.out.println("Items added.");
//          itemList.sort(Comparator.comparing(Item :: getWeight)); sort by weight
        } catch (FileNotFoundException e) {
            System.out.println("File " + file + " not found! Program shutting down.");
            System.exit(0);
        }
        System.out.println("\n");
    }

    ArrayList<U1> loadU1(ArrayList<Item> list) {

        ArrayList<U1> u1rocket = new ArrayList<>();
        boolean loading = true;
        int i = 0;
        while (loading) {
            U1 u1 = new U1();
            System.out.println("Filling " + u1.name + " rocket number " + (u1rocket.size() + 1) + ".");
            label:
                for ( ; i < list.size(); ) {
                    if (u1.canCarry(list.get(i))) {
                        System.out.println("Item \"" + list.get(i).getName() + "\" is added.");
                        u1.carry(list.get(i));
                        i++;
                        if (i >= list.size()) {
                            u1rocket.add(u1);
                            System.out.println("Loading phase is done.");
                            loading = false;
                            break label;
                        }
                    } else {
                        System.out.println("Item \"" + list.get(i).getName() + "\" weights: " + list.get(i).getWeight() + ". Cargo limit is: " + ( u1.getCargoLimit() - u1.getCargoWeight()) + ".");
                        u1rocket.add(u1);
                        break label;
                    }
                }
        }
        System.out.println("\n");
        return u1rocket;
    }

    ArrayList<U2> loadU2(ArrayList<Item> list) {

        ArrayList<U2> u2rocket = new ArrayList<>();
        boolean loading = true;
        int i = 0;
        while (loading) {
            U2 u2 = new U2();
            System.out.println("Filling " + u2.name + " rocket number " + (u2rocket.size() + 1) + "." );
            label:
                for (; i < list.size(); ) {
                    if (u2.canCarry(list.get(i))) {
                        System.out.println("Item \"" + list.get(i).getName() + "\" is added.");
                        u2.carry(list.get(i));
                        i++;
                        if (i >= list.size()) {
                            u2rocket.add(u2);
                            System.out.println("Loading phase is done.");
                            loading = false;
                            break label;
                        }
                    } else {
                        System.out.println("Item \"" + list.get(i).getName() + "\" weights: " + list.get(i).getWeight() + ". Cargo limit is: " + ( u2.getCargoLimit() - u2.getCargoWeight()) + ".");
                        u2rocket.add(u2);
                        break label;
                    }
                }
        }
        System.out.println("\n");
        return u2rocket;
    }


    public void runSimulation(ArrayList<? extends Rocket> rockets) {

        if (rockets.size() == 0){
            System.out.println("No rockets!");
            return;
        }

        int rNumber = 0;
        boolean exe = false;
        boolean x = true;
        Rocket rocket = null;

        for (int i = 0; i < rockets.size(); i++) {
            while ( x ) {
                rocket = rockets.get(i);
                if (!exe){
                    System.out.println("Launching " + rocket.name + " rockets!");
                    exe = true;
                }
                if (rocket.launch()) {
                    System.out.println("Rocket " + (rNumber + 1) + " launched successfully.");
                    if (rocket.land()) {
                        System.out.println("Rocket " + (rNumber + 1) + " landed successfully.");
                        rNumber++;
                        break;
                    } else {
                        System.out.println("Rocket " + (rNumber + 1) + " exploded during landing! Sending new rocket loaded with the same items.");
                        rNumber++;
                    }
                } else {
                    System.out.println("Rocket " + (rNumber + 1) + " exploded during launching! Sending new rocket loaded with the same items.");
                    rNumber++;
                }
            }
        }
        int totalCost = rNumber * rocket.cost;

        System.out.println("Total cost of mission: " + totalCost + "$, with " + rNumber + " " + rocket.name + " rockets launched.");
        System.out.println("\n");
    }
}
