# CS611-Assignment 1
## Sliding Puzzle
---------------------------------------------------------------------------
- Name: Edaad Azman
- Email: edaad@bu.edu
- Student ID: U38459100

## Files
---------------------------------------------------------------------------

App.java: Main entry point that starts the sliding puzzle game with a Scanner for user input.

Board.java: Board interface defines common board operations like dimensions, piece management, adjacency checking, and validation for checking if game is solved. Now supports object-based pieces instead of primitive values.

BoardGame.java: Abstract base class implementing the Template Method pattern for board games with functionality for game looping, move counting, and replay capabilities.

Piece.java: Abstract base class representing game pieces with value, ownership, and movement capabilities. Provides extensible foundation for different game piece types.

Tile.java: Concrete implementation of Piece specifically for sliding puzzle tiles, supporting numbered tiles and blank tiles with appropriate movement validation.

Player.java: Handles player information and input operations, providing a clean abstraction for user interaction.

SlidingPuzzleBoard.java: Implementation of the sliding puzzle board using Tile objects instead of primitive integers. Includes size constants, tile management, shuffling algorithms, and move validation with object-oriented design.

SlidingPuzzleGame.java: Sliding puzzle specific game logic extending BoardGame with setup, move parsing, and special commands like shuffle. Uses constants from SlidingPuzzleBoard for size validation.

## Notes
---------------------------------------------------------------------------

Design Choices: 

- Applied encapsulation principles with each class having clear responsibilities and controlled access through public methods. SlidingPuzzleBoard encapsulates tile state using Tile objects instead of primitive integers, while Player encapsulates input handling. 

- Inheritance hierarchy implemented with Piece as abstract base class and Tile as concrete implementation, allowing for extensible game piece types. BoardGame uses Template Method pattern enabling subclasses like SlidingPuzzleGame to customize specific behaviors.

- Polymorphism applied through Board interface supporting different board implementations and Piece hierarchy allowing different game piece behaviors. BoardGame works with any Board implementation without knowing the specific type. 

- Abstraction layers separate concerns: Player abstracts input handling, Board abstracts board operations, Piece abstracts game element behavior, and BoardGame abstracts game flow, making each component independently testable and reusable.

- Object-oriented design eliminates hardcoded values by using constants (MIN_SIZE, MAX_SIZE) and replacing primitive int[][] with Tile[][] for better type safety and extensibility.

- These design choices enable easy creation of new board games by extending BoardGame, implementing Board, and creating specific Piece subclasses (e.g., for Dots and Boxes, Tic-Tac-Toe, etc.). 

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