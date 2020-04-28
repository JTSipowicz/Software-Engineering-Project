package CurrencyExchange;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner; 
//import java.util.HashMap;

public class AppEngine {
	// Menu View Static Identifiers
	static int mainMenu = 0;
	static int accountRegistration = 1;
	static int accountLogin = 2;
	static int currencyExchange = 3;

	double USDtoEUR = .92;
	double EURtoUSD = 1/USDtoEUR;
	double USDtoYen = 107.27;
	double YentoUSD = 1/USDtoYen;
	double USDtoPound = .81;
	double PoundtoUSD = 1/USDtoPound;
	double EURtoYen = 116.13;
	double YentoEUR = 1/EURtoYen;
	double EURtoPound = .87;
	double PoundtoEUR = 1/EURtoPound;
	double YentoPound = .0075;
	double PoundtoYen = 1/YentoPound;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Hashmap Creation
		//HashMap<Account, String> accountHashMap = new HashMap<>();

		// List Creation
		List<Account> accountList = new ArrayList<Account>();
		
		int menuSelector = 0;
		System.out.println("Welcome to my Currency Application");
		Scanner integerScanner = new Scanner(System.in);

		while(menuSelector == mainMenu) {
		System.out.println("** Main Menu **");
		System.out.println("Select and option:");
		System.out.println("1: Login to account");
		System.out.println("2: Create an account");
		System.out.println("3: Make a transfer");
		System.out.println("4: Exit Application");

		int inputInt = integerScanner.nextInt();
			if(inputInt == 1) {
				menuSelector = 1;
				System.out.println("** Login **");
				System.out.println("NOT IMPLEMENTED YET");
			}else if(inputInt == 2) {
				menuSelector = 2;
				Scanner stringScanner = new Scanner(System.in);
				String tempUser, tempPass, tempEmail;
				System.out.println("** Create an Account **");
				System.out.println("Please enter a username: ");
				tempUser = stringScanner.nextLine();
				System.out.println("Please enter a password: ");
				tempPass = stringScanner.nextLine();
				System.out.println("Please enter an email: ");
				tempEmail = stringScanner.nextLine();
				accountList.add(new Account(tempUser, tempPass, tempEmail));
				System.out.println("Account successfully added! :) ");
			} else if(inputInt == 3) {
				menuSelector = 3;
				Scanner intScanner = new Scanner(System.in);
				System.out.println("Please choose one of the following currencies to transfer from: ");
				System.out.println("(1) USD");
				System.out.println("(2) EUR");
				System.out.println("(3) Yen");
				System.out.println("(4) Pound");
				int currencyFrom = intScanner.nextInt();
				System.out.println("Please choose one of the following currencies to transfer from: ");
				System.out.println("(1) USD");
				System.out.println("(2) EUR");
				System.out.println("(3) Yen");
				System.out.println("(4) Pound");
				int currencyTo = intScanner.nextInt();
				System.out.println("How much currency would you like to spend?");
				double currencySpent = intScanner.nextDouble();
				double transactionFee, deliveryFee, taxFee;
				transactionFee = currencySpent*.01;
				deliveryFee = 10.0;
				taxFee = currencySpent*.0825;
				double currencyAfterFees = currencySpent - transactionFee - deliveryFee - taxFee;
				break;
			} else if(inputInt == 4) {
				System.out.println("** Exit **");
				System.exit(0);
				break;
			}else {
				System.out.println("Invalid Input");
			}
			menuSelector = 0;
		}
		integerScanner.close();
		System.out.println(accountList.toString());
		System.out.println("Implemented by: James Sipowicz, Mason Watson, Tyler Hansen, Jafeth Zuniga");
	}
}
