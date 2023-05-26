package com.shanks.solid;

public class InterfaceSegregation {


}

interface CoffeeMachine {
    void loadCoffee(Coffee coffee);
    void brewFilteredCoffee();
    void brewEspresso();
}

class FilteredCoffeeMachine implements CoffeeMachine{
    @Override
    public void loadCoffee(Coffee coffee) {
        System.out.println("Loaded "+coffee.getName());
    }

    @Override
    public void brewFilteredCoffee() {
        System.out.println("Brewing Filtered Coffee");
    }

    @Override
    public void brewEspresso() {
        System.out.println("Not Allowed, as I can't brew Espresso");
    }
}

class Coffee{
    private final String name;

    public Coffee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

