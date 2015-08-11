package register;

/**
 * register.Person register.
 */
@SuppressWarnings("serial")
public class ArrayRegister implements Register {
	/** register.Person array. */
	private Person[] persons;

	/** Number of persons in this register. */
	private int count;

	/**
	 * Constructor creates an empty register with maximum size specified.
	 * 
	 * @param size
	 *            maximum size of the register
	 */
	public ArrayRegister(int size) {
		persons = new Person[size];
		count = 0;
	}

	/**
	 * Returns the number of persons in this register.
	 * 
	 * @return the number of persons in this register
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Returns the maximum number of persons in this register.
	 * 
	 * @return the maximum number of persons in this register.
	 */
	public int getSize() {
		return persons.length;
	}

	/**
	 * Returns the person at the specified position in this register.
	 * 
	 * @param index
	 *            index of the person to return
	 * @return person the person at the specified position in this register
	 */
	public Person getPerson(int index) {
		return persons[index];
	}

	/**
	 * Appends the specified person to the end of this register.
	 * 
	 * @param person
	 *            person to append to this register
	 */
	public void addPerson(Person person) {
		persons[count] = person;
		count++;
	}

	/**
	 * Returns the person with specified name in this register or
	 * <code>null</code>, if match can not be found.
	 * 
	 * @param name
	 *            name of a person to search for
	 * @return person with specified phone number
	 */
	public Person findPersonByName(String name) {
		Person p = new Person(null, null);
		for (int i = 0; i < count; i++) {
			if(name.equals(persons[i].getName()))
			{
				p.setName(persons[i].getName());
				p.setPhoneNumber(persons[i].getPhoneNumber());
			}
		}
		return p;
	}

	/**
	 * Returns the person with specified phone number in this register or
	 * <code>null</code>, if match can not be found.
	 * 
	 * @param phoneNumber
	 *            phone number of a person to search for
	 * @return person with specified phone number
	 */
	public Person findPersonByPhoneNumber(String phoneNumber) {
			Person p = new Person(null, null);
			for (int i = 0; i < count; i++) {
				if(phoneNumber.equals(persons[i].getPhoneNumber()))
				{
					p.setName(persons[i].getName());
					p.setPhoneNumber(persons[i].getPhoneNumber());
				}
			}
			return p;
	}

	/**
	 * Removes the specified person from the register.
	 * 
	 * @param person
	 *            person to remove
	 */
	public void removePerson(Person person) {
		Person p = new Person(null, null);
		for (int i = 0; i < getCount(); i++) {
			p = getPerson(i);
			// if 
			if (p.getName() != null && person.getName().equals(p.getName())) {
				for (int j = i; j < getCount() - 1; j++) {
					persons[j].setName(persons[j + 1].getName());
					persons[j].setPhoneNumber(persons[j + 1].getPhoneNumber());
				}
				count--;
			}
			if (i == getCount()) {
				persons[i].setName(null);
			}
		}
	}

	@Override
	public void ArrayRegister(Person person) {
		// TODO Auto-generated method stub
		persons[count] = person;
		count++;
	}
}
