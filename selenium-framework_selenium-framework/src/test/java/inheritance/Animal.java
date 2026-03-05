package inheritance;

class Animal {

    void eat() {
        System.out.println("Animal is eating");
    }
    
    
}

class Dog extends Animal {

    void bark() {
        System.out.println("Dog is barking");
    }
    
//    @Override
//    void eat() {
//        System.out.println("Dog is eating");
//    }
}