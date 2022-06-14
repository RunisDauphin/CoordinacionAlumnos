import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class CalificacionDTO {
    private double calification;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
