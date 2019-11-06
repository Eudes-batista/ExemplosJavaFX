package exemplosjavafx.tableview.checkbox;

import exemplosjavafx.tableview.model.CursoCheck;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLTableViewCheckBoxController implements Initializable {

    @FXML
    private TableView<CursoCheck> tabela;

    @FXML
    private TableColumn<CursoCheck, CheckBox> columnCheck;

    @FXML
    private CheckBox checkTodos;

    @FXML
    private TableColumn<CursoCheck, Integer> columnId;

    @FXML
    private TableColumn<CursoCheck, String> columnCurso;

    @FXML
    private Button buttonApagar;

    @FXML
    private Button buttonVerSelecionados;

    private final ObservableList<CursoCheck> cursos = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnCheck.setCellValueFactory(new PropertyValueFactory<>("checkBox"));
        columnId.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        columnCurso.setCellValueFactory(new PropertyValueFactory<>("curso"));
        listarCursos();
        tabela.setItems(cursos);
        
        checkTodos.setOnAction(evt -> marcarEdesmarcaTodos());
        buttonVerSelecionados.setOnAction(evt -> verSelecionados());
        buttonApagar.setOnAction(evt -> apagarSelecionados());
    }

    private void listarCursos() {
        cursos.clear();
        cursos.add(new CursoCheck(1, "Java"));
        cursos.add(new CursoCheck(2, "Java Script"));
        cursos.add(new CursoCheck(3, "Type Script"));
        cursos.add(new CursoCheck(4, "JavaFX"));
        cursos.add(new CursoCheck(5, "AngularJs"));
        cursos.add(new CursoCheck(6, "Angular"));
        cursos.add(new CursoCheck(7, "Spring boot"));
        cursos.add(new CursoCheck(8, "Php"));
        cursos.add(new CursoCheck(9, "Python"));
        cursos.add(new CursoCheck(10, "C#"));
    }
    
    private void apagarSelecionados() {
        List<CursoCheck> cursosSelecionados = this.cursos.stream().filter(CursoCheck::isSelecionado).collect(Collectors.toList());
        cursos.removeAll(cursosSelecionados);
    }
    
    private void verSelecionados() {
        List<CursoCheck> cursoSelecionados = this.cursos.stream().filter(CursoCheck::isSelecionado).collect(Collectors.toList());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cursos");
        alert.setContentText(cursoSelecionados.toString());
        alert.show();
    }
    
    private void marcarEdesmarcaTodos() {
        if(this.checkTodos.isSelected())
            this.cursos.forEach(curso -> curso.getCheckBox().setSelected(true));
        else
            this.cursos.forEach(curso -> curso.getCheckBox().setSelected(false));
    }
    

}
