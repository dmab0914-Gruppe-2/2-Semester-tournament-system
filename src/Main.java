/**
 * 
 */

import java.security.MessageDigest;

/**
 * @author Jacob 12/05/2015
 *
 */
public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{

		System.out.print("Please enter a password for hashing: ");
        String password = System.console().readLine();

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
        messageDigest.update(password.getBytes());

        byte byteData[] = messageDigest.digest();

        //Convert to HEX 1
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i<byteData.length; i++){
            stringBuffer.append(Integer.toString(byteData[i] & 0xff + 0x100, 16).substring(1));
        }
        System.out.print("HEX Format method 1: "+stringBuffer.toString() + "\n");
	}
}
