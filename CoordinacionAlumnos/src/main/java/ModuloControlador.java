import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ModuloControlador {

    private final ModuloRepo modulorepo;
    private final ModuloConvertidorDTO moduloconvertidorDTO;

    @GetMapping("/modulo")
    public ResponseEntity<?> todosModulos() {
        List<Modulo> listadoModulos = modulorepo.findAll();

        if(listadoModulos.isEmpty() == true) {
            return ResponseEntity.notFound().build();
        }
        if(listadoModulos.isEmpty() == false) {
            /*return ResponseEntity.ok(listadoModulos);*/
            List<ModuloDTO> listadoModulosDTO = listadoModulos.stream()
                    .map(moduloconvertidorDTO::convertirDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(listadoModulosDTO);
        }
        return null;
    }

    @GetMapping("/modulo/{idnt}")
    public ResponseEntity<?> unModulo(@PathVariable Long idnt) {
        Modulo modulo = modulorepo.findById(idnt).orElse(null);

        if(modulo == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Module non existant.");
        }
        else {
            return ResponseEntity.ok(modulo);
        }
    }

    @PostMapping("/modulo")
    public ResponseEntity<Modulo> nuevoModulo(@RequestBody Modulo moduloNuevo) {
        Modulo nuevoModuloCreado = new Modulo();
        nuevoModuloCreado.setIdnt(moduloNuevo.getIdnt());
        nuevoModuloCreado.setNom(moduloNuevo.getNom());
        nuevoModuloCreado.setAbreviation(moduloNuevo.getAbreviation());
        nuevoModuloCreado.setCursoIdnt(moduloNuevo.getCursoIdnt());
        nuevoModuloCreado.setUpdateAt(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(modulorepo.save(nuevoModuloCreado));
    }

    @PutMapping("/modulo/{idnt}")
    public ResponseEntity<?> editarModulo(@RequestBody Modulo moduloViejo, @PathVariable Long idnt) {
        Modulo viejoModuloModificado = new Modulo();
        viejoModuloModificado.setIdnt(moduloViejo.getIdnt());
        viejoModuloModificado.setNom(moduloViejo.getNom());
        viejoModuloModificado.setAbreviation(moduloViejo.getAbreviation());
        viejoModuloModificado.setCursoIdnt(moduloViejo.getCursoIdnt());
        viejoModuloModificado.setUpdateAt(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(modulorepo.save(viejoModuloModificado));
    }

    @DeleteMapping("/modulo/{idnt}")
    public ResponseEntity<?> borrarModulo(@PathVariable Long idnt) {
        return ResponseEntity.unprocessableEntity().build();
    }
}
