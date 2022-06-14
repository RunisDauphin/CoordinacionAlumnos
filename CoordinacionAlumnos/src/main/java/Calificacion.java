import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calificacion {
    @Id
    @Column(name = "idnt", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idnt;
//    @ManyToOne
//    @JoinColumn(name = "modulo_idnt")
//    private Modulo modulo;
//    @ManyToOne
//    @JoinColumn(name = "alumno_idnt")
//    private Alumno alumno;
    @Column(name = "calification")
    private double calification;
}
