package register;

import java.io.IOException;

public interface RegisterLoader {

	/* (non-Javadoc)
	 * @see register.RegisterLoader#readRegisterFromFile()
	 */
	Register readRegisterFromFile() throws IOException;

	/* (non-Javadoc)
	 * @see register.RegisterLoader#saveRegister(register.Register)
	 */
	void saveRegister(Register register);

}