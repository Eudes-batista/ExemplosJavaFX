package exemplosjavafx.tableview.button;

import exemplosjavafx.tableview.model.CursoButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLTableViewButtonController implements Initializable {

    @FXML
    private TableView<CursoButton> tabela;

    @FXML
    private TableColumn<CursoButton, Button> columnButton;

    @FXML
    private TableColumn<CursoButton, Integer> columnId;

    @FXML
    private TableColumn<CursoButton, String> columnCurso;

    private final ObservableList<CursoButton> cursos = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnButton.setCellValueFactory(new PropertyValueFactory<>("button"));
        columnId.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        columnCurso.setCellValueFactory(new PropertyValueFactory<>("curso"));
        listarCursos();
        tabela.setItems(cursos);

    }

    private void listarCursos() {
        cursos.clear();
        cursos.add(new CursoButton(1, "Java",this.cursos));
        cursos.add(new CursoButton(2, "Java Script",this.cursos));
        cursos.add(new CursoButton(3, "Type Script",this.cursos));
        cursos.add(new CursoButton(4, "JavaFX",this.cursos));
        cursos.add(new CursoButton(5, "AngularJs",this.cursos));
        cursos.add(new CursoButton(6, "Angular",this.cursos));
        cursos.add(new CursoButton(7, "Spring boot",this.cursos));
        cursos.add(new CursoButton(8, "Php",this.cursos));
        cursos.add(new CursoButton(9, "Python",this.cursos));
        cursos.add(new CursoButton(10, "C#",this.cursos));
    }

}
