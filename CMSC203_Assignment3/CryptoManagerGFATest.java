/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: (Give a brief description for each Class) Test class
 * Due: 07/07/2025
 * Platform/compiler: MacOS openjdk21 temurin
 * I pledge that I have completed the programming  assignment independently.
 *  I have not copied the code from a student or any source.
 *  I have not given my code to any student.
 *  Print your Name here: Oguz Can Yilmazlar
 */


/**
 * This class represents GFA test cases for a CryptoManager object.
 * 
 * @author Huseyin Aygun
 * @version 5/3/2025
 * 
 */

import junit.framework.TestCase;

public class CryptoManagerGFATest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
    public void testIsStringInBounds() {
        assertTrue(CryptoManager.isStringInBounds("MONTGOMERY"));
    }

	public void testVigenereEncryptDecrypt() {
        String plain = "MONTGOMERY";
        String key = "MNT";
        String encrypted = CryptoManager.vigenereEncryption(plain, key);
        String decrypted = CryptoManager.vigenereDecryption(encrypted, key);
        assertEquals(plain, decrypted);
    }
    

}
