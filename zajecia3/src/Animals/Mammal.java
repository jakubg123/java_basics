package Animals;

class Mammal extends Animal {

    private int numberOfLegs;

    public Mammal(double weight, int age, String name, int numberOfLegs) {
        super(weight, age, name);
        this.numberOfLegs = numberOfLegs;
    }

    private void fightMethod() {
        System.out.println("fightMammal");

    }

    public void speciesInfo() {
        System.out.println("Mammal");
    }

    public void walk() {
        System.out.println("I am walking on " + numberOfLegs + " legs");
    }


}
