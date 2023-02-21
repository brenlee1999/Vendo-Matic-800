package com.techelevator;

import com.techelevator.view.Menu;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String MAIN_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String MAIN_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String MAIN_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
    private static final String[] PURCHASE_MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_FEED_MONEY, MAIN_MENU_OPTION_SELECT_PRODUCT, MAIN_MENU_OPTION_FINISH_TRANSACTION};
    private Menu menu;
    private Product product = new Product();

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        product.readInFile();
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                // display vending machine items
                displayItems();
            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                // do purchase
                purchase();
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                break;
            }
        }
    }



    public void displayItems() {
        try (BufferedReader br = new BufferedReader(new FileReader("vendingmachine.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectProduct(){
        displayItems();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an ID: ");
        String userInput = input.nextLine();
        product.dispense(userInput);
    }

    public void purchase() {
        while (true) {
            System.out.println("Current Money Provided: " /*Money user added*/);
            String choice = (String) menu.getChoiceFromOptions(PURCHASE_MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_FEED_MONEY)) {
                // call feed money method
            } else if (choice.equals(MAIN_MENU_OPTION_SELECT_PRODUCT)) {
                // select product
                selectProduct();
                //Ask for user Input, user chooses slotID to select product.
                //If product code does not exist, inform user and return to purchase();
                //If the product is out of stock, inform user and return to purchase();
                //If selected product is valid, dispense the item, call dispense() method.
            } else if (choice.equals(MAIN_MENU_OPTION_FINISH_TRANSACTION)) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }
}
