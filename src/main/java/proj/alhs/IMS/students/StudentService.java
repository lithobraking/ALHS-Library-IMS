package proj.alhs.IMS.students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();

    }

    public void addStudent(Student student) {
        Optional<Student> existingStudent = studentRepository.findStudentByEmail(student.getEmail());
        if (existingStudent.isPresent()) {
            throw new IllegalStateException("Sorry, but this email is already in use.");
        } else {
            studentRepository.save(student);
        }
    }

    public void deleteStudent(Long studentId) {
        if(!studentRepository.existsById(studentId)) {
            throw new IllegalStateException(
                    "student with ID " + studentId + " does not exist. Please review your request."
            );
        } else {
            studentRepository.deleteById(studentId);
        }
    }

    @Transactional
    public void editStudent(Long studentId, String firstName, String lastName, String email, Integer reservedItems) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                    "cannot edit student " + studentId + " because that entity does not exist."
                ));

        if (firstName != null &&
            firstName.length() > 0 &&
            !Objects.equals(student.getFirstName(), firstName)) {
                student.setFirstName(firstName);
        }

        if (lastName != null &&
            lastName.length() > 0 &&
            !Objects.equals(student.getLastName(), lastName)) {
                student.setLastName(lastName);
        }


        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(student.getEmail(), email)) {
            Optional<Student> existingStudent = studentRepository.findStudentByEmail(email);
            if (existingStudent.isPresent()) {
                throw new IllegalStateException("Sorry, but this email is already in use.");
            }
            student.setEmail(email);
        }

        // TODO - implement function to update number of reserved items
    }
}
