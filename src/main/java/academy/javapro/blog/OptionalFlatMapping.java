package academy.javapro.blog;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalFlatMapping {
    private static final List<Student> students = new ArrayList<>();
    private static final List<Course> courses = new ArrayList<>();

    public static Optional<Student> findStudent(String name) {
        return students.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    private static Optional<Course> getEnrolledCourse(Student student) {
        return courses.stream()
                .filter(c -> c.getStudents().contains(student))
                .findFirst();
    }

    public static void main(String[] args) {
        students.add(new Student("Alice", 20));
        students.add(new Student("Bob", 22));

        Course javaCourse = new Course("Java 101");
        javaCourse.addStudent(students.get(0));  // Alice is enrolled
        courses.add(javaCourse);

        Optional<String> courseTitle = findStudent("Alice")
                .flatMap(OptionalFlatMapping::getEnrolledCourse)
                .map(Course::getTitle);

        courseTitle.ifPresent(title -> System.out.println("Enrolled course: " + title));
    }
}
