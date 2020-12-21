package com.hackedlings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PuzzleSolverImplementation {

    private BufferedReader br;
    private char[][] arr;

    public PuzzleSolverImplementation() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        LetterGuessPuzzle.printInstructions();
        this.arr = new char[][]{   // Mesh grid on which we are asked to find the words.
                {'M', 'E', 'H', 'X', 'R', 'E', 'G', 'C', 'T', 'M', 'V', 'Z', 'C', 'N'},
                {'M', 'K', 'A', 'P', 'G', 'N', 'K', 'B', 'A', 'S', 'B', 'D', 'R', 'X'},
                {'R', 'Q', 'N', 'C', 'E', 'Y', 'D', 'T', 'H', 'D', 'Q', 'G', 'M', 'W'},
                {'B', 'G', 'B', 'O', 'C', 'T', 'F', 'U', 'O', 'C', 'R', 'Q', 'Q', 'L'},
                {'R', 'F', 'M', 'W', 'W', 'O', 'H', 'T', 'W', 'Z', 'N', 'U', 'H', 'M'},
                {'Q', 'K', 'V', 'Y', 'V', 'L', 'U', 'I', 'I', 'W', 'V', 'A', 'V', 'D'},
                {'C', 'O', 'M', 'P', 'E', 'T', 'E', 'N', 'C', 'Y', 'M', 'L', 'S', 'Q'},
                {'X', 'C', 'B', 'T', 'R', 'X', 'X', 'D', 'T', 'A', 'M', 'I', 'J', 'R'},
                {'X', 'R', 'Q', 'N', 'N', 'U', 'O', 'F', 'G', 'A', 'L', 'T', 'F', 'K'},
                {'Q', 'I', 'R', 'E', 'L', 'I', 'A', 'B', 'L', 'E', 'B', 'Y', 'J', 'K'},
                {'M', 'E', 'P', 'F', 'Q', 'Y', 'H', 'Z', 'R', 'C', 'K', 'L', 'Q', 'G'},
                {'U', 'E', 'Z', 'T', 'L', 'U', 'I', 'Z', 'G', 'B', 'O', 'E', 'E', 'T'}
        };
    }

    public void solvePuzzle() throws IOException {
        LetterGuessPuzzle puzzle = new LetterGuessPuzzle(arr);
        boolean exit = false;

        while(!exit) {
            System.out.println("******** MAIN MENU ********");
            System.out.println("1. Find word position");
            System.out.println("2. See puzzle mesh");
            System.out.println("3. See instructions");
            System.out.println("4. Exit");
            System.out.println("Please enter your choice (1 - 4)");
            String choice = br.readLine().strip();

            switch (choice) {
                case "1":
                    System.out.println("Enter word to find. Replace unknown letters by *");
                    puzzle.find(br.readLine());
                    break;
                case "2":
                    puzzle.printPuzzleMesh();
                    break;
                case "3":
                    LetterGuessPuzzle.printInstructions();
                    break;
                case "4":
                    System.out.println();
                    System.out.println("Thank you :)");
                    System.out.println("Gracefully exiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number 1, 2, 3 or 4");
                    System.out.println();
            }
        }
    }
}
