package exemplosjavafx.stages.model;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    private int id;
    private String nome;
    private int idade;

    public Pessoa() {
    }

    public Pessoa(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public Pessoa(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
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
        final Pessoa other = (Pessoa) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", idade=" + idade + '}';
    }
    
    public List<Pessoa> listarPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa(1,"João",35));
        pessoas.add(new Pessoa(2,"Maria",26));
        return pessoas;
    }
    
    
    
}
