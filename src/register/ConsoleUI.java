package register;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User interface of the application.
 */
public class ConsoleUI {
	/** register.Register of persons. */
	private Register register;
	private RegisterLoader regLoad = new FileRegisterLoader();

	/**
	 * In JDK 6 use Console class instead.
	 * 
	 * @see readLine()
	 */
	private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Menu options.
	 */
	private enum Option {
		PRINT, ADD, UPDATE, REMOVE, FIND, EXIT
	};

	/**
	 * Select arrayList or arrayRegister by choice
	 * 
	 * @throws IOException
	 */
	public ConsoleUI(int choice) throws IOException {
		if (regLoad.readRegisterFromFile() != null) {
			this.register = regLoad.readRegisterFromFile();
		} else {
			// TODO Auto-generated catch block
			if (choice == 1)
				this.register = new ArrayRegister(20);
			else if (choice == 2)
				this.register = new ListRegister();
			registerFill();
		}
	}

	/** Fill register of persons */
	private void registerFill() {
		// add person into the Register - ArrayRegister
		register.ArrayRegister(new Person("Janko Hrasko 1", "0900123456"));
		register.ArrayRegister(new Person("Janko Patocka 2", "0904512548"));
		register.ArrayRegister(new Person("Dodo Hrasko 3", "0904587458"));
		register.ArrayRegister(new Person("Janko Rusnak 4", "0904125489"));
		register.ArrayRegister(new Person("Janka Hraskova 5", "0905124789"));
	}

	public void run() {
		while (true) {
			switch (showMenu()) {
			case PRINT:
				printRegister();
				break;
			case ADD:
				addToRegister();
				break;
			case UPDATE:
				updateRegister();
				break;
			case REMOVE:
				removeFromRegister();
				break;
			case FIND:
				findInRegister();
				break;
			case EXIT:
				regLoad.saveRegister(register);
				return;
			}
		}
	}

	private String readLine() {
		// In JDK 6.0 and above Console class can be used
		// return System.console().readLine();
		try {
			return input.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	private Option showMenu() {
		System.out.println("Menu.");
		for (Option option : Option.values()) {
			System.out.printf("%d. %s%n", option.ordinal() + 1, option);
		}
		System.out.println("-----------------------------------------------");

		int selection = -1;
		do {
			System.out.println("Option: ");
			selection = Integer.parseInt(readLine());
		} while (selection <= 0 || selection > Option.values().length);

		return Option.values()[selection - 1];
	}

	/** Print register */
	private void printRegister() {
		System.out.println();
		for (int i = 0; i < register.getCount(); i++) {
			if (register.getPerson(i).getName() != null)
				System.out.printf("%d. %s\n", i + 1, register.getPerson(i).toString());
		}
		System.out.println();
	}

	/**
	 * Add person into to register, only for unique user name and phone number.
	 */
	private void addToRegister() {
		Person p = new Person(null, null);

		// insert Name
		System.out.println("Enter Name: ");
		String name = readLine();

		if (register.findPersonByName(name).getName() != null) {
			System.out.println("Person with same name exist !");
			return;
		}
		p.setName(name);

		// insert PhoneNumber
		System.out.println("Enter Phone Number: ");
		String phoneNumber = readLine();

		if (register.findPersonByPhoneNumber(phoneNumber).getPhoneNumber() != null) {
			System.out.println("Person with same phoneNumber exist !");
			return;
		}
		p.setPhoneNumber(phoneNumber);
		register.ArrayRegister(p);

		System.out.println("Add person: " + name + " (" + phoneNumber + ") sucessful !");
	}

	/** Update specified value (phone number or name) person in register */
	private void updateRegister() {
		// select person in register for update
		System.out.println("Enter index: ");
		int index = Integer.parseInt(readLine());
		Person person = register.getPerson(index - 1);

		// update name of person
		System.out.println("Enter Name: ");
		person.setName(readLine());

		// update Phone number
		System.out.println("Enter Phone Number: ");
		person.setPhoneNumber(readLine());
	}

	/** Find person in register by phone number or name. */
	private void findInRegister() {
		System.out.println("Enter Name or phone number ! ");
		String insert = readLine();
		// if inserted value is integer find person by phoneNumber
		try {
			Integer.parseInt(insert);
			System.out.println(register.findPersonByPhoneNumber(insert));
		} catch (Exception e) {
			System.out.println(register.findPersonByName(insert));
		}
	}

	/** Remove person from register. */
	private void removeFromRegister() {
		System.out.println("Enter index: ");
		int index = Integer.parseInt(readLine());
		Person person = register.getPerson(index - 1);
		register.removePerson(person);
	}
}
