package proj.alhs.IMS.students;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repo) {
        return args -> {
            Student ex1 = new Student(
                    "Alana",
                    "Wexler",
                    0
            );

            Student ex2 = new Student(
                    "Denny",
                    "Lee",
                    0
            );

            repo.saveAll(
                    List.of(ex1, ex2)
            );
        };
    }
}
