package dz6;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int foodToDecrease) {
        food = food - foodToDecrease;
    }

    public void increaseFood(int foodToIncrease) {
        food = food + foodToIncrease;
    }

    public Integer qtyFood() {
        return food;
    }

    @Override
    public String toString() {
        return "Plate[" + food + "]";
    }

}
