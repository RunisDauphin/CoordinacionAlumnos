import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class AlumnoDTO {
    private String prenom;
    private String nom;
    private String courrier;
    private String photo;
    private List<Long> groupeModuloIdnt = new ArrayList<>();
    private List<Double> groupeCalifications = new ArrayList<>();
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
