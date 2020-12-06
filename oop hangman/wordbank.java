import java.util.*;

public class wordbank {
    private static int tries = 0;
    List<Character> letterBank2 = new ArrayList<>();
    boolean weArePlaying=true;
    public static void print(char array[]) {
        for (int i = 0; i < array.length; i++) { // Assign empty dashes at start "_ _ _ _ _ _ _ _"
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static boolean isTheWordGuessed(char[] array) {
        boolean condition = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '_') {
                condition = false;
            }
        }
        return condition;
    }

    public static void hangmanImage() {

        if (tries == 1) {
            System.out.println("Wrong guess, try again");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("___|___");
            System.out.println();
        }
        if (tries == 2) {
            System.out.println("Wrong guess, try again");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (tries == 3) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   | ");
            System.out.println("___|___");
        }
        if (tries == 4) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (tries == 5) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (tries == 6) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }
        if (tries == 7) {
            System.out.println("GAME OVER!");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");

        }
    }

    public void dispayRules() {
        System.out.println("One player thinks of a word or phrase; the others try to guess what it is one letter at a time");
        System.out.println("The program will draws a number of dashes equivalent to the number of letters in the word.");
        System.out.println("You will then guess a letter that occurs in the word");
        System.out.println("If the letter is correct it will be filled in the dashes");
        System.out.println("You have a limited number of chances");
        System.out.println("Good Luck !!");

    }

    public void display() {
        String[] category = {"sports", "fruits", "vehicles"};
        System.out.println("select a category to proceed:");
        for (String element : category) {
            System.out.println(element);

        }

    }

    public void wordphrase() {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        // word bank initialized
        String[] sports = {"football", "volleyball", "handdball", "cricket", "basketball"};
        String[] fruits = {"bananas", "grapes", "apples", "oranges", "mangos"};
        String[] vehicles = {"car", "van", "lorry", "pickup", "truck"};


        System.out.println("select  a category:");
        String userChoice = scanner.nextLine();
        switch (userChoice) {
            case "sports":
                weArePlaying = true;
                while (weArePlaying) {
                    int randomNumber = random.nextInt(6); // random.nextInt(10);
                    char[] randomWordToGuess = sports[randomNumber].toCharArray(); // java -> j,a,v,a

                    int ammountOfGuesses = randomWordToGuess.length; // total tries to guess a word.
                    char [] playerGuess = new char[ammountOfGuesses]; // "_ _ _ _ _ _ _ _"
                    // Assign empty dashes at start "_ _ _ _ _ _ _ _"
                    Arrays.fill(playerGuess, '_');

                    boolean wordIsGuessed = false;

                    char c;

                    for(c = 'a'; c <= 'z'; ++c){
                        letterBank2.add(c);
                    }
                    System.out.println("Lets Start Pl5aying Hangman ver 0.1");
                        while (!wordIsGuessed && tries != ammountOfGuesses) {
                            System.out.println("Current Guesses: ");
                            print(playerGuess);
                            System.out.printf("You have %d amount of tries left.\n", ammountOfGuesses - tries);

                            System.out.println("Enter a single character: ");
                            char input = scanner.nextLine().charAt(0);

                            letterBank2.remove(Character.valueOf(input));
                            System.out.println("Letters -- ");

                            System.out.println(letterBank2);


                            System.out.println("\n");

                            tries++;
                            boolean state=false;
                            for (int i = 0; i < randomWordToGuess.length; i++) {
                                if (randomWordToGuess[i] == input) {
                                    playerGuess[i] = input;
                                    state=true;
                                }
                            }
                            if (!state){
                                hangmanImage();
                            }


                            if (isTheWordGuessed(playerGuess)) {
                                System.out.println("Congratulations");
                            }

                        } /* End of wordIsGuessed */



                    if (!wordIsGuessed) {
                        System.out.println("You ran out of guesses.");
                    }


                    System.out.println("Would you like to play again? (yes/no) ");
                    String choice = scanner.nextLine();
                    if (choice.equals("no")) {
                        weArePlaying = false;
                    } else if (choice.equals("yes")) {
                        weArePlaying=true;
                        wordIsGuessed = false;
                        tries=0;
                    }

                } /* End of We Are Playing */
                scanner.close();

                System.out.println("Game Over!");

                break;
            case "fruits":
                weArePlaying = true;
                while (weArePlaying) {
                    int randomNumber = random.nextInt(6); // random.nextInt(10);
                    char[] randomWordToGuess = fruits[randomNumber].toCharArray(); // java -> j,a,v,a

                    int ammountOfGuesses = randomWordToGuess.length; // total tries to guess a word.
                    char [] playerGuess = new char[ammountOfGuesses]; // "_ _ _ _ _ _ _ _"
                    // Assign empty dashes at start "_ _ _ _ _ _ _ _"
                    Arrays.fill(playerGuess, '_');

                    boolean wordIsGuessed = false;

                    char c;

                    for(c = 'a'; c <= 'z'; ++c){
                        letterBank2.add(c);
                    }
                    System.out.println("Lets Start Pl5aying Hangman ver 0.1");
                        while (!wordIsGuessed && tries != ammountOfGuesses) {
                            System.out.println("Current Guesses: ");
                            print(playerGuess);
                            System.out.printf("You have %d amount of tries left.\n", ammountOfGuesses - tries);

                            System.out.println("Enter a single character: ");
                            char input = scanner.nextLine().charAt(0);

                            letterBank2.remove(Character.valueOf(input));
                            System.out.println("Letters -- ");

                            System.out.println(letterBank2);


                            System.out.println("\n");

                            tries++;
                            boolean state=false;
                            for (int i = 0; i < randomWordToGuess.length; i++) {
                                if (randomWordToGuess[i] == input) {
                                    playerGuess[i] = input;
                                    state=true;
                                }
                            }
                            if (!state){
                                hangmanImage();
                            }


                            if (isTheWordGuessed(playerGuess)) {
                                System.out.println("Congratulations");
                            }

                        } /* End of wordIsGuessed */



                    if (!wordIsGuessed) {
                        System.out.println("You ran out of guesses.");
                    }


                    System.out.println("Would you like to play again? (yes/no) ");
                    String choice = scanner.nextLine();
                    if (choice.equals("no")) {
                        weArePlaying = false;
                    } else if (choice.equals("yes")) {
                        weArePlaying=true;
                        wordIsGuessed = false;
                        tries=0;
                    }

                } /* End of We Are Playing */
                scanner.close();

                System.out.println("Game Over!");
                break;
            case "vehicles":
                weArePlaying = true;
                while (weArePlaying) {
                    int randomNumber = random.nextInt(6); // random.nextInt(10);
                    char[] randomWordToGuess = vehicles[randomNumber].toCharArray(); // java -> j,a,v,a

                    int ammountOfGuesses = randomWordToGuess.length; // total tries to guess a word.
                    char [] playerGuess = new char[ammountOfGuesses]; // "_ _ _ _ _ _ _ _"
                    // Assign empty dashes at start "_ _ _ _ _ _ _ _"
                    Arrays.fill(playerGuess, '_');

                    boolean wordIsGuessed = false;

                    char c;

                    for(c = 'a'; c <= 'z'; ++c){
                        letterBank2.add(c);
                    }
                    System.out.println("Lets Start Pl5aying Hangman ver 0.1");
                    while (!wordIsGuessed && tries != ammountOfGuesses) {
                        System.out.println("Current Guesses: ");
                        print(playerGuess);
                        System.out.printf("You have %d amount of tries left.\n", ammountOfGuesses - tries);

                        System.out.println("Enter a single character: ");
                        char input = scanner.nextLine().charAt(0);

                        letterBank2.remove(Character.valueOf(input));
                        System.out.println("Letters -- ");

                        System.out.println(letterBank2);


                        System.out.println("\n");

                        tries++;
                        boolean state=false;
                        for (int i = 0; i < randomWordToGuess.length; i++) {
                            if (randomWordToGuess[i] == input) {
                                playerGuess[i] = input;
                                state=true;
                            }
                        }
                        if (!state){
                            hangmanImage();
                        }


                        if (isTheWordGuessed(playerGuess)) {
                            System.out.println("Congratulations");
                        }

                    } /* End of wordIsGuessed */



                    if (!wordIsGuessed) {
                        System.out.println("You ran out of guesses.");
                    }


                    System.out.println("Would you like to play again? (yes/no) ");
                    String choice = scanner.nextLine();
                    if (choice.equals("no")) {
                        weArePlaying = false;
                    } else if (choice.equals("yes")) {
                        weArePlaying=true;
                        wordIsGuessed = false;
                        tries=0;
                    }

                } /* End of We Are Playing */
                scanner.close();

                System.out.println("Game Over!");
        }


    }

}
