import java.util.Random;

import javafx.application.Application;

import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.geometry.Pos;
import javafx.geometry.Insets;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class TicTacToe extends Application
{
	final int ROWS = 3;
	final int COLS = 3;
	// declare fields which can be used by event handler
	private Label resultsLabel;
	private ImageView[][] imageBoard;
	private Image blank = new Image("file:blank.png");
	private Image x = new Image("file:x.png");
	private Image o = new Image("file:o.png");
	private int[][] gameBoard;
	private int turn = 1;
	
	// gameResult combinations
	// 0 = O wins
	// 1 = X wins
	// 2 = Tie
	// 3 = game not started or in progress
	private int gameResult = -1;

	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage)
	{
		// Initialize imageBoard with blank images
		imageBoard = new ImageView[ROWS][COLS];
		for (int row = 0; row < ROWS; row++)
		{
   			for (int col = 0; col < COLS; col++)
   			{
      			imageBoard[row][col] = new ImageView(blank);
   			}
		}

		
		// Organize image array onto GridPane
		GridPane grid = new GridPane();
		grid.add(imageBoard[0][0], 0, 0);
		grid.add(imageBoard[0][1], 0, 1);
		grid.add(imageBoard[0][2], 0, 2);
		grid.add(imageBoard[1][0], 1, 0);
		grid.add(imageBoard[1][1], 1, 1);
		grid.add(imageBoard[1][2], 1, 2);
		grid.add(imageBoard[2][0], 2, 0);
		grid.add(imageBoard[2][1], 2, 1);
		grid.add(imageBoard[2][2], 2, 2);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setAlignment(Pos.CENTER);

		// Label for showing results
		resultsLabel = new Label("Click New Game to play.");

		// Button to run the game
		Button newGameButton = new Button("New Game");
		newGameButton.setOnAction(new NewGameHandler());
		
		// Put everything in a VBox
		VBox vBox = new VBox(20, grid, resultsLabel, newGameButton);
		vBox.setAlignment(Pos.CENTER);
		vBox.setPadding(new Insets(20));
		
		// Add box to scene and set the stage
		Scene scene = new Scene(vBox);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Tic Tac Toe");
		primaryStage.show();
	}

	// Event handler class for New Game button
	class NewGameHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			// check if reset is needed
			if (turn != 1)
			{
				turn = 1;
				gameResult = -1;
				
				// clear the game peices
				for (int row = 0; row < ROWS; row++)
				{
   					for (int col = 0; col < COLS; col++)
   					{
      					imageBoard[row][col].setImage(blank);
   					}
				}
			}

			Random rand = new Random();
			
			// game array initialization, set every element to three which 
			// will be used to indicate blank, unused element
			
			gameBoard = new int[ROWS][COLS];
		
			for (int row = 0; row < ROWS; row++)
			{
				for (int col = 0; col < COLS; col++)
				{
					gameBoard[row][col] = 3;
				}
			}

			// play the game
			while (gameResult == -1)
			{
				if (turn % 2 != 0)  // X goes first, on odd turns 
				{	
					int xMoveRow, xMoveCol;
					
					// generate random position until you find a blank element
					do
					{
						xMoveRow = rand.nextInt(3);
						xMoveCol = rand.nextInt(3);
					} while (gameBoard[xMoveRow][xMoveCol] != 3); // only elements equal to 3(blank) can be played on
				
					gameBoard[xMoveRow][xMoveCol] = 1; // set element to represent X
					imageBoard[xMoveRow][xMoveCol].setImage(x);
				}
				else 				// O goes second, on even turns
				{	
					int oMoveRow, oMoveCol;
		
					// generate random position until you find a blank element
					do
					{	
						oMoveRow = rand.nextInt(3);
						oMoveCol = rand.nextInt(3);
					} while (gameBoard[oMoveRow][oMoveCol] != 3); // only elements equal to 3(blank) can be played on
				
					gameBoard[oMoveRow][oMoveCol] = 0; // set element to represent O
					imageBoard[oMoveRow][oMoveCol].setImage(o);
				}
			
				// check for a winner -
				//
				// eight ways to win
				//	
				// does O win? - O's array elements are equal to 0
				// vertical check
				if (gameBoard[0][0] == 0 && gameBoard[1][0] == 0 && gameBoard[2][0] == 0)
					gameResult = 0;
				if (gameBoard[0][1] == 0 && gameBoard[1][1] == 0 && gameBoard[2][1] == 0)
					gameResult = 0;
				if (gameBoard[0][2] == 0 && gameBoard[1][2] == 0 && gameBoard[2][2] == 0)
					gameResult = 0;
				// horizontal check
				if (gameBoard[0][0] == 0 && gameBoard[0][1] == 0 && gameBoard[0][2] == 0)
					gameResult = 0;
				if (gameBoard[1][0] == 0 && gameBoard[1][1] == 0 && gameBoard[1][2] == 0)
					gameResult = 0;
				if (gameBoard[2][0] == 0 && gameBoard[2][1] == 0 && gameBoard[2][2] == 0)
					gameResult = 0;
				// diagonal check
				if (gameBoard[0][0] == 0 && gameBoard[1][1] == 0 && gameBoard[2][2] == 0)
					gameResult = 0;
				if (gameBoard[2][0] == 0 && gameBoard[1][1] == 0 && gameBoard[0][2] == 0)
					gameResult = 0;
				// does X win? - X's array elements are equal to 1
				//	vertical check
				if (gameBoard[0][0] == 1 && gameBoard[1][0] == 1 && gameBoard[2][0] == 1)
					gameResult = 1;
				if (gameBoard[0][1] == 1 && gameBoard[1][1] == 1 && gameBoard[2][1] == 1)
					gameResult = 1;
				if (gameBoard[0][2] == 1 && gameBoard[1][2] == 1 && gameBoard[2][2] == 1)
					gameResult = 1;
				// horizontal check
				if (gameBoard[0][0] == 1 && gameBoard[0][1] == 1 && gameBoard[0][2] == 1)
					gameResult = 1;
				if (gameBoard[1][0] == 1 && gameBoard[1][1] == 1 && gameBoard[1][2] == 1)
					gameResult = 1;
				if (gameBoard[2][0] == 1 && gameBoard[2][1] == 1 && gameBoard[2][2] == 1)
					gameResult = 1;
				// diagonal check
				if (gameBoard[0][0] == 1 && gameBoard[1][1] == 1 && gameBoard[2][2] == 1)
					gameResult = 1;
				if (gameBoard[2][0] == 1 && gameBoard[1][1] == 1 && gameBoard[0][2] == 1)
					gameResult = 1;
				// is it a tie?
				if (turn == 9 && gameResult == -1)
					gameResult = 2;
			
				turn++;
			}

			if (gameResult == 0)
				resultsLabel.setText("O Wins!");
			if (gameResult == 1)	
				resultsLabel.setText("X Wins!");
			if (gameResult == 2)	
				resultsLabel.setText("Game is Tied!");
		}
	}
}
