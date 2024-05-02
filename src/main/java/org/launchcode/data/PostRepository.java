package org.launchcode.data;

import org.launchcode.models.Post;
import org.launchcode.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
//allows access to data stored into the database
@Repository
//JpaRepository Spring Data provides methods for CRUD
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUser_Id(Long userId);
    //query method for finding post by the user id
    @Modifying //will modify data in the database
    // JPQL query to increment the number of likes for a post with a specific ID
    @Query("UPDATE Post p SET p.likes = p.likes + 1 WHERE p.id = :postId")
    int incrementLikes(@Param("postId") Integer postId);

}
