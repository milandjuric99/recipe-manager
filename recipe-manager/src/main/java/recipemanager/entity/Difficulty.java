package recipemanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dificulty")
public class Difficulty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dificultyId;

    @Column(name = "name", length = 15, nullable = false)
    private String name;

    public Difficulty(String name) {
        this.name = name;
    }
}
