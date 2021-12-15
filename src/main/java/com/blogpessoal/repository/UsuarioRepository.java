package com.blogpessoal.repository;

import com.blogpessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Método que busca um usuário pelo seu usuario (email).
     *
     * select * from tb_usuarios where usuario = "usuario procurado"
     */
    public Optional<Usuario> findByUsuario(String usuario);

}
