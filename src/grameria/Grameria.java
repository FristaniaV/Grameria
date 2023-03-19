package grameria;

import java.util.ArrayList;
import java.util.Scanner;

public class Grameria {

	Scanner scan = new Scanner(System.in);
	ArrayList<String> itemList = new ArrayList<String>();
	ArrayList<Integer> priceList = new ArrayList<Integer>();
	ArrayList<Integer> qtyList = new ArrayList<Integer>();
	ArrayList<Integer> totalList = new ArrayList<Integer>();
	ArrayList<String> choosedList = new ArrayList<String>();

	String name;
	int qty;
	int firstItem;
	int qty1;
	int totalPrice;

	public Grameria() {
		Menu();
	}

	public void Menu() {

		int choose;

		itemList.add("Adventures of Huckleberry Finn by Mark Twain");
		itemList.add("Anna Karenina by Leo Tolstoy");
		itemList.add("Na Honjaman Lebel-eob by Chugong");
		itemList.add("Faber-Castell Pencil 2b");
		itemList.add("Zebra Sarasa Clip Pen 0.5 mm");
		itemList.add("Joyko Scissor");

		priceList.add(50000);
		priceList.add(60000);
		priceList.add(70000);
		priceList.add(5000);
		priceList.add(17000);
		priceList.add(8000);

		do {
			System.out.println("Grameria");
			System.out.println("==========================");
			System.out.println("1. Insert Transaction");
			System.out.println("2. Delete Transaction");
			System.out.println("3. Exit");
			System.out.print("Choose >> ");
			choose = scan.nextInt();
			scan.nextLine();
		} while (choose > 3 || choose < 1);

		if (choose == 1) {
			Insert();
		} else if (choose == 2) {
			Delete();
		} else if (choose == 3) {
			System.exit(0);
		}
	}

	public void Insert() {

		do {
			try {
				System.out.print("Input Customer Name [5 - 20 character] : ");
				name = scan.nextLine();
			} catch (Exception e) {
				System.out.println("Customer Name Length Must Between [5 - 20 character]");
			}
		} while (name.length() > 20 || name.length() < 5);

		do {
			try {
				System.out.print("Input How Many items " + name + " want to buy  [1-5] : ");
				qty = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				System.out.println("items must between [1-5]");
			}
		} while (qty > 5 || qty < 1);

		System.out.println("List Item");

		for (int i = 0; i < itemList.size(); i++) {
			System.out.println((i + 1) + " | " + itemList.get(i) + " | " + priceList.get(i));
		}

		for (int i = 0; i < qty; i++) {
			do {
				try {
					System.out.print("Input item-(" + (i + 1) + ") [1-6] : ");
					firstItem = scan.nextInt(); scan.nextLine();
				} catch (Exception e) {
					System.out.println("Must be [1-6]");
				}
			} while (firstItem > 6 || firstItem < 1);
		
			do {
				try {
					System.out.print("Input Quantity for item " + itemList.get(firstItem - 1) + " [1-20] : ");
					qty1 = scan.nextInt(); scan.nextLine();
				} catch (Exception e) {
					System.out.println("The Quantity must between [1-20]");
				}
			} while (qty1 < 1 || qty1 > 20);
			choosedList.add(itemList.get(firstItem));
			qtyList.add(qty1);
			
			totalList.add(priceList.get(i) * qtyList.get(i));
			totalPrice = totalList.get(i) + totalPrice;
		}

		System.out.println();
		System.out.println("Bill");
		System.out.println("-------------------------------------");
		System.out.println("Customer Name: " + name);
		System.out.println("Item(s)");
		System.out.println("=====================================");
		
		
		for (int i = 0; i > qty; i++) {
			System.out.println((i+1) + " | " + choosedList.get(i) + " @" + qtyList.get(i) + "pcs | " + totalList.get(i));
		}
		System.out.println("Total Price -> " + totalPrice);
	}

	public void Delete() {

	}

	public static void main(String[] args) {
		new Grameria();

	}

}
