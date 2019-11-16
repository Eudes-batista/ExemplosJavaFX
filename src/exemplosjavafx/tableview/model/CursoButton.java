package exemplosjavafx.tableview.model;

import java.util.Objects;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

public class CursoButton {

    private Button button;
    private Integer codigo;
    private String curso;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public CursoButton(Integer codigo) {
        this.codigo = codigo;
    }

    public CursoButton() {
    }

    public CursoButton(Integer codigo, String curso, ObservableList<CursoButton> cursos) {
        this.codigo = codigo;
        this.curso = curso;
        this.button = new Button("Excluir");
        this.button.setOnAction(evt -> {
            cursos.remove(this);
        });
    }

    public CursoButton(Integer codigo, String curso) {
        this.codigo = codigo;
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CursoButton other = (CursoButton) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "CursoButton{codigo=" + codigo + ", curso=" + curso + '}';
    }

}
