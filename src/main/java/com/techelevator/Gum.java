package com.techelevator;

public class Gum extends Product implements Vendable {
    public Gum(String slotID, String name, Double price) {
        super(slotID, name, price);
    }

    @Override
    public void dispense(String ID) {
        super.dispense(ID);
        System.out.println("Chew Chew, Yum!");
        super.updateStock();
    }
}
