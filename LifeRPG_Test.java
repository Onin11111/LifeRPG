import java.util.Random;
import java.util.Scanner;

public class LifeRPG_Test {
    public static void main(String[] args) {
        Scanner onins = new Scanner(System.in);
        Random oninr = new Random();

        String RESET = "\u001B[0m";
        String BRIGHT_RED = "\u001B[91m";
        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String BRIGHT_GREEN = "\u001B[92m";
        String LIGHT_GREEN = "\u001B[92m";
        String LIME_GREEN = "\u001B[38;5;46m";
        String NEON_GREEN = "\u001B[38;5;10m";
        String SKY_BLUE = "\u001B[38;5;38m";

        String bold = "\033[1m";
        String reset = "\033[0m";

        String name, space;
        String job = "Jobless";
        int payRate = 0;
        int[] stats = {18, 100, 100, 500};

        space = "__________________";

        String welcomeText = "[Welcome to " + LIGHT_GREEN + "Life" + BRIGHT_RED + bold + "R" + GREEN + bold + "P" + SKY_BLUE + bold + "G" + reset + "]" + RESET;
        for (int i = 0; i < welcomeText.length(); i++) {
            System.out.print(welcomeText.charAt(i));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println();
        String charNameText = "[Enter your character's name: ";
        for (int i = 0; i < charNameText.length(); i++) {
            System.out.print(charNameText.charAt(i));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        name = onins.nextLine();

        String startText = "[Hello " + LIME_GREEN + name + RESET + "! Let's see how your life goes.]";
        for (int i = 0; i < startText.length(); i++) {
            System.out.print(startText.charAt(i));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        boolean isAlive = true;

        while (isAlive) {
            System.out.println();
            System.out.println(space);
            System.out.println(YELLOW + bold + "[--- Life Stats ---]" + reset + RESET);
            System.out.println(LIGHT_GREEN + "[Name: " + bold + name + reset + LIGHT_GREEN + "]" + reset + RESET);
            System.out.println(LIGHT_GREEN + "[Age: " + bold + stats[0] + reset + LIGHT_GREEN + "]" + reset + RESET);
            System.out.println(BRIGHT_GREEN + "[Health: " + bold + stats[1] + reset + BRIGHT_GREEN + "]" + reset + RESET);
            System.out.println(NEON_GREEN + "[Happiness: " + bold + stats[2] + reset + LIGHT_GREEN + "]" + reset + RESET);
            System.out.println(LIME_GREEN + "[Money: " + bold + "₱" + stats[3] + reset + LIGHT_GREEN + "]" + reset + RESET);
            System.out.println(LIME_GREEN + "[Job: " + job + "]" + RESET);

            System.out.println(space);
            System.out.println(YELLOW + bold + "[--- Choose an action ---]" + reset);
            System.out.println(LIGHT_GREEN + "[1] " + bold + "[Age Up]" + reset);
            System.out.println(LIGHT_GREEN + "[2] " + bold + "[Work]" + reset);
            System.out.println(SKY_BLUE + "[3] " + bold + "[Shop]" + reset);
            System.out.println(SKY_BLUE + "[4] " + bold + "[Gamble]" + reset);
            System.out.println(BRIGHT_RED + "[5] " + bold + "[Retire]" + reset);
            System.out.print("Your choice: ");
            int actionChoice = onins.nextInt();
            System.out.println(space);

            switch (actionChoice) {
                case 1:
                    String ageUpText = "[You're getting older...]";
                    for (int i = 0; i < ageUpText.length(); i++) {
                        System.out.print(ageUpText.charAt(i));
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println();

                    ageUp(oninr, onins, stats, job, payRate);

                    if (stats[1] <= 0) {
                        System.out.println("\n[You've died at the age of " + stats[0] + ". GG]");
                        isAlive = false;
                    }

                    stats[0]++;
                    stats[1] = Math.min(stats[1], 100);
                    stats[2] = Math.min(stats[2], 100);
                break;

                case 2:
                break;

                case 3:
                    System.out.println(YELLOW + bold + "[--- Shop ---]" + reset + RESET);

                    System.out.println(GREEN + "[1] " + bold + "Health Potion (+30 Health | -₱100)" + reset + RESET);
                    System.out.println(GREEN + "[2] " + bold + "Happiness Book (+20 Happiness | -₱150)" + reset + RESET);
                    System.out.println(BRIGHT_RED + "[3] " + "[Exit Shop]" + RESET);
                    System.out.print("Your choice: ");
                    int choice = onins.nextInt();
                    switch (choice) {
                        case 1:
                            if (stats[3] >= 100) {
                                stats[1] = Math.min(100, stats[1] + 30);
                                stats[3] -= 100;
                                System.out.println(GREEN + "[You bought a Health Potion. Health restored!]" + RESET);
                            } else {
                                System.out.println(BRIGHT_RED + "[Not enough money!]" + RESET);
                            }
                            break;
                        case 2:
                            if (stats[3] >= 150) {
                                stats[2] = Math.min(100, stats[2] + 20);
                                stats[3] -= 150;
                                System.out.println(GREEN + "[You bought a Happiness Book. Feeling happy!]" + RESET);
                            } else {
                                System.out.println(BRIGHT_RED + "[Not enough money!]" + RESET);
                            }
                            break;
                        case 3:
                            System.out.println(YELLOW + "[Leaving the shop.]" + RESET);
                            break;
                        default:
                            System.out.println(BRIGHT_RED + "[Invalid choice.]" + RESET);
                    }
                    break;

                case 4:
                    System.out.println(YELLOW + "[Welcome to the Color Guessing Game]" + RESET);

                    boolean playAgain = true;

                    while (playAgain) {
                        System.out.print("\n[How much do you want to bet?] ");
                        double bet = onins.nextDouble();

                        if (bet > stats[3]) {
                            System.out.println(BRIGHT_RED + "[You don't have enough money to place that bet!]" + RESET);
                            break;
                        }

                        int randomColor = oninr.nextInt(3) + 1;

                        System.out.println("\n[Guess a color:]:");
                        System.out.println(BRIGHT_RED + "[1] → [Red❤️ ]" + RESET);
                        System.out.println(SKY_BLUE + "[2] → [Blue💙 ]" + RESET);
                        System.out.println(GREEN +  "[3] → [Green💚 ]" + RESET);
                        System.out.print("\nEnter the number of your guess (1-3): ");
                        int userGuess = onins.nextInt();

                        if (userGuess < 1 || userGuess > 3) {
                            System.out.println(BRIGHT_RED + "[Invalid guess! Please guess a number between 1 and 3.]" + RESET);
                        } else {
                            switch (userGuess) {
                                case 1:
                                    System.out.println(BRIGHT_RED + "[You've chosen Red❤️!]" + RESET);
                                    break;
                                case 2:
                                    System.out.println(SKY_BLUE + "[You've chosen Blue💙!]" + RESET);
                                    break;
                                case 3:
                                    System.out.println(GREEN + "[You've chosen Green💚!]" + RESET);
                                    break;
                            }

                            if (userGuess == randomColor) {
                                System.out.println(GREEN + "[You guessed it right!]" + RESET);
                                double winnings = bet * 2;
                                stats[3] += winnings;
                                System.out.println(GREEN + "[You win ₱" + winnings + "!]" + RESET);
                            } else {
                                System.out.println(BRIGHT_RED + "[You guessed it wrong.]" + RESET);
                                stats[3] -= bet;
                                System.out.println(BRIGHT_RED + "[You lose your bet of ₱" + bet + "]" + RESET);

                                System.out.println("[Current Money: ₱" + stats[3] + "]");
                            }
                        }

                        System.out.print("\nDo you want to try again? (Y/N): ");
                        char response = onins.next().charAt(0);

                        if (response == 'N' || response == 'n') {
                            playAgain = false;
                            System.out.println("Thank you for playing! Goodbye!");
                        }
                    }
                    break;

                case 5:
                    String retireText = "[You have retired. Thank you for playing!]";
                    for (int i = 0; i < retireText.length(); i++) {
                        System.out.print(retireText.charAt(i));
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    isAlive = false;
                    break;

                default:
                    System.out.println("[Invalid choice! Please select 1-5 only.]");
            }
        }

        onins.close();
    }

    private static void ageUp(Random oninr, Scanner onins, int[] stats, String job, int payRate) {
        int event = oninr.nextInt(3);
    
        switch (event) {
            case 0:
                System.out.println("\nEvent: 🍴 Lunch Break");
                System.out.println("\nIt's lunchtime, and you're deciding where to eat.");
                System.out.println("1. 🍛 Eat at a local carinderia");
                System.out.println("2. 🍔 Go to a fast-food chain");
                System.out.print("Your choice: ");
                int lunchChoice0 = onins.nextInt();
            
                if (lunchChoice0 == 1) {
                    int healthGain = oninr.nextInt(6) + 5;
                    int happinessGain = oninr.nextInt(6) + 5;
                    int cost = oninr.nextInt(51) + 50;
            
                    stats[1] += healthGain;
                    stats[2] += happinessGain;
                    stats[3] -= cost;
            
                    System.out.println("You enjoyed a simple, affordable meal that kept you satisfied.");
                    System.out.println("Health: +" + healthGain + " | Happiness: +" + happinessGain + " | Cost: -₱" + cost);
                } else if (lunchChoice0 == 2) {
                    int healthLoss = oninr.nextInt(6) + 5;
                    int happinessGain = oninr.nextInt(6) + 10;
                    int cost = oninr.nextInt(51) + 150;
            
                    stats[1] -= healthLoss;
                    stats[2] += happinessGain;
                    stats[3] -= cost;
            
                    System.out.println("You splurged on fast food, which lifted your mood but wasn’t the healthiest choice.");
                    System.out.println("Health: -" + healthLoss + " | Happiness: +" + happinessGain + " | Cost: -₱" + cost);
                } else {
                    System.out.println("Invalid choice. Please select a valid option.");
                }
                break;

            case 1:
                System.out.println("\nEvent: 🐕 Pet Adoption");
                System.out.println("\nYou see a stray dog needing a home.");
                System.out.println("1. 🐾 Adopt the dog");
                System.out.println("2. ️🚶 Walk away");
                System.out.print("Your choice: ");
                int workChoice12 = onins.nextInt();
    
                if (workChoice12 == 1) {
                    int healthGain = oninr.nextInt(16) + 5;
                    int happinessGain = oninr.nextInt(26) + 25;
                    int cost = oninr.nextInt(101) + 200;
    
                    stats[1] += healthGain;
                    stats[2] += happinessGain;
                    stats[3] -= cost;
    
                    System.out.println("You gained a loyal companion, but it came with added responsibility.");
                    System.out.println("Health: +" + healthGain + " | Happiness: +" + happinessGain + " | Cost: -₱" + cost);
                } else if (workChoice12 == 2) {
                    int healthGain = oninr.nextInt(0) + 0;
                    int happinessGain = oninr.nextInt(16) + 5;
                    int cost = oninr.nextInt(0) + 0;
    
                    stats[1] += healthGain;
                    stats[2] -= happinessGain;
                    stats[3] -= cost;
    
                    System.out.println("You avoided extra costs, but felt a pang of guilt for not helping.");
                    System.out.println("Health: +" + healthGain + " | Happiness: +" + happinessGain + " | Cost: -₱" + cost);
                } else {
                    System.out.println("Invalid choice. Please select a valid option.");
                }
                break;

            case 2:
                System.out.println("\n[Nothing happened this year.]");
                break;
    
        }
    }    
}
