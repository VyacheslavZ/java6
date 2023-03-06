package dz6;

public class Cat {

    private String name;
    private int appetite;
    private int satiety = 0;

    public Cat(String name) {
        this(name, 10);
//        this.name = name;
//        this.appetite = 10;
//        satiety = false;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
//        satiety = false;

        Thread backgroundSatietyManagement = new Thread(() -> {
            while (true) {
                if (satiety > 0) satiety -= 1;
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        backgroundSatietyManagement.setDaemon(true);
        backgroundSatietyManagement.start();
    }

    public void eat(Plate plate) {
        if ((satiety < appetite) && (plate.qtyFood() >= (appetite - satiety))) {
            plate.decreaseFood(appetite - satiety);
            satiety = appetite;
        } else if (((satiety < appetite) && (plate.qtyFood() < (appetite - satiety)))) {
            satiety = satiety + plate.qtyFood();
            plate.decreaseFood(plate.qtyFood());
        }
    }

    public int getAppetite() {
        return appetite;
    }

    public int getSatiety() {
        return satiety;
    }

    @Override
    public String toString() {
        return name + "{Аппетит=" + appetite + ", Сытость=" + satiety + "}";
    }
}
