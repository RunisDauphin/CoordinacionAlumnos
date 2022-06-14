import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ModuloCreadorDTO {
    private String nom;
    private String abreviation;
    private int annee;
    private Long curso_idnt;
    private List<Long> groupeAlumnoIdnt = new ArrayList<>();
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
