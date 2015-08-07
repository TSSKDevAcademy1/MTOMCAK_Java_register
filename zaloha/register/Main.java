package register;

/**
 * Created by jaro on 3.2.2014.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Register register = new ArrayRegister(20);
        register.addPerson(new Person("Janko Hrasko 1", "0900123456"));
        register.addPerson(new Person("Janko Patocka 2", "0904512548"));
        register.addPerson(new Person("Dodo Hrasko 3", "0904587458"));
        register.addPerson(new Person("Janko Rusnak 4", "0904125489"));
        register.addPerson(new Person("Janka Hraskova 5", "0905124789"));
        ConsoleUI ui = new ConsoleUI(register);
        ui.run();
    }
}
