package com.techelevator;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

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
	}

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {

		boolean vending = true;

		while (vending) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			VendingMachine machine = new VendingMachine();
			Balance balance = new Balance();

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				machine.readInventory();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				boolean buying = true;
				machine.readInventory();
				System.out.println();
				System.out.println("Your current balance is " + balance.getBalance());
				String purchaseChoice = (String)menu.getChoiceFromOptions(SUB_MENU_OPTIONS);
				if(purchaseChoice.equals(SUB_MENU_FEED_MONEY)){
					try {
						System.out.println("How much money would you like to insert?");
						} catch (Exception e) {
						e.printStackTrace();
					}

				}


			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				vending = false;
			}
		}

	}

}
