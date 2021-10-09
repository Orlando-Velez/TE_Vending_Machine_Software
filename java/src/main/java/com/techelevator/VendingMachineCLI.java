package com.techelevator;

import com.techelevator.view.Menu;

import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI extends Inventory {

	private Transactions vendingMachineTransaction;
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
	Scanner reader = new Scanner(System.in);

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
						String moneyOption = moneyToFeed();
						String formatString = String.format("Current Money Provided: $%s", moneyOption);
						System.out.println(formatString);

					}
					if (purchase.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)){
						for (String[] display : getFile()) {
							String formatString = String.format("%s: %-18s $%-5s (%s) Quantity:%d", display[0], display[1], display[2], display[3], START_QUANTITY);
							System.out.println(formatString);
						}
						System.out.println();
						String itemOption = itemCode();
						if(itemOption.startsWith("A")){
							System.out.println(getInfoFromLine().get(itemOption).getItemName() + " $" + getInfoFromLine().get(itemOption).getPrice());
						}
						else if(itemOption.startsWith("B")){
							System.out.println(getInfoFromLine().get(itemOption).getItemName() + " $" + getInfoFromLine().get(itemOption).getPrice());
						}
						else if(itemOption.startsWith("C")){
							System.out.println(getInfoFromLine().get(itemOption).getItemName() + " $" + getInfoFromLine().get(itemOption).getPrice());
						}
						else if(itemOption.startsWith("D")){
							System.out.println(getInfoFromLine().get(itemOption).getItemName() + " $" + getInfoFromLine().get(itemOption).getPrice());
						}

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

	public String moneyToFeed() {

		System.out.println("Insert money in  whole dollar amounts: $1, $2, $5, or $10");
		String userInput = reader.nextLine();
		return userInput;

	}

	public String itemCode(){

		System.out.println();
		System.out.println("Please make a selection: ");
		String userInput = reader.nextLine();
		return userInput;
	}


}
