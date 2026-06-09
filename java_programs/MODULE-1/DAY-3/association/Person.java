package association;

public class Person {
        private String name;
        private String fname;
        private String lname;
        private int age;

        Person(String name, String fname, String lname, int age){
            this.name = name;
            this.fname = fname;
            this.lname = lname;
            this.age = age;
        }
        public String toString(){
            return fname + " " + lname + " " + age;
        }

        public void setName(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }
    public void setFname(String fname){
        this.fname = fname;
    }
    public String getFname(){
        return fname;
    }

    public void setLname(String Lname){
        this.lname = Lname;
    }
    public String getLName(){
        return lname;
    }


    public void setAge(int age){
            this.age = age;
        }

        public int getAge(){
            return this.age;
        }
}
