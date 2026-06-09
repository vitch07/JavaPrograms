package Encapsulation;
public class SuperHeroMain {
    public static void main(String[] args){
        Superhero hero = new Superhero();

        hero.name = "superman";
        hero.superpower = "strength";

        hero.useSuperPower();
        Superhero.general_power();
    }
}
