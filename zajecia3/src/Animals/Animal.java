package Animals;

public class Animal {

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
    public void whoAmI(){

        System.out.println(getName() + " " + getAge() + " " + getWeight());

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




    public void speciesInfo(){
        System.out.println("None");
    }
}



