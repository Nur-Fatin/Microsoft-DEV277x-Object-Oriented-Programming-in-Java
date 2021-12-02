/*
Build the game of battleships. How does it work?
1. 2 players; user player vs computer player
2. Player will place 5 of their ships on a 10 by 10 grid.
3. Once the game starts the player and computer take turns, trying to sink each other's ships by guessing the coordinates to "attack".
4. The game ends when either the player or computer has no ships left.
 */


import java.util.*;

public class BattleShips {
    public static final int[][] oceanMap = new int[10][10];
    public static final Scanner input = new Scanner(System.in);
    public static final Random rand = new Random();

    public static void main(String[] args) {
        intro();
        createMap();
        deployPlayerShips();
        deployComputerShips();
        battle();

    }

    // Step 1 – Create the ocean map using one 2D array
    public static void intro() {
        System.out.println();
        System.out.println(" ***** Welcome to the Battle Ships Game! ***** ");
        System.out.println();
        System.out.println(" Right now, the sea is empty. ");
        System.out.println();
    }

    public static void createMap() {
        // Display the coordinates
        System.out.println("    0123456789    ");
        for (int i = 0; i < oceanMap.length; i++) { // print row
            System.out.print(i + " | ");
            for (int j = 0; j < oceanMap[i].length; j++) { // print column
                if (oceanMap[i][j] == 1) {
                    System.out.print("@");

                } else if (oceanMap[i][j] == 3) {
                    System.out.print("-");

                } else if (oceanMap[i][j] == 4 || oceanMap[i][j] == 7) {
                    System.out.print("x");

                } else if (oceanMap[i][j] == 5 || oceanMap[i][j] == 8) {
                    System.out.print("!");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println(" | " + i);
        }
        System.out.println("    0123456789    ");
        System.out.println("___________________________________________________________");
    }

    // Step 2 – Deploy player’s ships
    public  static void deployPlayerShips() {
        // Ask the user the coordinates of where they would like to place their ships.
        System.out.println("Deploy your ships: ");
        int ships = 0;
        while ( ships < 5) {
            System.out.print("Enter X coordinate for your " + (ships + 1) +  ". ship: ");
            int x = input.nextInt();
            System.out.print("Enter Y coordinate for your " + (ships + 1) +  ". ship: ");
            int y = input.nextInt();

            // Update the oceanMap with player ships, then print out the map:
            // First, Check if the ship  is OK, if not re-prompt the player.
            // if OK store the player's ships within the OceanMap as '1'.
            if (x >= 0 && x <= 9 && y >= 0 && y <= 9) {
                if (oceanMap[x][y] == 0) {
                    oceanMap[x][y] = 1;
                    ships++; //  Add 1 to ships if the update is successful
                } else {
                    System.out.println("You can NOT place two or more ships on the same location. Try again");
                }
            } else {
                System.out.println("You can’t place ships outside the 10 by 10 grid. Try again");
            }
        }
        createMap();
    }

    // Step 3 – Deploy computer’s ships
    public  static void deployComputerShips() {
        System.out.println("Computer is deploying 5 ships...");
        int ships = 0;
        while (ships < 5) {
            int x = rand.nextInt(10);
            int y = rand.nextInt(10);
            if (oceanMap[x][y] == 0) { // Check if no ship in that location
                oceanMap[x][y] = 2;
                ships++; //  Add 1 to ships if the update is successful
                System.out.println(ships + ". Ship DEPLOYED ");
            }
        }
        System.out.println("___________________________________________________________");
    }

    // Step 4 – Battle
    public static void battle() {
        System.out.print("It's time to start the battle! Guess the location of your opponent’s ships.");
        System.out.println();

        int playerShips = 5;
        int computerShips = 5;
        while (playerShips > 0 && playerShips <= 5 && computerShips > 0 && computerShips <= 5) {
            // Player's Turn
            System.out.println("Your Turn");
            System.out.print("Enter X coordinate: ");
            int x = input.nextInt();
            System.out.print("Enter Y coordinate: ");
            int y = input.nextInt();

            if (x >= 0 && x <= 9 && y >= 0 && y <= 9) {
                if (oceanMap[x][y] == 0 || oceanMap[x][y] == 6 || oceanMap[x][y] == 7 || oceanMap[x][y] == 8) {
                    System.out.println("Sorry, you missed");
                    oceanMap[x][y] = 3;

                } else if (oceanMap[x][y] == 1) {
                    System.out.println("Oh no, you sunk your own ship :(");
                    oceanMap[x][y] = 4;
                    playerShips--;

                } else if (oceanMap[x][y] == 2) {
                    System.out.println("Boom! You sunk the ship!");
                    oceanMap[x][y] = 5;
                    computerShips--;

                } else {
                    System.out.println("You have guessed this location. Select new location.");
                    continue;
                }
            } else {
                System.out.println("The location is outside the 10 by 10 grid. Try again");
                continue;
            }

            // Computer's Turn
            System.out.println("Computer Turn");
            String differentLocation = "no";
            while (differentLocation.equals("no")) {
                int cx = rand.nextInt(10);
                int cy = rand.nextInt(10);

                if (oceanMap[cx][cy] == 0 || oceanMap[cx][cy] == 3 || oceanMap[cx][cy] == 4 || oceanMap[cx][cy] == 5 ) {
                    System.out.println("Computer missed");
                    oceanMap[cx][cy] = 6;
                    differentLocation = "yes";

                } else if (oceanMap[cx][cy] == 1) {
                    System.out.println("The Computer sunk one of your ships!");
                    oceanMap[cx][cy] = 7;
                    playerShips--;
                    differentLocation = "yes";

                } else if (oceanMap[cx][cy] == 2) {
                    System.out.println("The Computer sunk one of its own ships");
                    oceanMap[cx][cy] = 8;
                    computerShips--;
                    differentLocation = "yes";
                }
            }

            // Show current state after each player made a guess
            createMap();
            System.out.println();
            System.out.println("Your ships: " + playerShips + " Computer ships: " + computerShips);
        }

        // Step 5 - Game Over
        if (computerShips > playerShips) {
            System.out.println("You lose the battle");
        } else {
            System.out.println("You won the battle!");
        }

    }



}
