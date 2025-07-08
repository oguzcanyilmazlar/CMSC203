/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: (Give a brief description for each Class) utility class that handles encryption and decryption
 * Due: 07/07/2025
 * Platform/compiler: MacOS openjdk21 temurin
 * I pledge that I have completed the programming  assignment independently.
 *  I have not copied the code from a student or any source.
 *  I have not given my code to any student.
 *  Print your Name here: Oguz Can Yilmazlar
 */

/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. 
 * 
 * The first approach is called the Vigenere Cipher.Vigenere encryption 
 * is a method of encrypting alphabetic text based on the letters of a keyword.
 * 
 * The second approach is Playfair Cipher. It encrypts two letters (a digraph) 
 * at a time instead of just one.
 * 
 * @author Huseyin Aygun
 * @version 5/3/2025
 */

public class CryptoManager { 

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
    // Use 64-character matrix (8X8) for Playfair cipher
    private static final String ALPHABET64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_ ";
    private static final int MATRIX_SIZE = 8;

    public static boolean isStringInBounds(String plainText) {
        for (int i = 0; i < plainText.length(); i++) {
            if (!(plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE)) {
                return false;
            }
        }
        return true;
    }

	/**
	 * Vigenere Cipher is a method of encrypting alphabetic text 
	 * based on the letters of a keyword. It works as below:
	 * 		Choose a keyword (e.g., KEY).
	 * 		Repeat the keyword to match the length of the plaintext.
	 * 		Each letter in the plaintext is shifted by the position of the 
	 * 		corresponding letter in the keyword (A = 0, B = 1, ..., Z = 25).
	 */   

