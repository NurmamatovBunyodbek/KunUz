package uz.bunyodbek.kunuz11a23.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleTypeDto {

    private Long ordernumber;
    private String nameuz;
    private String  nameru;
    private String nameeng;
    private String visible;
    private Date createdDate;



}
