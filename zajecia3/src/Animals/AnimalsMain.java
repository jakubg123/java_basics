package Animals;

public class AnimalsMain {

    public static void main(String [] args){

        Mammal elephant = new Elephant(500, 10, "test");
        Mammal tiger = new Tiger(200, 5, "test2");
        Bird sparrow = new Sparrow(300, 2, "test3");
        Fish shark = new Shark(400, 8, "test5");

        elephant.whoAmI();
        elephant.eat();
        elephant.sleep();
        elephant.speciesInfo();
        elephant.walk();

        tiger.whoAmI();
        tiger.eat();
        tiger.sleep();
        tiger.speciesInfo();
        tiger.walk();

        sparrow.whoAmI();
        sparrow.eat();
        sparrow.sleep();
        sparrow.speciesInfo();
        sparrow.fly();

        shark.whoAmI();
        shark.eat();
        shark.sleep();
        shark.speciesInfo();
        shark.swim();

        ((Carnivorous) tiger).hunt();

        ((Carnivorous) shark).hunt();
    }

}
