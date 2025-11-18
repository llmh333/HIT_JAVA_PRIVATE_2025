package service.impl;

import model.Animal;
import service.AnimalService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AnimalServiceImpl implements AnimalService {
    @Override
    public List<Animal> animalsSwimmable(List<Animal> animals) {
        List<Animal> result = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.swim()) {
                result.add(animal);
            }
        }
        return result;
    }

    @Override
    public List<Animal> animalsFlyable(List<Animal> animals) {
        List<Animal> result = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.fly()) {
                result.add(animal);
            }
        }
        return result;
    }

    @Override
    public boolean deleteAnimalSwimmable(List<Animal> animals) {

        Iterator<Animal> iterator = animals.iterator();
        while (iterator.hasNext()) {
            Animal animal = iterator.next();
            if (animal.swim()) {
                iterator.remove();
            }
        }
        return true;

    }

    @Override
    public boolean deleteAnimalSwimmableAndFlyable(List<Animal> animals) {
        Iterator<Animal> iterator = animals.iterator();
        while (iterator.hasNext()) {
            Animal animal = iterator.next();
            if (animal.fly() && animal.swim()) {
                iterator.remove();
            }
        }
        return true;
    }
}
