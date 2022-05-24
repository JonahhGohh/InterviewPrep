package StacksAndQueues;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AnimalShelter {
    Queue<AnimalInfo> catQueue;
    Queue<AnimalInfo> dogQueue;
    int order;

    public AnimalShelter() {
        catQueue = new LinkedList<>();
        dogQueue = new LinkedList<>();
        order = 0;
    }

    public AnimalShelter(List<Animal> lst) {
        for (Animal animal : lst) {
            if (animal instanceof Cat) {
                catQueue.add(new AnimalInfo(animal, order));
            } else {
                catQueue.add(new AnimalInfo(animal, order));
            }
            order++;
        }
    }

    public static AnimalShelter generateAnimalShelter() {
        AnimalShelter animalShelter = new AnimalShelter();
        animalShelter.enqueue(new Dog("dog1"));
        animalShelter.enqueue(new Cat("cat2"));
        animalShelter.enqueue(new Dog("dog3"));
        animalShelter.enqueue(new Dog("dog4"));
        animalShelter.enqueue(new Cat("cat5"));
        animalShelter.enqueue(new Cat("cat6"));
        animalShelter.enqueue(new Dog("dog7"));
        animalShelter.enqueue(new Dog("dog8"));

        return animalShelter;
    }

    public void enqueue(Animal animal) {
        if (animal instanceof Cat) {
            catQueue.add(new AnimalInfo(animal, order));
        } else {
            dogQueue.add(new AnimalInfo(animal, order));
        }
        order++;
    }

    public Animal dequeueAny() {
        if (catQueue.size() == 0 && dogQueue.size() == 0) {
            return null;
        } else if (catQueue.size() == 0) {
            return dogQueue.poll().animal;
        } else if (dogQueue.size() == 0) {
            return catQueue.poll().animal;
        } else {
            if (catQueue.peek().order <= dogQueue.peek().order) {
                return catQueue.poll().animal;
            } else {
                return dogQueue.poll().animal;
            }
        }
    }

    public Dog dequeueDog() {
        if (dogQueue.size() == 0) {
            return null;
        }
        return (Dog) dogQueue.poll().animal;
    }

    public Cat dequeueCat() {
        if (catQueue.size() == 0) {
            return null;
        }
        return (Cat) catQueue.poll().animal;
    }
}

class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

class AnimalInfo {
    Animal animal;
    int order;

    AnimalInfo(Animal animal, int order) {
        this.animal = animal;
        this.order = order;
    }

    @Override
    public String toString() {
        return animal.toString() + ": " + order;
    }
}
