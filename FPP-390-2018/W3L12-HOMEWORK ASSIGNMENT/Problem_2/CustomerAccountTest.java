package Problem_2;

import java.util.Random;
import java.util.Scanner;

public class CustomerAccountTest {

	public static void main(String[] args) throws AccountCheckingException {
		Scanner scanner = new Scanner(System.in);
		String name;
		Random rand = new Random();
		int num = rand.nextInt(9000000) + 1000000;
		String accNo = String.valueOf(num);
		double initialSaving;
		double withdrawAmount;
		int choice = 0;
		System.out.println("Enter your name: ");
		name = scanner.nextLine();
		System.out.println("Enter initial saving amount:");
		initialSaving = scanner.nextDouble();
		if(initialSaving<0) throw new AccountCheckingException("Initial Saving amount cannot be negative");
		
		
		CustomerAccount c = new CustomerAccount(name, accNo, initialSaving);
		System.out.println("Your New account created sucessfully, This is your account Info");
		System.out.println("==========================================================");
		System.out.println(c);
		System.out.println("\n------What would you like to do?-------------------------");
		System.out.println("Enter 1 to withdraw: ");
		System.out.println("Enter 2 to deposit: ");
		System.out.println("Enter 3 to get Balance");
		System.out.println("Enter 4 to Exit");
		System.out.println("----------------------------------------------------");
		do {
			System.out.println("Enter Your Choice : ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter the withdraw amount");
				withdrawAmount = scanner.nextDouble();
				c.withdraw(withdrawAmount);
				break;
			case 2:
				System.out.println("Enter the amount to deposit");
				initialSaving = scanner.nextDouble();

					c.deposit(initialSaving);
					break;
				

			case 3:

				System.out.println("Your Current Balance :" + c.getBalance());
				break;
			case 4:
				System.out.println("Thanks,Good Bye!");
				System.exit(4);
				// break;
			case 5:
				System.out.println("Invalid Choice");
				break;

			}
		} while (choice > 0 && choice <= 4);
	}
}
/*Output
Enter your name: 
thomas
Enter initial saving amount:
500
Your New account created sucessfully, This is your account Info
==========================================================
Name: thomas Acc_No: 9316397 Initial Saving: 500.0

------What would you like to do?----------------------------------------
Enter 1 to withdraw: 
Enter 2 to deposit: 
Enter 3 to get Balance
Enter 4 to Exit
----------------------------------------------------
Enter Your Choice : 
2
Enter the amount to deposit
300
Enter Your Choice : 
3
Your Current Balance :800.0
Enter Your Choice : 
1
Enter the withdraw amount
1000
Exception in thread "main" Problem_2.AccountCheckingException: Sorry!, you dont have sufficient balance to withdrow: withdraw amount shoud be <= 800.0
	at Problem_2.CustomerAccount.withdraw(CustomerAccount.java:40)
	at Problem_2.CustomerAccountTest.main(CustomerAccountTest.java:40)
*/