import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CalificacionControlador {
    @GetMapping("/calificacion")
    public Calificacion calificacion() {
        return null;
    }
}
