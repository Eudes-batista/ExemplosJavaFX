package exemplosjavafx.stages.cena1;

import exemplosjavafx.stages.cena2.Cena2Controller;
import exemplosjavafx.stages.model.Pessoa;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Cena1Controller implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TableView<Pessoa> tabela;

    @FXML
    private TableColumn<Pessoa, String> columnNome;

    @FXML
    private TableColumn<Pessoa, Integer> columnIdade;

    @FXML
    private Button buttonVerPessoa;

    private ObservableList<Pessoa> pessoas;

    private BoxBlur boxBlur;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.boxBlur = new BoxBlur(10, 10, 10);
        this.pessoas = FXCollections.observableArrayList();
        this.iniciarColunas();
        this.pessoas.addAll(new Pessoa().listarPessoas());
        this.tabela.setItems(this.pessoas);

        buttonVerPessoa.setOnAction((event) -> {
            abrirCena2();
        });
    }

    private void abrirCena2() {
        try {
            this.anchorPane.setEffect(this.boxBlur);
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("../cena2/Cena2.fxml"));
            Parent root = fXMLLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            Cena2Controller controller = fXMLLoader.getController();
            controller.setPessoa(this.tabela.getSelectionModel().getSelectedItem());
            stage.showAndWait();
            this.anchorPane.setEffect(null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void iniciarColunas() {
        this.columnNome.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNome()));
        this.columnIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));
    }

}
