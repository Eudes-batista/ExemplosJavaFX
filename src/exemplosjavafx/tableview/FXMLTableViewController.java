package exemplosjavafx.tableview;

import exemplosjavafx.tableview.model.Curso;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLTableViewController implements Initializable {

    @FXML
    private Button button;

    @FXML
    private TableView<Curso> tableView;

    @FXML
    private TableColumn<Curso, Integer> columnCodigo;

    @FXML
    private TableColumn<Curso, String> columnCurso;

    private final ObservableList<Curso> cursos = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        columnCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        columnCurso.setCellValueFactory(new PropertyValueFactory<>("curso"));

        tableView.setItems(cursos);
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        cursos.clear();
        cursos.add(new Curso(1, "Java"));
        cursos.add(new Curso(2, "Java Script"));
        cursos.add(new Curso(3, "Type Script"));
        cursos.add(new Curso(4, "JavaFX"));
        cursos.add(new Curso(5, "AngularJs"));
        cursos.add(new Curso(6, "Angular"));
        cursos.add(new Curso(7, "Spring boot"));
        cursos.add(new Curso(8, "Php"));
        cursos.add(new Curso(9, "Python"));
        cursos.add(new Curso(10, "C#"));
    }

}
