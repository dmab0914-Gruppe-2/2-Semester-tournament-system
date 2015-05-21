/**
 * 
 */

/*import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;*/

import UILayer.MainUI;

/**
 * @author Jacob 12/05/2015
 *
 */
public class Main {
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String[] args) {
		try {
		new MainUI();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
