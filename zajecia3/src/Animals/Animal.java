package Animals;
interface Carnivorous{
    void hunt();
}

public abstract class Animal {

    private double weight;
    private int age;
    private String name;

    public Animal(double weight, int age, String name){
        this.weight = weight;
        this.age = age;
        this.name = name;
    }

    public void eat(){
        System.out.println("eat");
    }
    public void sleep(){

        System.out.println("sleep");

    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public double getWeight(){
        return weight;
    }


    public void whoAmI(){

        System.out.println(getName() + " " + getAge() + " " + getWeight());

    }

    public abstract String getSpecies();
}

class Mammal extends Animal{

    private int numberOfLegs;

    public Mammal(double weight, int age, String name, int numberOfLegs) {
        super(weight, age, name);
        this.numberOfLegs = numberOfLegs;
    }

    private void fightMethod() {
        System.out.println("fightMammal");

    }

    public String getSpecies(){
        return "Mammal";
    }

    public void walk(){
        System.out.println("I am walking on " + numberOfLegs + " legs");
    }

}

class Bird extends Animal{
    public Bird(double weight, int age, String name){
        super(weight, age, name);
    }

    public void fly(){
        System.out.println("fly");
    }

    public String getSpecies(){
        return "Bird";
    }
}

class Fish extends Animal{
    public Fish(double weight, int age, String name) {
        super(weight, age, name);
    }
        public void swim(){
            System.out.println("swim");
        }

    public String getSpecies(){
        return "Fish";
    }
}

class Elephant extends Mammal {
    public Elephant(double weight, int age, String name) {
        super(weight, age, name, 4);
    }
}

class Tiger extends Mammal implements Carnivorous {
    public Tiger(double weight, int age, String name) {
        super(weight, age, name, 4);
    }

    @Override
    public void hunt() {
        System.out.println("hunting");
    }
}

class Sparrow extends Bird {
    public Sparrow(double weight, int age, String name) {
        super(weight, age, name);
    }
}

class Owl extends Bird {
    public Owl(double weight, int age, String name) {
        super(weight, age, name);
    }
}

class Crucian extends Fish {
    public Crucian(double weight, int age, String name) {
        super(weight, age, name);
    }
}

class Shark extends Fish implements Carnivorous {
    public Shark(double weight, int age, String name) {
        super(weight, age, name);
    }

    @Override
    public void hunt() {
        System.out.println("I'm hunting.");
    }
}



