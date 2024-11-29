package uz.bunyodbek.kunuz11a23.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import uz.bunyodbek.kunuz11a23.model.Article;
import uz.bunyodbek.kunuz11a23.model.Profile;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleLikeDto {

    private Long profileId;
    private Integer articleId;
    private Date createdDate;
    private String status;
}
