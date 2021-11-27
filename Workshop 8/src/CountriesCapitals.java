import java.util.Map;
import java.util.HashMap;
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

public class CountriesCapitals extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage ps) throws Exception {
		ps.setTitle("Countries & Capitals");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text sceneTitle = new Text("Welcome To Countries & Capitals Application");
        sceneTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);
        
        Label countryLabel = new Label("Enter A Country");
        grid.add(countryLabel, 0, 1);
        
        final TextField country = new TextField();
        country.setPrefColumnCount(7);
        country.getText();
        GridPane.setConstraints(country, 1, 1);
        grid.getChildren().add(country);
        
        //Check Guessed Number Button
        Button checkBtn = new Button("Check");
        GridPane.setConstraints(checkBtn, 0, 3);
        grid.getChildren().add(checkBtn); 
        
        Label capital = new Label("");
        capital.setFont(Font.font("Helvetica", FontWeight.BOLD, 15));
        capital.setTextFill(Color.BLUE);
        grid.add(capital, 0, 0, 5, 24);
        
        //Check-capital-for-a-country Button Event Handler
        checkBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String countryText = country.getText();
				Map<String, String> countriesCapitals = setData();
				if (countriesCapitals.get(countryText) != null) {
					capital.setText("The capital of " + countryText + " is " 
						+ countriesCapitals.get(countryText) + "\n");
				}
			}   	
        });
        
        Scene scene = new Scene(grid, 600, 400);
        ps.setScene(scene);
        ps.show();
	}
	
	public static Map<String, String> setData() {
		Map<String, String> map = new HashMap<>();
		String[][] countriesData = {
				{"Iran", "Tehran"},
				{"Canada", "Ottawa"},
				{"Chile", "	Santiago"},
				{"China", "Beijing"},
				{"Philippines", "Manila"},
				{"Qatar", "Doha"},
				{"Spain", "Madrid"},
				{"Russia", "Moscow"},
				{"Norway", "Oslo"},
				{"Netherlands", "Amsterdam"},
				{"Mexico", "Mexico City"},
				{"Madagascar", "Antananarivo"},
				{"Pakistan", "Islamabad"},
				{"Denmark", "Copenhagen"},
				{"Egypt", "Cairo"},
				{"France", "Paris"},
				{"United Kingdom", "London"},
				{"United States of America", "Washington, D.C."},
				{"Jamaica", "Kingston"},
				{"Malaysia", "Kuala Lumpur"},
				{"India", "New Delhi"},
				{"Germany", "Berlin"},
				{"South Korea", "Seoul"},
				{"Italy", "Rome"},
				{"Japan", "Tokyo"},
		};
		for (int i=0; i < countriesData.length; i++) map.put(countriesData[i][0], countriesData[i][1]);
		return map;
	}
}
