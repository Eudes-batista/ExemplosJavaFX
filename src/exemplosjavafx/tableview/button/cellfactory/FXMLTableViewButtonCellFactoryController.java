package exemplosjavafx.tableview.button.cellfactory;

import exemplosjavafx.tableview.model.CursoButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLTableViewButtonCellFactoryController implements Initializable {

    @FXML
    private TableView<CursoButton> tabela;

    @FXML
    private TableColumn<CursoButton, Integer> columnButton;

    @FXML
    private TableColumn<CursoButton, Integer> columnId;

    @FXML
    private TableColumn<CursoButton, String> columnCurso;

    private final ObservableList<CursoButton> cursos = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.iniciarColunas();
        this.listarCursos();
        this.tabela.setItems(this.cursos);

    }

    private void iniciarColunas() {
        this.columnButton.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        this.columnId.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        this.columnCurso.setCellValueFactory(new PropertyValueFactory<>("curso"));

        // passando um callback
//        columnButton.setCellFactory(new Callback<TableColumn<CursoButton, Integer>, TableCell<CursoButton, Integer>>() {
//            @Override
//            public TableCell<CursoButton, Integer> call(TableColumn<CursoButton, Integer> param) {
//                return new TableCell<CursoButton,Integer>(){
//                    @Override
//                    protected void updateItem(Integer item, boolean empty) {
//                        super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
//                    }
//                };
//            }
//        });
        // usando expressão lambda
        columnButton.setCellFactory((TableColumn<CursoButton, Integer> param) -> new TableCell<CursoButton, Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                if (!empty) {
                    Button button = new Button();
                    button.setText("Excluir");
                    button.setOnAction(evt -> {
                        cursos.remove(getIndex());
                    });
                    setGraphic(button);
                } else {
                    setGraphic(null);
                }
            }
        });

    }

    private void listarCursos() {
        this.cursos.clear();
        this.cursos.add(new CursoButton(1, "Java"));
        this.cursos.add(new CursoButton(2, "Java Script"));
        this.cursos.add(new CursoButton(3, "Type Script"));
        this.cursos.add(new CursoButton(4, "JavaFX"));
        this.cursos.add(new CursoButton(5, "AngularJs"));
        this.cursos.add(new CursoButton(6, "Angular"));
        this.cursos.add(new CursoButton(7, "Spring boot"));
        this.cursos.add(new CursoButton(8, "Php"));
        this.cursos.add(new CursoButton(9, "Python"));
        this.cursos.add(new CursoButton(10, "C#"));
    }

}