    public static String vigenereEncryption(String plainText, String key) {
         //to be implemented by students

        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++)
        {
            char p = plainText.charAt(i);
            char k = key.charAt(i % key.length());

            int pIndex = ALPHABET64.indexOf(p);
            int kIndex = ALPHABET64.indexOf(k);

            if (pIndex == -1) {
                throw new IllegalArgumentException("Plaintext contains invalid character: " + p);
            }
            if (kIndex == -1) {
                throw new IllegalArgumentException("Key contains invalid character: " + k);
            }

            int cIndex = (pIndex + kIndex) % ALPHABET64.length();
            cipherText.append(ALPHABET64.charAt(cIndex));

        }
        return cipherText.toString();
    }

    // Vigenere Decryption
    public static String vigenereDecryption(String encryptedText, String key) {
        StringBuilder originalText = new StringBuilder();

        for (int i = 0 ; i < encryptedText.length(); i++)
        {
            char c = encryptedText.charAt(i);
            char k = key.charAt(i % key.length());

            int cIndex = ALPHABET64.indexOf(c);
            int kIndex = ALPHABET64.indexOf(k);

            if (cIndex == -1) {
                throw new IllegalArgumentException("Ciphertext contains invalid character: " + c);
            }
            if (kIndex == -1) {
                throw new IllegalArgumentException("Key contains invalid character: " + k);
            }



            int pIndex = (cIndex - kIndex + ALPHABET64.length()) % ALPHABET64.length();
            originalText.append(ALPHABET64.charAt(pIndex));
        }
        return originalText.toString();
    }


	/**
	 * Playfair Cipher encrypts two letters at a time instead of just one.
	 * It works as follows:
	 * A matrix (8X8 in our case) is built using a keyword
	 * Plaintext is split into letter pairs (e.g., ME ET YO UR).
	 * Encryption rules depend on the positions of the letters in the matrix:
	 *     Same row: replace each letter with the one to its right.
	 *     Same column: replace each with the one below.
	 *     Rectangle: replace each letter with the one in its own row but in the column of the other letter in the pair.
	 */    

    public static String playfairEncryption(String plainText, String key) {
         //to be implemented by students
        plainText = cleanInput(plainText);
        key = cleanInput(key);

        char[][] matrix = buildMatrix(key);
        StringBuilder prepared = prepareTextPairs(plainText);

        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < prepared.length(); i += 2) {
            char a = prepared.charAt(i);
            char b = prepared.charAt(i + 1);
            int[] posA = findPosition(matrix, a);
            int[] posB = findPosition(matrix, b);

            if (posA[0] == posB[0]) {
                // Same row
                encrypted.append(matrix[posA[0]][(posA[1] + 1) % MATRIX_SIZE]);
                encrypted.append(matrix[posB[0]][(posB[1] + 1) % MATRIX_SIZE]);
            } else if (posA[1] == posB[1]) {
                // Same column
                encrypted.append(matrix[(posA[0] + 1) % MATRIX_SIZE][posA[1]]);
                encrypted.append(matrix[(posB[0] + 1) % MATRIX_SIZE][posB[1]]);
            } else {
                // Rectangle swap
                encrypted.append(matrix[posA[0]][posB[1]]);
                encrypted.append(matrix[posB[0]][posA[1]]);
            }
        }

        return encrypted.toString();
    }

    // Playfair Decryption
    public static String playfairDecryption(String encryptedText, String key) {
         //to be implemented by students
        key = key.toUpperCase();
        encryptedText = encryptedText.toUpperCase();

        StringBuilder unique = new StringBuilder();
        for (char c : (key + ALPHABET64).toCharArray()) {
            if (unique.indexOf(String.valueOf(c)) == -1) {
                unique.append(c);
            }
        }

        char[][] matrix = new char[MATRIX_SIZE][MATRIX_SIZE];
        for (int i = 0; i < MATRIX_SIZE * MATRIX_SIZE; i++) {
            matrix[i / MATRIX_SIZE][i % MATRIX_SIZE] = unique.charAt(i);
        }

        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i += 2) {
            char a = encryptedText.charAt(i);
            char b = encryptedText.charAt(i + 1);

            int[] posA = findPosition(matrix, a);
            int[] posB = findPosition(matrix, b);

            if (posA[0] == posB[0]) {
                // Same row: move left
                decrypted.append(matrix[posA[0]][(posA[1] + MATRIX_SIZE - 1) % MATRIX_SIZE]);
                decrypted.append(matrix[posB[0]][(posB[1] + MATRIX_SIZE - 1) % MATRIX_SIZE]);
            } else if (posA[1] == posB[1]) {
                // Same column: move up
                decrypted.append(matrix[(posA[0] + MATRIX_SIZE - 1) % MATRIX_SIZE][posA[1]]);
                decrypted.append(matrix[(posB[0] + MATRIX_SIZE - 1) % MATRIX_SIZE][posB[1]]);
            } else {
                // Rectangle: swap columns
                decrypted.append(matrix[posA[0]][posB[1]]);
                decrypted.append(matrix[posB[0]][posA[1]]);
            }
        }

        return decrypted.toString();

    }


    private static String cleanInput(String input) {
        StringBuilder cleaned = new StringBuilder();
        for (char c : input.toUpperCase().toCharArray()) {
            if (ALPHABET64.indexOf(c) != -1) {
                cleaned.append(c);
            }
        }
        return cleaned.toString();
    }

    // Build 8x8 matrix from key + ALPHABET64
    private static char[][] buildMatrix(String key) {
        StringBuilder unique = new StringBuilder();

        for (char c : (key + ALPHABET64).toCharArray()) {
            if (unique.indexOf(String.valueOf(c)) == -1) {
                unique.append(c);
            }
        }

        if (unique.length() < MATRIX_SIZE * MATRIX_SIZE) {
            System.out.println(ALPHABET64.length());
            throw new IllegalArgumentException("Key and alphabet must provide 64 unique characters.");
        }

        char[][] matrix = new char[MATRIX_SIZE][MATRIX_SIZE];
        for (int i = 0; i < MATRIX_SIZE * MATRIX_SIZE; i++) {
            matrix[i / MATRIX_SIZE][i % MATRIX_SIZE] = unique.charAt(i);
        }

        return matrix;
    }

    private static int[] findPosition(char[][] matrix, char c) {
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                if (matrix[i][j] == c) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("Character not found in matrix: " + c);
    }

    private static StringBuilder prepareTextPairs(String text) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < text.length()) {
            char first = text.charAt(i);
            char second = (i + 1 < text.length()) ? text.charAt(i + 1) : '_';

            if (first == second) {
                result.append(first).append('_');
                i++;
            } else {
                result.append(first).append(second);
                i += 2;
            }
        }

        if (result.length() % 2 != 0) {
            result.append('_'); // Padding if odd
        }

        return result;
    }

}
