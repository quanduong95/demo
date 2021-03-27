// Student Name: Quan Duong
// Class: CSC20
// Professor Name: Abida Mukarram
// Date: 2/1/2021

package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) throws IOException {
        // create an answers array to store the answers taken from text file
        String[] answers = new String[20];

        // call readAnswers method
        readAnswers(answers);

        // call playGame method
        playGame(answers);
    }

    // header of readAnswers method
    public static void readAnswers(String[] answers) throws IOException {
        {
            // declare text file
            File text = new File("C:/Users/QUAN/Lab1/src/com/company/answers.txt");

            Scanner scan = new Scanner(text);
            int counter = 0;

            // loop through text file to take and store its element into answers array
            // counter variable to keep track of the maximum elements allowance for the array is 20
            while (scan.hasNextLine() && counter < 20) {

                // store each element on each line into answers's array respectively
                answers[counter] = scan.nextLine();
                counter++;
            }
        }
    }
    public static void playGame( String[] answers) throws IOException {
        // declare rand variable as random type
        Random rand = new Random();

        // declare randomNum var to store random Int from 0-19
        int randomNum = rand.nextInt(19);

        // create question string variable to store user's input as his/her question
        String question = "";
        Scanner scan = new Scanner(System.in);

        // ask user to enter his/her question
        System.out.println("What do you want to ask ? ");
        question = scan.nextLine();

        /* display the answer for the user's first question by accessing a random element from
            answers array */
        /* use if statement in case of the number of element in the text file is less than 20,
         which will create some null element for the array */
        if(answers[randomNum] == null){
            randomNum = rand.nextInt(19);
            System.out.println(answers[randomNum]);
        } else {
            System.out.println(answers[randomNum]);
        }

        // use while loop to keep doing the task until the user hit ENTER
        while(!question.isEmpty()){
            // generate a different randomNum every time
            randomNum = rand.nextInt(19);
            System.out.println("Do you want to ask another question? Enter the question." +
                " If not, hit ENTER to terminate the program!");
            question = scan.nextLine();
            System.out.println(answers[randomNum]);
        }
    }
}