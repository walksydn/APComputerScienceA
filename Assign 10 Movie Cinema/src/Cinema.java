import java.util.ArrayList;
import java.util.Scanner;
 
/**
 * Author: Sydney Walker 
 * Period: 9 
 * Class: Cinema.java 
 * Purpose: creates a cinema
 */
public class Cinema {
    static Movie[][] schedule = new Movie[6][5];
         
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SRWUtilities util = new SRWUtilities();
        IntVerifier theaterSelect = new IntVerifier(input, 1, true, 6, true);
        IntVerifier timeSelect = new IntVerifier(input, 1, true, 5, true);
        IntVerifier menuSelect = new IntVerifier(input, 0, true, 8, true);
        while (true) {
            System.out.println("Please select what you would like to do.\n1: Schedule a Theater and Time\n"
                    + "2: Schedule a Theater for One Movie All Day\n3: Schedule a Movie for The Same Time At All Theaters\n"
                    + "4: Clear a Theater\n5: Search for Times for a Movie\n6: Search for a Movie Rating\n7: Autofill\n"
                    + "8: Display Movies and Times\n9: Edit a Movie");
            System.out.println("\nOr Press 0 to Quit");
            int choice = input.nextInt();
//            int choice = menuSelect.readAndVerify();
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1: //make a movie, select theater, select movie time, save movie to the time
                    Movie movie1 = makeAMovie(input);
                    System.out.println("Select a theater 1-6.");
                    int theater = theaterSelect.readAndVerify() - 1;
                    System.out.println("Enter your movie time.");
                    System.out.println("1: 10am\t2: 1pm\t3: 4pm\t4: 7pm\t5: 10pm");
                    int time = timeSelect.readAndVerify() - 1;
                    schedule[theater][time] = movie1;
                    break;
                case 2:
                    Movie movie2 = makeAMovie(input);
                    System.out.println("Which theater do you want to schedule " + movie2.getName() + " at?");
                    int theater2 = theaterSelect.readAndVerify() - 1;
                    //sets the movie to each time slot in the theater
                    for(int i = 0; i < schedule[0].length; i++){
                        schedule[theater2][i] = movie2;
                    }
                    break;
                case 3:
                    Movie movie3 = makeAMovie(input);
                    System.out.println("What time do you want to schedule " + movie3.getName() + " at?");
                    int time2 = timeSelect.readAndVerify() - 1;
                    //sets the movie to selected time slot in every theater
                    for(int i = 0; i < schedule.length; i++){
                        schedule[i][time2] = movie3;
                    }
                    break;
                case 4:
                    System.out.println("Which theater would you like to clear?");
                    int theater3 = theaterSelect.readAndVerify() - 1;
                    //sets all times for the selected theater to null
                    for(int i = 0; i < schedule[0].length; i++){
                        schedule[theater3][i] = null;
                    }
                    break;
                case 5:
                    input.skip("\n");
                    System.out.println("What movie do you want to look for?");
                    String movieName = input.nextLine();
                    ArrayList<int[]> times = new ArrayList<>();
                    for(int r = 0; r < schedule.length; r++){
                        for(int c = 0; c < schedule[0].length; c++){
                            //checks if the movie name matches and saves it to an array list if it does
                            if(schedule[r][c] != null && schedule[r][c].getName().equals(movieName)){
                                times.add(new int[]{r+1, c+1});
                            }
                        }
                    }
                    for(int i = 0; i < times.size(); i++){
                        System.out.println("The movie plays in theater " + times.get(i)[0] + " during time slot " + times.get(i)[1] + ".");
                         
                    }
                    break;
                case 6:
                    input.skip("\n");
                    System.out.println("What rating movie are you looking for?");
                    String rating = input.nextLine();
                    ArrayList<String> names = new ArrayList<>();
                    ArrayList<int[]> movies = new ArrayList<>();
                    for(int r = 0; r < schedule.length; r++){
                        for(int c = 0; c < schedule[0].length; c++){
                            //checks if the rating matches and adds it to the array list if it does
                            if(schedule[r][c] != null && schedule[r][c].getMPAA().equals(rating)){
                                names.add(schedule[r][c].getName());
                                movies.add(new int[]{r+1, c+1});
                            }
                        }
                    }
                    for(int i = 0; i < movies.size(); i++){
                        System.out.println(names.get(i) + " plays in theater " + movies.get(0)[0] + " during time slot " + movies.get(0)[1] + ".");
                    }
                    break;
                case 7:
                    autoFill();
                    break;
                case 8:
                    //Prints out all of the movie information
                    System.out.format("%-20s%-20s%-50s%-20s%-20s%-20s", "Theater", "Time Slot", "Movie", "MPAA Rating", "Run Time", "Rating");
                    System.out.println("");
                    for(int r = 0; r < schedule.length; r++){   //loops through each theater and time
                        for(int c = 0; c < schedule[0].length; c++){
                            System.out.format("%-20s%-20s%-20s", r+1, c+1, schedule[r][c]);
                            System.out.println("");
                        }
                    }
                    System.out.println("");
                    break;
                case 9:
                    System.out.println("Which theater do you want to edit?");
                    int theater4 = theaterSelect.readAndVerify();
                    System.out.println("Which time slot do you want to edit?");
                    int time4 = timeSelect.readAndVerify();
                    System.out.println("What would you like to edit?");
                    System.out.println("1: Name\n2: Runtime\n3: MPAA Rating\n4: Rotton Tomatoes Rating");
                    int select = input.nextInt();
                    switch(select){
                        case 1: 
                            input.skip("\n");
                            System.out.println("What new name?");
                            String name = input.nextLine();
                            schedule[theater4][time4].name = name;
                            break;
                        case 2: 
                            System.out.println("What new runtime?");
                            int runTime = input.nextInt();
                            schedule[theater4][time4].runTime = runTime;
                            break;
                        case 3:
                            input.skip("\n");
                            System.out.println("What new MPAA rating?");
                            String mpaa = input.nextLine();
                            schedule[theater4][time4].mpaa = mpaa;
                            break;
                        case 4:
                            System.out.println("What new rating?");
                            int ratingRT = input.nextInt();
                            schedule[theater4][time4].rating = ratingRT;
                            break;
                    }
            }
        }
    }
 
    static public Movie makeAMovie(Scanner input){
        //collects all information for the movie being made
        IntVerifier runTimeSelect = new IntVerifier(input, 0, true, 2147483647, true);
        IntVerifier ratingSelect = new IntVerifier(input, 0, true, 100, true);
        input.skip("\n");
        System.out.println("What movie would you like to play?");
        String movie = input.nextLine();
        System.out.println("What is the runtime of the movie? (in minutes)");
        int runTime = runTimeSelect.readAndVerify();
        System.out.println("What is your movie rated (mpaa standard)?");
        String mpaa = input.nextLine();
        System.out.println("What is your movie's rotton tomatoes rating?");
        int rating = ratingSelect.readAndVerify();
        return new Movie(movie, mpaa, runTime, rating);
    }
     
    static public void autoFill(){
        schedule[0][0] = new Movie("My Girl", "PG-13", 102, 50);
        schedule[0][1] = new Movie("In Between", "NR", 96, 97);
        schedule[0][2] = new Movie("Blame", "NR", 100, 90);
        schedule[0][3] = new Movie("Una", "R", 94, 74);
        schedule[0][4] = new Movie("Star Wars: The Last Jedi", "PG-13", 152, 91);
        schedule[1][0] = new Movie("The Shape of Water", "R", 119, 93);
        schedule[1][1] = new Movie("The Florida Project", "R", 115 ,95);
        schedule[1][2] = new Movie("Marshall", "PG-13", 118, 83);
        schedule[1][3] = new Movie("Film Stars Don't Die", "R", 105, 81);
        schedule[1][4] = new Movie("The Post", "PG-13", 95, 86);
        schedule[2][0] = new Movie("Film Stars Don't Die", "R", 105, 81);
        schedule[2][1] = new Movie("Star Wars: The Last Jedi", "PG-13", 152, 91);
        schedule[2][2] = new Movie("My Girl", "PG-13", 102, 50);
        schedule[2][3] = new Movie("The Florida Project", "R", 115 ,95);
        schedule[2][4] = new Movie("Blame", "NR", 100, 90);
        schedule[3][0] = new Movie("Una", "X", 94, 74);
        schedule[3][1] = new Movie("The Post", "PG-13", 95, 86);
        schedule[3][2] = new Movie("The Shape of Water", "R", 119, 93);
        schedule[3][3] = new Movie("In Between", "NR", 96, 97);
        schedule[3][4] = new Movie("Marshall", "PG-13", 118, 83);
        schedule[4][0] = new Movie("Una", "R", 94, 74);
        schedule[4][1] = new Movie("Star Wars: The Last Jedi", "PG-13", 152, 91);
        schedule[4][2] = new Movie("The Shape of Water", "R", 119, 93);
        schedule[4][3] = new Movie("The Florida Project", "R", 115 ,95);
        schedule[4][4] = new Movie("Marshall", "PG-13", 118, 83);
        schedule[5][0] = new Movie("Film Stars Don't Die", "R", 105, 81);
        schedule[5][1] = new Movie("The Post", "PG-13", 95, 86);
        schedule[5][2] = new Movie("My Girl", "PG-13", 102, 50);
        schedule[5][3] = new Movie("In Between", "NR", 96, 97);
        schedule[5][4] = new Movie("Blame", "NR", 100, 90);
    }
}