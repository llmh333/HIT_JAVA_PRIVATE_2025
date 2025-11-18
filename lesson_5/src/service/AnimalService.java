package service;

import model.Animal;

import java.util.List;

public interface AnimalService {

    public List<Animal> animalsSwimmable(List<Animal> animals);
    public List<Animal> animalsFlyable(List<Animal> animals);

    public boolean deleteAnimalSwimmable(List<Animal> animals);
    public boolean deleteAnimalSwimmableAndFlyable(List<Animal> animals);

}
