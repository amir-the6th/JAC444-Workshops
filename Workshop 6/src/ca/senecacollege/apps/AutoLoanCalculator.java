package ca.senecacollege.apps;

import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AutoLoanCalculator extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage ps) throws Exception {

		ps.setTitle("Auto Loan Calculator");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome To Car Loan Calculator");
        scenetitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label carPriceLabel = new Label("Car Price:");
        grid.add(carPriceLabel, 0, 1);

        TextField carPrice = new TextField();
        grid.add(carPrice, 1, 1);

        Label downPaymentLabel = new Label("Down-Payment Amount:");
        grid.add(downPaymentLabel, 0, 2);

        TextField downPayment = new TextField();
        grid.add(downPayment, 1, 2);
        
        Label annualInterestRateLabel = new Label("Annual Interest Rate:");
        grid.add(annualInterestRateLabel, 0, 3);

        TextField annualInterestRate = new TextField();
        grid.add(annualInterestRate, 1, 3);
        
        Label loanDurationLabel = new Label("Loan Duration:");
        grid.add(loanDurationLabel, 0, 4);
        
        
        ChoiceBox<String> loanDuration = new ChoiceBox<>();
        loanDuration.getItems().addAll("24 months", "36 months", "48 months", "60 months");
        grid.add(loanDuration, 1, 4);
        

        Button btn = new Button("Submit");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 5);

        final Text monthlyPaymentResult = new Text();
        final Text header = new Text();
        grid.add(header, 0, 7);
        grid.add(monthlyPaymentResult, 0, 8);

        CalculateMonthlyPayment cmp = new CalculateMonthlyPayment();
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
            	header.setFont(Font.font("Edwardian Script ITC", 50));
            	header.setFill(Color.LIGHTGRAY);
            	header.setText("Results");
            	
            	monthlyPaymentResult.setFill(Color.BLUE);
            	monthlyPaymentResult.setFont(Font.font("Helvetica", FontWeight.BOLD, 13));
            	monthlyPaymentResult.setText(cmp.calculate(carPrice, downPayment, annualInterestRate, loanDuration));
            }
        });

        

        Scene scene = new Scene(grid, 600, 400);
        ps.setScene(scene);
        ps.show();
	}
	
	private class CalculateMonthlyPayment implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent arg0) {
		}
		
		private String calculate(TextField cp, TextField dp, TextField air, ChoiceBox<String> ld) {
			try {
			/*  Auto loan calculation formula:
			 *
			 *	A=P*(r(1+r)^n)/((1+r)^n-1)
			 *
			 *	A = the monthly payment
			 *	P = the principal
			 *	r = the interest rate per month, which equals the annual interest rate divided by 12
			 *	n = the total number of months 
			 */
			
			int carPrice = Integer.parseInt(cp.getText());
			int downPayment = Integer.parseInt(dp.getText());
			double annualRate = Double.parseDouble(air.getText());
			int loanDurationIndex = ld.getSelectionModel().getSelectedIndex();

			double monthlyRate = (annualRate/100) / 12; //first, remove the percentage (divide by 100), then divide by 12 to get monthly rate
			int loanDuration = -1;
			switch(loanDurationIndex) {
			case 0:
				loanDuration = 24;
				break;
			case 1:
				loanDuration = 36;
				break;
			case 2:
				loanDuration = 48;
				break;
			case 3:
				loanDuration = 60;
				break;
			default:
				break;
			}
			
			double partOfFormula = Math.pow(1 + monthlyRate, loanDuration);
			double monthlyPayment = (carPrice - downPayment) * ((monthlyRate * partOfFormula) / (partOfFormula - 1));
			
			final DecimalFormat df = new DecimalFormat("0.00");

			String res = "Monthly payment is $" + df.format(monthlyPayment);
			return res;
			}
			catch(Exception e) {
				return "Please fill all the fields of the form!";
			}
		}
	}
}
