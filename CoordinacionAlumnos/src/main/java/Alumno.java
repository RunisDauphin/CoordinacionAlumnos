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
public class Alumno {
    @Id
    @Column(name = "idnt", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idnt;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "nom")
    private String nom;
    @Column(name = "courrier")
    private String courrier;
    @Column(name = "photo")
    private String photo;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    @JoinColumn(name = "modulo_idnt")
    private List<Long> groupeModuloIdnt = new ArrayList<>();
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "calificaciones_idnt")
    private List<Long> groupeCalificationsIdnt = new ArrayList<>();
    @CreatedDate
    @Column(name = "createAt")
    private LocalDateTime createAt;
    @Column(name = "updateAt")
    private LocalDateTime updateAt;
}
