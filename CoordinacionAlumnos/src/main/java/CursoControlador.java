import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CursoControlador {

    private final CursoRepo cursorepo;
    private final CursoConvertidorDTO cursoconvertidorDTO;

    @GetMapping("/curso")
    public ResponseEntity<?> todosCursos() {
        List<Curso> listadoCursos = cursorepo.findAll();

        if(listadoCursos.isEmpty() == true) {
            return ResponseEntity.notFound().build();
        }
        if(listadoCursos.isEmpty() == false) {
            /*return ResponseEntity.ok(listadoCursos);*/
            List<CursoDTO> listadoCursosDTO = listadoCursos.stream()
                    .map(cursoconvertidorDTO::convertirDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(listadoCursosDTO);
        }
        return null;
    }

    @GetMapping("/curso/{idnt}")
    public ResponseEntity<?> unCurso(@PathVariable Long idnt) {
        Curso curso = cursorepo.findById(idnt).orElse(null);

        if(curso == null) {
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.ok(curso);
        }
    }

    @PostMapping("/curso")
    public ResponseEntity<Curso> nuevoCurso(@RequestBody Curso cursoNuevo, @PathVariable Long idnt) {
        Curso nuevoCursoCreado = new Curso();
        nuevoCursoCreado.setIdnt(cursoNuevo.getIdnt());
        nuevoCursoCreado.setNom(cursoNuevo.getNom());
        nuevoCursoCreado.setAbreviation(cursoNuevo.getAbreviation());
        nuevoCursoCreado.setAnnee(cursoNuevo.getAnnee());
        nuevoCursoCreado.setUpdateAt(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(cursorepo.save(nuevoCursoCreado));
    }

    @PutMapping("/curso/{idnt}")
    public ResponseEntity<?> editarCurso(@RequestBody Curso cursoViejo, @PathVariable Long idnt) {
        Curso viejoCursoModificado = new Curso();
        viejoCursoModificado.setIdnt(cursoViejo.getIdnt());
        viejoCursoModificado.setNom(cursoViejo.getNom());
        viejoCursoModificado.setAbreviation(cursoViejo.getAbreviation());
        viejoCursoModificado.setAnnee(cursoViejo.getAnnee());
        viejoCursoModificado.setUpdateAt(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(cursorepo.save(viejoCursoModificado));
    }

    @DeleteMapping("/curso/{idnt}")
    public ResponseEntity<?> borrarCurso(@PathVariable Long idnt) {
        return ResponseEntity.unprocessableEntity().build();
    }
}
