public class Rocket implements  SpaceShip{

    protected final String name;
    protected final int cost;
    protected final int rocketWeight;
    protected final int maxWeight;
    private int cargoWeight;

    public Rocket(String name, int cost, int rocketWeight, int maxWeight){
        this.name = name;
        this.cost = cost;
        this.rocketWeight = rocketWeight;
        this.maxWeight = maxWeight;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public int getCargoLimit(){
        return maxWeight - rocketWeight;
    }

    public void carry(Item item) {
        this.cargoWeight += item.getWeight();
    }

    public boolean canCarry(Item item) {
        return cargoWeight + item.getWeight() <= getCargoLimit();
    }

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

}
