package uz.bunyodbek.kunuz11a23.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //  @CreatedDate
    private Date createDate;
    // @CreatedDate
    private Date updateDate;
    @ManyToOne
    private Profile profile;
    @Column(nullable = false)
    private String content;
    @ManyToMany
    private List<Article> article;
    @Column(nullable = false)
    private Integer replyId;
    @Column(nullable = false)
    private String visible;


}
