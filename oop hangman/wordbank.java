import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class wordbank {
    private static int tries = 0;

    public void dispayRules() {
        System.out.println("One player thinks of a word or phrase; the others try to guess what it is one letter at a time");
        System.out.println("The program will draws a number of dashes equivalent to the number of letters in the word.");
        System.out.println("You will then guess a letter that occurs in the word");
        System.out.println("If the letter is correct it will be filled in the dashes");
        System.out.println("You have a limited number of chances");
        System.out.println("Good Luck !!");

    }

    public void display() {
        String[] category = {"sports","fruits","vehicles"};
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
            int randomNumber = random.nextInt(6); // random.nextInt(10);
            char[] randomWordToGuess = sports[randomNumber].toCharArray(); // java -> j,a,v,a

            int ammountOfGuesses = randomWordToGuess.length; // total tries to guess a word.
            char[] playerGuess = new char[ammountOfGuesses]; // "_ _ _ _ _ _ _ _"

            // Assign empty dashes at start "_ _ _ _ _ _ _ _"
            Arrays.fill(playerGuess, '_');

            boolean wordIsGuessed = false;

            boolean weArePlaying = true;
            while (weArePlaying) {
                System.out.println("Lets Start Pl5aying Hangman ver 0.1");

                while (!wordIsGuessed && tries != ammountOfGuesses) {
                    System.out.println("Current Guesses: ");
                    print(playerGuess);
                    System.out.printf("You have %d amount of tries left.\n", ammountOfGuesses - tries);
     
                    System.out.println("Enter a single character: ");
                    char input = scanner.nextLine().charAt(0);
                                     // letter word bank
        char [] letterBank = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        

            //removing letter already selected
            for(int i = 0; i < letterBank.length; i++){
                if(letterBank[i] == input){
                    // shifting elements
                    for(int j = i; j < letterBank.length - 1; j++){
                        letterBank[j] = letterBank[j+1];
                    }
                    break;
                }
            }
            System.out.println("Letters -- " );
            for(int i = 0; i < letterBank.length - 1; i++){
                System.out.print(" " + letterBank[i]);
            }  
          
            
 System.out.println("\n");

                    tries++;
                    hangmanImage();

                    if (input == '-') {
                        wordIsGuessed = true;
                        weArePlaying = false;
                        System.out.println("entered the wrong letter!");


                    }                        

                     else {
                        for (int i = 0; i < randomWordToGuess.length; i++) {
                            if (randomWordToGuess[i] == input) {
                                playerGuess[i] = input;
                            }
                        }

                        if (isTheWordGuessed(playerGuess)) {
                            wordIsGuessed = true;
                            System.out.println("Congratulations");
                        }
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
                    weArePlaying = true;

                }

            } /* End of We Are Playing */
            scanner.close();

            System.out.println("Game Over!");
        
                break;
                case "fruits":
                randomNumber = random.nextInt(6); // random.nextInt(10);
             randomWordToGuess = fruits[randomNumber].toCharArray(); // java -> j,a,v,a

         ammountOfGuesses = randomWordToGuess.length; // total tries to guess a word.
             playerGuess = new char[ammountOfGuesses]; // "_ _ _ _ _ _ _ _"

            // Assign empty dashes at start "_ _ _ _ _ _ _ _"
            Arrays.fill(playerGuess, '_');

            wordIsGuessed = false;

            weArePlaying = true;
            while (weArePlaying) {
                System.out.println("Lets Start Playing Hangman ver 0.1");

                while (!wordIsGuessed && tries != ammountOfGuesses) {
                    System.out.println("Current Guesses: ");
                    print(playerGuess);
                    System.out.printf("You have %d amount of tries left.\n", ammountOfGuesses - tries);
                    System.out.println("Enter a single character: ");
                    char input = scanner.nextLine().charAt(0);
                                                     // letter word bank
        char [] letterBank = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        

        //removing letter already selected
        for(int i = 0; i < letterBank.length; i++){
            if(letterBank[i] == input){
                // shifting elements
                for(int j = i; j < letterBank.length - 1; j++){
                    letterBank[j] = letterBank[j+1];
                }
                break;
            }
        }
        System.out.println("Letters -- " );
        for(int i = 0; i < letterBank.length - 1; i++){
            System.out.print(" " + letterBank[i]);
        } 

                    tries++;

                    if (input == '-') {
                        wordIsGuessed = true;
                        weArePlaying = false;
                    } else {
                        for (int i = 0; i < randomWordToGuess.length; i++) {
                            if (randomWordToGuess[i] == input) {
                                playerGuess[i] = input;
                            }
                        }

                        if (isTheWordGuessed(playerGuess)) {
                            wordIsGuessed = true;
                            System.out.println("Congratulations");
                        }
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
                    weArePlaying = true;

                }

            } /* End of We Are Playing */
            scanner.close();

            System.out.println("Game Over!");
        
                break;
                case "vehicles":
             randomNumber = random.nextInt(6); // random.nextInt(10);
             randomWordToGuess = vehicles[randomNumber].toCharArray(); // java -> j,a,v,a

           ammountOfGuesses = randomWordToGuess.length; // total tries to guess a word.
             playerGuess = new char[ammountOfGuesses]; // "_ _ _ _ _ _ _ _"

            // Assign empty dashes at start "_ _ _ _ _ _ _ _"
            Arrays.fill(playerGuess, '_');

             wordIsGuessed = false;

             weArePlaying = true;
            while (weArePlaying) {
                System.out.println("Lets Start Playing Hangman ver 0.1");

                while (!wordIsGuessed && tries != ammountOfGuesses) {
                    System.out.println("Current Guesses: ");
                    print(playerGuess);
                    System.out.printf("You have %d amount of tries left.\n", ammountOfGuesses - tries);
                    System.out.println("Enter a single character: ");
                    char input = scanner.nextLine().charAt(0);
                                                     // letter word bank
        char [] letterBank = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        

        //removing letter already selected
        for(int i = 0; i < letterBank.length; i++){
            if(letterBank[i] == input){
                // shifting elements
                for(int j = i; j < letterBank.length - 1; j++){
                    letterBank[j] = letterBank[j+1];
                }
                break;
            }
        }
        System.out.println("Letters -- " );
        for(int i = 0; i < letterBank.length - 1; i++){
            System.out.print(" " + letterBank[i]);
        } 

                    tries++;

                    hangmanImage();
                    if (input == '-') {
                        wordIsGuessed = true;
                        weArePlaying = false;
                    } else {
                        for (int i = 0; i < randomWordToGuess.length; i++) {
                            if (randomWordToGuess[i] == input) {
                                playerGuess[i] = input;
                            }
                        }

                        if (isTheWordGuessed(playerGuess)) {
                            wordIsGuessed = true;
                            System.out.println("Congratulations");
                        }
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
                    weArePlaying = true;

                }

            } /* End of We Are Playing */
            scanner.close();

            System.out.println("Game Over!");
        }
                
                
    }

      

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

}
