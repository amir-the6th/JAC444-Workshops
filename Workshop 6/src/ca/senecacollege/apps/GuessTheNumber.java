package ca.senecacollege.apps;

import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GuessTheNumber extends Application {
	
	private Label guessResult;
	private TextField guessNumber;
	private int randomNumber;
	private int userGuess;
    private int latestGuess = 0;
    private int cnt = 0;

	public GuessTheNumber() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage ps) throws Exception {
		ps.setTitle("Guess The Number Game");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text sceneTitle = new Text("Welcome To Guess The Number Game");
        sceneTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);

        randomNumber = new Random().nextInt(1000) + 1; //generate a random number between 1 - 1000
        
        Text sceneSubTitle = new Text("I have a number between 1 and 1000. Can you guess my number?");
        sceneSubTitle.setFont(Font.font("Helvetica", FontWeight.SEMI_BOLD, 13));
        grid.add(sceneSubTitle, 0, 0, 5, 4);

        
        Label guessNumberLabel = new Label("Enter your guess");
        grid.add(guessNumberLabel, 0, 3);

        guessNumber = new TextField();
        grid.add(guessNumber, 1, 3);
        
        //Check Guessed Number Button
        Button checkBtn = new Button("Check");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(checkBtn);
        grid.add(hbBtn, 0, 0, 2, 9);
        //Check Guessed Number Button Event Handler
        checkGuessHandler cgHandler = new checkGuessHandler();
        checkBtn.setOnAction(cgHandler);
        
        //New Game Button
        Button newGameBtn = new Button("New Game");
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn1.getChildren().add(newGameBtn);
        grid.add(hbBtn1, 0, 0, 2, 13);
        //New Game Button Event Handler
        newGameHandler ngHandler = new newGameHandler();
        newGameBtn.setOnAction(ngHandler);
        
        //Exit Game Button
        Button exitGameBtn = new Button("Exit Game");
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn2.getChildren().add(exitGameBtn);
        grid.add(hbBtn2, 0, 0, 2, 17);
        //Exit Game Button Event Handler
        exitGameHandler egHandler = new exitGameHandler();
        exitGameBtn.setOnAction(egHandler);
        
        guessResult = new Label("");
        grid.add(guessResult, 0, 0, 5, 16);
        
        Scene scene = new Scene(grid, 600, 400);
        ps.setScene(scene);
        ps.show();
	}
	private class checkGuessHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent arg0) {
			userGuess = Integer.parseInt(guessNumber.getText());
			compareNums(userGuess, randomNumber);
		}
		
		private void compareNums(int ug, int rn) {
			cnt++;
			if (userGuess == randomNumber) {
				guessResult.setTextFill(Color.GREEN);
				guessResult.setText("CORRECT. Total " + cnt + (cnt==1 ? " guess" : " guesses"));
            }
			else if (userGuess > randomNumber) {
				guessResult.setText("TOO HIGH. Guess again!");
            }
			else if (userGuess < randomNumber) {
				guessResult.setText("TOO LOW. Guess again!");
            }
			
			if (cnt > 1) {
	            if ((randomNumber - userGuess) > (randomNumber - latestGuess)) {
	                    guessResult.setTextFill(Color.RED);
	                }
	            else if ((randomNumber - userGuess) < (randomNumber - latestGuess)) {
	            		guessResult.setTextFill(Color.BLUE);
	                }
	            else {
	            		guessResult.setTextFill(Color.GRAY);
	                }
	        }
			latestGuess = userGuess;
		}
	}
	private class newGameHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent arg0) {
			guessResult.setText("");
			randomNumber = new Random().nextInt(1000) + 1;
		}
	}
	private class exitGameHandler implements EventHandler<ActionEvent>{
		
		@Override
		public void handle(ActionEvent arg0) {
			System.exit(0);
		}
	}
}
