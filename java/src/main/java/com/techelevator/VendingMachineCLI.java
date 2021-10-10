package com.techelevator;

import com.techelevator.view.Menu;

import java.io.IOException;
import java.math.BigDecimal;

public class VendingMachineCLI  extends Inventory {

	private Inventory vendingMachineInventory = new Inventory();
	private Beverages beverages;

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
					String formatString = String.format("%s: %-18s  $%-5s Quantity: %d", display[0], display[1], display[2], startQuantity);
					System.out.println(formatString);
				}
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while (true) {
					String purchase = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					if(purchase.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
						System.out.println();
						moneyToFeed();
						String formatString = String.format("Current Money Provided: $%s", balance);
						System.out.println(formatString);

						try {
							logFile(String.format("%s FEED MONEY: \\$%s", dayTime(), balance));
						} catch (IOException e) {
							e.printStackTrace();
						}

					}
					if (purchase.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)){
						for (String[] display : getFile()) {
							String formatString = String.format("%s: %-18s $%-5s %-6s Quantity:%d", display[0], display[1], display[2], display[3], startQuantity);
							System.out.println(formatString);
						}
						System.out.println();
						String choiceInput = itemCode();

						if(startQuantity <= 0) {
							System.out.println("***Item SOLD OUT Returning To Menu***");
							break;
						}
						else if(choiceInput.startsWith("A") && startQuantity >= 1){ {
								decreaseCount();
							}
							System.out.println();
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
						else if(choiceInput.isEmpty() || !choiceInput.startsWith("A") || !choiceInput.startsWith("B") || !choiceInput.startsWith("C") || !choiceInput.startsWith("D")){
							System.out.println("***Item Does Not Exist Returning To Menu***");
							break;
						}

						System.out.println();
						System.out.println("Your Remaining Balance is: $" + balanceRemaining(getInfoFromLine().get(choiceInput)));

						try {
							logFile(String.format("%s %s %s \\$%s", dayTime(), getInfoFromLine().get(choiceInput).getItemName(), choiceInput, balance));
						} catch (IOException e) {
							e.printStackTrace();
						}
						}
//					}	if(itemOption.){
//						System.out.println("***Item Does Not Exist Returning To Menu***");
					if(purchase.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTIONS)){
						System.out.println("Your Change is:");
						System.out.println(changeBack());
//						try {
//							logFile(getInfoFromLine().get(choiceInput).getItemName());
//						} catch (IOException e) {
//							e.printStackTrace();
//						}
						System.exit(1);
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
