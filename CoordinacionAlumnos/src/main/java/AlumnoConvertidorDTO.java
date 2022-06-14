import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlumnoConvertidorDTO {
    private final ModelMapper modelmapper;

    public AlumnoDTO convertirDTO(Alumno alumno) {
        return modelmapper.map(alumno, AlumnoDTO.class);
    }
}
