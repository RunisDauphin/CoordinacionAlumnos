import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AlumnoControlador {

    private final AlumnoRepo alumnorepo;
    private final AlumnoConvertidorDTO alumnoconvertidorDTO;
    private final ModuloRepo modulorepo;
    private final CalificacionRepo calificacionrepo;

    @GetMapping("/alumno")
    public ResponseEntity<?> todosAlumnos() {
        List<Alumno> listadoAlumnos = alumnorepo.findAll();

        if(listadoAlumnos.isEmpty() == true) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Liste étudiants vide.");
        }
        if(listadoAlumnos.isEmpty() == false) {
            /*return ResponseEntity.ok(listadoAlumnos);*/
            List<AlumnoDTO> listadoAlumnosDTO = listadoAlumnos.stream()
                    .map(alumnoconvertidorDTO::convertirDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(listadoAlumnosDTO);
        }
        return null;
    }

    @GetMapping("/alumno/{idnt}")
    public ResponseEntity<?> unAlumno(@PathVariable Long idnt) {
        Alumno alumno = alumnorepo.findById(idnt).orElse(null);

        if(alumno == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Étudiant non existant.");
        }
        else {
            return ResponseEntity.ok(alumno);
        }
    }

    @PostMapping("/alumno")
    public ResponseEntity<Alumno> nuevoAlumno(@RequestBody AlumnoCreadorDTO alumnoNuevo) {
        /*Alumno alumno = alumnorepo.save(alumnoNuevo);
        return ResponseEntity.status(HttpStatus.CREATED).body(alumno);*/
        Scanner scanner = new Scanner(System.in);
        Alumno nuevoAlumnoCreado = new Alumno();
        List<Calificacion> listadoCalificaciones = calificacionrepo.findAll();
        List<Long> listadoCalificacionesIdnt = nuevoAlumnoCreado.getGroupeCalificationsIdnt();
        nuevoAlumnoCreado.setPrenom(alumnoNuevo.getPrenom());
        nuevoAlumnoCreado.setNom(alumnoNuevo.getNom());
        nuevoAlumnoCreado.setCourrier(alumnoNuevo.getCourrier());
        nuevoAlumnoCreado.setPhoto(alumnoNuevo.getPhoto());
        for(int i = 0; i < 15; i = i + 1) {
            List<Long> moduloTemporal = new ArrayList<>();
            Long idntAnotation = 1L;
            while(idntAnotation != 0L && idntAnotation != 99L && idntAnotation != 373L && (idntAnotation < 483L || idntAnotation > 495L)) {
                System.out.println("Introduzca el código del módulo al que el alumno está inscrito. Marque 0 para salir.");
                idntAnotation = scanner.nextLong();
            }
            for(int j = 0; j < moduloTemporal.size(); j = j + 1) {
                if(idntAnotation == moduloTemporal.get(j)) {
                    idntAnotation = 1L;
                    i = i - 1;
                    System.out.println("Módulo ya en lista.");
                }
            }
            if(idntAnotation == 0L) {
                break;
            }
            if(idntAnotation != 1L) {
                moduloTemporal.add(idntAnotation);
            }
            Double valeurCalification = -1.0;
            while(valeurCalification < 0 || valeurCalification > 10) {
                System.out.println("Introduzca la nota del módulo al que el alumno acaba de inscribirse.");
                valeurCalification = scanner.nextDouble();
            }
            Long nouveauIndex = Long.valueOf(nuevoAlumnoCreado.getGroupeCalificationsIdnt().size());
            Calificacion calificacion = new Calificacion(nouveauIndex, valeurCalification);
            listadoCalificaciones.add(calificacion);
            listadoCalificacionesIdnt.add(nouveauIndex);
            nuevoAlumnoCreado.setGroupeModuloIdnt(moduloTemporal);
            nuevoAlumnoCreado.setGroupeCalificationsIdnt(listadoCalificacionesIdnt);
        }
        nuevoAlumnoCreado.setUpdateAt(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnorepo.save(nuevoAlumnoCreado));
    }

    @PutMapping("/alumno/{idnt}")
    public ResponseEntity<?> editarAlumno(@RequestBody Alumno alumnoViejo, @PathVariable Long idnt) {
        return alumnorepo.findById(idnt).map(obj1 -> {
            Scanner scanner = new Scanner(System.in);
            List<Modulo> listadoModulos = modulorepo.findAll();
            List<Calificacion> listadoCalificaciones = calificacionrepo.findAll();
            List<Long> listadoCalificacionesIdnt = obj1.getGroupeCalificationsIdnt();
            obj1.setPrenom(alumnoViejo.getPrenom());
            obj1.setNom(alumnoViejo.getNom());
            obj1.setCourrier(alumnoViejo.getCourrier());
            obj1.setPhoto(alumnoViejo.getPhoto());
            List<Long> moduloTemporal = obj1.getGroupeModuloIdnt();
            for(int i = 0; i < moduloTemporal.size(); i = i + 1) {
                Long idntAnotation = 1L;
                while(idntAnotation != 0L && idntAnotation != 99L && idntAnotation != 373L && (idntAnotation < 483L || idntAnotation > 495L)) {
                    System.out.println("Introduzca el código del módulo al que el alumno no está más inscrito. Marque 0 para salir.");
                    idntAnotation = scanner.nextLong();
                }
                for(int j = 0; j < moduloTemporal.size(); j = j + 1) {
                    if(idntAnotation == moduloTemporal.get(j)) {
                        moduloTemporal.remove(j);
                        System.out.println("Módulo borrado.");
                    }
                }
                if(idntAnotation == 0L) {
                    break;
                }
                for(Modulo modulo : listadoModulos) {
                    for(int k = 0; k < modulo.getGroupeAlumnoIdnt().size(); k = k + 1) {
                        if(modulo.getGroupeAlumnoIdnt().get(k) == idnt) {
                            modulo.getGroupeAlumnoIdnt().remove(k);
                            alumnoViejo.getGroupeCalificationsIdnt().remove(k);
                            modulo.setUpdateAt(LocalDateTime.now());
                        }
                    }
                }
                obj1.setGroupeModuloIdnt(moduloTemporal);
            }
            for(int i = 0; i < 15 - moduloTemporal.size(); i = i + 1) {
                Long idntAnotation = 1L;
                while(idntAnotation != 0L && idntAnotation != 99L && idntAnotation != 373L && (idntAnotation < 483L || idntAnotation > 495L)) {
                    System.out.println("Introduzca el código del módulo al que el alumno acaba de inscribirse. Marque 0 para salir.");
                    idntAnotation = scanner.nextLong();
                }
                for(int j = 0; j < moduloTemporal.size(); j = j + 1) {
                    if(idntAnotation == moduloTemporal.get(j)) {
                        idntAnotation = 1L;
                        i = i - 1;
                        System.out.println("Módulo ya en lista.");
                    }
                }
                if(idntAnotation == 0L) {
                    break;
                }
                if(idntAnotation != 1L) {
                    moduloTemporal.add(idntAnotation);
                }
                obj1.setGroupeModuloIdnt(moduloTemporal);
                for(Modulo modulo : listadoModulos) {
                    if(modulo.getIdnt() == idntAnotation) {
                        modulo.getGroupeAlumnoIdnt().add(idnt);
                        modulo.setUpdateAt(LocalDateTime.now());
                    }
                }
                Double valeurCalification = -1.0;
                while(valeurCalification < 0 || valeurCalification > 10) {
                    System.out.println("Introduzca la nota del módulo al que el alumno acaba de inscribirse.");
                    valeurCalification = scanner.nextDouble();
                }
                Long nouveauIndex = Long.valueOf(obj1.getGroupeCalificationsIdnt().size());
                Calificacion calificacion = new Calificacion(nouveauIndex, valeurCalification);
                listadoCalificaciones.add(calificacion);
                listadoCalificacionesIdnt.add(nouveauIndex);
                obj1.setGroupeModuloIdnt(moduloTemporal);
                obj1.setGroupeCalificationsIdnt(listadoCalificacionesIdnt);
            }
            obj1.setUpdateAt(LocalDateTime.now());
            return ResponseEntity.ok(alumnorepo.save(obj1));
        })
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Étudiant non existant."));
    }

    @DeleteMapping("/alumno/{idnt}")
    public ResponseEntity<?> borrarAlumno(@PathVariable Long idnt) {
        alumnorepo.deleteById(idnt);
        List<Modulo> listadoModulos = modulorepo.findAll();
        for(Modulo modulo : listadoModulos) {
            for(int i = 0; i < modulo.getGroupeAlumnoIdnt().size(); i = i + 1) {
                if(modulo.getGroupeAlumnoIdnt().get(i) == idnt) {
                    modulo.getGroupeAlumnoIdnt().remove(i);
                    modulo.setUpdateAt(LocalDateTime.now());
                }
            }
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Étudiant non existant.");
    }
}
