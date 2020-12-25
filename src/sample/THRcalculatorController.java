package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.math.BigDecimal;
import java.math.MathContext;
public class THRcalculatorController {
    @FXML
    private Label age;
    @FXML
    private TextField year;
    @FXML
    private TextField THRrange;
    @FXML
    private Button calculate;
    @FXML
    private Label THRrangelabel;
    @FXML
    void calcButPressed(ActionEvent event) {
        try{
            BigDecimal age = new BigDecimal(year.getText());
            if(age.compareTo(new BigDecimal(0))<=0){
                throw  new NumberFormatException();
            }
            BigDecimal maxheartrate = new BigDecimal(200).subtract(age);
            BigDecimal hrlower = maxheartrate.multiply(new BigDecimal(0.50)).round(new MathContext(4));
            BigDecimal hrupper = maxheartrate.multiply(new BigDecimal(0.85)).round(new MathContext(4));
            String ans = String.format("%s bpm - %s bpm",hrlower.toString(),hrupper.toString());
            THRrange.setText(ans);
        }
        catch (NumberFormatException ex){
            year.setText("Enter your Age");
            year.selectAll();
            year.requestFocus();
        }
    }
}