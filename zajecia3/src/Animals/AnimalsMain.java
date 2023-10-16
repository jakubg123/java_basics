package Animals;

public class AnimalsMain {

    public static void main(String [] args){

        Mammal elephant = new Elephant(500, 10, "test");
        Animal tiger = new Tiger(200, 5, "test2");
        Animal sparrow = new Sparrow(300, 2, "test3");
        Animal shark = new Shark(400, 8, "test5");

        elephant.whoAmI();
        elephant.eat();
        elephant.sleep();
        System.out.println(elephant.getSpecies());
        elephant.walk();

        tiger.whoAmI();
        tiger.eat();
        tiger.sleep();
        elephant.getSpecies();

        sparrow.whoAmI();
        sparrow.eat();
        sparrow.sleep();
        elephant.getSpecies();

        shark.whoAmI();
        shark.eat();
        shark.sleep();
        elephant.getSpecies();

        if (tiger instanceof Carnivorous) {
            ((Carnivorous) tiger).hunt();
        }

        if (shark instanceof Carnivorous) {
            ((Carnivorous) shark).hunt();
        }
    }

}
