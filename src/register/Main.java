package register;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import consoleui.ConsoleUI;

/**
 * Register of persons. Choose selection type of list.
 */
public class Main {
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] ArrayRegister) throws Exception {
		int selection = -1;
		System.out.println("Select 1 - register array  2 - list register");
		do {
			System.out.println("Option: ");
			selection = Integer.parseInt(input.readLine());
			if (selection < 3) {
				ConsoleUI ui = new ConsoleUI(selection);
				ui.run();
			}
			/**Skuska git hub commit*/
		} while (selection <= 0);
	}
}