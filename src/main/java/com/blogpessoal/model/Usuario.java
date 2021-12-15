package com.blogpessoal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "O atributo Nome é Obrigatório!")
    private String nome;

    @NotNull(message = "O atributo Usuário é Obrigatório!")
    @Email(message = "O atributo Usuário deve ser um email válido!")
    private String usuario;

    /**
     * A anotação @Size está definida apenas com o valor min
     * porque ao criptografar a senha a mesma terá uma tamanho
     * muito maior (em numero de caracteres) do que a senha
     * não ciptografada.
     *
     * Exemplo: admin123 -> 8 caracteres
     * admin123 criptografado -> 60 caracteres
     *
     * A anotação @NotBlank indica que o atributo não deve ser
     * nulo e/ou conter espaços em branco.
     */
    @NotBlank(message = "O atributo Senha é Obrigatório!")
    @Size(min = 8, message = "A Senha deve ter no mínimo 8 caracteres")
    private String senha;

    private String foto;

    /**
     * CascadeType.REMOVE -> Ele propaga a operação de remoção de um objeto Pai para um
     * objeto Filho.
     * Apenas quando remover a Entidade Usuario, também será removida todas as entidades
     * Postagens associadas. Nas demais operações não haverá a propagação.
     *
     * CascadeType.ALL -> Ele propaga todas a operações (Inserir, Listar, Atualizar e Apagar)
     * de um objeto Pai para um objeto Filho.
     */
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("usuario")
    private List<Postagem> postagem;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Postagem> getPostagem() {
        return postagem;
    }

    public void setPostagem(List<Postagem> postagem) {
        this.postagem = postagem;
    }

}
