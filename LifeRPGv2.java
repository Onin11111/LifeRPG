import java.util.Random;
import java.util.Scanner;

public class LifeRPGv2 {
    public static void main(String[] args) {
        Scanner onins = new Scanner(System.in);
        Random oninr = new Random();

        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
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
            System.out.println(LIME_GREEN + "[Job: " + (job.equals("Jobless") ? job : job + " (₱" + payRate + " per year)]") + RESET);

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
                    stats[2] = Math.min(stats[2], 100);

                    if (!job.equals("Jobless")) {
                        stats[3] += payRate;
                    }
                    break;

                case 2:
                    if (job.equals("Jobless")) {
                        String jobText = "[You are currently jobless. Let's look for a job...]";
                        for (int i = 0; i < jobText.length(); i++) {
                            System.out.print(jobText.charAt(i));
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println();
                        System.out.println(GREEN + "[1] Take a job (+₱300 | -20 Health | +5 Happiness)" + RESET);
                        System.out.println(BRIGHT_RED + "[2] Decline the job offer" + RESET);
                        System.out.print("Your choice: ");
                        int workChoice = onins.nextInt();
                        if (workChoice == 1) {
                            job = "Private Worker";
                            payRate = 300;
                            stats[3] += payRate;
                            stats[1] -= 20;
                            stats[2] += 5;
                            System.out.println("[You accepted the job offer! You are now working with a pay of ₱" + payRate + " per year.]");
                        } else if (workChoice == 2) {
                            System.out.println("[You decided to decline the job offer and focus on your well-being.]");
                        } else {
                            System.out.println("[Invalid choice. Please select a valid option.]");
                        }
                    } else {
                        System.out.println("\n[You are already working at your job. Your pay rate increases as you get older.]");
                        stats[3] += payRate;
                    }
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
                    String retireText = "[You have retired. Thank you for playing!]¢";
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
        int event = oninr.nextInt(13);

        switch (event) {
            case 0:
                System.out.println("\nEvent: 🍴 Lunch Break");
                System.out.println("\nIt's lunchtime, and you're deciding where to eat.");
                System.out.println("1. 🍛 Eat at a local carinderia (-₱50 | +5 Health | +5 Happiness)");
                System.out.println("2. 🍔 Go to a fast-food chain (-₱150 | -5 Health | +10 Happiness)");
                System.out.print("Your choice: ");
                int lunchChoice0 = onins.nextInt();

                if (lunchChoice0 == 1) {
                    stats[1] += 5;
                    stats[2] += 5;
                    stats[3] -= 50;
                    System.out.println("You enjoyed a simple, affordable meal that kept you satisfied.");
                } else if (lunchChoice0 == 2) {
                    stats[1] -= 5;
                    stats[2] += 10;
                    stats[3] -= 150;
                    System.out.println("You splurged on fast food, which lifted your mood but wasn’t the healthiest choice.");
                } else {
                    System.out.println("Invalid choice. Please select a valid option.");
                }
                break;

            case 1:
                System.out.println("\nEvent: 🛒 Grocery Day");
				System.out.println("\nYou’re running low on supplies and need to restock.");
				System.out.println("1. 🛍️ Shop at a wet market (-₱500 | +10 Health | +5 Happiness)");
				System.out.println("2. 🏪 Go to a convenience store (-₱700 | -5 Health | +10 Happiness)");
				System.out.print("Your choice: ");
				int workChoice1 = onins.nextInt();

					if (workChoice1 == 1) {
						stats[1] += 10;
						stats[2] += 5;
						stats[3] -= 500;
					System.out.println("You bought fresh produce and supported local vendors, boosting your health and spirits.");
					} else if (workChoice1 == 2) {
						stats[1] -= 5;
						stats[2] += 10;
						stats[3] -= 700;
					System.out.println("You paid more for less healthy items, but the quick shopping experience was convenient.");
					} else {
					System.out.println("Invalid choice. Please select a valid option.");
					}
					break;
                
            case 2:
                System.out.println("\nEvent: 🌅 Weekend Plan");
					System.out.println("\nIt’s a Saturday morning, and you’re deciding how to spend your day.");
					System.out.println("1. 🗻 Go hiking in Rizal (-₱200 | +20 Health | +15 Happiness)");
					System.out.println("2. 📺 Stay at home and binge-watch movies (-10 Health | +10 Happiness)");
					System.out.print("Your choice: ");
					int workChoice2 = onins.nextInt();

					if (workChoice2 == 1) {
						stats[1] += 20;
						stats[2] += 15;
						stats[3] -= 200;
					System.out.println("You had an energizing day outdoors, soaking in nature and getting a workout.");
					} else if (workChoice2 == 2) {
						stats[1] -= 10;
						stats[2] += 10;
						stats[3] -= 0;
					System.out.println("You saved money and enjoyed a relaxed day, but missed out on physical activity.");
					} else {
					System.out.println("Invalid choice. Please select a valid option.");
					}
					break;
					
			case 3:
			    System.out.println("\nEvent: 📱 Phone Upgrade");
					System.out.println("\nYour phone is lagging, and you’re considering an upgrade.");
					System.out.println("1. 🔧 Get your phone repaired (-₱1,500 | +5 Happiness)");
					System.out.println("2. 📱 Buy a new phone (-₱15,000 | +15 Happiness)");
					System.out.print("Your choice: ");
					int workChoice3 = onins.nextInt();

					if (workChoice3 == 1) {
						stats[1] += 0;
						stats[2] += 5;
						stats[3] -= 1000;
					System.out.println("Your phone works fine now, but it’s still not the latest model.");
					} else if (workChoice3 == 2) {
						stats[1] -= 0;
						stats[2] += 15;
						stats[3] -= 15000;
					System.out.println("You’re thrilled with the latest tech, but your wallet took a big hit.");
					} else {
					System.out.println("Invalid choice. Please select a valid option.");
					}
					break;
					
			case 4:
			    	System.out.println("\nEvent: 🏠 Utility Bills");
					System.out.println("\nYour electricity bill has arrived, and it’s higher than expected.");
					System.out.println("1. 💡 Reduce consumption by unplugging appliances and using fans (-₱500 | +5 Health | +5 Happiness)");
					System.out.println("2. ️❄️ Keep using air conditioning (-₱1,500 | +0 Health | +10 Happiness)");
					System.out.print("Your choice: ");
					int workChoice4 = onins.nextInt();

					if (workChoice4 == 1) {
						stats[1] += 5;
						stats[2] += 5;
						stats[3] -= 500;
					System.out.println("You saved money and felt good about conserving energy, but it required extra effort.");
					} else if (workChoice4 == 2) {
						stats[1] -= 0;
						stats[2] += 10;
						stats[3] -= 1500;
					System.out.println("You stayed comfortable but spent more, leaving less money for other needs.");
					} else {
					System.out.println("Invalid choice. Please select a valid option.");
					}
					break;
					
			case 5:
			    System.out.println("\nEvent: 🚌 Commute to Work");
					System.out.println("\nYou’re deciding how to get to work during rush hour.");
					System.out.println("1. 🚋 Take the MRT/LRT (-₱50 | -10 Health | -5 Happiness)");
					System.out.println("2. 🚗 Carpool with colleagues (-₱100 | +5 Health | +5 Happiness)");
					System.out.print("Your choice: ");
					int workChoice5 = onins.nextInt();

					if (workChoice5 == 1) {
						stats[1] -= 10;
						stats[2] -= 5;
						stats[3] -= 50;
					System.out.println("You spent less money but endured a crowded, stressful commute.");
					} else if (workChoice5 == 2) {
						stats[1] += 5;
						stats[2] += 5;
						stats[3] -= 100;
					System.out.println("You spent more but enjoyed a comfortable and fun ride with friends.");
					} else {
					System.out.println("Invalid choice. Please select a valid option.");
					}
					break;
					
			case 6:
			    System.out.println("\nEvent: 🌟 Fiesta Time");
					System.out.println("\nYour barangay is celebrating a fiesta, and you’re invited to join.");
					System.out.println("1. 🎉 Join the festivities (-₱200 | +10 Health | +20 Happiness)");
					System.out.println("2. ️🏠 Stay at home -10 Happiness)");
					System.out.print("Your choice: ");
					int workChoice6 = onins.nextInt();

					if (workChoice6 == 1) {
						stats[1] += 10;
						stats[2] += 20;
						stats[3] -= 200;
					System.out.println("You had a fantastic time enjoying food and mingling with neighbors.");
					} else if (workChoice6 == 2) {
						stats[1] += 0;
						stats[2] += 0;
						stats[3] -= 10;
					System.out.println("You saved money but missed out on the community spirit and fun.");
					} else {
					System.out.println("Invalid choice. Please select a valid option.");
					}
					break;
					
				case 7:
				    System.out.println("\nEvent: 🥤 Afternoon Merienda");
					System.out.println("\nIt’s mid-afternoon, and you’re feeling hungry.");
					System.out.println("1. 🍌 Buy banana cue from a street vendor (-₱20 | +5 Health | +10 Happiness)");
					System.out.println("2. ️🧋 Order milk tea (-₱120 | -5 Health | +15 Happiness)");
					System.out.print("Your choice: ");
					int workChoice7 = onins.nextInt();

					if (workChoice7 == 1) {
						stats[1] += 5;
						stats[2] += 10;
						stats[3] -= 20;
					System.out.println("You enjoyed a classic Filipino snack that’s both affordable and satisfying.");
					} else if (workChoice7 == 2) {
						stats[1] -= 5;
						stats[2] += 10;
						stats[3] -= 120;
					System.out.println("You indulged in a sweet treat, boosting your mood but at the cost of your health and wallet.");
					} else {
					System.out.println("Invalid choice. Please select a valid option.");
					}
					break;
					
				case 8:
				    System.out.println("\nEvent: 🌄 Morning Exercise");
					System.out.println("\nYou wake up early and consider whether to work out.");
					System.out.println("1. 🏃 Jog around your barangay (+15 Health | +10 Happiness)");
					System.out.println("2. ️🛌 Stay in bed and sleep longer (+5 Health | +5 Happiness)");
					System.out.print("Your choice: ");
					int workChoice8 = onins.nextInt();

					if (workChoice8 == 1) {
						stats[1] += 15;
						stats[2] += 10;
						stats[3] -= 0;
					System.out.println("You felt energized and started the day on a positive note without spending a peso.");
					} else if (workChoice8 == 2) {
						stats[1] += 5;
						stats[2] += 5;
						stats[3] -= 0;
					System.out.println("You felt rested, but missed out on the physical benefits of exercise.");
					} else {
					System.out.println("Invalid choice. Please select a valid option.");
					}
					break;
					
				case 9:
				    System.out.println("\nEvent: 🎓 Family Reunion");
					System.out.println("\nYour relatives invite you to a family gathering.");
					System.out.println("1. 🎁 Bring a small gift (-₱300 | +5 Health | +20 Happiness)");
					System.out.println("2. ️🚫 Politely decline (-10 Happiness)");
					System.out.print("Your choice: ");
					int workChoice9 = onins.nextInt();

					if (workChoice9 == 1) {
						stats[1] += 5;
						stats[2] += 20;
						stats[3] -= 300;
					System.out.println("You felt good about contributing and enjoyed bonding with family.");
					} else if (workChoice9 == 2) {
						stats[1] += 0;
						stats[2] -= 10;
						stats[3] -= 0;
					System.out.println("You avoided spending money, but missed out on family time and felt a little guilty.");
					} else {
					System.out.println("Invalid choice. Please select a valid option.");
					}
					break;
					
				case 10:
				    System.out.println("\nEvent: 💻 Freelance Gig");
					System.out.println("\nYou’re offered an additional freelance job over the weekend.");
					System.out.println("1. 👨‍💻 Take the gig (+₱500 | -10 Health | +20 Happiness)");
					System.out.println("2. ️🛌 Decline the gig (+10 Health | -5 Happiness)");
					System.out.print("Your choice: ");
					int workChoice10 = onins.nextInt();

					if (workChoice10 == 1) {
						stats[1] -= 10;
						stats[2] += 20;
						stats[3] += 500;
					System.out.println("You earned extra money but felt more tired from the extra work.");
					} else if (workChoice10 == 2) {
						stats[1] += 10;
						stats[2] -= 50;
						stats[3] -= 0;
					System.out.println("You prioritized rest and health but missed out on potential income.");
					} else {
					System.out.println("Invalid choice. Please select a valid option.");
					}
					break;
					
				case 11:
				    System.out.println("\nEvent: 🎵 Weekend Concert");
					System.out.println("\nYou’re offered an additional freelance job over the weekend.");
					System.out.println("1. 🎫 Buy a ticket (-₱2,000 | +30 Happiness)");
					System.out.println("2. ️📺 Watch the livestream at home (+5 Happiness)");
					System.out.print("Your choice: ");
					int workChoice11 = onins.nextInt();

					if (workChoice11 == 1) {
						stats[1] -= 0;
						stats[2] += 30;
						stats[3] -= 2000;
					System.out.println("You had an unforgettable experience but spent a significant amount.");
					} else if (workChoice11 == 2) {
						stats[1] += 0;
						stats[2] += 5;
						stats[3] -= 0;
					System.out.println("You enjoyed the performance for free but missed the live atmosphere.");
					} else {
					System.out.println("Invalid choice. Please select a valid option.");
					}
					break;
					
				case 12:
				    System.out.println("\nEvent: 🐕 Pet Adoption");
					System.out.println("\nYou see a stray dog needing a home.");
					System.out.println("1. 🐾 Adopt the dog (-₱300 | +10 Health | +50 Happiness)");
					System.out.println("2. ️🚶 Walk away (-5 Happiness)");
					System.out.print("Your choice: ");
					int workChoice12 = onins.nextInt();

					if (workChoice12 == 1) {
						stats[1] += 10;
						stats[2] += 50;
						stats[3] -= 300;
					System.out.println("You gained a loyal companion, but it came with added responsibility.");
					} else if (workChoice12 == 2) {
						stats[1] += 0;
						stats[2] -= 5;
						stats[3] -= 0;
					System.out.println("You avoided extra costs, but felt a pang of guilt for not helping.");
					} else {
					System.out.println("Invalid choice. Please select a valid option.");
					}
					break;
			    

            case 13:
                System.out.println("\n[Nothing happened this year.]");
                break;
        }
    }
}