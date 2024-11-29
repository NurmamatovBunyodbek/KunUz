package uz.bunyodbek.kunuz11a23.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private Integer sharedcount;
    @Column(nullable = false)
    private Integer imageid;
    @Column(nullable = false)
    private Integer regionId;
    @Column(nullable = false)
    private Integer categoryId;
    @Column(nullable = false)
    private Integer moderatorId;
    @Column(nullable = false)
    private Integer publisherId;
    @Column(nullable = false)
    private String status;
    @CreatedDate()
    private Date createDate;
    @CreatedDate()
    private Date publishedDate;
    @Column(nullable = false)
    private String visible;
    @Column(nullable = false)
    private Integer viewCount;

}

