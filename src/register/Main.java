package register;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

/**
 * Created by jaro on 3.2.2014.
 */
public class Main {
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static String file = System.getProperty("user.home") + System.getProperty("file.separator") + "register.bin";

	public static void main(String[] ArrayRegister) throws Exception {
		readRegisterFromFile();
		int selection = -1;
		System.out.println("Select 1 - register array  2 - list register");
		do {
			System.out.println("Option: ");
			selection = Integer.parseInt(input.readLine());
			if (selection == 1) {
				ArrayRegister lr;
				/** Array register of person */
				if ((lr = (ArrayRegister) readRegisterFromFile()) == null)
				{
					ConsoleUI ui = new ConsoleUI(new ArrayRegister(20));
					ui.run();
				}
				else {
					ConsoleUI ui = new ConsoleUI(lr);
					ui.run();
				}

			} else if (selection == 2) {
				/** ListArray register of person */
				ListRegister lr;
				
				if ((lr = (ListRegister) readRegisterFromFile()) == null){
					ConsoleUI ui = new ConsoleUI(new ListRegister());
					ui.run();
				}
				else {
					ConsoleUI ui = new ConsoleUI(lr);
					ui.run();
				}
			}
		} while (selection <= 0);
	}
	/** Read register from file.
	 * */

	private static Register readRegisterFromFile() throws IOException {
		Register r = null;
		try {
			File f = new File(file);
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			r = (Register) ois.readObject();
			ois.close();
			System.out.println("Register load from file !" + file);
			return r;
		} catch (Exception e) {
			System.out.println("File don't exist !" + file);
		}
		return r;
	}
}