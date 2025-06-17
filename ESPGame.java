/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: (Give a brief description for each Class) extrasensory perception test
 * Due: 06/16/2025
 * Platform/compiler: MacOS openjdk temurin 24.0.1
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Oguz Can Yilmazlar
 */

import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class ESPGame {

    public static void main(String[] args) throws IOException {

        Random random = new Random();

        Scanner keyboard = new Scanner(System.in);
        System.out.println("CMSC203 Assignment1: Test your ESP skills!");
        System.out.println("Welcome to ESP - extrasensory perception!");
        int input;

        do{
            System.out.println("Would you please choose one of the 4 options from the menu:");
            System.out.println("1-	read and display on the screen first 16 names of colors from a file colors.txt, so the player can select one of them names of colors.");
            System.out.println("2-	read and display on the screen first 10 names of colors from a file colors.txt, so the player can select one of them names of colors.");
            System.out.println("3-	read and display on the screen first 5 names of colors from a file colors.txt, so the player can select one of them names of colors.");
            System.out.println("4-	exit");
            System.out.print("Enter the option: ");
            input = keyboard.nextInt();
            int lineAmount = -1;
            File readFile;
            switch(input){
                case 1:
                    if(lineAmount == -1) lineAmount = 16;
                case 2:
                    if(lineAmount == -1) lineAmount = 10;
                case 3:
                    if(lineAmount == -1) lineAmount = 5;
                    System.out.print("Enter the file name: ");
                    keyboard.nextLine();
                    String fileName = keyboard.nextLine();
                    readFile = new File(fileName);
                    break;
                default:
                    continue; // continues the while loop to process 4 or invalid options.
            }

            int lineReadAmount = 0;
            Scanner scanner = new Scanner(readFile);
            while(lineReadAmount++ < lineAmount && scanner.hasNext()){
                String line = scanner.nextLine();
                System.out.println(lineReadAmount + " " + line);
            }
            scanner.close();

            // game logic

            int playerScore = 0;

            for(int i = 0; i < 3; i++){
                // offsetting by one to ensure the for loop runs at least once.
                int pickedColorIndex = random.nextInt(15) + 1;
                String pickedColor = null;
                Scanner colorPicker = new Scanner(readFile);
                // no need to write if checks because the latest line we read will always be the one randomly picked.
                for(int j = 0; j < pickedColorIndex; j++){
                    pickedColor = colorPicker.nextLine();
                }
                scanner.close();
                System.out.println("I picked a color out of the 16 colors.");
                System.out.println("Try to guess the color I picked!");
                System.out.print("Enter your guess: ");
                String userColor = keyboard.nextLine();
                if(pickedColor != null && userColor.equalsIgnoreCase(pickedColor)){
                    playerScore++;
                }
                System.out.println("I was thinking of " + pickedColor);
            }

            System.out.println("Game Over");
            System.out.println();
            System.out.println("You guessed " + playerScore + " out of 3 colors correctly.");
            System.out.println("Would you like to continue a Game? Type Yes/No");
            String gameAnswer = keyboard.nextLine();
            if(!gameAnswer.equalsIgnoreCase("yes")){
                break;
            }

        }while(input!=4);

    }


}