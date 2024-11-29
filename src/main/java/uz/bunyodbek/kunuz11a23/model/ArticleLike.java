package uz.bunyodbek.kunuz11a23.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ArticleLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany
    private List<Profile> profileId;
    @OneToMany
    private List<Article> articleId;
    @CreatedDate
    private Date createdDate;
    @Column(nullable = false)
    private String status;
}
