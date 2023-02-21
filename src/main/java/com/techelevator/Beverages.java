package com.techelevator;

public class Beverages extends Product implements Vendable{
    public Beverages(String slotID, String name, Double price) {
        super(slotID, name, price);
    }

    @Override
    public void dispense(String ID) {
        super.dispense(ID);
        System.out.println("Glug Glug, Yum!");
        super.updateStock();
    }
}
