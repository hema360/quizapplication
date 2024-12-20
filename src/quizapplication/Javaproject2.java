package quizapplication;

import java.util.Scanner;
import java.util.Random;

public class Javaproject2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        project player = new project();

        
        try {
            System.out.println("Enter Your Name:");
            player.setName(sc.nextLine());

            System.out.println("Enter Your Place:");
            player.setPlace(sc.nextLine());

            System.out.println("Enter Your Phone Number:");
            player.setPhoneNo(sc.nextLine());

            System.out.println("Enter Your Age:");
            player.setAge(Integer.parseInt(sc.nextLine()));  

            System.out.println("Enter Your Email:");
            player.setEmail(sc.nextLine());

        } catch (NumberFormatException e) {
            System.out.println("Invalid input for age. Please enter a valid integer for age.");
            System.exit(0); // Exit the program if input is invalid
        }

        System.out.println("\nWelcome, " + player.getName() + "!");
        System.out.println("From: " + player.getPlace());
        System.out.println("Age: " + player.getAge());
        System.out.println("Email: " + player.getEmail());

        System.out.println("\nAre you ready to start the Quiz? (yes/no):");
        String ready = sc.nextLine();
        if (!ready.equalsIgnoreCase("yes")) {
            System.out.println("Game is terminated!");
            System.exit(0); 
        }

        System.out.println("Welcome to the Quiz Game!");
        System.out.println("RULES:");
        System.out.println("1. There will be 10 questions, each with 4 options.");
        System.out.println("2. You must choose the correct answer(1-4) for each question.");
        System.out.println("3. Each correct answer rewards $1000.");
        System.out.println("4. If you answer a question incorrectly, the game will end.");
        System.out.println("5. No lifelines are allowed in this quiz, except the 50-50 lifeline (once).");

        String[] questions = {
            "What is the size of the int data type in java?",
            "What is the super class of all classes in java?",
            "Which of the following is not a Java keyword?",
            "Which keyword is used to create an object in java?",
            "What is the entry point of a java program?",
            "What is the default value of a boolean variable in Java?",
            "Which of the following is not a primitive data type in Java?",
            "Which method is used to start a thread in Java?",
            "Which keyword is used to prevent a class from being subclassed?",
            "Which of the following is used to create a constant in Java?"
        };

        String[][] options = {
            {"1. 4 bytes", "2. 8 bytes", "3. 2 bytes", "4. 16 bytes","5. lifeline","6. quit"},
            {"1. object", "2. class", "3. parent", "4. main","5. lifeline","6. quit"},
            {"1. static", "2. void", "3. null", "4. unsigned","5. lifeline","6. quit"},
            {"1. new","2. create","3. class","4.object","5. lifeline","6. quit"},
            {"1. start()","2. main","3. run()","4. begin()","5. lifeline","6. quit"},
            {"1. true", "2. false", "3. 0", "4. null","5. lifeline","6. quit"},
            {"1. int", "2. char", "3. float", "4. String","5. lifeline","6. quit"},
            {"1. run()", "2. start()", "3. begin()", "4. execute()","5. lifeline","6. quit"},
            {"1. static", "2. final", "3. abstract", "4. extends","5. lifeline","6. quit"},
            {"1. constant", "2. const", "3. final", "4. static","5. lifeline","6. quit"}
        };

        int[] correctAnswers = {1, 2, 4, 1, 2, 2, 4, 2, 2, 3}; 
        int reward = 1000;
        int totalAmountWon = 0;
        boolean hasLifelineUsed = false;
        
        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + ": " + questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }

            
            if (!hasLifelineUsed) {
                System.out.println("Do you want to use the 50-50 lifeline? (yes/no)");
                String useLifeline = sc.nextLine();
                if (useLifeline.equalsIgnoreCase("yes")) {
                    hasLifelineUsed = true;
                    useFiftyFiftyLifeline(options[i], correctAnswers[i]);
                }
            }

           
            System.out.println("Type 'quit' to exit the  quiz game or press Enter to continue.");

            String quitInput = sc.nextLine();
            if (quitInput.equalsIgnoreCase("quit")) {
                System.out.println("You have quit the game. Goodbye!");
                System.exit(0); 
            }

            int answer = 0;
            boolean validAnswer = false;

           
            while (!validAnswer) {
                try {
                    System.out.print("Enter your answer (1-6): ");
                    answer = Integer.parseInt(sc.nextLine());

                    if (answer < 1 || answer > 6) {
                        System.out.println("Invalid answer. Please choose between 1 and 6.");
                        continue;
                    }

                    validAnswer = true; 
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 6.");
                }
            }

            if (answer == correctAnswers[i]) {
                totalAmountWon += reward;
                System.out.println("Correct! You earned $" + reward + ". Total: $" + totalAmountWon);
            } else {
                System.out.println("Wrong answer! You won $" + totalAmountWon);
                System.exit(0); 
            }
        }

        System.out.println("\nCongratulations, " + player.getName() + "! You completed the quiz.");
        System.out.println("Total amount won: $" + totalAmountWon);
    }

    
    public static void useFiftyFiftyLifeline(String[] options, int correctAnswer) {
        Random random = new Random();
        int correctOption = correctAnswer - 1;
       
        int incorrectOption1 = random.nextInt(6);
        while (incorrectOption1 == correctOption) {
            incorrectOption1 = random.nextInt(6);
        }

        int incorrectOption2 = random.nextInt(6);
        while (incorrectOption2 == correctOption || incorrectOption2 == incorrectOption1) {
            incorrectOption2 = random.nextInt(6);
        }

        System.out.println("\n50-50 Lifeline Used! The remaining options are:");
        for (int i = 0; i < options.length; i++) {
            if (i == correctOption || i == incorrectOption1) {
                System.out.println(options[i]);
            }
        }
    }
}



