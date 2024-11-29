package uz.bunyodbek.kunuz11a23.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {

    private String title;
    private String description;
    private String content;
    private Integer sharedcount;
    private Integer imageid;
    private Integer regionId;
    private Integer categoryId;
    private Integer moderatorId;
    private Integer publisherId;
    private String status;
    private Date createDate;
    private Date publishedDate;
    private String visible;
    private Integer viewCount;
}
