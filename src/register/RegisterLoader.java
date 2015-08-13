package register;

import java.io.IOException;

public interface RegisterLoader {

	/* (non-Javadoc)
	 * @see register.RegisterLoader#readRegisterFromFile()
	 */
	Register load() throws IOException;

	/* (non-Javadoc)
	 * @see register.RegisterLoader#saveRegister(register.Register)
	 */
	void store(Register register);
}