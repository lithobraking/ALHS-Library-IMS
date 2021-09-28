package proj.alhs.IMS.students;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "Alana",
                        "Wexler",
                        0
                )
        );
    }
}
