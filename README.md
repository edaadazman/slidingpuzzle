# CS611-Assignment 1
## Sliding Puzzle
---------------------------------------------------------------------------
- Name: Edaad Azman
- Email: edaad@bu.edu
- Student ID: U38459100

## Files
---------------------------------------------------------------------------

App.java: Main entry point that starts the sliding puzzle game with a Scanner for user input.

Board.java: Board is an interface that defines common board operations like dimensions, adjacency checking, and validation for checking if game is solved.

BoardGame.java: This is the abstract base class implementing a template for board games with functionality for game looping, counting moves, and replay.

Player.java: Handles player information and input operations, providing a clean abstraction for user interaction.

SlidingPuzzleBoard.java: Implementation of the sliding puzzle board with tile management, shuffling the board, and validating moves.

SlidingPuzzleGame.java: Sliding puzzle specific game logic extending BoardGame with setup, move parsing, and special commands like shuffle.

## Notes
---------------------------------------------------------------------------

Design Choices: 

- Applied encapsulation principles as each class has clear responsibilities with private fields and a controlled system of access through public methods. SlidingPuzzleBoard encapsulates the state of the grid and any tile operations, while Player encapsulates input handling. 

- Inheritance was used through a template method of BoardGame being an abstract class, and subclasses like SlidingPuzzleGame can be applied on top to customize specific behaviors.

- Polymorphism applied through the Board interface which enables different board implementations for different types of games. The BoardGame class works with any Board implementation without knowing the specific type. 

- Abstraction layers help with seperating concerns, where Plyaer abstracts all the input handling, and Board abstracts all board operations, etc. making each component independently testable. 

- These design choices enable the easy creation of new board games by just extending BoardGame and implementing Board on other games like Tic-Tac-Toe for example. 

Cool Features / Creative Choices: 

- Automatic move counting with display in victory message to show player performance. This feature is very nice to have for the player to see how many moves it took them to complete the board and can therefore keep a "score" in some form. 

- Added "shuffle" command during gameplay to reshuffle the current board without restarting. I noticed that some boards can often get frustrating and feels almost unsolvable, so adding this feature helped sort of get some "help" when those situations come. 

- A creative choice I made to ensure that a board is always solvable was to use valid moves from a solved board, rather than just random arrangement.


## How to compile and run
---------------------------------------------------------------------------

1. Download all .java files and place them in the directory /slidingpuzzle/src 
2. Navigate to the root "slidingpuzzle" directory and open the terminal
3. Run the following instructions:
```
javac src/*.java
cd src
java App
```

