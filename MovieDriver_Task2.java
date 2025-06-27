/*
 * Class: CMSC203 40539
 * Instructor: Grigoriy Grinberg
 * Description: (Give a brief description for each Class) Ask for movie title, rating, and sold ticket amount and print them.
 * Due: 06/30/2025
 * Platform/compiler: MacOS openjdk temurin 24.0.1
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Oguz Can Yilmazlar
 */


import java.util.Scanner;

public class MovieDriver_Task2 {

    public static void main(String[] args){

        Scanner keyboard = new Scanner(System.in);
        do{
            System.out.println(askForMovie(keyboard));
        }while(shouldContinue(keyboard));

    }

    private static boolean shouldContinue(Scanner in){
        in.nextLine();
        System.out.println("Do you want to enter another movie? (y/n)");
        return in.nextLine().equals("y");
    }

    private static Movie askForMovie(Scanner in){
        Movie movie = new Movie();

        System.out.println("Enter the title of the movie: ");
        String movieTitle = in.nextLine();
        movie.setTitle(movieTitle);

        System.out.println("Enter the rating of the movie: ");
        String movieRating = in.next();
        movie.setRating(movieRating);

        System.out.println("Enter the amount of tickets sold at the theater: ");
        int ticketsSold = in.nextInt();
        movie.setSoldTickets(ticketsSold);

        return movie;
    }

}
