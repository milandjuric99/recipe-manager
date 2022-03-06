package recipemanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ingredients")
public class Ingredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingredientId;

    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @Column(name = "quantity", nullable = false)
    private double quantity;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "unit_of_measure_id")
    private UnitOfMeasure unitOfMeasure;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public Ingredients(String name, double quantity, UnitOfMeasure unitOfMeasure) {
        this.name = name;
        this.quantity = quantity;
        this.unitOfMeasure = unitOfMeasure;
    }

    public Ingredients(String name, double quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}
