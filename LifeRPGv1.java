// Game Project, Cenaon, LifeRPG 1.0.2

import java.util.Random;
import java.util.Scanner;

public class LifeRPGv1 {
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
        int[] stats = {18, 100, 100, 500, 19};

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
        String charNameText = "[Enter your character's name]: ";
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
            System.out.println(LIME_GREEN + "[Money: " + bold + stats[3] + reset + LIGHT_GREEN + "]" + reset + RESET);

            System.out.println(space);
            System.out.println(YELLOW + bold + "[--- Choose an action ---]" + reset);
            System.out.println(LIGHT_GREEN + "[1] " + bold + "[Age Up]" + reset);
            System.out.println(LIGHT_GREEN + "[2] " + bold + "[Work]" + reset);
            System.out.println(SKY_BLUE + "[3] " + bold + "[Shop]" + reset);
            System.out.println(SKY_BLUE + "[4] " + bold + "[Gamble]" + reset);
            System.out.println(BRIGHT_RED + "[5] " + bold + "[Retire]" + reset);
            System.out.print("Your choice: ");
            int actionChoice = onins.nextInt();
            System.out.print(space);

            switch (actionChoice) {
                case 1:
                    System.out.println(LIME_GREEN + "\n[You're getting older...]" + RESET);
                    System.out.println(LIME_GREEN + "[You've turned " + stats[4] + "]" + RESET);
                    
                    int event = oninr.nextInt(28);

                    switch (event) {
                        case 1:
                            System.out.println(YELLOW + "\nEvent: 🍴 Lunch Break");
                            System.out.println(YELLOW + "\nIt's lunchtime, and you're deciding where to eat.");
                            System.out.println(LIME_GREEN + "[1] [🍛 Eat at a local carinderia]");
                            System.out.println(LIME_GREEN + "[2] [🍔 Go to a fast-food chain]");
                            System.out.print("Your choice: ");
                            int eventChoice1 = onins.nextInt();

                            if (eventChoice1 == 1) {
                                int healthGain = oninr.nextInt(10) + 5;
                                int happinessGain = oninr.nextInt(10) + 5;
                                int cost = oninr.nextInt(61) + 30;

                                stats[1] += healthGain;
                                stats[2] += happinessGain;
                                stats[3] -= cost;

                                System.out.println(LIME_GREEN + "\n[You enjoyed a simple, affordable meal that kept you satisfied.]" + RESET);
                                System.out.println(LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET + LIGHT_GREEN + "[Happiness: + " + happinessGain + " ] " + RESET + BRIGHT_RED + " [ Cost: - " + cost + " ] " + RESET);

                            } else if (eventChoice1 == 2) {
                                int healthGain = oninr.nextInt(11) + 5;
                                int happinessGain = oninr.nextInt(16) + 5;
                                int cost = oninr.nextInt(101) + 100;

                                stats[1] -= healthGain;
                                stats[2] += happinessGain;
                                stats[3] -= cost;

                                System.out.println(LIME_GREEN+ "\n[You splurged on fast food, which lifted your mood but wasn’t the healthiest choice.]");
                                System.out.println(BRIGHT_RED + "[Health: -" + healthGain + " ] " + RESET + BRIGHT_RED + "[ Happiness: -" + happinessGain + " ]" + RESET);
                            } else {
                                System.out.println("[Invalid choice. Please select a valid option.]");
                            }
                            break;

                        case 2:
                            System.out.println("\n[Nothing happened this year.]");
                            break;
                
                        case 3:
                            System.out.println(YELLOW + "\nEvent: 🌧️ Bad Weather");
                            System.out.println(YELLOW + "\nA storm has passed through the area. You're deciding what to do.");
                            System.out.println(LIME_GREEN + "[1] [☔ Stay indoors and relax]");
                            System.out.println(LIME_GREEN + "[2] [🌬️ Brave the weather and go for a walk]");
                            System.out.print("Your choice: ");
                            int eventChoice3 = onins.nextInt();
                        
                            if (eventChoice3 == 1) {
                                int happinessGain = oninr.nextInt(11) + 5;
                                int healthLoss = oninr.nextInt(16) + 10;
                                int cost = oninr.nextInt(21) + 10;
                        
                                stats[1] -= healthLoss;
                                stats[2] += happinessGain;
                                stats[3] -= cost;
                        
                                System.out.println(LIME_GREEN + "\n[You enjoyed the comfort of your home while staying dry, but it cost you a bit.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + BRIGHT_RED + "[Health: -" + healthLoss + " ] " + RESET + BRIGHT_RED + "[ Cost: - " + cost + " ]" + RESET);
                            } else if (eventChoice3 == 2) {
                                int healthGain = oninr.nextInt(6) + 0;
                                int happinessLoss = oninr.nextInt(16) + 10;
                                int cost = oninr.nextInt(31) + 20;
                        
                                stats[1] += healthGain;
                                stats[2] -= happinessLoss;
                                stats[3] -= cost;
                        
                                System.out.println(LIME_GREEN + "\n[You braved the storm and felt refreshed after a walk, but the weather wasn’t enjoyable.]");
                                System.out.println(LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET + BRIGHT_RED + "[Happiness: -" + happinessLoss + " ]" + RESET);
                            } else {
                                System.out.println("[Invalid choice. Please select a valid option.]");
                            }
                            break;
                        
                        case 4:
                            System.out.println(YELLOW + "\nEvent: 🛒 Shopping Spree");
                            System.out.println(YELLOW + "\nYou have some extra cash and you're thinking of treating yourself.");
                            System.out.println(LIME_GREEN + "[1] [🛍️ Buy new clothes]");
                            System.out.println(LIME_GREEN + "[2] [🎮 Buy a new game]");
                            System.out.print("Your choice: ");
                            int eventChoice4 = onins.nextInt();
                        
                            if (eventChoice4 == 1) {
                                int happinessGain = oninr.nextInt(16) + 10;
                                int cost = oninr.nextInt(301) + 200;
                        
                                stats[2] += happinessGain;
                                stats[3] -= cost;
                        
                                System.out.println(LIME_GREEN + "\n[You bought some new clothes and feel great about it.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + BRIGHT_RED + "[ Cost: - " + cost + " ]" + RESET);
                            } else if (eventChoice4 == 2) {
                                int happinessGain = oninr.nextInt(16) + 10;
                                int healthLoss = oninr.nextInt(26) + 20;
                                int cost = oninr.nextInt(501) + 300;
                        
                                stats[2] += happinessGain;
                                stats[1] -= healthLoss;
                                stats[3] -= cost;
                        
                                System.out.println(LIME_GREEN + "\n[You got a new game! It was a lot of fun, but you spent a bit too much.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + BRIGHT_RED + "[Health: -" + healthLoss + " ]" + RESET);
                            } else {
                                System.out.println("[Invalid choice. Please select a valid option.]");
                            }
                            break;
                        
                        case 5:
                            System.out.println(YELLOW + "\nEvent: 🚴‍♀️ Weekend Adventure");
                            System.out.println(YELLOW + "\nIt's the weekend! You have a free day to explore.");
                            System.out.println(LIME_GREEN + "[1] [🏞️ Go for a nature hike]");
                            System.out.println(LIME_GREEN + "[2] [🎡 Visit a theme park]");
                            System.out.print("Your choice: ");
                            int eventChoice5 = onins.nextInt();
                        
                            if (eventChoice5 == 1) {
                                int healthGain = oninr.nextInt(16) + 10;
                                int happinessGain = oninr.nextInt(16) + 10;
                                int cost = oninr.nextInt(51) + 20;
                        
                                stats[1] += healthGain;
                                stats[2] += happinessGain;
                                stats[3] -= cost;
                        
                                System.out.println(LIME_GREEN + "\n[You spent the day outdoors, which gave you a boost in health and mood.]");
                                System.out.println(LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET + LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + BRIGHT_RED + "[ Cost: - " + cost + " ]" + RESET);
                            } else if (eventChoice5 == 2) {
                                int healthGain = oninr.nextInt(6) + 0;
                                int happinessGain = oninr.nextInt(16) + 5;
                                int cost = oninr.nextInt(301) + 250;
                        
                                stats[1] += healthGain;
                                stats[2] += happinessGain;
                                stats[3] -= cost;
                        
                                System.out.println(LIME_GREEN + "\n[You had a blast at the theme park, but it was a bit expensive.]");
                                System.out.println(LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET + LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + BRIGHT_RED + "[ Cost: - " + cost + " ]" + RESET);
                            } else {
                                System.out.println("[Invalid choice. Please select a valid option.]");
                            }
                            break;
                        
                        case 6:
                            System.out.println(YELLOW + "\nEvent: 🎉 Birthday Party");
                            System.out.println(YELLOW + "\nIt's your friend's birthday party. You're invited, but you're not sure if you should go.");
                            System.out.println(LIME_GREEN + "[1] [🎂 Attend the party]");
                            System.out.println(LIME_GREEN + "[2] [🚶‍♀️ Stay home and relax]");
                            System.out.print("Your choice: ");
                            int eventChoice6 = onins.nextInt();
                        
                            if (eventChoice6 == 1) {
                                int happinessGain = oninr.nextInt(11) + 10;
                                int healthLoss = oninr.nextInt(11) + 5;
                                int cost = oninr.nextInt(151) + 50;
                        
                                stats[1] -= healthLoss;
                                stats[2] += happinessGain;
                                stats[3] -= cost;
                        
                                System.out.println(LIME_GREEN + "\n[You had a great time at the party, but it cost you a bit.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + BRIGHT_RED + "[Health: -" + healthLoss + " ]" + RESET + BRIGHT_RED + "[ Cost: - " + cost + " ]" + RESET);
                            } else if (eventChoice6 == 2) {
                                int healthGain = oninr.nextInt(11) + 5;
                                int happinessLoss = oninr.nextInt(11) + 5;
                        
                                stats[1] += healthGain;
                                stats[2] -= happinessLoss;
                        
                                System.out.println(LIME_GREEN + "\n[You enjoyed a quiet day at home, but missed out on the fun.]");
                                System.out.println(LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET + BRIGHT_RED + "[Happiness: -" + happinessLoss + " ]" + RESET);
                            } else {
                                System.out.println("[Invalid choice. Please select a valid option.]");
                            }
                            break;

                        case 7:
                            System.out.println(YELLOW + "\nEvent: 🐾 Adopt a Pet");
                            System.out.println(YELLOW + "\nYou’re considering adopting a pet. It could bring joy, but it's a big responsibility.");
                            System.out.println(LIME_GREEN + "[1] [🐱 Adopt a cat]");
                            System.out.println(LIME_GREEN + "[2] [🐶 Adopt a dog]");
                            System.out.print("Your choice: ");
                            int eventChoice7 = onins.nextInt();
                        
                            if (eventChoice7 == 1) {
                                int happinessGain = oninr.nextInt(6) + 0;
                                int healthLoss = oninr.nextInt(6) + 0;
                                int cost = oninr.nextInt(1501) + 1000;
                        
                                stats[1] -= healthLoss;
                                stats[2] += happinessGain;
                                stats[3] -= cost;
                        
                                System.out.println(LIME_GREEN + "\n[You adopted a cat, and it brought you some joy, but it's a bit of work.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + BRIGHT_RED + "[Health: -" + healthLoss + " ]" + RESET + BRIGHT_RED + "[ Cost: - " + cost + " ]" + RESET);
                            } else if (eventChoice7 == 2) {
                                int happinessGain = oninr.nextInt(11) + 10;
                                int healthLoss = oninr.nextInt(16) + 10;
                                int cost = oninr.nextInt(2501) + 2000;
                        
                                stats[1] -= healthLoss;
                                stats[2] += happinessGain;
                                stats[3] -= cost;
                        
                                System.out.println(LIME_GREEN + "\n[You adopted a dog, and it made you very happy, but it’s a lot of work.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + BRIGHT_RED + "[Health: -" + healthLoss + " ]" + RESET + BRIGHT_RED + "[ Cost: - " + cost + " ]" + RESET);
                            } else {
                                System.out.println("[Invalid choice. Please select a valid option.]");
                            }
                            break;
                        
                        case 8:
                            System.out.println(YELLOW + "\nEvent: 🎬 Movie Night");
                            System.out.println(YELLOW + "\nIt's the weekend, and you're deciding whether to watch a movie.");
                            System.out.println(LIME_GREEN + "[1] [🍿 Watch a movie at the theater");
                            System.out.println(LIME_GREEN + "[2] [📱 Stream a movie at home]");
                            System.out.print("Your choice: ");
                            int eventChoice8 = onins.nextInt();
                        
                            if (eventChoice8 == 1) {
                                int happinessGain = oninr.nextInt(6) + 0;
                                int healthLoss = oninr.nextInt(6) + 0;
                                int cost = oninr.nextInt(251) + 150;
                        
                                stats[1] -= healthLoss;
                                stats[2] += happinessGain;
                                stats[3] -= cost;
                        
                                System.out.println(LIME_GREEN + "\n[You enjoyed the movie theater experience, but the popcorn wasn't the healthiest choice.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + BRIGHT_RED + "[Health: -" + healthLoss + " ]" + RESET + BRIGHT_RED + "[ Cost: - " + cost + " ]" + RESET);
                            } else if (eventChoice8 == 2) {
                                int happinessGain = oninr.nextInt(11) + 5;
                                int healthGain = oninr.nextInt(6) + 0;
                                int cost = oninr.nextInt(51) + 20;
                        
                                stats[1] += healthGain;
                                stats[2] += happinessGain;
                                stats[3] -= cost;
                        
                                System.out.println(LIME_GREEN + "\n[You relaxed with a movie at home, and you feel healthier afterwards.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET + BRIGHT_RED + "[ Cost: - " + cost + " ]" + RESET);
                            } else {
                                System.out.println("[Invalid choice. Please select a valid option.]");
                            }
                            break;
                        
                        case 9:
                            System.out.println(YELLOW + "\nEvent: 📚 Study Break");
                            System.out.println(YELLOW + "\nYou've been studying a lot lately. It's time for a short break.");
                            System.out.println(LIME_GREEN + "[1] [🍵 Drink tea and relax]");
                            System.out.println(LIME_GREEN + "[2] [📱 Scroll through social media]");
                            System.out.print("Your choice: ");
                            int eventChoice9 = onins.nextInt();
                        
                            if (eventChoice9 == 1) {
                                int healthGain = oninr.nextInt(6) + 0;
                                int happinessGain = oninr.nextInt(11) + 5;
                                int cost = oninr.nextInt(31) + 20;
                        
                                stats[1] += healthGain;
                                stats[2] += happinessGain;
                                stats[3] -= cost;
                        
                                System.out.println(LIME_GREEN + "\n[You had a calming tea break and feel a bit better.]");
                                System.out.println(LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET + LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + BRIGHT_RED + "[ Cost: - " + cost + " ]" + RESET);
                            } else if (eventChoice9 == 2) {
                                int happinessGain = oninr.nextInt(6) + 10;
                                int healthLoss = oninr.nextInt(6) + 5;
                                int cost = oninr.nextInt(21) + 10;
                        
                                stats[1] -= healthLoss;
                                stats[2] += happinessGain;
                                stats[3] -= cost;
                        
                                System.out.println(LIME_GREEN + "\n[You had fun scrolling through social media, but it wasn’t the healthiest break.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + BRIGHT_RED + "[Health: -" + healthLoss + " ]" + RESET + BRIGHT_RED + "[ Cost: - " + cost + " ]" + RESET);
                            } else {
                                System.out.println("[Invalid choice. Please select a valid option.]");
                            }
                            break;
                        
                        case 10:
                            System.out.println(YELLOW + "\nEvent: 💻 Work Overtime");
                            System.out.println(YELLOW + "\nYour boss has asked you to stay overtime and finish an important project.");
                            System.out.println(LIME_GREEN + "[1] [💼 Work overtime]");
                            System.out.println(LIME_GREEN + "[2] [⏰ Decline and leave on time]");
                            System.out.print("Your choice: ");
                            int eventChoice10 = onins.nextInt();
                        
                            if (eventChoice10 == 1) {
                                int happinessGain = oninr.nextInt(11) + 5;
                                int healthLoss = oninr.nextInt(16) + 10;
                                int cost = oninr.nextInt(201) + 150;
                        
                                stats[1] -= healthLoss;
                                stats[2] -= happinessGain;
                                stats[3] += cost;
                        
                                System.out.println(LIME_GREEN + "\n[You worked late and completed the project, but you're feeling drained.]");
                                System.out.println(BRIGHT_RED + "[Happiness: +" + happinessGain + " ] " + RESET + BRIGHT_RED + "[Health: -" + healthLoss + " ]" + RESET + LIGHT_GREEN + "[ Cost: - " + cost + " ]" + RESET);
                            } else if (eventChoice10 == 2) {
                                int healthGain = oninr.nextInt(11) + 5;
                                int happinessLoss = oninr.nextInt(6) + 0;
                        
                                stats[1] += healthGain;
                                stats[2] -= happinessLoss;
                        
                                System.out.println(LIME_GREEN + "\n[You left work on time and felt better, but you're a bit disappointed.]");
                                System.out.println(LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET + BRIGHT_RED + "[Happiness: -" + happinessLoss + " ]" + RESET);
                            } else {
                                System.out.println("[Invalid choice. Please select a valid option.]");
                            }
                            break;
                        
                        case 11:
                            System.out.println(YELLOW + "\nEvent: 🌳 Nature Walk");
                            System.out.println(YELLOW + "\nYou decide to take a break and go for a walk in the park to clear your mind.");
                            System.out.println(LIME_GREEN + "[1] [🚶‍♂️ Take a relaxing walk in the park]");
                            System.out.println(LIME_GREEN + "[2] [🧘‍♀️ Do some light exercise at the park]");
                            System.out.print("Your choice: ");
                            int eventChoice11 = onins.nextInt();
                        
                            if (eventChoice11 == 1) {
                                int healthGain = oninr.nextInt(16) + 10;
                                int happinessGain = oninr.nextInt(11) + 5;
                        
                                stats[1] += healthGain;
                                stats[2] += happinessGain;
                        
                                System.out.println(LIME_GREEN + "\n[You had a peaceful walk in nature, which improved both your health and mood.]");
                                System.out.println(LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET + LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET);
                            } else if (eventChoice11 == 2) {
                                int healthGain = oninr.nextInt(16) + 10;
                                int happinessGain = oninr.nextInt(16) + 10;
                        
                                stats[1] += healthGain;
                                stats[2] += happinessGain;
                        
                                System.out.println(LIME_GREEN + "\n[You exercised in the park, feeling revitalized and much happier.]");
                                System.out.println(LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET + LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET);
                            } else {
                                System.out.println("[Invalid choice. Please select a valid option.]");
                            }
                            break;
                        
                        case 12:
                            System.out.println(YELLOW + "\nEvent: 🏠 Home Improvement");
                            System.out.println(YELLOW + "\nYou’ve been thinking about redecorating or fixing up your living space.");
                            System.out.println(LIME_GREEN + "[1] [🖼️ Buy new furniture and redecorate]");
                            System.out.println(LIME_GREEN + "[2] [🔨 Do the repairs yourself]");
                            System.out.print("Your choice: ");
                            int eventChoice12 = onins.nextInt();
                        
                            if (eventChoice12 == 1) {
                                int healthGain = oninr.nextInt(11) + 5;
                                int happinessGain = oninr.nextInt(16) + 10;
                                int cost = oninr.nextInt(2501) + 1500;
                        
                                stats[1] += healthGain;
                                stats[2] += happinessGain;
                                stats[3] -= cost;
                        
                                System.out.println(LIME_GREEN + "\n[You redecorated your space, and it made your home more comfortable and pleasant.]");
                                System.out.println(LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET + LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + BRIGHT_RED + "[Cost: - " + cost + " ]" + RESET);
                            } else if (eventChoice12 == 2) {
                                int healthGain = oninr.nextInt(11) + 10;
                                int happinessGain = oninr.nextInt(11) + 5;
                                int cost = oninr.nextInt(501) + 400;
                        
                                stats[1] += healthGain;
                                stats[2] += happinessGain;
                                stats[3] -= cost;
                        
                                System.out.println(LIME_GREEN + "\n[You did the repairs yourself, and it felt rewarding to improve your living space.]");
                                System.out.println(LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET + LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + BRIGHT_RED + "[Cost: - " + cost + " ]" + RESET);
                            } else {
                                System.out.println("[Invalid choice. Please select a valid option.]");
                            }
                            break;
                        
                        case 13:
                            System.out.println(YELLOW + "\nEvent: 💼 Business Opportunity");
                            System.out.println(YELLOW + "\nA friend invites you to start a small business together. It sounds like a great opportunity!");
                            System.out.println(LIME_GREEN + "[1] [💡 Start a small business]");
                            System.out.println(LIME_GREEN + "[2] [🚫 Decline and focus on your current job]");
                            System.out.print("Your choice: ");
                            int eventChoice13 = onins.nextInt();
                        
                            if (eventChoice13 == 1) {
                                int happinessGain = oninr.nextInt(30) + 20;
                                int healthGain = oninr.nextInt(11) + 5;
                                int cost = oninr.nextInt(5001) + 2000;
                        
                                stats[1] += healthGain;
                                stats[2] += happinessGain;
                                stats[3] -= cost;
                        
                                System.out.println(LIME_GREEN + "\n[You invested in a small business venture with your friend. It was risky but exciting.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET + BRIGHT_RED + "[Cost: - " + cost + " ]" + RESET);
                            } else if (eventChoice13 == 2) {
                                int happinessGain = oninr.nextInt(16) + 10;
                                int healthGain = oninr.nextInt(16) + 5;
                        
                                stats[1] += healthGain;
                                stats[2] += happinessGain;
                        
                                System.out.println(LIME_GREEN + "\n[You decided to decline the business opportunity, but you're happy with your current job.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET);
                            } else {
                                System.out.println("[Invalid choice. Please select a valid option.]");
                            }
                            break;
                        
                        case 14:
                            System.out.println(YELLOW + "\nEvent: 🏖️ Vacation Time");
                            System.out.println(YELLOW + "\nYou’ve been working hard and now have some time off. It’s the perfect moment to unwind.");
                            System.out.println(LIME_GREEN + "[1] [✈️ Go on a vacation abroad]");
                            System.out.println(LIME_GREEN + "[2] [🏡 Stay home and relax]");
                            System.out.print("Your choice: ");
                            int eventChoice14 = onins.nextInt();
                        
                            if (eventChoice14 == 1) {
                                int happinessGain = oninr.nextInt(30) + 25;
                                int healthLoss = oninr.nextInt(6) + 5;
                                int cost = oninr.nextInt(10001) + 5000;
                        
                                stats[1] -= healthLoss;
                                stats[2] += happinessGain;
                                stats[3] -= cost;
                        
                                System.out.println(LIME_GREEN + "\n[You took a vacation abroad and had a great time, but the trip was costly.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + BRIGHT_RED + "[Health: -" + healthLoss + " ]" + RESET + BRIGHT_RED + "[Cost: - " + cost + " ]" + RESET);
                            } else if (eventChoice14 == 2) {
                                int happinessGain = oninr.nextInt(6) + 5;
                                int healthGain = oninr.nextInt(11) + 8;
                        
                                stats[1] += healthGain;
                                stats[2] += happinessGain;
                        
                                System.out.println(LIME_GREEN + "\n[You had a relaxing staycation, recharging your health and happiness.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET);
                            } else {
                                System.out.println("[Invalid choice. Please select a valid option.]");
                            }
                            break;

                        case 15:
                            System.out.println(YELLOW + "\nEvent: 📚 Book Reading");
                            System.out.println(YELLOW + "\nYou find yourself with some free time and decide to pick up a book.");
                            System.out.println(LIME_GREEN + "[1] [📖 Read a self-help book]");
                            System.out.println(LIME_GREEN + "[2] [📚 Read a fiction novel]");
                            System.out.print("Your choice: ");
                            int eventChoice15 = onins.nextInt();
                        
                            if (eventChoice15 == 1) {
                                int healthGain = oninr.nextInt(6) + 5;
                                int happinessGain = oninr.nextInt(11) + 10;
                        
                                stats[1] += healthGain;
                                stats[2] += happinessGain;
                        
                                System.out.println(LIME_GREEN + "\n[You gained some useful knowledge and felt motivated after reading the book.]");
                                System.out.println(LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET + LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET);
                            } else if (eventChoice15 == 2) {
                                int happinessGain = oninr.nextInt(11) + 5;
                                int healthLoss = oninr.nextInt(6) + 2;
                        
                                stats[1] -= healthLoss;
                                stats[2] += happinessGain;
                        
                                System.out.println(LIME_GREEN + "\n[The novel was a thrilling escape, but you ended up staying up too late.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + BRIGHT_RED + "[Health: -" + healthLoss + " ]" + RESET);
                            } else {
                                System.out.println("[Invalid choice. Please select a valid option.]");
                            }
                            break;
                        
                        case 16:
                            System.out.println(YELLOW + "\nEvent: 🐶 Adopt a Pet");
                            System.out.println(YELLOW + "\nYou’re walking down the street when you see a cute dog that’s up for adoption.");
                            System.out.println(LIME_GREEN + "[1] [🐕 Adopt the dog]");
                            System.out.println(LIME_GREEN + "[2] [🚶‍♂️ Keep walking and avoid the temptation]");
                            System.out.print("Your choice: ");
                            int eventChoice16 = onins.nextInt();
                        
                            if (eventChoice16 == 1) {
                                int happinessGain = oninr.nextInt(26) + 20;
                                int healthLoss = oninr.nextInt(6) + 2;
                                int cost = oninr.nextInt(2001) + 1000;
                        
                                stats[1] -= healthLoss;
                                stats[2] += happinessGain;
                                stats[3] -= cost;
                        
                                System.out.println(LIME_GREEN + "\n[You adopted the dog, and it brought a lot of joy to your life, but the care costs add up.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + BRIGHT_RED + "[Health: -" + healthLoss + " ]" + RESET + BRIGHT_RED + "[Cost: - " + cost + " ]" + RESET);
                            } else if (eventChoice16 == 2) {
                                int happinessGain = oninr.nextInt(6) + 10;
                                int healthGain = oninr.nextInt(11) + 5;
                        
                                stats[1] += healthGain;
                                stats[2] += happinessGain;
                        
                                System.out.println(LIME_GREEN + "\n[You decided not to adopt the dog, but you felt good about the decision and had a nice walk.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET);
                            } else {
                                System.out.println("[Invalid choice. Please select a valid option.]");
                            }
                            break;
                        
                        case 17:
                            System.out.println(YELLOW + "\nEvent: 🎤 Karaoke Night");
                            System.out.println(YELLOW + "\nYour friends are going out for a karaoke night. It sounds like a blast!");
                            System.out.println(LIME_GREEN + "[1] [🎶 Join the karaoke night]");
                            System.out.println(LIME_GREEN + "[2] [🎧 Skip it and have a quiet evening at home]");
                            System.out.print("Your choice: ");
                            int eventChoice17 = onins.nextInt();
                        
                            if (eventChoice17 == 1) {
                                int happinessGain = oninr.nextInt(16) + 10;
                                int healthLoss = oninr.nextInt(6) + 3;
                                int cost = oninr.nextInt(401) + 100;
                        
                                stats[1] -= healthLoss;
                                stats[2] += happinessGain;
                                stats[3] -= cost;
                        
                                System.out.println(LIME_GREEN + "\n[You had a fun night out singing with friends, but it was a little too loud.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + BRIGHT_RED + "[Health: -" + healthLoss + " ]" + RESET + BRIGHT_RED + "[Cost: - " + cost + " ]" + RESET);
                            } else if (eventChoice17 == 2) {
                                int happinessGain = oninr.nextInt(6) + 5;
                                int healthGain = oninr.nextInt(11) + 5;
                        
                                stats[1] += healthGain;
                                stats[2] += happinessGain;
                        
                                System.out.println(LIME_GREEN + "\n[You had a peaceful night in, catching up on rest and recharging.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET);
                            } else {
                                System.out.println("[Invalid choice. Please select a valid option.]");
                            }
                            break;
                        
                        case 18:
                            System.out.println(YELLOW + "\nEvent: 🍷 Wine Tasting");
                            System.out.println(YELLOW + "\nA local vineyard is offering a wine tasting event. You’ve never been to one before!");
                            System.out.println(LIME_GREEN + "[1] [🍇 Go to the wine tasting event]");
                            System.out.println(LIME_GREEN + "[2] [🥤 Skip the event and stay home]");
                            System.out.print("Your choice: ");
                            int eventChoice18 = onins.nextInt();
                        
                            if (eventChoice18 == 1) {
                                int happinessGain = oninr.nextInt(11) + 15;
                                int healthLoss = oninr.nextInt(6) + 5;
                                int cost = oninr.nextInt(1501) + 1000;
                        
                                stats[1] -= healthLoss;
                                stats[2] += happinessGain;
                                stats[3] -= cost;
                        
                                System.out.println(LIME_GREEN + "\n[You enjoyed a delightful evening tasting wines, though it did take a toll on your health.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + BRIGHT_RED + "[Health: -" + healthLoss + " ]" + RESET + BRIGHT_RED + "[Cost: - " + cost + " ]" + RESET);
                            } else if (eventChoice18 == 2) {
                                int happinessGain = oninr.nextInt(6) + 5;
                                int healthGain = oninr.nextInt(11) + 10;
                        
                                stats[1] += healthGain;
                                stats[2] += happinessGain;
                        
                                System.out.println(LIME_GREEN + "\n[You had a quiet night in, resting and feeling rejuvenated.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET);
                            } else {
                                System.out.println("[Invalid choice. Please select a valid option.]");
                            }
                            break;

                        case 19:
                            System.out.println(YELLOW + "\nEvent: 🚴‍♂️ Weekend Bike Ride");
                            System.out.println(YELLOW + "\nYou’ve been feeling the urge to get out and do something active this weekend.");
                            System.out.println(LIME_GREEN + "[1] [🚴‍♂️ Go on a long bike ride]");
                            System.out.println(LIME_GREEN + "[2] [🚶‍♂️ Take a walk in the park]");
                            System.out.print("Your choice: ");
                            int eventChoice19 = onins.nextInt();
                        
                            if (eventChoice19 == 1) {
                                int healthGain = oninr.nextInt(6) + 10;
                                int happinessGain = oninr.nextInt(6) + 5;
                                int cost = oninr.nextInt(31) + 20;
                        
                                stats[1] += healthGain;
                                stats[2] += happinessGain;
                                stats[3] -= cost;
                        
                                System.out.println(LIME_GREEN + "\n[You had an energetic bike ride, feeling refreshed and enjoying the outdoors.]");
                                System.out.println(LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET + LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + BRIGHT_RED + "[Cost: - " + cost + " ]" + RESET);
                            } else if (eventChoice19 == 2) {
                                int healthGain = oninr.nextInt(6) + 5;
                                int happinessGain = oninr.nextInt(11) + 10;
                        
                                stats[1] += healthGain;
                                stats[2] += happinessGain;
                        
                                System.out.println(LIME_GREEN + "\n[You had a peaceful walk in the park, feeling calm and content.]");
                                System.out.println(LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET + LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET);
                            } else {
                                System.out.println("[Invalid choice. Please select a valid option.]");
                            }
                            break;
                        
                        case 20:
                            System.out.println(YELLOW + "\nEvent: 🎬 Movie Marathon");
                            System.out.println(YELLOW + "\nYour friends are inviting you to a movie marathon to watch your favorite films.");
                            System.out.println(LIME_GREEN + "[1] [🍿 Join the movie marathon]");
                            System.out.println(LIME_GREEN + "[2] [🎥 Stay home and watch your favorite show]");
                            System.out.print("Your choice: ");
                            int eventChoice20 = onins.nextInt();
                        
                            if (eventChoice20 == 1) {
                                int happinessGain = oninr.nextInt(6) + 5;
                                int healthLoss = oninr.nextInt(11) + 10;
                                int cost = oninr.nextInt(101) + 100;
                        
                                stats[1] -= healthLoss;
                                stats[2] += happinessGain;
                                stats[3] -= cost;
                        
                                System.out.println(LIME_GREEN + "\n[You had a fun time with your friends, but stayed up too late and snacked a bit too much.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + BRIGHT_RED + "[Health: -" + healthLoss + " ]" + RESET + BRIGHT_RED + "[Cost: - " + cost + " ]" + RESET);
                            } else if (eventChoice20 == 2) {
                                int happinessGain = oninr.nextInt(11) + 10;
                                int healthGain = oninr.nextInt(6) + 5;
                        
                                stats[1] += healthGain;
                                stats[2] += happinessGain;
                        
                                System.out.println(LIME_GREEN + "\n[You enjoyed a relaxed evening, catching up on your favorite show and feeling at ease.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET);
                            } else {
                                System.out.println("[Invalid choice. Please select a valid option.]");
                            }
                            break;
                        
                        case 21:
                            System.out.println(YELLOW + "\nEvent: 🎉 Weekend Party");
                            System.out.println(YELLOW + "\nYour friends are throwing a big weekend party, and you're invited!");
                            System.out.println(LIME_GREEN + "[1] [🎉 Go to the party]");
                            System.out.println(LIME_GREEN + "[2] [🍂 Stay home and enjoy some quiet time]");
                            System.out.print("Your choice: ");
                            int eventChoice21 = onins.nextInt();
                        
                            if (eventChoice21 == 1) {
                                int happinessGain = oninr.nextInt(21) + 15;
                                int healthLoss = oninr.nextInt(11) + 10;
                                int cost = oninr.nextInt(201) + 100;
                        
                                stats[1] -= healthLoss;
                                stats[2] += happinessGain;
                                stats[3] -= cost;
                        
                                System.out.println(LIME_GREEN + "\n[You had a blast at the party, but you stayed out a little too late.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + BRIGHT_RED + "[Health: -" + healthLoss + " ]" + RESET + BRIGHT_RED + "[Cost: - " + cost + " ]" + RESET);
                            } else if (eventChoice21 == 2) {
                                int happinessGain = oninr.nextInt(6) + 5;
                                int healthGain = oninr.nextInt(11) + 10;
                        
                                stats[1] += healthGain;
                                stats[2] += happinessGain;
                        
                                System.out.println(LIME_GREEN + "\n[You had a peaceful weekend at home, enjoying some much-needed rest.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET);
                            } else {
                                System.out.println("[Invalid choice. Please select a valid option.]");
                            }
                            break;
                        
                        case 22:
                            System.out.println(YELLOW + "\nEvent: 🧘‍♀️ Yoga Session");
                            System.out.println(YELLOW + "\nYou're feeling a bit stressed, and a local studio is offering a yoga class.");
                            System.out.println(LIME_GREEN + "[1] [🧘‍♀️ Join the yoga class]");
                            System.out.println(LIME_GREEN + "[2] [🛋️ Skip the class and rest at home]");
                            System.out.print("Your choice: ");
                            int eventChoice22 = onins.nextInt();
                        
                            if (eventChoice22 == 1) {
                                int healthGain = oninr.nextInt(16) + 10;
                                int happinessGain = oninr.nextInt(16) + 10;
                                int cost = oninr.nextInt(151) + 100;
                        
                                stats[1] += healthGain;
                                stats[2] += happinessGain;
                                stats[3] -= cost;
                        
                                System.out.println(LIME_GREEN + "\n[You feel rejuvenated after the yoga session and more at peace with yourself.]");
                                System.out.println(LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET + LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + BRIGHT_RED + "[Cost: - " + cost + " ]" + RESET);
                            } else if (eventChoice22 == 2) {
                                int healthGain = oninr.nextInt(6) + 5;
                                int happinessGain = oninr.nextInt(6) + 5;
                        
                                stats[1] += healthGain;
                                stats[2] += happinessGain;
                        
                                System.out.println(LIME_GREEN + "\n[You took a well-deserved break at home, feeling relaxed and at ease.]");
                                System.out.println(LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET + LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET);
                            } else {
                                System.out.println("[Invalid choice. Please select a valid option.]");
                            }
                            break;
                        
                        case 23:
                            System.out.println(YELLOW + "\nEvent: 🏠 Home Renovation");
                            System.out.println(YELLOW + "\nYour home needs some repairs, and you're thinking about renovating a few rooms.");
                            System.out.println(LIME_GREEN + "[1] [🔨 Start the renovation project]");
                            System.out.println(LIME_GREEN + "[2] [🏡 Skip the renovation for now]");
                            System.out.print("Your choice: ");
                            int eventChoice23 = onins.nextInt();
                        
                            if (eventChoice23 == 1) {
                                int happinessGain = oninr.nextInt(11) + 15;
                                int healthLoss = oninr.nextInt(11) + 10;
                                int cost = oninr.nextInt(3001) + 2000;
                        
                                stats[1] -= healthLoss;
                                stats[2] += happinessGain;
                                stats[3] -= cost;
                        
                                System.out.println(LIME_GREEN + "\n[The renovation was a huge success! Your home looks amazing, but the process was exhausting.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + BRIGHT_RED + "[Health: -" + healthLoss + " ]" + RESET + BRIGHT_RED + "[Cost: - " + cost + " ]" + RESET);
                            } else if (eventChoice23 == 2) {
                                int happinessGain = oninr.nextInt(6) + 5;
                                int healthGain = oninr.nextInt(16) + 10;
                        
                                stats[1] += healthGain;
                                stats[2] += happinessGain;
                        
                                System.out.println(LIME_GREEN + "\n[You decided to wait on the renovation, and you’ve been enjoying a peaceful and healthy time at home.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET);
                            } else {
                                System.out.println("[Invalid choice. Please select a valid option.]");
                            }
                            break;
                        
                        case 24:
                            System.out.println(YELLOW + "\nEvent: 🎮 Video Game Release");
                            System.out.println(YELLOW + "\nA new video game you’ve been waiting for is finally released!");
                            System.out.println(LIME_GREEN + "[1] [🎮 Buy the game and play it]");
                            System.out.println(LIME_GREEN + "[2] [📵 Resist the temptation and focus on other activities]");
                            System.out.print("Your choice: ");
                            int eventChoice24 = onins.nextInt();
                        
                            if (eventChoice24 == 1) {
                                int happinessGain = oninr.nextInt(11) + 10;
                                int healthLoss = oninr.nextInt(6) + 5;
                                int cost = oninr.nextInt(1501) + 500;
                        
                                stats[1] -= healthLoss;
                                stats[2] += happinessGain;
                                stats[3] -= cost;
                        
                                System.out.println(LIME_GREEN + "\n[You had a great time playing the game, but you spent hours on it and neglected your health.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + BRIGHT_RED + "[Health: -" + healthLoss + " ]" + RESET + BRIGHT_RED + "[Cost: - " + cost + " ]" + RESET);
                            } else if (eventChoice24 == 2) {
                                int happinessGain = oninr.nextInt(6) + 5;
                                int healthGain = oninr.nextInt(6) + 10;
                        
                                stats[1] += healthGain;
                                stats[2] += happinessGain;
                        
                                System.out.println(LIME_GREEN + "\n[You stayed productive and healthy by resisting the urge to game. You feel proud of yourself.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET);
                            } else {
                                System.out.println("[Invalid choice. Please select a valid option.]");
                            }
                            break;
                        
                        case 25:
                            System.out.println(YELLOW + "\nEvent: 🦠 Caught a Cold");
                            System.out.println(YELLOW + "\nYou’ve caught a cold, and you’re feeling under the weather.");
                            System.out.println(LIME_GREEN + "[1] [💊 Take medicine and rest]");
                            System.out.println(LIME_GREEN + "[2] [🤧 Try to work through it]");
                            System.out.print("Your choice: ");
                            int eventChoice25 = onins.nextInt();
                        
                            if (eventChoice25 == 1) {
                                int healthGain = oninr.nextInt(11) + 10;
                                int cost = oninr.nextInt(101) + 100;
                        
                                stats[1] += healthGain;
                                stats[3] -= cost;
                        
                                System.out.println(LIME_GREEN + "\n[You rested and took the medicine, and you’re starting to feel better.]");
                                System.out.println(LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET + BRIGHT_RED + "[Cost: - " + cost + " ]" + RESET);
                            } else if (eventChoice25 == 2) {
                                int healthLoss = oninr.nextInt(16) + 10;
                                int happinessLoss = oninr.nextInt(6) + 5;
                        
                                stats[1] -= healthLoss;
                                stats[2] -= happinessLoss;
                        
                                System.out.println(LIME_GREEN + "\n[You pushed through, but your cold made it difficult to focus and feel happy.]");
                                System.out.println(BRIGHT_RED + "[Health: -" + healthLoss + " ] " + RESET + BRIGHT_RED + "[Happiness: -" + happinessLoss + " ]" + RESET);
                            } else {
                                System.out.println("[Invalid choice. Please select a valid option.]");
                            }
                            break;

                        case 26:
                            System.out.println(YELLOW + "\nEvent: 🎰 Lottery Win!");
                            System.out.println(YELLOW + "\nYou receive an unexpected email saying you’ve won the lottery!");
                            System.out.println(LIME_GREEN + "[1] [💰 Claim your lottery winnings]");
                            System.out.println(LIME_GREEN + "[2] [❌ Decline the lottery winnings]");
                            System.out.print("Your choice: ");
                            int eventChoice26 = onins.nextInt();
                        
                            if (eventChoice26 == 1) {
                                int happinessGain = oninr.nextInt(11) + 10;
                                int healthLoss = oninr.nextInt(6) + 5;
                                int moneyGain = 50000;
                        
                                stats[1] -= healthLoss;
                                stats[2] += happinessGain;
                                stats[3] += moneyGain;
                        
                                System.out.println(LIME_GREEN + "\n[You claimed your lottery winnings, and the money brought you joy, but the stress of sudden wealth took a toll.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + BRIGHT_RED + "[Health: -" + healthLoss + " ] " + RESET + GREEN + "[Money: +" + moneyGain + " ]" + RESET);
                            } else if (eventChoice26 == 2) {
                                int healthGain = oninr.nextInt(6) + 5;
                                int happinessLoss = oninr.nextInt(11) + 10;
                        
                                stats[1] += healthGain;
                                stats[2] -= happinessLoss;
                        
                                System.out.println(LIME_GREEN + "\n[You declined the lottery winnings, feeling that the money wasn’t worth the hassle. You feel healthier but a bit sad.]");
                                System.out.println(LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET + BRIGHT_RED + "[Happiness: -" + happinessLoss + " ]" + RESET);
                            } else {
                                System.out.println("[Invalid choice. Please select a valid option.]");
                            }
                            break;

                        case 27:
                            System.out.println(YELLOW + "\nEvent: 🌟 Unexpected Gift");
                            System.out.println(YELLOW + "\nA mysterious stranger approaches you and gives you a small package. Inside is a rare, valuable artifact.");
                            System.out.println(LIME_GREEN + "[1] [🎁 Accept the gift and sell it]");
                            System.out.println(LIME_GREEN + "[2] [🙏 Refuse the gift]");
                            System.out.print("Your choice: ");
                            int eventChoice27 = onins.nextInt();
                        
                            if (eventChoice27 == 1) {
                                int happinessLoss = oninr.nextInt(11) + 10;
                                int healthLoss = oninr.nextInt(6) + 5;
                                int moneyGain = 5000;
                        
                                stats[1] -= healthLoss;
                                stats[2] -= happinessLoss;
                                stats[3] += moneyGain;
                        
                                System.out.println(LIME_GREEN + "\n[You accepted the gift, sold it, and made a lot of money. However, the guilt of profiting from something so mysterious weighs on you.]");
                                System.out.println(BRIGHT_RED + "[Happiness: -" + happinessLoss + " ] " + RESET + BRIGHT_RED + "[Health: -" + healthLoss + " ] " + RESET + GREEN + "[Money: +" + moneyGain + " ]" + RESET);
                            } else if (eventChoice27 == 2) {
                                int happinessGain = oninr.nextInt(11) + 10;
                                int healthGain = oninr.nextInt(6) + 5;
                        
                                stats[1] += healthGain;
                                stats[2] += happinessGain;
                        
                                System.out.println(LIME_GREEN + "\n[You refused the gift, and your decision brought a sense of peace and happiness.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + LIGHT_GREEN + "[Health: +" + healthGain + " ]" + RESET);
                            } else {
                                System.out.println("[Invalid choice. Please select a valid option.]");
                            }
                            break;
                        
                        case 28:
                            System.out.println(YELLOW + "\nEvent: 💎 Found Treasure");
                            System.out.println(YELLOW + "\nWhile walking on the beach, you find a hidden treasure chest half-buried in the sand.");
                            System.out.println(LIME_GREEN + "[1] [🔑 Open the treasure chest]");
                            System.out.println(LIME_GREEN + "[2] [🚶‍♂️ Leave the treasure and walk away]");
                            System.out.print("Your choice: ");
                            int eventChoice28 = onins.nextInt();
                        
                            if (eventChoice28 == 1) {
                                int happinessGain = oninr.nextInt(21) + 20;
                                int healthLoss = oninr.nextInt(21) + 10;
                                int moneyGain = 8000;
                        
                                stats[1] -= healthLoss;
                                stats[2] += happinessGain;
                                stats[3] += moneyGain;
                        
                                System.out.println(LIME_GREEN + "\n[You opened the treasure chest and found a fortune! The wealth brought you joy, but the stress of finding it was overwhelming.]");
                                System.out.println(LIGHT_GREEN + "[Happiness: +" + happinessGain + " ] " + RESET + BRIGHT_RED + "[Health: -" + healthLoss + " ] " + RESET + GREEN + "[Money: +" + moneyGain + " ]" + RESET);
                            } else if (eventChoice28 == 2) {
                                int healthGain = oninr.nextInt(11) + 10;
                                int happinessLoss = oninr.nextInt(6) + 5;
                        
                                stats[1] += healthGain;
                                stats[2] -= happinessLoss;
                        
                                System.out.println(LIME_GREEN + "\n[You walked away from the treasure, and while your health improved, you couldn’t help but feel a little regret.]");
                                System.out.println(LIGHT_GREEN + "[Health: +" + healthGain + " ] " + RESET + BRIGHT_RED + "[Happiness: -" + happinessLoss + " ]" + RESET);
                            } else {
                                System.out.println("[Invalid choice. Please select a valid option.]");
                            }
                            break;

                    }

                    if (stats[1] <= 0) {
                        System.out.println("\n[You've died at the age of " + stats[0] + ". GG]");
                        isAlive = false;
                    }

                    stats[0]++;
                    stats[1] = Math.min(stats[1], 100);
                    stats[2] = Math.min(stats[2], 100);
                    stats[4]++;
                    break;

                case 2:
                    if (job == "Jobless") {
                        System.out.println(YELLOW + "\n[You are currently jobless. Looking for a job...]" + RESET);
                        System.out.println(YELLOW + "\nYou've been offered a job" + RESET);
                        int jobEvent = oninr.nextInt(10);

                        switch (jobEvent) {
                            case 1:
                                System.out.println(GREEN + "[1] [Programmer]" + RESET);
                                System.out.println(BRIGHT_RED + "[2] [Decline offer.]" + RESET);
                                System.out.print("Your choice: ");
                                int jobChoice1 = onins.nextInt();

                                if (jobChoice1 == 1) {
                                    job = "Programmer";
                                    int healthGain = oninr.nextInt(16) + 5;
                                    int happinessGain = oninr.nextInt(26) + 25;
                                    int pay = oninr.nextInt(7501) + 3500;

                                    stats[1] -= healthGain;
                                    stats[2] += happinessGain;
                                    stats[3] += pay;
                                    
                                    System.out.println(GREEN + "\n[You accepted the job offer! You are now working as " + job + " with a pay of ₱" + pay + " per year.]" + RESET);
                                } else if (jobChoice1 == 2) {
                                    System.out.println(BRIGHT_RED + "[You decided to decline the job offer and you stay jobless.]" + RESET);
                                } else {
                                    System.out.println("[Invalid choice. Please select a valid option.]");
                                }
                                stats[1] = Math.min(stats[1], 100);
                                stats[2] = Math.min(stats[2], 100);
                                break;

                            case 2:
                                System.out.println(GREEN + "[1] [Teacher]" + RESET);
                                System.out.println(BRIGHT_RED + "[2] [Decline offer.]" + RESET);
                                System.out.print("Your choice: ");
                                int jobChoice2 = onins.nextInt();
                            
                                if (jobChoice2 == 1) {
                                    job = "Teacher";
                                    int healthGain = oninr.nextInt(11) + 5;
                                    int happinessGain = oninr.nextInt(21) + 15;
                                    int pay = oninr.nextInt(6001) + 2000;
                            
                                    stats[1] -= healthGain;
                                    stats[2] += happinessGain;
                                    stats[3] += pay;
                            
                                    System.out.println(GREEN + "\n[You accepted the job offer! You are now working as " + job + " with a pay of ₱" + pay + " per year.]" + RESET);
                                } else if (jobChoice2 == 2) {
                                    System.out.println(BRIGHT_RED + "[You decided to decline the job offer and you stay jobless.]" + RESET);
                                } else {
                                    System.out.println("[Invalid choice. Please select a valid option.]");
                                }
                                stats[1] = Math.min(stats[1], 100);
                                stats[2] = Math.min(stats[2], 100);
                                break;
                            
                            case 3:
                                System.out.println(GREEN + "[1] [Designer]" + RESET);
                                System.out.println(BRIGHT_RED + "[2] [Decline offer.]" + RESET);
                                System.out.print("Your choice: ");
                                int jobChoice3 = onins.nextInt();
                            
                                if (jobChoice3 == 1) {
                                    job = "Designer";
                                    int healthGain = oninr.nextInt(6) + 3;
                                    int happinessGain = oninr.nextInt(31) + 20;
                                    int pay = oninr.nextInt(7001) + 4000;
                            
                                    stats[1] -= healthGain;
                                    stats[2] += happinessGain;
                                    stats[3] += pay;
                            
                                    System.out.println(GREEN + "\n[You accepted the job offer! You are now working as " + job + " with a pay of ₱" + pay + " per year.]" + RESET);
                                } else if (jobChoice3 == 2) {
                                    System.out.println(BRIGHT_RED + "[You decided to decline the job offer and you stay jobless.]" + RESET);
                                } else {
                                    System.out.println("[Invalid choice. Please select a valid option.]");
                                }
                                stats[1] = Math.min(stats[1], 100);
                                stats[2] = Math.min(stats[2], 100);
                                break;
                            
                            case 4:
                                System.out.println(GREEN + "[1] [Chef]" + RESET);
                                System.out.println(BRIGHT_RED + "[2] [Decline offer.]" + RESET);
                                System.out.print("Your choice: ");
                                int jobChoice4 = onins.nextInt();
                            
                                if (jobChoice4 == 1) {
                                    job = "Chef";
                                    int healthGain = oninr.nextInt(21) + 10;
                                    int happinessGain = oninr.nextInt(16) + 20;
                                    int pay = oninr.nextInt(8001) + 5000;
                            
                                    stats[1] -= healthGain;
                                    stats[2] += happinessGain;
                                    stats[3] += pay;
                            
                                    System.out.println(GREEN + "\n[You accepted the job offer! You are now working as " + job + " with a pay of ₱" + pay + " per year.]" + RESET);
                                } else if (jobChoice4 == 2) {
                                    System.out.println(BRIGHT_RED + "[You decided to decline the job offer and you stay jobless.]" + RESET);
                                } else {
                                    System.out.println("[Invalid choice. Please select a valid option.]");
                                }
                                stats[1] = Math.min(stats[1], 100);
                                stats[2] = Math.min(stats[2], 100);
                                break;
                            
                            case 5:
                                System.out.println(GREEN + "[1] [Photographer]" + RESET);
                                System.out.println(BRIGHT_RED + "[2] [Decline offer.]" + RESET);
                                System.out.print("Your choice: ");
                                int jobChoice5 = onins.nextInt();
                            
                                if (jobChoice5 == 1) {
                                    job = "Photographer";
                                    int healthGain = oninr.nextInt(10) + 5;
                                    int happinessGain = oninr.nextInt(26) + 15;
                                    int pay = oninr.nextInt(6001) + 3500;
                            
                                    stats[1] -= healthGain;
                                    stats[2] += happinessGain;
                                    stats[3] += pay;
                            
                                    System.out.println(GREEN + "\n[You accepted the job offer! You are now working as " + job + " with a pay of ₱" + pay + " per year.]" + RESET);
                                } else if (jobChoice5 == 2) {
                                    System.out.println(BRIGHT_RED + "[You decided to decline the job offer and you stay jobless.]" + RESET);
                                } else {
                                    System.out.println("[Invalid choice. Please select a valid option.]");
                                }
                                stats[1] = Math.min(stats[1], 100);
                                stats[2] = Math.min(stats[2], 100);
                                break;
                            
                            case 6:
                                System.out.println(GREEN + "[1] [Engineer]" + RESET);
                                System.out.println(BRIGHT_RED + "[2] [Decline offer.]" + RESET);
                                System.out.print("Your choice: ");
                                int jobChoice6 = onins.nextInt();
                            
                                if (jobChoice6 == 1) {
                                    job = "Engineer";
                                    int healthGain = oninr.nextInt(12) + 5;
                                    int happinessGain = oninr.nextInt(21) + 10;
                                    int pay = oninr.nextInt(10001) + 8000;
                            
                                    stats[1] -= healthGain;
                                    stats[2] += happinessGain;
                                    stats[3] += pay;
                            
                                    System.out.println(GREEN + "\n[You accepted the job offer! You are now working as " + job + " with a pay of ₱" + pay + " per year.]" + RESET);
                                } else if (jobChoice6 == 2) {
                                    System.out.println(BRIGHT_RED + "[You decided to decline the job offer and you stay jobless.]" + RESET);
                                } else {
                                    System.out.println("[Invalid choice. Please select a valid option.]");
                                }
                                stats[1] = Math.min(stats[1], 100);
                                stats[2] = Math.min(stats[2], 100);
                                break;
                            
                            case 7:
                                System.out.println(GREEN + "[1] [Scientist]" + RESET);
                                System.out.println(BRIGHT_RED + "[2] [Decline offer.]" + RESET);
                                System.out.print("Your choice: ");
                                int jobChoice7 = onins.nextInt();
                            
                                if (jobChoice7 == 1) {
                                    job = "Scientist";
                                    int healthGain = oninr.nextInt(16) + 5;
                                    int happinessGain = oninr.nextInt(11) + 15;
                                    int pay = oninr.nextInt(12001) + 10000;
                            
                                    stats[1] -= healthGain;
                                    stats[2] += happinessGain;
                                    stats[3] += pay;
                            
                                    System.out.println(GREEN + "\n[You accepted the job offer! You are now working as " + job + " with a pay of ₱" + pay + " per year.]" + RESET);
                                } else if (jobChoice7 == 2) {
                                    System.out.println(BRIGHT_RED + "[You decided to decline the job offer and you stay jobless.]" + RESET);
                                } else {
                                    System.out.println("[Invalid choice. Please select a valid option.]");
                                }
                                stats[1] = Math.min(stats[1], 100);
                                stats[2] = Math.min(stats[2], 100);
                                break;
                            
                            case 8:
                                System.out.println(GREEN + "[1] [Nurse]" + RESET);
                                System.out.println(BRIGHT_RED + "[2] [Decline offer.]" + RESET);
                                System.out.print("Your choice: ");
                                int jobChoice8 = onins.nextInt();
                            
                                if (jobChoice8 == 1) {
                                    job = "Nurse";
                                    int healthGain = oninr.nextInt(21) + 10;
                                    int happinessGain = oninr.nextInt(16) + 15;
                                    int pay = oninr.nextInt(5001) + 3000;
                            
                                    stats[1] -= healthGain;
                                    stats[2] += happinessGain;
                                    stats[3] += pay;
                            
                                    System.out.println(GREEN + "\n[You accepted the job offer! You are now working as " + job + " with a pay of ₱" + pay + " per year.]" + RESET);
                                } else if (jobChoice8 == 2) {
                                    System.out.println(BRIGHT_RED + "[You decided to decline the job offer and you stay jobless.]" + RESET);
                                } else {
                                    System.out.println("[Invalid choice. Please select a valid option.]");
                                }
                                stats[1] = Math.min(stats[1], 100);
                                stats[2] = Math.min(stats[2], 100);
                                break;
                            
                            case 9:
                                System.out.println(GREEN + "[1] [Writer]" + RESET);
                                System.out.println(BRIGHT_RED + "[2] [Decline offer.]" + RESET);
                                System.out.print("Your choice: ");
                                int jobChoice9 = onins.nextInt();
                            
                                if (jobChoice9 == 1) {
                                    job = "Writer";
                                    int healthGain = oninr.nextInt(11) + 3;
                                    int happinessGain = oninr.nextInt(31) + 20;
                                    int pay = oninr.nextInt(4001) + 2500;
                            
                                    stats[1] -= healthGain;
                                    stats[2] += happinessGain;
                                    stats[3] += pay;
                            
                                    System.out.println(GREEN + "\n[You accepted the job offer! You are now working as " + job + " with a pay of ₱" + pay + " per year.]" + RESET);
                                } else if (jobChoice9 == 2) {
                                    System.out.println(BRIGHT_RED + "[You decided to decline the job offer and you stay jobless.]" + RESET);
                                } else {
                                    System.out.println("[Invalid choice. Please select a valid option.]");
                                }
                                stats[1] = Math.min(stats[1], 100);
                                stats[2] = Math.min(stats[2], 100);
                                break;
                            
                            case 10:
                                System.out.println(GREEN + "[1] [Lawyer]" + RESET);
                                System.out.println(BRIGHT_RED + "[2] [Decline offer.]" + RESET);
                                System.out.print("Your choice: ");
                                int jobChoice10 = onins.nextInt();
                            
                                if (jobChoice10 == 1) {
                                    job = "Lawyer";
                                    int healthGain = oninr.nextInt(8) + 4;
                                    int happinessGain = oninr.nextInt(21) + 12;
                                    int pay = oninr.nextInt(15001) + 12000;
                            
                                    stats[1] -= healthGain;
                                    stats[2] += happinessGain;
                                    stats[3] += pay;
                            
                                    System.out.println(GREEN + "\n[You accepted the job offer! You are now working as " + job + " with a pay of ₱" + pay + " per year.]" + RESET);
                                } else if (jobChoice10 == 2) {
                                    System.out.println(BRIGHT_RED + "[You decided to decline the job offer and you stay jobless.]" + RESET);
                                } else {
                                    System.out.println("[Invalid choice. Please select a valid option.]");
                                }
                                stats[1] = Math.min(stats[1], 100);
                                stats[2] = Math.min(stats[2], 100);
                                break;

                        }
                    } else {
                        System.out.println("\n[You are working as a " + job + ".]");

                        System.out.println(GREEN + "\n[1] [Continue working]" + RESET);
                        System.out.println(BRIGHT_RED + "[2] [Quit]" + RESET);
                        System.out.print("[Your choice]: ");
                        int retireChoice = onins.nextInt();
                
                        if (retireChoice == 1) {
                            System.out.println(GREEN + "\n[You continue working as a " + job + ".]" + RESET);
                        } else if (retireChoice == 2) {
                            System.out.println(BRIGHT_RED + "\n[You decided to quit the job.]" + RESET);
                            job = "Jobless";
                        } else {
                            System.out.println("[Invalid choice. Please select a valid option.]");
                        }
                    }
                    break;

                case 3:
                    System.out.println(YELLOW + bold + "[--- Shop ---]" + reset + RESET);

                    System.out.println(GREEN + "\n[1] " + bold + "[Health Potion] [+30 Health] [-₱100]" + reset + RESET);
                    System.out.println(GREEN + "[2] " + bold + "[Happiness Book [+20 Happiness] [-₱150]" + reset + RESET);
                    System.out.println(BRIGHT_RED + "[3] " + "[Exit Shop]" + RESET);
                    System.out.print("[Your choice: ");
                    int choice = onins.nextInt();

                    switch (choice) {
                        case 1:
                            if (stats[3] >= 100) {
                                stats[1] = Math.min(100, stats[1] + 30);
                                stats[3] -= 100;
                                System.out.println(GREEN + "\n[You bought a Health Potion. Health restored!]" + RESET);
                            } else {
                                System.out.println(BRIGHT_RED + "[Not enough money!]" + RESET);
                            }
                            break;
                        case 2:
                            if (stats[3] >= 150) {
                                stats[2] = Math.min(100, stats[2] + 20);
                                stats[3] -= 150;
                                System.out.println(GREEN + "\n[You bought a Happiness Book. Feeling happy!]" + RESET);
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
}
