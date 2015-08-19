package registerLoader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import register.ListRegister;
import register.Person;
import register.Register;

public class TextFileRegisterLoader implements RegisterLoader {

	@Override
	public Register load() throws IOException {
		Register r = new ListRegister();
		int i = 0;
		// write persons to file
		try (FileReader file = new FileReader("register.txt"); BufferedReader br = new BufferedReader(file);) {					 
				String s; 
				while((s = br.readLine()) != null) { 
					String phoneNumber = br.readLine();
					System.out.println(i++);
					 if (phoneNumber == null)
					 {
						 throw new IOException("Damaged file");
					 }
				r.ArrayRegister(new Person(s, phoneNumber));
			}
		return r;
	}
	}
		

	@Override
	public void store(Register register) {
		File file = new File("register.txt");
		// write persons to file
		try (FileWriter writer = new FileWriter(file);) {
			for (int i = 0; i < register.getCount(); i++) {
				writer.write(register.getPerson(i).getName() + "\n" + register.getPerson(i).getPhoneNumber() + "\n");
				writer.flush();
			}
			System.out.println("Save register to text file !");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
