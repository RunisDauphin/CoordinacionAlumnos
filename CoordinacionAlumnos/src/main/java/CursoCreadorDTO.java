import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CursoCreadorDTO {
    private String nom;
    private String abreviation;
    private int annee;
    private List<Long> groupeModuloIdnt = new ArrayList<>();
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
