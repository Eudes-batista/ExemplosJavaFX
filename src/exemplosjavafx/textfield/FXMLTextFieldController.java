package exemplosjavafx.textfield;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class FXMLTextFieldController implements Initializable {

    @FXML
    private TextField textfieldNumero;

    @FXML
    private TextField textfieldLetra;

    @FXML
    private TextField textfieldApenasNumeroLimitado;
    
    @FXML
    private TextField textfieldLetraMaiusculas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        textfieldNumero.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            this.textfieldNumero.setText(newValue.replaceAll("\\D", ""));
        });

        textfieldLetra.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            this.textfieldLetra.setText(newValue.replaceAll("\\d", ""));
        });

        textfieldApenasNumeroLimitado.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (newValue.length() <= 10) {
                this.textfieldApenasNumeroLimitado.setText(newValue.replaceAll("\\D", ""));
            } else {
                this.textfieldApenasNumeroLimitado.setText(oldValue);
            }
        });
        
        textfieldLetraMaiusculas.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            this.textfieldLetraMaiusculas.setText(newValue.toUpperCase());
        });

    }

}
