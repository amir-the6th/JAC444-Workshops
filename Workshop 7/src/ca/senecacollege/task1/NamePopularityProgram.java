package ca.senecacollege.task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage; 

public class NamePopularityProgram extends Application {
	int year, rank;
	String gender, name, finalMessage;
	File file;


	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage ps) throws Exception {
		ps.setTitle("Baby Name Ranking Application");
		
		GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text sceneTitle = new Text("Welcome To Baby Name Ranking Application");
        sceneTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);

        Label yearLabel = new Label("Enter the Year:");
        grid.add(yearLabel, 0, 1);
        
        final TextField yearField = new TextField();
        yearField.setPrefColumnCount(5);
        yearField.getText();
        GridPane.setConstraints(yearField, 1, 1);
        grid.getChildren().add(yearField);
        
        Label genderLabel = new Label("Enter the Gender:");
        grid.add(genderLabel, 0, 2);
        
        ChoiceBox<String> genderField = new ChoiceBox<>();
        genderField.getItems().addAll("Male", "Female");
        GridPane.setConstraints(genderField, 1, 2);
        grid.getChildren().add(genderField);
        
        Label nameLabel = new Label("Enter the Name:");
        grid.add(nameLabel, 0, 3);
        
        final TextField nameField = new TextField();
        nameField.setPrefColumnCount(5);
        nameField.getText();
        GridPane.setConstraints(nameField, 1, 3);
        grid.getChildren().add(nameField);
        
        
        HBox hbox = new HBox(10);
		hbox.setAlignment(Pos.CENTER);
		//Submit Query Button
        Button submitBtn = new Button("Submit Query");
        GridPane.setConstraints(submitBtn, 0, 4);
        grid.getChildren().add(submitBtn);
        //Exit Button
		Button exitBtn =  new Button("Exit");
		GridPane.setConstraints(exitBtn, 1, 4);
        grid.getChildren().add(exitBtn);
		
        hbox.getChildren().addAll(submitBtn, exitBtn);
        
        VBox vb = new VBox();
        vb.getChildren().addAll(grid, hbox);

        //Layout 2 - after the form submission
        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(25, 25, 25, 25));
        
        final Text rankingResult = new Text();
		Label againLabel = new Label("Do You Want To Search For Another Name?");
		grid2.add(rankingResult, 0, 1);
		grid2.add(againLabel, 0, 2);
		
		Button yesBtn = new Button("Yes");
		Button noBtn = new Button("No");
		HBox hbox1 = new HBox(10);
		hbox1.getChildren().addAll(yesBtn, noBtn);
		hbox1.setAlignment(Pos.CENTER);
		VBox vb2 = new VBox();
		vb2.getChildren().addAll(grid2, hbox1);
		Scene scene2 = new Scene(vb2, 400, 150);
		
		//Run the program and display the first layout
        Scene scene = new Scene(vb, 500, 250);
        ps.setScene(scene);
        ps.show();
        
        //Submit Button Event Handler
  		submitBtn.setOnAction(e -> {
  			setData(yearField, genderField, nameField);
  			calculateRanking(year, name);
  			setFinalMessage();
  			ps.setScene(scene2); //display the second layout
  			rankingResult.setText(finalMessage);
  		});
  		//Exit Button Event Handler
  		exitBtn.setOnAction(e->{
  			ps.close();
  		});
  		//Yes Button Event Handler
  		yesBtn.setOnAction( e -> {
  			yearField.clear();
  			nameField.clear();
  	        yearField.setText(null);
  	        nameField.setText(null);
  			ps.setScene(scene);
  		});
  		//No Button Event Handler
  		noBtn.setOnAction( e -> {
  			ps.close();
  		});
	}
	
	private void setData(TextField y, ChoiceBox<String> g, TextField n) {
		this.year = Integer.parseInt(y.getText());
		int genderIndex = g.getSelectionModel().getSelectedIndex();
		this.name = n.getText();
		
		switch(genderIndex) {
		case 0:
			this.gender = "male";
			break;
		case 1:
			this.gender = "female";
			break;
		default:
			break;
		}
		
		file = new File("babynamesranking" + y.getText() + ".txt");
	}

	private void calculateRanking(int y, String n) {		
		try {
			Scanner read = new Scanner(file);
			String line;
			while(read.hasNext()) {
				line = read.nextLine();
				String[] temp = line.split(" ");
				if(gender == "male" && isContain(temp[1],n)) { //instead of temp[1].contains(n), I declared a method to exactly match the name
					rank = Integer.parseInt(temp[0]);
				}
				else if(isContain(temp[2],n)) {
					rank = Integer.parseInt(temp[0]);
				}
			}
			read.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void setFinalMessage() {
		if(rank == 0) {
			if (this.gender == "male") finalMessage = "Boy Name " + name + " is not ranked in year " + year;
			else finalMessage = "Girl Name " + name + " is not ranked in year " + year;
		} else {
			if (this.gender == "male") finalMessage = "Boy Name " + name + " is ranked #" + rank + " in year " + year;
			else finalMessage = "Girl Name " + name + " is ranked #" + rank + " in year " + year;
		}
	}
	
	private static boolean isContain(String source, String subItem){
        String pattern = "\\b"+subItem+"\\b";
        Pattern p=Pattern.compile(pattern);
        Matcher m=p.matcher(source);
        return m.find();
   } //method source: https://stackoverflow.com/questions/25417363/java-string-contains-matches-exact-word
}
