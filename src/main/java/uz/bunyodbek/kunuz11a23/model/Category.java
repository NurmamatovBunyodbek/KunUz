package uz.bunyodbek.kunuz11a23.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionId;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String ordernumber;
    @Column(nullable = false)
    private String nameuz;
    @Column(nullable = false)
    private String nameru;
    @Column(nullable = false)
    private String nameeng;
    @Column(nullable = false)
    private String visible;

}
