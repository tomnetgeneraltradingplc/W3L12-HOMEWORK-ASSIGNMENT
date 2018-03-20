package Problem_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputOfMark {
	public static void main(String[] args) {
		double mark = 0.0;
		while (true) {
			System.out.println("Enter your mark here: ");
			try {
				Scanner scanner = new Scanner(System.in);
				mark = scanner.nextDouble();
				if (mark < 0 || mark > 100)
					throw new UnsupportedOperationException("Marks must be in the range of 0 to 100");
				else {
					System.out.println("Your score is : " + mark);
					break;
				}
			} catch (InputMismatchException | UnsupportedOperationException e) {
				System.out.println("Your input is not correct,Try again, with correct Input?");
				System.out.println(e);
			}
		}
	}
}
/*Output
Enter your mark here: 
105
Your input is not correct,Try again, with correct Input?
java.lang.UnsupportedOperationException: Marks must be in the range of 0 to 100
Enter your mark here: 
fifty
Your input is not correct,Try again, with correct Input?
java.util.InputMismatchException
Enter your mark here: 
-80
Your input is not correct,Try again, with correct Input?
java.lang.UnsupportedOperationException: Marks must be in the range of 0 to 100
Enter your mark here: 
90
Your score is : 90.0
*/