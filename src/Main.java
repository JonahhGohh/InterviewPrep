import LinkedLists.*;
import StacksAndQueues.*;

public class Main {
    public static void main(String args[]) {
        AnimalShelter animalShelter = AnimalShelter.generateAnimalShelter();
        System.out.println(animalShelter.dequeueAny());
        System.out.println(animalShelter.dequeueDog());
        System.out.println(animalShelter.dequeueCat());
        System.out.println(animalShelter.dequeueCat());
        System.out.println(animalShelter.dequeueCat());
        System.out.println(animalShelter.dequeueCat());
        System.out.println(animalShelter.dequeueAny());
        System.out.println(animalShelter.dequeueAny());
        System.out.println(animalShelter.dequeueAny());
        System.out.println(animalShelter.dequeueAny());
    }
}
