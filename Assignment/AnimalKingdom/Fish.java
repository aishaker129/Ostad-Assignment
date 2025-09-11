package AnimalKingdom;

public abstract class Fish extends Animal implements Swimmable {

    public Fish(double weight) {
        super(weight);
    }

    @Override
    public void swim() {
        System.out.println("Fish is swimming");
    }

    @Override
    public void breathe() {
        System.out.println("Fish is breath");
    }

    public void layEggs() {
        System.out.println(getClass().getSimpleName()+" eggs");
    }
    
}
