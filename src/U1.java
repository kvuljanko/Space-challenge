public class U1 extends Rocket {

    U1(){
        super( "U1", 100000000, 10000, 18000);
    }

    @Override
    public boolean launch() {
        double chanceOfExplosion = 10 * ( (double) getCargoWeight() / getCargoLimit()) / 100;
        double value = Math.random();
        return value > chanceOfExplosion;
    }

    @Override
    public boolean land() {
        double chanceOfCrash = 2 * ( (double) getCargoWeight() / getCargoLimit()) / 100;
        double value = Math.random();
        return value > chanceOfCrash;
    }
}
