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
		
		//Prompt user for price of item
		System.out.print("Item price: $");
		double price = sc.nextDouble();
		
		//Ask for amount tendered by customer
		System.out.print("Amount given: $");
		double payment = sc.nextDouble();
		
		//Output if amount was too little or exact change
		checkPayment(price, payment);
		
		
		//Call method checkPayment to check amount is <= price & output if either is true
		
		//If amount tendered is more than item cost, display change and number of bills and coins
		//that should be given back.
		
		//Call a method to calculate and display change, perhaps within checkPayment
		
		sc.close();
	}
	
	public static void checkPayment(double price, double payment) {
		if (price < payment) {
			//call calculateChange
			double change = calculateChange(price, payment);
			System.out.println("Your change is: $" + change);
		}
		if (price == payment) {
			System.out.println("No change needed.");
		}
		if (price > payment) {
			price = price - payment;
			System.out.println("Amount still owed: $" + price); //possibly make loop so customer can give more
		}
	}
	
	public static double calculateChange (double price, double payment) {
		//check change for bill and coin denominations
		double change = payment - price;
		
		return change;
	}
	public static double changeDollars(double change) {
		double changeDollars = 0.0;
		//take change and divide by 1 to get cents
		//if (change % 1 != 0) {
		//}
		
		return changeDollars;
	}
	public static double changeCents (double change) {
		//set change to cents value
		double changeCents = change % (int)change; //cast to int for whole number
		
		return changeCents;
	}

}
