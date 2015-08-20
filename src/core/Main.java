package core;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import consoleui.ConsoleUI;

/**
 * Register of persons, consist from persons with name and phone number.
 * Choose selection type of list.
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
		} while (selection <= 0);
	}
}