package register;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
* Read and save register of person from file.
*
* @author  Matus Tomcak
* @version 1.0
* @since   2015-08-11 
*/

/**Load register from file*/
public class FileRegisterLoader implements RegisterLoader {
	public final String file = System.getProperty("user.home") + System.getProperty("file.separator") + "register.bin";
	
	/* (non-Javadoc)
	 * @see register.RegisterLoader#readRegisterFromFile()
	 */
	/* (non-Javadoc)
	 * @see register.RegisterLoader#readRegisterFromFile()
	 */
	@Override
	public Register readRegister() throws IOException {
		Register r = null;
		File f = new File(file);
		if (!f.exists())
			return null;
		try (FileInputStream fis = new FileInputStream(f); ObjectInputStream ois = new ObjectInputStream(fis);) {
			r = (Register) ois.readObject();
			System.out.println("Register load from file !" + file);
			return r;
		} catch (Exception e) {
			System.out.println("File don't exist !" + file);
		}
		return r;
	}
	/* (non-Javadoc)
	 * @see register.RegisterLoader#saveRegister(register.Register)
	 */
	/* (non-Javadoc)
	 * @see register.RegisterLoader#saveRegister(register.Register)
	 */

	@Override
	public void saveRegister(Register register) {
		File f = new File(file);
		try (FileOutputStream fos = new FileOutputStream(f); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			// write object to file
			oos.writeObject(register);
			System.out.println("Settings saved !");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
