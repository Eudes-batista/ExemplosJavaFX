package exemplosjavafx.combobox;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;

public class FXMLComboBoxController implements Initializable {

    @FXML
    private ComboBox<String> comboBoxPadrao;

    @FXML
    private ComboBox<CursoCombo> comboBoxConverter;

    private ObservableList<String> cursos;
    private ObservableList<CursoCombo> cursosConverter;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cursos = FXCollections.observableArrayList();
        this.cursosConverter = FXCollections.observableArrayList();

        this.preencherCursos();
        this.preencherCursoConverter();

        this.comboBoxPadrao.setItems(this.cursos);
        this.comboBoxConverter.setItems(this.cursosConverter);

        this.comboBoxPadrao.setOnAction(evt -> this.verCursoSelecionadoPadrao());
        this.comboBoxConverter.setOnAction(evt -> this.verCursoSelecionadoConverter());
    }

    private void preencherCursos() {
        this.cursos.add("Java");
        this.cursos.add("Java Script");
        this.cursos.add("JavaFX");
        this.cursos.add("Java Server Pages");
        this.cursos.add("Java Server Faces");
        this.cursos.add("JavaEE");
        this.cursos.add("Spring Framework");
        this.cursos.add("Spring MVC");
    }

    private void preencherCursoConverter() {
        this.cursosConverter.add(new CursoCombo(1, "Java"));
        this.cursosConverter.add(new CursoCombo(2, "Java Script"));
        this.cursosConverter.add(new CursoCombo(3, "JavaFX"));
        this.cursosConverter.add(new CursoCombo(4, "Java Server Pages"));
        this.cursosConverter.add(new CursoCombo(5, "Java Server Faces"));
        this.cursosConverter.add(new CursoCombo(6, "JavaEE"));
        this.cursosConverter.add(new CursoCombo(7, "Spring Framework"));
        this.cursosConverter.add(new CursoCombo(8, "Spring MVC"));
    }

    private void verCursoSelecionadoPadrao() {
        String cursoSelecionado = this.comboBoxPadrao.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ComboBox");
        alert.setContentText(cursoSelecionado);
        alert.show();
    }

    private void verCursoSelecionadoConverter() {
        CursoCombo cursoSelecionado = this.comboBoxConverter.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ComboBox");
        alert.setContentText("Id: " + cursoSelecionado.getId() + " Curso: " + cursoSelecionado.getCurso());
        alert.show();
    }

}
