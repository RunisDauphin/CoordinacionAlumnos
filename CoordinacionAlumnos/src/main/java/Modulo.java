import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Modulo {
    @Id
    @Column(name = "idnt", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idnt;
    @Column(name = "nom")
    private String nom;
    @Column(name = "abreviation")
    private String abreviation;
    @ManyToOne
    @JoinColumn(name = "curso_idnt")
    private Long cursoIdnt;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    @JoinColumn(name = "alumno_idnt")
    private List<Long> groupeAlumnoIdnt = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "calificacion_idnt")
    private Long calificacionIdnt;
    @CreatedDate
    @Column(name = "createAt")
    private LocalDateTime createAt;
    @Column(name = "updateAt")
    private LocalDateTime updateAt;
}
