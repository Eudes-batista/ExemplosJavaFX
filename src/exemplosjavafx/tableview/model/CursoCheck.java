package exemplosjavafx.tableview.model;

import java.util.Objects;
import javafx.scene.control.CheckBox;

public class CursoCheck {
    
    private CheckBox checkBox;
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

    public CursoCheck(Integer codigo) {
        this.codigo = codigo;
    }

    public CursoCheck() {
    }

    public CursoCheck(Integer codigo, String curso) {
        this.codigo = codigo;
        this.curso = curso;
        this.checkBox = new CheckBox();
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
        final CursoCheck other = (CursoCheck) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    @Override
    public String toString() {
        return "CursoCheck{" + "selecionado=" + checkBox.isSelected() + ", codigo=" + codigo + ", curso=" + curso + '}';
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public boolean isSelecionado() {
        return this.checkBox.isSelected();
    }
    
    
}
