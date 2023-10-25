package Animals;

class Shark extends Fish implements Carnivorous {
    public Shark(double weight, int age, String name) {
        super(weight, age, name);
    }

    @Override
    public void hunt() {
        System.out.println("I'm hunting.");
    }
}
