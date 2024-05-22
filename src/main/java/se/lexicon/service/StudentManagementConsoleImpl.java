package se.lexicon.service;

import se.lexicon.data_acess.StudentDao;
import se.lexicon.models.Student;
import se.lexicon.util.UserInputService;

import java.util.List;

public class StudentManagementConsoleImpl  implements StudentManagement{
private UserInputService userInputService;
private StudentDao studendDao;

    public StudentManagementConsoleImpl(UserInputService userInputService, StudentDao studendDao) {
        this.userInputService = userInputService;
        this.studendDao = studendDao;
    }

    @Override
    public Student create() {
        System.out.println("enter A Student Id :");
        int studentId = userInputService.getInt();
        System.out.println("enter A  Student Name:");
        String studentName= userInputService.getString();

        return new Student(studentId,studentName);
    }

    @Override
    public Student save(Student student) {
        studendDao.save (student);
        return student;
    }

    @Override
    public Student find(int id) {
      /*  for (Student s:studendDAD.findAll()){
            if (s.getId()==id){
                return s;
            }
        }*/
        return studendDao.find(id);
    }

    @Override
    public Student remove(int id) {
      /*  for (Student s: studendDao.findAll()){
            if (s.getId()==id){
                studendDao.delete(id);
                return s;
            }
        }
        return null ;*/
        studendDao.delete(id);
        return studendDao.find(id);
    }

    @Override
    public List<Student> findAll() {
        return studendDao.findAll();
    }

    @Override
    public Student edit(Student student) {

        Student updateStudent = studendDao.find(student.getId());
        System.out.println("enter a new id :");
        int newId = userInputService.getInt();
        System.out.println("enter new Name :");
        String newName = userInputService.getString();
        updateStudent.setId(newId);
        studendDao.save(updateStudent);
        return updateStudent;

    }
}
