package com.hackedlings;

public class LetterGuessPuzzle {

    private char[][] arr;
    private int maxRows;
    private int maxCols;

    private enum DIRECTION {
        LEFT_RIGHT,
        RIGHT_LEFT,
        TOP_BOTTOM,
        BOTTOM_TOP,
        TOP_BOTTOM_DIAGONALLY,
        BOTTOM_TOP_DIAGONALLY
    }

    public LetterGuessPuzzle(char[][] arr) {
        this.arr = arr;
        this.maxRows = arr.length;
        this.maxCols = arr[0].length;
    }

    public void find(String key) {
        key = key.toUpperCase();
        char firstChar = key.charAt(0);
        char lastChar = key.charAt(key.length() - 1);
        boolean foundFlag = false;
        int span = key.length() - 1;

        System.out.println("\n***************************");
        System.out.println("        SEARCHING");
        System.out.println("***************************");
        for (int row = 1; row <= maxRows; row++) {
            for (int col = 1; col <= maxCols; col++) {
                // Skipping if letter does not match
                if (arr[row - 1][col - 1] != firstChar) {
                    continue;
                }

                //Searching left -> right
                if (col <= maxCols - key.length()) {
                    if (arr[row - 1][col - 1 + span] == lastChar) {
                        System.out.println("***** POSSIBLE LEFT -> RIGHT MATCH FOUND *****");
                        this.printMatchedWord(row, col, span, DIRECTION.LEFT_RIGHT);
                        foundFlag = true;
                    }
                }

                //Searching right -> left
                if (col >= key.length()) {
                    if (arr[row - 1][col - 1 - span] == lastChar) {
                        System.out.println("***** POSSIBLE RIGHT -> LEFT MATCH FOUND *****");
                        this.printMatchedWord(row, col, span, DIRECTION.RIGHT_LEFT);
                        foundFlag = true;
                    }
                }

                // Searching top -> bottom
                if (row <= maxRows - key.length()) {
                    if (arr[row - 1 + span][col - 1] == lastChar) {
                        System.out.println("***** POSSIBLE TOP -> BOTTOM MATCH FOUND *****");
                        this.printMatchedWord(row, col, span, DIRECTION.TOP_BOTTOM);
                        foundFlag = true;
                    }
                }

                // Searching bottom -> top
                if (row >= key.length()) {
                    if (arr[row - 1 - span][col - 1] == lastChar) {
                        System.out.println("***** POSSIBLE BOTTOM -> TOP MATCH FOUND *****");
                        this.printMatchedWord(row, col, span, DIRECTION.BOTTOM_TOP);
                        foundFlag = true;
                    }
                }

                // Searching top -> bottom diagonally
                if ((row <= maxRows - key.length() + 1) && (col <= maxCols - key.length() + 1)) {
                    int targetRow = row - 1 + span;
                    int targetCol = col - 1 + span;
                    if (arr[targetRow][targetCol] == lastChar) {
                        System.out.println("***** POSSIBLE TOP -> BOTTOM DIAGONAL MATCH FOUND *****");
                        this.printMatchedWord(row, col, span, DIRECTION.TOP_BOTTOM_DIAGONALLY);
                        foundFlag = true;
                    }
                }

                // Searching bottom -> top diagonally
                if ((row >= key.length()) && (col >= key.length())) {
                    int targetRow = row - 1 - span;
                    int targetCol = col - 1 - span;
                    if (arr[targetRow][targetCol] == lastChar) {
                        System.out.println("***** POSSIBLE BOTTOM -> TOP DIAGONAL MATCH FOUND *****");
                        this.printMatchedWord(row, col, span, DIRECTION.BOTTOM_TOP_DIAGONALLY);
                        foundFlag = true;
                    }
                }
            }
        }

        if (!foundFlag) {
            System.out.println(key + " could not be found in the puzzle :(");
        }
        System.out.println("***************************\n");
    }

    private void printMatchedWord(int rowStart, int colStart, int span, DIRECTION direction) {
        if (direction == DIRECTION.LEFT_RIGHT) {
            for (int i = colStart; i <= colStart + span; i++) {
                System.out.print(this.arr[rowStart - 1][i - 1]);
            }
            System.out.print(" found in location ");
            System.out.println("(" + rowStart + ", " + colStart + ") -> " + "(" + rowStart + ", " + (colStart + span) + ")");
        } else if (direction == DIRECTION.RIGHT_LEFT) {
            for (int i = colStart; i >= colStart - span; i--) {
                System.out.print(this.arr[rowStart - 1][i - 1]);
            }
            System.out.print(" found in location ");
            System.out.println("(" + rowStart + ", " + colStart + ") -> " + "(" + rowStart + ", " + (colStart - span) + ")");
        } else if (direction == DIRECTION.TOP_BOTTOM) {
            for (int i = rowStart; i <= rowStart + span; i++) {
                System.out.print(this.arr[i - 1][colStart - 1]);
            }
            System.out.print(" found in location ");
            System.out.println("(" + rowStart + ", " + colStart + ") -> " + "(" + (rowStart + span) + ", " + colStart + ")");
        } else if (direction == DIRECTION.BOTTOM_TOP) {
            for (int i = rowStart; i >= rowStart - span; i--) {
                System.out.print(this.arr[i - 1][colStart - 1]);
            }
            System.out.print(" found in location ");
            System.out.println("(" + rowStart + ", " + colStart + ") -> " + "(" + (rowStart - span) + ", " + colStart + ")");
        } else if (direction == DIRECTION.TOP_BOTTOM_DIAGONALLY) {
            for (int i = rowStart, j = colStart; i <= rowStart + span; i++, j++) {
                System.out.print(this.arr[i - 1][j - 1]);
            }
            System.out.print(" found in location ");
            System.out.println("(" + rowStart + ", " + colStart + ") -> " + "(" + (rowStart + span) + ", " + (colStart + span) + ")");
        } else if (direction == DIRECTION.BOTTOM_TOP_DIAGONALLY) {
            for (int i = rowStart, j = colStart; i >= rowStart - span; i--, j--) {
                System.out.print(this.arr[i - 1][j - 1]);
            }
            System.out.print(" found in location ");
            System.out.println("(" + rowStart + ", " + colStart + ") -> " + "(" + (rowStart - span) + ", " + (colStart - span) + ")");
        }
        System.out.println();
    }

    public void printPuzzleMesh() {
        System.out.println();
        System.out.println("******* PUZZLE MESH *******");
        for (int row = 1; row <= maxRows; row++) {
            for (int col = 1; col <= maxCols; col++) {
                System.out.print(arr[row - 1][col - 1] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printInstructions() {
        System.out.println("\n***************************");
        System.out.println(" PUZZLE SOLVER USER GUIDE");
        System.out.println("***************************");
        System.out.println("This tool finds starting and ending position of the word in the puzzle by" +
                " matching the first & last letter of the searched word.");
        System.out.println("So feel free to replace the unknown letters by *");
        System.out.println("***************************\n");
    }
}
