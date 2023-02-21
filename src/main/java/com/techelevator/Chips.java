package com.techelevator;

public class Chips extends Product implements Vendable{
    public Chips(String slotID, String name, Double price) {
        super(slotID, name, price);
    }

    @Override
    public void dispense(String ID) {
        super.dispense(ID);
        System.out.println("Crunch Crunch, Yum!");
        super.updateStock();
    }
}
