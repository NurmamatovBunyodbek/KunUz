package uz.bunyodbek.kunuz11a23.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.bunyodbek.kunuz11a23.model.Article;
import uz.bunyodbek.kunuz11a23.model.Profile;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private Long profileId;
    private String content;
    private UUID articleId;
    private Integer replyId;
    private String visible;
}
