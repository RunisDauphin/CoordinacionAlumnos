import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CoordinacionAlumnosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoordinacionAlumnosApplication.class, args);
	}
	/*Seguridad y tests no implementados.
	Parece que funciona por mis pruebas manuales.
	El curso de OpenWebinars de SpringBoot Security incluye, de una lección a otra, un servicio REST que no me daba tiempo a implementar.*/
}
