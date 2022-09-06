
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author 20202pf.cc0003
 */
@Entity
@Table(name = "estado")
public class Estado implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_estado", sequenceName = "seq_estado_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_estado", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome deve ser informado!") // restrição para rejeitar campo em branco
    @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres!") // restrição para tamanho
    @Column(name = "nome", nullable = false, length = 40)
    private String nome;
    
    @NotBlank(message = "A uf deve ser informada!")
    @Length(max = 2, min = 2, message = "A uf deve ter {max} caracteres!") // max e min definem o tamanho exato
    @Column(name = "uf", nullable = false, length = 2)
    private String uf;
    
    // construtor sem argumentos
    public Estado() {
        
    }

    // getters e setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Estado other = (Estado) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
}
