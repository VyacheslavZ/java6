package dz6;

public class Main {
    
    public static void main(String[] args) throws InterruptedException {

        int catQuantity = 10;
        Cat[] cats = new Cat[catQuantity];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("Кот-" + (i + 1), 10 + 4 * i);
        }

        Plate plate = new Plate(100);

        while (true) {
            int foodOnPlate = plate.qtyFood();
            int eatenFoodCounter = 0;
            while (plate.qtyFood() > 0) {
                for (Cat cat : cats) {
                    System.out.println("Количество корма перед кормлением: " + plate.qtyFood()+" едениц.");
                    System.out.println(cat + " Голоден! ");
                    if (cat.getSatiety() == cat.getAppetite()) {
                        System.out.println(cat + " Сытый.");
                    } else {
                        cat.eat(plate);
                        if (cat.getSatiety() != cat.getAppetite()) {
                            System.out.println(cat + " Мало корма, не наелься!");
                            eatenFoodCounter += (foodOnPlate - plate.qtyFood());
                            foodOnPlate = plate.qtyFood();
                            break;
                        } else {
                            System.out.println(cat + " Наелься.");
                            System.out.println("Количество еды после кормления: " + plate.qtyFood() + " едениц.\n");
                            eatenFoodCounter += (foodOnPlate - plate.qtyFood());
                            foodOnPlate = plate.qtyFood();
                        }
                    }
                }
                plate.increaseFood(eatenFoodCounter);
                System.out.println("Миска вновь наполнена на: " + eatenFoodCounter + " едениц корма. " +
                        "Котики снова голодны! \n");
                Thread.sleep(7000);
            }
        }
    }
}

