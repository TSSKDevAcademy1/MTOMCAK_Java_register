package register;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListRegister implements Register{
	/** register.Person ListArray. */
	private List<Person> ListRegister = new ArrayList<Person>();

	@Override
	public int getCount() {
		return ListRegister.size();
	}

	@Override
	public int getSize() {
		// same as COUNT !!! in ARRAY LIST !!!return ListRegister.size();
		return 0;
	}

	@Override
	public Person getPerson(int index) {
		return ListRegister.get(index);
	}

	@Override
	public void ArrayRegister(Person person) {
		ListRegister.add(person);
		Collections.sort(ListRegister);
	}

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

	@Override
	public Person findPersonByPhoneNumber(String phoneNumber) {
		Person p = new Person(null, null);
		for (int i = 0; i < ListRegister.size(); i++) {
			if(phoneNumber.equals(ListRegister.get(i).getPhoneNumber()))
			{
				p.setName(ListRegister.get(i).getName());
				p.setPhoneNumber(ListRegister.get(i).getPhoneNumber());
			}
		}
		return p;
	}


	@Override
	public void removePerson(Person person) {
		ListRegister.remove(person);
	}	
}