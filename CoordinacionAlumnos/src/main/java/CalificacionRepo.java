import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CalificacionRepo extends JpaRepository<Calificacion, Long> {
}
