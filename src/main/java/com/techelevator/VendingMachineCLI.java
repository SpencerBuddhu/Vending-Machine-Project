package com.techelevator;

import com.techelevator.view.Menu;

import java.util.Scanner;

public class VendingMachineCLI {

	Scanner inputScan = new Scanner(System.in);

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private static final String SUB_MENU_FEED_MONEY = "Feed Money";
	private static final String SUB_MENU_SELECT_PRODUCT = "Select Product";
	private static final String SUB_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] SUB_MENU_OPTIONS = {SUB_MENU_FEED_MONEY, SUB_MENU_SELECT_PRODUCT, SUB_MENU_FINISH_TRANSACTION};

	private Menu menu;

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachine machine = new VendingMachine();
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
		machine.addToInventoryList();
	}

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {

		boolean vending = true;
		Balance balance = new Balance();
		VendingMachine machine = new VendingMachine();
		machine.addToInventoryList();

		while (vending) {

			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				machine.printInventory();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase

				System.out.println();
				System.out.println("Your current balance is $" + balance.getBalance());
				String purchaseChoice = (String)menu.getChoiceFromOptions(SUB_MENU_OPTIONS);
				if(purchaseChoice.equals(SUB_MENU_FEED_MONEY)){
					try {
						System.out.println("How much money would you like to insert?");
						String inputMoney = inputScan.nextLine();
						Double moneyAdded = Double.parseDouble(inputMoney);
						balance.setBalance(moneyAdded);
						System.out.println("Your current balance is $" + balance.getBalance());
						} catch (NumberFormatException e) {
						System.out.println("Input must be an integer");
					}
				} else if (purchaseChoice.equals(SUB_MENU_SELECT_PRODUCT)) {
					try{
						machine.printInventory();
						System.out.println();
						System.out.println("Your current balance is $" + balance.getBalance());
						System.out.println();
						System.out.println("Please select item code >>> ");
						String itemCodeInput = inputScan.nextLine();
						//Purchase methods after selection
						if (machine.getCurrentProduct(itemCodeInput).getNumberOFItems() > 0) {
							balance.purchase(machine.readInventoryForPrice(itemCodeInput));
							machine.adjustStock(itemCodeInput);
							System.out.println(machine.inventoryItemLine(itemCodeInput));
							System.out.println("Your new balance is: $" + balance.getBalance());
							System.out.println();
							System.out.println(machine.itemSound(itemCodeInput));
						} else {
							System.out.println("Item is out of Stock!");
						}
					} catch (Exception e) {
						System.out.println("Invalid item code");
					}
				}
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Your change is: $"+ balance.getBalance());
				vending = false;
			}
		}
	}
}
