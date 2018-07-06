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

		String changeNames[] = { "Twenties", "Tens", "Fives", "Ones", 
				"Quarters", "Dimes", "Nickels", "Pennies" }; //names for output
		double changeNumbers[] = {20.00, 10.00, 5.00, 1.00, 
				0.25, 0.10, 0.05, 0.01}; //amounts that go with the names for output

		// Prompt user for price of item
		System.out.print("Item price: $");
		double price = sc.nextDouble();

		// Ask for amount tendered by customer
		System.out.print("Amount given: $");
		double payment = sc.nextDouble();

		// Call method checkPayment to check amount is <= price & output if either is
		// true
		checkPayment(price, payment);
		double change = calculateChange(price, payment);
			changeNumbers[0] = (int)change / 20;
				change = change - 20 * changeNumbers[0];
			changeNumbers[1] = (int)change / 10;//divide remainder from above calculation by 10
				change = change - 10 * changeNumbers[1];	
			changeNumbers[2] = (int)change / 5;//divide remainder from above calculation by 5
				change = change - 5 * changeNumbers[2];
			changeNumbers[3] = (int)change;//print out remaining numbers after above 3 calculations are done
				change = change - (int)change;
			changeNumbers[4] = change / 0.25;//same as above 4, except decimals
				change = change - changeNumbers[4];
			changeNumbers[5] = change / 0.10;
				change = change - changeNumbers[5];
			changeNumbers[6] = change / 0.05;
				change = change - changeNumbers[6];
			changeNumbers[7] = change;
			
		// If amount tendered is more than item cost, display change and number of bills
		// and coins that should be given back.
		// Call a method to calculate and display change

		sc.close();
	}

	public static void checkPayment(double price, double payment) {
		double change = calculateChange(price, payment);
		if (price < payment) {
			// call calculateChange
			System.out.println("Change is: $" + change);
			//change = changeAmount(change);//might need to change variable on left side?
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
//	public static void changeAmount(double[] changeNumbers) {
//		//double changeAmount = change;
//		//need code to count how many times each of changeAmounts occurs, then output changeNames
//		//for loop?
//		for (int i = 0; i < changeNumbers.length; i++) {
//			if ((int)change % 20 == 0) { //if divisible by 20
//				changeNumbers[0] = (int)change / 20;
//				//this sets first position of array to change/20.
//			}
//			if ((int)change % 10 == 0) {
//				changeNumbers[1] = (int)change / 10;
//			}
//			if ((int)change % 5 == 0) {
//				changeNumbers[2] = (int)change / 5;
//			}
//			changeNumbers[3] = ((int) change - changeNumbers[0] - changeNumbers[1] - changeNumbers[2]); //need to set 1s to whatever is left
//		}
		
		
		// take change and divide by 1 to get cents
		// if (change % 1 != 0) {
		// }

//		return change;//possibly returning array
//	}
//
//	public static double changeCents(double change) {
//		// set change to cents value
//		double changeCents = change % (int) change; // cast to int for whole number
//
//		return changeCents;
//	}

}
