package uz.bunyodbek.kunuz11a23.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.bunyodbek.kunuz11a23.model.Comment;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
