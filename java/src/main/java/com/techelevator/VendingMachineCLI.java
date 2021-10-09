package com.techelevator;

import com.techelevator.view.Menu;

import java.math.BigDecimal;

public class VendingMachineCLI extends Inventory{

	private Inventory vendingMachineInventory;
	private Chips chips;
	private Beverages beverages;
	private Product product;
	private Inventory map;

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTIONS = "Finish Transactions";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTIONS};


	private Menu menu;



	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				for (String[] display : getFile()) {
					String formatString = String.format("%s: %-18s  $%-5s Quantity:%d", display[0], display[1], display[2] ,START_QUANTITY);
					System.out.println(formatString);
				}
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while (true) {
					String purchase = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					if(purchase.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
						System.out.println();
						String moneyInput = moneyToFeed();
						String formatString = String.format("Current Money Provided: $%s", moneyInput);
						System.out.println(formatString);
					}
					if (purchase.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)){
						for (String[] display : getFile()) {
							String formatString = String.format("%s: %-18s $%-5s (%s) Quantity:%d", display[0], display[1], display[2], display[3], START_QUANTITY);
							System.out.println(formatString);
						}
						System.out.println();
						String choiceInput = itemCode();
						if(choiceInput.startsWith("A")){
							System.out.println(getInfoFromLine().get(choiceInput).getItemName() + " $" + getInfoFromLine().get(choiceInput).getPrice());
						}
						else if(choiceInput.startsWith("B")){
							System.out.println(getInfoFromLine().get(choiceInput).getItemName() + " $" + getInfoFromLine().get(choiceInput).getPrice());
						}
						else if(choiceInput.startsWith("C")){
							System.out.println(getInfoFromLine().get(choiceInput).getItemName() + " $" + getInfoFromLine().get(choiceInput).getPrice());
						}
						else if(choiceInput.startsWith("D")){
							System.out.println(getInfoFromLine().get(choiceInput).getItemName() + " $" + getInfoFromLine().get(choiceInput).getPrice());
						}
						System.out.println("Your Change is: $" + balanceRemaining());
						}
//					}	if(itemOption.){
//						System.out.println("***Item Does Not Exist Returning To Menu***");
					if(purchase.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTIONS)){

					}

				}
				// do purchase
			}
			else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				//exit menu
				System.exit(1);
			}

		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}


}
