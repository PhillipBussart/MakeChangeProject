//read chapters 1-5 in book
/*Things to check for:
~~~* Amount: .67, Tendered: .50, Result: Error message
~~~* Amount: .67, Tendered: 1.00, Result: 1 quarter, 1 nickel, 3 pennies.
~~~* Amount: .59, Tendered: 1.00, Result: 1 quarter, 1 dime, 1 nickel, 1 penny.
* Amount: 3.96, Tendered: 20.00, Result: 1 ten dollar bill, 1 five dollar bill, 
* 	1 one dollar bill, 4 pennies.
* Amount: any amount less than 20.00, Tendered: anything greater than amount: 
* 	correct denominations for correct change.
 */

package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Prompt user for price of item
		System.out.print("Item price: $");
		double price = sc.nextDouble();

		// Ask for amount tendered by customer
		System.out.print("Amount given: $");
		double payment = sc.nextDouble();

		// Call method checkPayment to check amount is <= price & output if either is
		// true
		checkPayment(price, payment);

		sc.close();
	}

	public static void checkPayment(double price, double payment) {
		double changeDue = calculateChange(price, payment);
		int changeBills[] = new int[8];
		if (price < payment) {
			// call calculateChange
			//double changeDue = calculateChange(price, payment);
			System.out.println("Change is: $" + changeDue);
			changeBills[0] = (int) changeDue / 20; // how many 20s
			changeDue %= 20; // change leftover
			changeBills[1] = (int) changeDue / 10;
			changeDue %= 10;
			changeBills[2] = (int) changeDue / 5;
			changeDue %= 5;
			changeBills[3] = (int) changeDue; // how many 1s
			changeDue %= 1; // returns coins

			changeDue = changeDue * 100; // must make coins ints to continue counting

			changeBills[4] = (int) changeDue / 25;
			changeDue %= 25;
			changeBills[5] = (int) changeDue / 10;
			changeDue %= 10;
			changeBills[6] = (int) changeDue / 5;
			changeDue %= 5;
			changeBills[7] = (int) changeDue;
			// If amount tendered is more than item cost, display change and number of bills
			// and coins that should be given back.
			// Call a method to calculate and display change
			printChange(changeBills); // prints respective bills
		}
		if (price == payment) {
			System.out.println("No change needed.");
		}
		if (price > payment) {
			price = price - payment;
			System.err.println("Payment must be greater than or equal to the item price.");
		}
		if (payment <= 00 || price <= 0) {
			System.err.println("Error: Cash cannot be negative.");
		}
	}

	public static double calculateChange(double price, double payment) {
		// check change for bill and coin denominations
		double changeDue = payment - price;
		// need to round to 2 decimal places

		changeDue = roundChange(changeDue);

		return changeDue;
	}

	public static void printChange(int[] changeBills) {

		System.out.println(changeBills[0] + " Twenties");
		System.out.println(changeBills[1] + " Tens");
		System.out.println(changeBills[2] + " Fives");
		System.out.println(changeBills[3] + " Ones");
		System.out.println(changeBills[4] + " Quarters");
		System.out.println(changeBills[5] + " Dimes");
		System.out.println(changeBills[6] + " Nickels");
		System.out.println(changeBills[7] + " Pennies");

	}

	public static double roundChange(double changeDue) {

		changeDue = changeDue * 100.0;

		double remainder = (changeDue % (int) changeDue);
		if (remainder != 0.00) {
			if (remainder >= 0.5) {
				changeDue = (int)changeDue + 1.0;
			} else if (remainder < 0.5) {
				changeDue = (int)changeDue - 1.0;
			}
		}

		changeDue = changeDue / 100.00;

		return changeDue;
	}

}
