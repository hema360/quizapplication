package quizapplication;

import java.util.Scanner;

public class JavaProject  {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		project player=new project();
		System.out.println("Enter Your Name");
		player.setName(sc.nextLine());
		System.out.println("Enter Your place");
		player.setName(sc.nextLine());
		System.out.println("Enter Your Phone Number");
		player.setName(sc.nextLine());
		System.out.println("Enter Your Age");
		player.setName(sc.nextLine());
		System.out.println("Enter Your Email");
		player.setName(sc.nextLine());
		System.out.println("\n Welcome,"+player.getName() +"!");
		System.out.println("From: "+player.getPlace());
		System.out.println("Age: "+player.getAge());
		System.out.println("Email: "+player.getEmail());
		 String[] questions = {
		    		"What is the size of the int data type in java? ",
		            "What is the super class of all classes in java?",
		            "Which of the following is not java keywords?"
		    };
		           
		    String[][] options = {
		    		{"1. 4 bytes", "2. 8 bytes", "3. 2 bytes", "4. 16 bytes"},
		            {"1. object", "2. class", "3. parent", "4. main"},
		            {"1. static", "2. void", "3. null", "4. unsigned"}};
		    int[] correctAnswers = {1,1,4};
		    int reward = 1000;
		    int totalAmountWon = 0;
		
		    System.out.println("\n Are you ready to start the Quiz?(yes/no):");
		    String ready=sc.nextLine();
		    if(! ready.equalsIgnoreCase("yes"));
		    {
		    	System.out.println("game is terminated!");
		    	return;
		    }
		    for (int i = 0; i < questions.length; i++)
		    {
	            System.out.println("\nQuestion " + (i + 1) + ": " + questions[i]);
	            for (String option : options[i]) {
	                System.out.println(option);
	            }

	            System.out.print("Enter your answer (1-4): ");
	            int answer = sc.nextInt();
	            sc.nextLine(); // Clear the buffer after reading an integer

	            // Check if the answer is correct
	            if (answer == correctAnswers[i]) {
	                totalAmountWon += reward;
	                System.out.println("Correct! You earned $" + reward + ". Total: $" + totalAmountWon);
	            } else {
	                System.out.println("Wrong answer! You won $" + totalAmountWon);
	                return; // End the game if the answer is wrong
	            }
	        }

	        // If all questions are answered correctly
	        System.out.println("\nCongratulations, " + player.getName() + "! You completed the quiz.");
	        System.out.println("Total amount won: $" + totalAmountWon);
	    }
	}
		   
		    
		
		

		    	
	    	
		
