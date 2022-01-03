/**
 * [WordSearch.java]
 * Capitalizes words found in a given wordsearch
 * @author Derek Chen
 * @version 1.0 May 23, 2020
 */

import java.util.Scanner;
import java.io.File;

class WordSearchSolver{
  
  public static boolean checkOutOfBond(int sideLength, int i, int j) {
    if (i >= 0 && i < sideLength && j >= 0 && j < sideLength) {
      return true;
    } else {
      return false;
    }
  }
  
  public static boolean search(char[][] puzzle, String word, int[][] charIndex, String[] possibleOutput, int g, int count) {
    boolean equal = true;
    for(int i = 0; i<charIndex.length;  i++){
      for(int j = 0; j<2; j++){
        int num1 = charIndex[i][0];
        int num2 = charIndex[i][1];
        if(puzzle[num1][num2] != word.charAt(i)){
          equal = false;
        }
        if (i == charIndex.length-1 && j == 1 && equal == true){
          return true;
        }
      }
    }
    
    char nextLetter = word.charAt(count + 1);
    int i = charIndex[count][0];
    int j = charIndex[count][1];
    
    if (checkOutOfBond(puzzle.length, i - 1, j - 1) == true && puzzle[i - 1][j - 1] == nextLetter && possibleOutput[g].equals("upleft")) {
      charIndex[count + 1][0] = i - 1;
      charIndex[count + 1][1] = j - 1;
      return search(puzzle, word, charIndex, possibleOutput, g, count + 1);
    } else if (checkOutOfBond(puzzle.length, i - 1, j - 0) == true && puzzle[i - 1][j - 0] == nextLetter && possibleOutput[g].equals("up")) {
      charIndex[count + 1][0] = i - 1;
      charIndex[count + 1][1] = j - 0;
      return search(puzzle, word, charIndex, possibleOutput, g, count + 1);
    } else if (checkOutOfBond(puzzle.length, i - 1, j + 1) == true && puzzle[i - 1][j + 1] == nextLetter && possibleOutput[g].equals("upright")) {
      charIndex[count + 1][0] = i - 1;
      charIndex[count + 1][1] = j + 1;
      return search(puzzle, word, charIndex, possibleOutput, g, count + 1);
    } else if (checkOutOfBond(puzzle.length, i - 0, j - 1) == true && puzzle[i - 0][j - 1] == nextLetter && possibleOutput[g].equals("left")) {
      charIndex[count + 1][0] = i - 0;
      charIndex[count + 1][1] = j - 1;
      return search(puzzle, word, charIndex, possibleOutput, g, count + 1);
    } else if (checkOutOfBond(puzzle.length, i - 0, j + 1) == true && puzzle[i - 0][j + 1] == nextLetter && possibleOutput[g].equals("right")) {
      charIndex[count + 1][0] = i - 0;
      charIndex[count + 1][1] = j + 1;
      return search(puzzle, word, charIndex, possibleOutput, g, count + 1);
    } else if (checkOutOfBond(puzzle.length, i + 1, j - 1) == true && puzzle[i + 1][j - 1] == nextLetter && possibleOutput[g].equals("downleft")) {
      charIndex[count + 1][0] = i + 1;
      charIndex[count + 1][1] = j - 1;
      return search(puzzle, word, charIndex, possibleOutput, g, count + 1);
    } else if (checkOutOfBond(puzzle.length, i + 1, j - 0) == true && puzzle[i + 1][j - 0] == nextLetter && possibleOutput[g].equals("down")) {
      charIndex[count + 1][0] = i + 1;
      charIndex[count + 1][1] = j - 0;
      return search(puzzle, word, charIndex, possibleOutput, g, count + 1);
    } else if (checkOutOfBond(puzzle.length, i + 1, j + 1) == true && puzzle[i + 1][j + 1] == nextLetter && possibleOutput[g].equals("downright")) {
      charIndex[count + 1][0] = i + 1;
      charIndex[count + 1][1] = j + 1;
      return search(puzzle, word, charIndex, possibleOutput, g, count + 1);
    } else {
      return false;
    }
  }
  
  public static int countPossible(char[][] puzzle, char nextLetter, int i, int j) {
    int count = 0;
    if (checkOutOfBond(puzzle.length, i - 1, j - 1) == true && puzzle[i - 1][j - 1] == nextLetter) {
      count++;
    }
    if (checkOutOfBond(puzzle.length, i - 1, j - 0) == true && puzzle[i - 1][j - 0] == nextLetter) {
      count++;
    }
    if (checkOutOfBond(puzzle.length, i - 1, j + 1) == true && puzzle[i - 1][j + 1] == nextLetter) {
      count++;
    }
    if (checkOutOfBond(puzzle.length, i - 0, j - 1) == true && puzzle[i - 0][j - 1] == nextLetter) {
      count++;
    }
    if (checkOutOfBond(puzzle.length, i - 0, j + 1) == true && puzzle[i - 0][j + 1] == nextLetter) {
      count++;
    }
    if (checkOutOfBond(puzzle.length, i + 1, j - 1) == true && puzzle[i + 1][j - 1] == nextLetter) {
      count++;
    }
    if (checkOutOfBond(puzzle.length, i + 1, j - 0) == true && puzzle[i + 1][j - 0] == nextLetter) {
      count++;
    }
    if (checkOutOfBond(puzzle.length, i + 1, j + 1) == true && puzzle[i + 1][j + 1] == nextLetter) {
      count++;
    }
    return count;
  }
  
