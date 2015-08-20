package core;

import java.io.Serializable;

/**
 * Persons consist from name and phone number.
 */
public class Person implements Comparable<Person>, Serializable {
	private static final long serialVersionUID = 1L;

	/** Person name. */
	private String name;

	/** Person phone number. */
	private String phoneNumber;

	/**
	 * Construct a person.
	 * 
	 * @param name
	 *            Person name
	 * @param phoneNumber
	 *            Person phone number
	 */
	public Person(String name, String phoneNumber) {
		this.name = name;
		this.setPhoneNumber(phoneNumber);
	}

	/**
	 * Returns name of person.
	 * 
	 * @return person name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set person name.
	 * 
	 * @param name
	 *            person name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Return phone number of person.
	 * 
	 * @return phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets phone number of person. Only valid phone number.
	 * 
	 * @param phoneNumberNew
	 *            person phone number
	 */
	public void setPhoneNumber(String phoneNumberNew) {
		if (!isValidPhoneNumber(phoneNumberNew)) {
			throw new RuntimeException("Phone number is not valid");
		}
		phoneNumber = phoneNumberNew;
	}

	/**
	 * Validates the phone number. Valid phone numbers contains only digits.
	 * 
	 * @param phoneNumber
	 *            phone number to validate
	 * @return <code>true</code> if phone number is valid, <code>false</code>
	 *         otherwise
	 */
	private boolean isValidPhoneNumber(String phoneNumber) {
		if (phoneNumber != null) {
			for (char c : phoneNumber.toCharArray()) {
				if (!Character.isDigit(c))
					return false;
			}
		}
		return true;
	}

	/**
	 * Returns a string representation of the person.
	 * 
	 * @return string representation of the person.
	 */
	public String toString() {
		return name + " (" + phoneNumber + ")";
	}

	/** Compare person by name. Using only for ListRegister. */
	@Override
	public int compareTo(Person person) {
		return this.name.compareTo(person.name);
	}
}
