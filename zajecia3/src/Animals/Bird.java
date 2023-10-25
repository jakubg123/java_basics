package Animals;

class Bird extends Animal {
    public Bird(double weight, int age, String name) {
        super(weight, age, name);
    }

    public void fly() {
        System.out.println("fly");
    }

    public void speciesInfo() {
        System.out.println("Bird");
    }
}
