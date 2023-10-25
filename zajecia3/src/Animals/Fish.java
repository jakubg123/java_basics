package Animals;

class Fish extends Animal {
    public Fish(double weight, int age, String name) {
        super(weight, age, name);
    }

    public void swim() {
        System.out.println("swim");
    }

    @Override
    public void speciesInfo() {
        System.out.println("Fish");
    }
}
