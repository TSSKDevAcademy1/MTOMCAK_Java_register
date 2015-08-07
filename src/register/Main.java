package register;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * Created by jaro on 3.2.2014.
 */
public class Main {
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] ArrayRegister) throws Exception {
		int selection = -1;
		System.out.println("Select 1 - register array  2 - list register");
		do {
			System.out.println("Option: ");
			selection = Integer.parseInt(input.readLine());
			if (selection == 1) {
				/** Array register of person */
				ArrayRegister lr = new ArrayRegister(20);
				ConsoleUI ui = new ConsoleUI(lr);
				ui.run();
			} else if (selection == 2) {
				/** ListArray register of person */
				ListRegister lr = new ListRegister();
				ConsoleUI ui = new ConsoleUI(lr);
				ui.run();
			}

		} while (selection <= 0);
	}
}
