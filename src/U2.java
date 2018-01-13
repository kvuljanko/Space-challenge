public class U2 extends Rocket {

    U2(){
        super( "U2", 120000000, 18000, 29000);
    }

    @Override
    public boolean launch() {
        double chanceOfExplosion = 8 * ( (double) getCargoWeight() / getCargoLimit()) / 100;
        double value = Math.random();
        return value > chanceOfExplosion;
    }

    @Override
    public boolean land() {
        double chanceOfCrash = 16 * ( (double) getCargoWeight() / getCargoLimit()) / 100;
        double value = Math.random();
        return value > chanceOfCrash;
    }
}
