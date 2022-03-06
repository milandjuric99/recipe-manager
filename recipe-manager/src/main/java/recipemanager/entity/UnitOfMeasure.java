package recipemanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "unit_of_measure")
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long unitOfMeasureId;

    @Column(name = "name", length = 5, nullable = false)
    private String name;

    public UnitOfMeasure(String name) {
        this.name = name;
    }
}
