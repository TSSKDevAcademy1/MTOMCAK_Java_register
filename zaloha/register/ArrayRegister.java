package register;

import java.awt.List;
import java.util.ArrayList;

/**
 * register.Person register.
 */
public class ArrayRegister implements Register {
	/** register.Person array. */
	ArrayList<Person> ListRegister = new ArrayList<Person>();
	//private Person[] persons;

	/** Number of persons in this register. */
	private int count;

	/**
	 * Constructor creates an empty register with maximum size specified.
	 * 
	 * @param size
	 *            maximum size of the register
	 */
	/*
	public ArrayRegister(int size) {
		ListRegister.
		persons = new Person[size];
		count = 0;
	}
*/
	/* (non-Javadoc)
	 * @see register.Register#getCount()
	 */
	@Override
	public int getCount() {
		return ListRegister.size();
	}

	/* (non-Javadoc)
	 * @see register.Register#getSize()
	 */
	/*
	@Override
	public int getSize() {
		return lis
	}
*/
	/* (non-Javadoc)
	 * @see register.Register#getPerson(int)
	 */
	@Override
	public Person getPerson(int index) {
		return ListRegister.get(index);
	}

	/* (non-Javadoc)
	 * @see register.Register#addPerson(register.Person)
	 */
	@Override
	public void addPerson(Person person) {
		ListRegister.add(person);
//		persons[count] = person;
//		count++;
	}

	// TODO: Implement the method findPersonByName
	/* (non-Javadoc)
	 * @see register.Register#findPersonByName(java.lang.String)
	 */
	@Override
	public Person findPersonByName(String name) {
		Person p = new Person(null, null);
		for (int i = 0; i < ListRegister.size(); i++) {
			if(name.equals(ListRegister.get(i).getName()))
			{
				p.setName(ListRegister.get(i).getName());
				p.setPhoneNumber(ListRegister.get(i).getPhoneNumber());
			}
		}
		return p;
	}

	// TODO: Implement the method findPersonByPhoneNumber
	/* (non-Javadoc)
	 * @see register.Register#findPersonByPhoneNumber(java.lang.String)
	 */
	@Override
	public Person findPersonByPhoneNumber(String phoneNumber) {
			Person p = new Person(null, null);
			for (int i = 0; i < count; i++) {
				if(phoneNumber.equals(ListRegister.get(i).getPhoneNumber()))
				{
					p.setName(ListRegister.get(i).getName());
					p.setPhoneNumber(ListRegister.get(i).getPhoneNumber());
				}
			}
			return p;
	}

	// TODO: Implement the method removePerson
	/* (non-Javadoc)
	 * @see register.Register#removePerson(register.Person)
	 */
	@Override
	public void removePerson(Person person) {
		Person p = new Person(null, null);
		for (int i = 0; i < getCount(); i++) {
			p = getPerson(i);
			if (p.getName() != null && person.getName().equals(p.getName())) {
				for (int j = i; j < getCount() - 1; j++) {
					ListRegister.get(j).setName(ListRegister.get(j + 1).getName());
					ListRegister.get(j).setPhoneNumber(ListRegister.get(j + 1).getPhoneNumber());
				}
				count--;
			}
			if (i == getCount()) {
				persons[i].setName(null);
			}
		}
	}
}
