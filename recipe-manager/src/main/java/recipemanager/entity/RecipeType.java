package recipemanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recipe_type")
public class RecipeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipeTypeId;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    public RecipeType(String name) {
        this.name = name;
    }
}
