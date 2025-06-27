import java.util.Scanner;

public class MovieDriver_Task1 {

    public static void main(String[] args){

        Scanner keyboard = new Scanner(System.in);
        System.out.println(askForMovie(keyboard));

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
