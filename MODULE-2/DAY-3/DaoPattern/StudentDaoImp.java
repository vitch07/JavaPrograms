package DaoPattern;

import entity.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.StreamSupport;

public class StudentDaoImp implements StudentDao{
    private ArrayList<Student> students;

    public StudentDaoImp(){
        students = new ArrayList<>();
    }
    @Override
    public void enroll(Student student) {
        students.add(student);
    }

    @Override
    public Iterable<Integer> maxMarkPerSub(Student student,String subname) {
            ArrayList<Integer> marks = new ArrayList<>();
            

        return null;
    }

    @Override
    public Iterable<Student> TopperPerSub(Student student) {
        ArrayList<Student> toppers = new ArrayList<>();
        this.students.stream()
                .max((Student o1, Student o2) ->
                        o1.getChemistry() - o2.getChemistry())
                .ifPresent(toppers::add);

        students.stream()
                .max((Student s1, Student s2) -> s1.getChemistry() - s2.getChemistry())
                .ifPresent(new Consumer<Student>() {
                    @Override
                    public void accept(Student student) {
                        toppers.add(student);
                    }
                });
        students.stream()
                .max((Student s1, Student s2) -> s1.getGeography() - s2.getGeography())
                .ifPresent(new Consumer<Student>() {
                    @Override
                    public void accept(Student student) {
                        toppers.add(student);
                    }});
        students.stream()
                .max((Student s1, Student s2) -> s1.getMath() - s2.getMath())
                .ifPresent(new Consumer<Student>() {
                    @Override
                    public void accept(Student student) {
                        toppers.add(student);
                    }});
        students.stream()
                .max((Student s1, Student s2) -> s1.getHistory() - s2.getHistory())
                .ifPresent(new Consumer<Student>() {
                    @Override
                    public void accept(Student student) {
                        toppers.add(student);
                    }});
        return toppers;
    }

    @Override
    public Student TotalTopper(Iterable<Student> students) {
        return StreamSupport.stream(students.spliterator(),false)
                .max(Comparator.comparingInt(s -> s.getPhysics()
                + s.getChemistry() + s.getMath() + s.getHistory() + s.getGeography()))
                .orElse(null);
    }

    @Override
    public Iterable<Integer> CalculateAvgPerSub(Student student) {
        ArrayList<Student> arr = new ArrayList<>();
//        students.stream().

        return null;

    }

    @Override
    public int CountAboveAvgInPhy(Student student) {
        return 0;
    }
}
