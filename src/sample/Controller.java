package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;



public class Controller {
    @FXML
    private TextField textField;
    @FXML
    private ToggleGroup group;
    @FXML
    private Label outputLabel;
    @FXML
    private Label error;
    private  String  degreesType;
    private double degrees;
    private double result;
    private String formatStr;
    @FXML
    private Label mode;

    @FXML
    public void initialize(){
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){

            public void changed(ObservableValue<? extends Toggle> changed, Toggle oldValue, Toggle newValue){

                // получаем выбранный элемент RadioButton
                RadioButton selectedBtn = (RadioButton) newValue;
                if (selectedBtn.getText().equals("C")) mode.setText("Конвертація з С у F");
                else mode.setText("Конвертація з F у C");
            }
        });
    }
    @FXML
    private void Calc(){
         degreesType = ((RadioButton) group.getSelectedToggle()).getText();
         try {
             degrees = Double.parseDouble(textField.getText());
             if(degreesType.equals("C")){
                 result = 9.0/5.0*degrees + 32.0;

             }
             else{
                 result =5.0/9.0*(degrees - 32.0);
             }
             formatStr = String.format("Result: %.2f",result);
             outputLabel.setText(formatStr);
             error.setText("");
         }
         catch(Exception e ){
             error.setText("Помилка введення");
             outputLabel.setText("");
        }

    }
}
