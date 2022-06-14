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
public class Curso {
    @Id
    @Column(name = "idnt", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idnt;
    @Column(name = "nom")
    private String nom;
    @Column(name = "abreviation")
    private String abreviation;
    @Column(name = "annee")
    private int annee;
//    @OneToMany(
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    @JoinColumn(name = "modulo_idnt")
//    private List<Modulo> groupeModulo = new ArrayList<>();
@CreatedDate
    @Column(name = "createAt")
    private LocalDateTime createAt;
    @Column(name = "updateAt")
    private LocalDateTime updateAt;
}
