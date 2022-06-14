import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CursoConvertidorDTO {
    private final ModelMapper modelmapper;

    public CursoDTO convertirDTO(Curso curso) {
        return modelmapper.map(curso, CursoDTO.class);
    }
}
