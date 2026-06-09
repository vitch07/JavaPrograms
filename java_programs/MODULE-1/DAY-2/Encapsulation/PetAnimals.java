package Encapsulation;

public class PetAnimals extends Animal implements Bird {
    protected  String petname;
    protected  boolean isVaccinated;

    public PetAnimals(String name, String type, String petname, boolean isVaccinated){
        super(name,type);
        this.petname = petname;
        this.isVaccinated = isVaccinated;
    }

    @Override
    public void fly() {
        System.out.println("The " + this.petname + " is  flying");
    }
    @Override
    public void sound(){
        System.out.println("THe " + this.petname + "is making sound");
    }
}
