package dio.web_api_JWT.repository;

import dio.web_api_JWT.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query("SELECT E FROM USER E JOIN FETCH E.ROLES WHERE E.USERNAME = :username")
    public Usuario findByUsername(@Param("username") String username);

    boolean existsByUsername(String username);
}
