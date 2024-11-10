package dio.web_api.repository;

import dio.web_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT E FROM USER WHERE E.USERNAME = :username")
    public User findByUsername(@Param("username") String username);
}
