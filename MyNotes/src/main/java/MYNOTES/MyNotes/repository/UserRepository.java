package MYNOTES.MyNotes.repository;

import MYNOTES.MyNotes.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);

}
