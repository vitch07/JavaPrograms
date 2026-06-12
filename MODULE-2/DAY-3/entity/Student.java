    package entity;

    public class Student {
        private String name;
        private int physics;
        private int chemistry;
        private int maths;
        private int history;
        private int geography;

        public Student(String name, int physics, int chemistry, int maths, int history, int geography) {
            this.name = name;
            this.physics = physics;
            this.chemistry = chemistry;
            this.maths = maths;
            this.history = history;
            this.geography = geography;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPhysics() {
            return physics;
        }

        public void setPhysics(int physics) {
            this.physics = physics;
        }

        public int getChemistry() {
            return chemistry;
        }

        public void setChemistry(int chemistry) {
            this.chemistry = chemistry;
        }

        public int getMath() {
            return maths;
        }

        public void setMath(int maths) {
            this.maths = maths;
        }

        public int getHistory() {
            return history;
        }

        public void setHistory(int history) {
            this.history = history;
        }

        public int getGeography() {
            return geography;
        }

        public void setGeography(int geography) {
            this.geography = geography;
        }

        public String toString(){
            return "Student marks are " + name + " physics mark " + physics + " chem marks" + chemistry
                    + " math mark "+ maths +"history" +  history + "geo" + geography;
        }
    }
