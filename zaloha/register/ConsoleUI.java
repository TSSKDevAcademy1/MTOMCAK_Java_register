package register;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.PhantomReference;
import java.util.Formatter;

/**
 * User interface of the application.
 */
public class ConsoleUI {
	/** register.Register of persons. */
	private Register register;

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

	public ConsoleUI(Register register) {
		this.register = register;
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

	// TODO: Implement the method printRegister
	private void printRegister() {
		System.out.println();
		for (int i = 0; i < register.getCount(); i++) {
			if (register.getPerson(i).getName() != null)
				System.out.printf("%d. %s\n", i + 1, register.getPerson(i).toString());
		}
		System.out.println();
	}

	private void addToRegister() {
		Person p = new Person(null, null);
		
		// insert Name
		System.out.println("Enter Name: ");
		String name = readLine();
		System.out.println(register.findPersonByName(name));
		
		if ( register.findPersonByName(name).getName() != null)
		{
			System.out.println("Person with same name exist !");
			return;
		}
		p.setName(name);
		
		// insert PhoneNumber
		System.out.println("Enter Phone Number: ");
		String phoneNumber = readLine();
		
		if ( register.findPersonByPhoneNumber(phoneNumber).getPhoneNumber() != null)
		{
			System.out.println("Person with same phoneNumber exist !");
			return;
		}
		p.setPhoneNumber(phoneNumber);
		register.addPerson(p);
		System.out.println("Add person: " + name + " (" + phoneNumber + ") sucessful !");
	}

	// TODO: Implement the method updateRegister
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

	// TODO: Implement the method findInRegister
	private void findInRegister() {
		System.out.println("Enter Name or phone number ! ");
		String insert = readLine();
		try {
			Integer.parseInt(insert);
			System.out.println(register.findPersonByPhoneNumber(insert));
		} catch (Exception e) {
			System.out.println(register.findPersonByName(insert));
		}
	}

	private void removeFromRegister() {
		System.out.println("Enter index: ");
		int index = Integer.parseInt(readLine());
		Person person = register.getPerson(index - 1);
		register.removePerson(person);
	}

}
