package machine;

public class Coffee {
    private int water;
    private int milk;
    private int coffee;
    private int cost;

    public Coffee(int water, int milk, int coffee, int cost) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.cost = cost;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffee() {
        return coffee;
    }

    public int getCost() {
        return cost;
    }
}
