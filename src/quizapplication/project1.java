package quizapplication;

import java.util.Scanner;

public class project1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        project player = new project();
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
        System.out.println("\nWelcome, " + player.getName() + "!");
        System.out.println("From: " + player.getPlace());
        System.out.println("Age: " + player.getAge());
        System.out.println("Email: " + player.getEmail());
        System.out.println("welcome to the Quiz Game!");
        System.out.println("RULES:");
        System.out.println("1. There will be 3 questions, each with 4 opptions.");
        System.out.println("2. You must choose the correct answer(1-4) for each question.");
        System.out.println("3.Each correct answer rewards $1000.");
        System.out.println("4. if you answer a question incorrectly,the game will end.");
        System.out.println("5. No lifelines are allowed in this quiz.");
        String[] questions = {
            "What is the size of the int data type in java?",
            "What is the super class of all classes in java?",
            "Which of the following is not a Java keyword?"
        };

        String[][] options = {
            {"1. 4 bytes", "2. 8 bytes", "3. 2 bytes", "4. 16 bytes"},
            {"1. object", "2. class", "3. parent", "4. main"},
            {"1. static", "2. void", "3. null", "4. unsigned"}
        };

        int[] correctAnswers = {1, 1, 4}; 
        int reward = 1000;
        int totalAmountWon = 0;
        System.out.println("\nAre you ready to start the Quiz? (yes/no):");
        String ready = sc.nextLine();
        if (!ready.equalsIgnoreCase("yes")) {
            System.out.println("Game is terminated!");
            return; 
        }
        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + ": " + questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.print("Enter your answer (1-4): ");
            int answer = sc.nextInt();
            sc.nextLine(); 
           
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
        System.exit(0);
    }
}



