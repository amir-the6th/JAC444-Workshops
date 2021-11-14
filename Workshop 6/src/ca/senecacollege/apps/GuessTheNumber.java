/**********************************************
Workshop #6
Course:JAC444 - Fall 2021
Name: Amirhossein Sabagh
ID:152956199
Section:NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Date:2021-11-13
**********************************************/
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
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GuessTheNumber extends Application {
	
	private Label guessResult;
	private int randomNumber;
	private int userGuess;
    private int latestGuess = 0;
    private int cnt = 1;

	public GuessTheNumber() {}

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

        final TextField guessNumber = new TextField();
        guessNumber.setPromptText("Enter your guess");
        guessNumber.setPrefColumnCount(10);
        guessNumber.getText();
        GridPane.setConstraints(guessNumber, 0, 3);
        grid.getChildren().add(guessNumber);
        
        //Check Guessed Number Button
        Button checkBtn = new Button("Check");
        GridPane.setConstraints(checkBtn, 1, 3);
        grid.getChildren().add(checkBtn);        
        //New Game Button
        Button newGameBtn = new Button("New Game");
        GridPane.setConstraints(newGameBtn, 1, 4);
        grid.getChildren().add(newGameBtn);        
        //Exit Game Button
        Button exitGameBtn = new Button("Exit Game");
        GridPane.setConstraints(exitGameBtn, 1, 5);
        grid.getChildren().add(exitGameBtn);
        
        guessResult = new Label("");
        grid.add(guessResult, 0, 0, 5, 24);
        
        
        //Check Guessed Number Button Event Handler
        checkBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				userGuess = Integer.parseInt(guessNumber.getText());
				if(userGuess < 1 || userGuess > 1000) guessResult.setText("Please enter a number between the range of 1 - 1000");
				else if(compareNums()) guessNumber.setEditable(false);
				else {
					cnt++;
					if(cnt == 2) guessResult.setTextFill(Color.GRAY);
					else setColor();
					latestGuess = userGuess;
				}	
			}   	
        });
        //New Game Button Event Handler
        newGameBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				guessResult.setText("");
				guessNumber.clear();
				guessNumber.setEditable(true);
				randomNumber = new Random().nextInt(1000) + 1;
				cnt = 1;
			}     	
        });
        //Exit Game Button Event Handler
        exitGameBtn.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
    		public void handle(ActionEvent arg0) {
    			System.exit(0);
    		}
        });
        
        Scene scene = new Scene(grid, 600, 400);
        ps.setScene(scene);
        ps.show();
	}
	
	private boolean compareNums() {
		boolean correctGuess = false;
		if (userGuess == randomNumber) {
			guessResult.setTextFill(Color.GREEN);
			guessResult.setText("CORRECT. Total " + cnt + (cnt==1 ? " guess" : " guesses"));
			correctGuess = true;
        }
		else if (userGuess > randomNumber) {
			guessResult.setText("TOO HIGH. Guess again!");
        }
		else if (userGuess < randomNumber) {
			guessResult.setText("TOO LOW. Guess again!");
        }		
		return correctGuess;
	}
	
	private void setColor() {
		if(cnt == 2) guessResult.setTextFill(Color.GRAY);
		else {
			if (userGuess > randomNumber) {
				if ((userGuess - randomNumber) < (latestGuess - randomNumber)) {
	                guessResult.setTextFill(Color.RED);
	            }
				else {
	        		guessResult.setTextFill(Color.BLUE);
	            }
			}
			else {
				if ((randomNumber - userGuess) < (randomNumber - latestGuess)) {
	                guessResult.setTextFill(Color.RED);
				}
				else {
	        		guessResult.setTextFill(Color.BLUE);
				}
			}
		}
	}
}
