import constant.MessageConstant;
import model.Animal;
import model.Bird;
import model.Cat;
import model.Dog;
import service.AnimalService;
import service.impl.AnimalServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();
        Animal cat = new Cat("Tam thể", 10);
        Animal dog = new Dog("Chó ngao", 15);
        Animal bird = new Bird("Vịt", 2);

        animals.add(cat);
        animals.add(dog);
        animals.add(bird);

        AnimalService animalService = new AnimalServiceImpl();

        System.out.println(MessageConstant.MenuMessage.MENU);
        System.out.println(MessageConstant.MenuMessage.INPUT_CHOICE);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                List<Animal> animalsSwimmable = animalService.animalsSwimmable(animals);        ;
                if (animalsSwimmable.isEmpty()) {
                    System.out.println(MessageConstant.SuccessMessage.NO_ANIMAL_SWIMMABLE);
                }
                for (Animal animal : animalsSwimmable) {
                    System.out.println(animal.toString());
                }
                break;
            case 2:
                List<Animal> animalsFlyable = animalService.animalsFlyable(animals);        ;
                if (animalsFlyable.isEmpty()) {
                    System.out.println(MessageConstant.SuccessMessage.NO_ANIMAL_SWIMMABLE);
                }
                for (Animal animal : animalsFlyable) {
                    System.out.println(animal.toString());
                }
                break;
            case 3:
                if (animalService.deleteAnimalSwimmable(animals)) {
                    System.out.println();
                } else {

                }
                break;
            case 4:
                break;
            default:
                System.out.println(MessageConstant.ErrorMessage.INVALID_CHOICE);
        }
    }
}