  public static void findDirection(char[][] puzzle, char nextLetter, String[] possibleOutput, int i, int j) {
    int c = 0;
    if (checkOutOfBond(puzzle.length, i - 1, j - 1) == true && puzzle[i - 1][j - 1] == nextLetter) {
      possibleOutput[c] = "upleft";
      c++;
    }
    if (checkOutOfBond(puzzle.length, i - 1, j - 0) == true && puzzle[i - 1][j - 0] == nextLetter) {
      possibleOutput[c] = "up";
      c++;
    }
    if (checkOutOfBond(puzzle.length, i - 1, j + 1) == true && puzzle[i - 1][j + 1] == nextLetter) {
      possibleOutput[c] = "upright";
      c++;
    }
    if (checkOutOfBond(puzzle.length, i - 0, j - 1) == true && puzzle[i - 0][j - 1] == nextLetter) {
      possibleOutput[c] = "left";
      c++;
    }
    if (checkOutOfBond(puzzle.length, i - 0, j + 1) == true && puzzle[i - 0][j + 1] == nextLetter) {
      possibleOutput[c] = "right";
      c++;
    }
    if (checkOutOfBond(puzzle.length, i + 1, j - 1) == true && puzzle[i + 1][j - 1] == nextLetter) {
      possibleOutput[c] = "downleft";
      c++;
    }
    if (checkOutOfBond(puzzle.length, i + 1, j - 0) == true && puzzle[i + 1][j - 0] == nextLetter) {
      possibleOutput[c] = "down";
      c++;
    }
    if (checkOutOfBond(puzzle.length, i + 1, j + 1) == true && puzzle[i + 1][j + 1] == nextLetter) {
      possibleOutput[c] = "downright";
      c++;
    }
  }
  
  //Begin Main
  public static void main(String[] args) throws Exception {
    
    File testCasesFile = new File("TestCases.txt");
    Scanner input = new Scanner(testCasesFile);
    
    //Checks to see if there is still text in the text file
    while (input.hasNextLine()) {
      
      //Stores the number of words in the word bank into a variable
      int numWords = input.nextInt();
      input.nextLine();
      
      //Creates an array for the puzzle's word bank
      String[] wordBank = new String[numWords];
      for (int i = 0; i < numWords; i++) {
        wordBank[i] = input.nextLine();
      }
      
      //Find the length of the first line in the wordsearch
      String firstLine = input.nextLine();
      firstLine = firstLine.replaceAll(" ", "");   //Removes spaces from the first line
      int sideLength = firstLine.length();
      
      //Creates two new variables based on the length of the puzzle, an original, which holds the word search in all lowercase, and a duplicate, which displays the words with capitalized letters 
      char[][] puzzle = new char[sideLength][sideLength];   //This array is the "original" word search and stores the puzzle in all lowercase
      char[][] puzzleAnswer = new char[sideLength][sideLength];   //This array is a duplicate of the original, and is later modified to display the puzzle with capitalized words. This helps with words that overlap because the words checked are only checked in lowercase
      
      //Copies the first line of the puzzle 
      for (int i = 0; i < sideLength; i++) {
        puzzle[0][i] = firstLine.charAt(i);
      }
      
      //Copies the other lines of the puzzle into the array
      int puzzleRow = 1;   //Starts on the second row of the array because the first row was already copied
      int puzzleColumn = 0;
      int limiter = 0;   //Limiter to prevent the other lines from becoming too large
      while (limiter != ((sideLength - 1) * sideLength)) {
        if (puzzleColumn == sideLength) {
          puzzleColumn = 0;
          puzzleRow++;
        }
        
        puzzle[puzzleRow][puzzleColumn] = input.next().charAt(0);   //Copies each letter of the array (takes the next character, so skips spacees)
        puzzleColumn++;
        limiter++;
      }
         
      //Copies the original array into the duplicate array
      for (int c = 0; c < sideLength; c++) {
        for (int v = 0; v < sideLength; v++) {
          puzzleAnswer[c][v] = puzzle[c][v];
        }
      }
      
      //The meat of the code: this for loop calls for 3 methods to find the words in the word search
      for (int i = 0; i < numWords; i++) {
        String wordToSearch = wordBank[i];   //Variable that takes each word the code is trying to find
        int[][] charIndex = new int[wordToSearch.length()][2];   //2d array with x, 2 length???
        boolean wordFound = false;
        
        //These two variables are basically a for loop in a for loop
        int a = 0;   //Column variable
        int b = 0;   //Row variable
        
        while (wordFound == false) {
          
          if (a == sideLength) {   //Checks to see if the column goes out of bounds (basically the limiter in a for loop)
            a = 0;
          }
          if (wordToSearch.charAt(0) == puzzle[a][b]) {
            char nextLetter = wordToSearch.charAt(1);
            int numberOfOutput = countPossible(puzzle, nextLetter, a, b);
            String[] possibleOutput = new String[numberOfOutput];
            findDirection(puzzle, nextLetter, possibleOutput, a, b);
            charIndex[0][0] = a;
            charIndex[0][1] = b;
            for (int g = 0; g < numberOfOutput; g++) {
              if (wordFound == false) {
                wordFound = search(puzzle, wordToSearch, charIndex, possibleOutput, g, 0);
              }
            }
          }
          if (b == sideLength - 1) {
            a++;
            b = 0;
          } else {
            b++;
          }
        }
 
        // Capitalizes words found in the word search
        for (int x = 0; x < charIndex.length; x++) {
          int index1 = charIndex[x][0];
          int index2 = charIndex[x][1];
          puzzleAnswer[index1][index2] = Character.toUpperCase(puzzleAnswer[index1][index2]);
        }
      }
      
      //Prints the copied word search, with capitalized words
      for (int k = 0; k < puzzle.length; k++) {
        for (int u = 0; u < puzzle.length; u++) {
          System.out.print(puzzleAnswer[k][u] + " ");
        }
        
        System.out.println();
      }
      
      input.nextLine();
    }   //End of checking for text while loop
    
    
  }   //END OF MAIN
  
  
}
