package register;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import core.Person;

@SuppressWarnings("serial")
public class ListRegister implements Register {
	/** register.Person ListArray. */
	private List<Person> persons = new ArrayList<Person>();

	@Override
	public int getCount() {
		return persons.size();
	}

	@Override
	public int getSize() {
		// same as COUNT !!! in ARRAY LIST !!!return ListRegister.size();
		return 0;
	}

	@Override
	public Person getPerson(int index) {
		return persons.get(index);
	}

	@Override
	public void ArrayRegister(Person person) {
		persons.add(person);
		Collections.sort(persons);
	}

	@Override
	public Person findPersonByName(String name) {
		// java 8 !!!
		return persons.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null); // java 8
// java 7
		//    System.out.println(match.toString());
		
//		Person p = new Person(null, null);
//		for (int i = 0; i < persons.size(); i++) {
//			if(name.equals(persons.get(i).getName()))
//			{
//				p.setName(persons.get(i).getName());
//				p.setPhoneNumber(persons.get(i).getPhoneNumber());
//			}
//		}
	}

	@Override
	public Person findPersonByPhoneNumber(String phoneNumber) {
		
		// java 8 !!!
		return persons.stream().filter(p -> p.getPhoneNumber().equals(phoneNumber)).findFirst().orElse(null); // java 8
//		java 7
//		Person p = new Person(null, null);
//		for (int i = 0; i < persons.size(); i++) {
//			if(phoneNumber.equals(persons.get(i).getPhoneNumber()))
//			{
//				p.setName(persons.get(i).getName());
//				p.setPhoneNumber(persons.get(i).getPhoneNumber());
//			}
//		}
//		return p;
	}

	@Override
	public void removePerson(Person person) {
		persons.remove(person);
	}	
}