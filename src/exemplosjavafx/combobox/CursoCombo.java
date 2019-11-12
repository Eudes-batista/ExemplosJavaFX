
package exemplosjavafx.combobox;

import java.util.Objects;


public class CursoCombo {
    
    private Integer id;
    private String curso;

    public CursoCombo(Integer id, String curso) {
        this.id = id;
        this.curso = curso;
    }

    public CursoCombo() {
    }

    public CursoCombo(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final CursoCombo other = (CursoCombo) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return this.curso;
    }
    
}
