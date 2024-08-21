package academy.javapro.blog;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String title;
    private List<Student> students = new ArrayList<>();

    public Course(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }
}
