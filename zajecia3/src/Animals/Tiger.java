package Animals;

class Tiger extends Mammal implements Carnivorous {
    public Tiger(double weight, int age, String name) {
        super(weight, age, name, 4);
    }

    @Override
    public void hunt() {
        System.out.println("hunting");
    }
}
