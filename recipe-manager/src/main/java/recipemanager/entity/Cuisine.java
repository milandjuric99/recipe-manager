package recipemanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cuisine")
public class Cuisine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cuisineId;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    public Cuisine(String name) {
        this.name = name;
    }
}