## Input/Output Example
```
---------------------------------------------------------------------------
INPUT: java App

OUTPUT:
Welcome to the Sliding Puzzle Game! Arrange the numbered tiles such that tiles are ordered from least to greatest from top left to bottom right.
Enter your name: 

INPUT: Edaad

OUTPUT:
Enter number of rows (2-10): 

INPUT: 3

OUTPUT:
Enter number of cols (2-10): 

INPUT: 3

OUTPUT: 
Good luck, Edaad!
Enter the number of the tile you want to move. Type 'shuffle' to reshuffle the board. Enter 'quit' to exit.

|  1|  3|  7|
+---+---+---+
|  4|  6|  2|
+---+---+---+
|   |  5|  8|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 5

OUTPUT: 
|  1|  3|  7|
+---+---+---+
|  4|  6|  2|
+---+---+---+
|  5|   |  8|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 6

OUTPUT: 
|  1|  3|  7|
+---+---+---+
|  4|   |  2|
+---+---+---+
|  5|  6|  8|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 3

OUTPUT: 
|  1|   |  7|
+---+---+---+
|  4|  3|  2|
+---+---+---+
|  5|  6|  8|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 7

OUTPUT: 
|  1|  7|   |
+---+---+---+
|  4|  3|  2|
+---+---+---+
|  5|  6|  8|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 2

OUTPUT: 
|  1|  7|  2|
+---+---+---+
|  4|  3|   |
+---+---+---+
|  5|  6|  8|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 3

OUTPUT: 
|  1|  7|  2|
+---+---+---+
|  4|   |  3|
+---+---+---+
|  5|  6|  8|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 7

OUTPUT: 
|  1|   |  2|
+---+---+---+
|  4|  7|  3|
+---+---+---+
|  5|  6|  8|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 2

OUTPUT: 
|  1|  2|   |
+---+---+---+
|  4|  7|  3|
+---+---+---+
|  5|  6|  8|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 3

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  4|  7|   |
+---+---+---+
|  5|  6|  8|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 8

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  4|  7|  8|
+---+---+---+
|  5|  6|   |
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 6

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  4|  7|  8|
+---+---+---+
|  5|   |  6|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 7

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  4|   |  8|
+---+---+---+
|  5|  7|  6|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 8

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  4|  8|   |
+---+---+---+
|  5|  7|  6|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 6

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  4|  8|  6|
+---+---+---+
|  5|  7|   |
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 7

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  4|  8|  6|
+---+---+---+
|  5|   |  7|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 5

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  4|  8|  6|
+---+---+---+
|   |  5|  7|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 4

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|   |  8|  6|
+---+---+---+
|  4|  5|  7|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 8

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  8|   |  6|
+---+---+---+
|  4|  5|  7|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 5

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  8|  5|  6|
+---+---+---+
|  4|   |  7|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 4

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  8|  5|  6|
+---+---+---+
|   |  4|  7|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 8

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|   |  5|  6|
+---+---+---+
|  8|  4|  7|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 5

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  5|   |  6|
+---+---+---+
|  8|  4|  7|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 4

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  5|  4|  6|
+---+---+---+
|  8|   |  7|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 7

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  5|  4|  6|
+---+---+---+
|  8|  7|   |
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 6

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  5|  4|   |
+---+---+---+
|  8|  7|  6|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 4

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  5|   |  4|
+---+---+---+
|  8|  7|  6|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 7

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  5|  7|  4|
+---+---+---+
|  8|   |  6|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 6

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  5|  7|  4|
+---+---+---+
|  8|  6|   |
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 4

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  5|  7|   |
+---+---+---+
|  8|  6|  4|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 7

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  5|   |  7|
+---+---+---+
|  8|  6|  4|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 5

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|   |  5|  7|
+---+---+---+
|  8|  6|  4|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 8

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  8|  5|  7|
+---+---+---+
|   |  6|  4|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 6

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  8|  5|  7|
+---+---+---+
|  6|   |  4|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 5

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  8|   |  7|
+---+---+---+
|  6|  5|  4|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 8

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|   |  8|  7|
+---+---+---+
|  6|  5|  4|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 6

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  6|  8|  7|
+---+---+---+
|   |  5|  4|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 5

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  6|  8|  7|
+---+---+---+
|  5|   |  4|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 4

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  6|  8|  7|
+---+---+---+
|  5|  4|   |
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 7

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  6|  8|   |
+---+---+---+
|  5|  4|  7|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 8

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  6|   |  8|
+---+---+---+
|  5|  4|  7|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 6

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|   |  6|  8|
+---+---+---+
|  5|  4|  7|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 5

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  5|  6|  8|
+---+---+---+
|   |  4|  7|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 4

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  5|  6|  8|
+---+---+---+
|  4|   |  7|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 7

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  5|  6|  8|
+---+---+---+
|  4|  7|   |
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 8

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  5|  6|   |
+---+---+---+
|  4|  7|  8|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 6

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  5|   |  6|
+---+---+---+
|  4|  7|  8|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 5

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|   |  5|  6|
+---+---+---+
|  4|  7|  8|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 4

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  4|  5|  6|
+---+---+---+
|   |  7|  8|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 7

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  4|  5|  6|
+---+---+---+
|  7|   |  8|
+---+---+---+

Enter your move, 'shuffle', or 'quit': 

INPUT: 8

OUTPUT: 
|  1|  2|  3|
+---+---+---+
|  4|  5|  6|
+---+---+---+
|  7|  8|   |
+---+---+---+

Congratulations! You won in 50 moves!
Would you like to play again? (yes/no): 

INPUT: no

OUTPUT: 
Thanks for playing! Goodbye!
```