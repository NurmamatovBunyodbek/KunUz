package uz.bunyodbek.kunuz11a23.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.bunyodbek.kunuz11a23.model.Article;
import uz.bunyodbek.kunuz11a23.model.Profile;

import java.util.Optional;
import java.util.UUID;

public interface ArticleRepo extends JpaRepository<Article, UUID> {
    Optional<Article> findById(Integer articleId);

}
