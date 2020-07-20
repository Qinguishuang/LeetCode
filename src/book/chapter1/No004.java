package book.chapter1;

import java.util.LinkedList;
import java.util.Queue;

public class No004 {
    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private int count;

    public No004() {
        dogQ = new LinkedList<PetEnterQueue>();
        catQ = new LinkedList<PetEnterQueue>();
        count = 0;
    }

    public void add(Pet pet) {
        if (pet.getType().equals("dog")) {
            dogQ.add(new PetEnterQueue(pet, count++));
        } else {
            catQ.add(new PetEnterQueue(pet, count++));
        }
    }

    public Pet pollAll() {
        if (!dogQ.isEmpty() && !catQ.isEmpty()) {
            if (dogQ.peek().getCount() < catQ.peek().getCount()) {
                return dogQ.poll().getPet();
            } else {
                return catQ.poll().getPet();
            }
        } else if (!dogQ.isEmpty()) {
            return dogQ.poll().getPet();
        } else if (!catQ.isEmpty()) {
            return catQ.poll().getPet();
        } else {
            throw new RuntimeException("queue is empty");
        }
    }
}

class PetEnterQueue {
    private Pet pet;
    private int count;

    public PetEnterQueue(Pet pet, int count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public int getCount() {
        return count;
    }

    public String getEnterPetType() {
        return pet.getType();
    }
}

class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class Dog extends Pet {

    public Dog(String type) {
        super("dog");
    }
}

class Cat extends Pet {

    public Cat(String type) {
        super("cat");
    }
}
