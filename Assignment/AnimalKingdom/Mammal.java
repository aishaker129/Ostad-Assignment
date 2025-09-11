package AnimalKingdom;

public abstract class Mammal extends Animal implements Walkable{

    public Mammal(double weight) {
        super(weight);
    }

    @Override
    public void walk(){
        System.out.println("Mammal is walking");
    }

    @Override
    public void breathe() {
        System.out.println("Mammal is breath");
    }

    public void growHair(){
        System.out.println(getClass().getSimpleName()+" hair");
    }

    
    
}
