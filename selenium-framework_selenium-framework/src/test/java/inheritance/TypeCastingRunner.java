package inheritance;

public class TypeCastingRunner {

    public static void main(String[] args) {

        Animal a = new Dog();  // Upcasting

        // Downcasting and calling child method
        ((Dog)a).bark();

        // Downcasting and calling inherited parent method
        ((Dog)a).eat();
    }
}