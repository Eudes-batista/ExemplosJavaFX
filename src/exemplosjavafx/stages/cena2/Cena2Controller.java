package exemplosjavafx.stages.cena2;

import exemplosjavafx.stages.model.Pessoa;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class Cena2Controller implements Initializable {

    @FXML
    private Label labelId;

    @FXML
    private Label labelNome;

    @FXML
    private Label labelIdade;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setPessoa(Pessoa pessoa) {
        this.labelId.setText(String.valueOf(pessoa.getId()));
        this.labelNome.setText(pessoa.getNome());
        this.labelIdade.setText(String.valueOf(pessoa.getIdade()));
    }

}
