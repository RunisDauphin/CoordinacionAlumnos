import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CalificacionConvertidorDTO {
    private final ModelMapper modelmapper;

    public ModuloDTO convertirDTO(Modulo modulo) {
        return modelmapper.map(modulo, ModuloDTO.class);
    }
}
