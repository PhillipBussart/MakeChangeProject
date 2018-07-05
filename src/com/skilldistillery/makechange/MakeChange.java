//push to git hourly!!!
//read chapters 1-5 in book
/*Things to check for:
* Amount: .67, Tendered: .50, Result: Error message
* Amount: .67, Tendered: 1.00, Result: 1 quarter, 1 nickel, 3 pennies.
* Amount: .59, Tendered: 1.00, Result: 1 quarter, 1 dime, 1 nickel, 1 penny.
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

		String changeNames[] = { "twenties", "tens", "fives", "ones", 
				"quarters", "dimes", "nickels", "pennies" }; //names for output

		// Prompt user for price of item
		System.out.print("Item price: $");
		double price = sc.nextDouble();

		// Ask for amount tendered by customer
		System.out.print("Amount given: $");
		double payment = sc.nextDouble();

		// Call method checkPayment to check amount is <= price & output if either is
		// true
		checkPayment(price, payment);

		// If amount tendered is more than item cost, display change and number of bills
		// and coins that should be given back.

		// Call a method to calculate and display change, perhaps within checkPayment

		sc.close();
	}

	public static void checkPayment(double price, double payment) {
		if (price < payment) {
			// call calculateChange
			double change = calculateChange(price, payment);
			System.out.println("Your change is: $" + change);
			change = changeAmount(change);//might need to change variable on left side?
		}
		if (price == payment) {
			System.out.println("No change needed.");
		}
		if (price > payment) {
			price = price - payment;
			System.out.println("Amount still owed: $" + price); // possibly make loop so customer can give more
		}
	}

	public static double calculateChange(double price, double payment) {
		// check change for bill and coin denominations
		double change = payment - price;

		
		return change;
	}

	//need to use changeAmount to calculate how many bills/coins necessary for change
	//then return the appropriate names in changeNames. Might need to move changeNames to main
	public static double changeAmount(double change) {
		//double changeAmount = change;
		
		
		double changeNumbers[] = {20.00, 10.00, 5.00, 1.00, 
				0.25, 0.10, 0.05, 0.01}; //amounts that go with the names for output
		
		//need code to count how many times each of changeAmounts occurs, then output changeNames
		//for loop?
		for (int i = 0; i < changeNumbers.length; i++) {
			if ((int)change % 20 == 0) { //if divisible by 20
				changeNumbers[0] = (int)change / 20; 
				//this currently sets first position of array to change/20.
			}
			if ((int)change % 10 == 0) {
				changeNumbers[1] = (int)change / 10;
			}
			if ((int)change % 5 == 0) {
				changeNumbers[2] = (int)change / 5;
			}
			changeNumbers[3] = () //need to set 1s to whatever is left
		}
		
		
		// take change and divide by 1 to get cents
		// if (change % 1 != 0) {
		// }

		return change;//possibly returning array
	}
//
//	public static double changeCents(double change) {
//		// set change to cents value
//		double changeCents = change % (int) change; // cast to int for whole number
//
//		return changeCents;
//	}

}
