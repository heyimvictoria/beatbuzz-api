package org.launchcode.data;
import java.util.List;
import org.launchcode.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//allows access to data stored into the database
@Repository
//JpaRepository Spring Data provides methods for CRUD
public interface UserRepository extends JpaRepository<User, Integer> {
    //query method for finding user by there username
    User findByUsername(String username);
}