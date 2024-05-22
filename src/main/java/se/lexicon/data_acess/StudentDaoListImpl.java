package se.lexicon.data_acess;

import org.springframework.stereotype.Component;
import se.lexicon.models.Student;

import java.util.ArrayList;
import java.util.List;
@Component
public class StudentDaoListImpl implements StudentDao {

    List<Student > students = new ArrayList<>();

    @Override

    public Student save(Student student) {
        if(student ==null ) throw  new IllegalArgumentException ("Student can not be null ");
       students.add (student);

        return student;

    }

    @Override
    public Student find(int id) {
for (Student s : students){
    if (s.getId()==id){
        return s;
    }
}
        return null;
    }

    public List<Student> findAll (){

        return students;
    }

    @Override
    public void delete(int id) {
        students.removeIf(student-> student.getId()== id);
    }


}
