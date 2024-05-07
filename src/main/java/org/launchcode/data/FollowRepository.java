package org.launchcode.data;

import org.launchcode.models.Follow;
import org.launchcode.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    Optional<Follow> findByFollowerId(Long followerId);
    // Other query methods as needed

    Optional<Follow>findByFollowerAndFollowed(User follower, User followed);
}