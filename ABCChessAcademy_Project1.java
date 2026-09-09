
package abcchessacademy_project1;
import java.io.*;
import java.util.Scanner;

public class ABCChessAcademy_Project1 {
static Scanner scanner = new Scanner(System.in);
    static String username = "admin";  
    static String password = "123password";
    static boolean loggedIn = false;
    
    static final String PLAYER_FILE = "players.txt";
    static final String TOURNAMENT_FILE = "tournaments.txt";

    
    public static void main(String[] args) {
     while (true) {
            if (!loggedIn) {
                login();
            } else {
                mainMenu();
            }
        }
    }

    public static void login() {
        System.out.print("Please enter username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Please enter password: ");
        String inputPassword = scanner.nextLine();

        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            loggedIn = true;
            System.out.println("Login successful! Welcome to the Chess Academy.");
        } else {
            System.out.println("Invalid credentials! Try again.");
        }
    }

    
    public static void mainMenu() {
        System.out.println("\n*****ABC Chess Academy System******");
        System.out.println("1. Add New Player");
        System.out.println("2. Display Player Information");
        System.out.println("3. Search Player");
        System.out.println("4. Add Tournament Schedules");
        System.out.println("5. Display Tournament Schedules");
        System.out.println("6. Search Tournament");
        System.out.println("7. Help");
        System.out.println("8. Logout");
        System.out.println("9. Exit");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  

        switch (choice) {
            case 1:
                addNewPlayer();
                break;
            case 2:
                displayPlayerInformation();
                break;
            case 3:
                searchPlayer();
                break;
            case 4:
                addTournamentschedule();
                break;
            case 5:
                displayTournamentSchedules();
                break;
            case 6:
                searchTournament();
                break;
            case 7:
                showHelp();
                break;
            case 8:
                logout();
                break;
            case 9:
                exit();
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }

    
    public static void addNewPlayer() {
        System.out.print("\nEnter Player Registration Number: ");
        String regNum = scanner.nextLine();
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Date of Birth (yyyy-mm-dd): ");
        String dob = scanner.nextLine();
        System.out.print("Enter Rating: ");
        double rating = scanner.nextDouble();
        scanner.nextLine();  
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("players.txt", true));
            writer.write(regNum + "," + firstName + "," + lastName + "," + dob + "," + rating);
            writer.newLine();
            writer.close();
            System.out.println("Player added successfully!");
        } catch (IOException e) {
            System.out.println("Error while saving player details.");
        }
    }
         
    public static void displayPlayerInformation() {
        System.out.print("\nPlayer Information: ");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("players.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading player details.");
        }
    }
    
    public static void searchPlayer() {
        System.out.print("\nEnter Player Registration Number to search: ");
        String regNum = scanner.nextLine();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("players.txt"));
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(regNum)) {
                    System.out.println(line);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Player not found!");
                
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error searching for player.");
            
        }
    }
    
    public static void addTournamentschedule() {
        System.out.print("\nEnter Tournament ID: ");
        String tournamentId = scanner.nextLine();
        System.out.print("Enter Tournament Name: ");
        String tournamentName = scanner.nextLine();
        System.out.print("Enter Date (yyyy-mm-dd): ");
        String date = scanner.nextLine();
        System.out.print("Enter Venue: ");
        String venue = scanner.nextLine();
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("tournaments.txt", true));
            writer.write(tournamentId + "," + tournamentName + "," + date + "," + venue);
            writer.newLine();
            writer.close();
            System.out.println("Tournament added successfully!");
        } catch (IOException e) {
            System.out.println("Error while saving tournament details.");
        }
    }    
     
    
    public static void displayTournamentSchedules() {
        System.out.print("\nTournament Schedules: ");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("tournaments.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading tournament details.");
        }
    }
    
    
    public static void searchTournament() {
        System.out.print("\nEnter Tournament ID to search: ");
        String tournamentId = scanner.nextLine();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("tournaments.txt"));
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(tournamentId)) {
                    System.out.println(line);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Tournament not found!");
                
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error searching for tournament.");
            
        }
    }
    
    
    public static void showHelp() {
        System.out.println("\nHelp: ");
        System.out.println("1. Add New Player: Add player details to the system.");
        System.out.println("2. Add Tournament Schedule: Add a new tournament schedule to the system.");
        System.out.println("3. Display Player Information: Show all player details.");
        System.out.println("4. Display Tournament Schedules: Show all tournament details.");
        System.out.println("5. Search Player: Search player information by registration number.");
        System.out.println("6. Search Tournament: Search tournament information by ID.");
        System.out.println("7. Logout: Log out of the system.");
        System.out.println("8. Exit: Exit the program.");
    }

    
    public static void logout() {
        
        System.out.println("You have logged out successfully.");
    }

  
    public static void exit() {
        System.out.println("Exiting the system. Goodbye!");
        System.exit(0);
    }
}   
    
    

