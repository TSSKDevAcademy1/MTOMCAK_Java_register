package tests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import register.ArrayRegister;
import register.ListRegister;
import register.Person;
import register.Register;

public class Test {

	static Register arrayReg;
	static Register listReg;
	static Person p;
	static String name;
	static String phoneNumber;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		name = "Mike matovic";
		phoneNumber = "421902457";
		arrayReg = new ArrayRegister(50);
		listReg = new ListRegister();
		p = new Person(name, phoneNumber);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**Test for phone number*/
	@org.junit.Test
	public void isValidPhoneNumber() {
		assertEquals(p.getPhoneNumber(), phoneNumber);

		p.setPhoneNumber("456987654");
		assertEquals(p.getPhoneNumber(), "456987654");

		try {
			p.setPhoneNumber("s45664846");
			assertNotEquals(p.getPhoneNumber(), "s45664846");
		} catch (Exception e) {
			System.out.println("Wrong phone number format");
		}

		assertEquals(p.getPhoneNumber(), "456987654");
	}

	/**Test for Array register*/
	@org.junit.Test
	public void addArrayRegisterArray() {
		p = new Person(name, phoneNumber);
		arrayReg.ArrayRegister(p);

		assertEquals(arrayReg.getCount(), 1);
		assertEquals(arrayReg.getPerson(arrayReg.getCount() - 1), p);

	}

	@org.junit.Test
	public void updateArrayRegister() {
		p = new Person(name, phoneNumber);
		arrayReg.ArrayRegister(p);

		// update name
		arrayReg.getPerson(0).setName("Mathew");
		assertEquals(arrayReg.getPerson(0).getName(), "Mathew");

		// update phone number
		arrayReg.getPerson(0).setPhoneNumber("684265874");
		assertEquals(arrayReg.getPerson(0).getPhoneNumber(), "684265874");
	}

	@org.junit.Test
	public void removeArrayRegister() {
		// add person to regster
		arrayReg = new ArrayRegister(20);
		arrayReg.ArrayRegister(new Person("Johny", "963258741"));
		arrayReg.ArrayRegister(new Person("Johny Mike", "987357159"));

		// check if person was added
		assertEquals(arrayReg.getCount(), 2);

		// Delete first person from register and check count
		arrayReg.removePerson(arrayReg.getPerson(0));
		assertEquals(arrayReg.getCount(), 1);
		
		
		// Delete second person from register and check count
		arrayReg.ArrayRegister(new Person("Johny Mike", "987357159"));
		arrayReg.removePerson(arrayReg.getPerson(1));
		assertEquals(arrayReg.getCount(), 1);
	}
	
	/**Test for ListRegister*/
	@org.junit.Test
	public void addListRegister() {
		p = new Person(name, phoneNumber);
		listReg.ArrayRegister(p);

		assertEquals(listReg.getCount(), 1);
		assertEquals(listReg.getPerson(listReg.getCount() - 1), p);

	}

	@org.junit.Test
	public void updateListRegister() {
		p = new Person(name, phoneNumber);
		listReg.ArrayRegister(p);

		// update name
		listReg.getPerson(0).setName("Mathew");
		assertEquals(listReg.getPerson(0).getName(), "Mathew");

		// update phone number
		listReg.getPerson(0).setPhoneNumber("684265874");
		assertEquals(listReg.getPerson(0).getPhoneNumber(), "684265874");
	}

	@org.junit.Test
	public void removeListRegister() {
		// add person to register
		listReg = new ListRegister();
		listReg.ArrayRegister(new Person("Johny", "963258741"));
		listReg.ArrayRegister(new Person("Johny Mike", "987357159"));

		// check if person was added
		assertEquals(listReg.getCount(), 2);

		// Delete first person from register and check count
		listReg.removePerson(listReg.getPerson(0));
		assertEquals(listReg.getCount(), 1);
		
		
		// Delete second person from register and check count
		listReg.ArrayRegister(new Person("Johny Mike", "987357159"));
		listReg.removePerson(listReg.getPerson(1));
		assertEquals(listReg.getCount(), 1);
	}
}
