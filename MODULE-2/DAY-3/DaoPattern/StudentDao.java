package DaoPattern;

import entity.Student;

public interface StudentDao {

    public void enroll(Student student);
    public Iterable<Integer> maxMarkPerSub(Student student,String subname);
    public Iterable<Student> TopperPerSub(Student student);
    public Student TotalTopper(Iterable<Student> students);
    public Iterable <Integer> CalculateAvgPerSub(Student student);
    public int CountAboveAvgInPhy(Student student);

}
