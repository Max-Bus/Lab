package PowerSchool;

public class Student implements Comparable<Student>{
    /* When you declare the Student class, declare it as:
     * public class Student implements Comparable<Student>{ * This is your promise to include the compareTo() method.
     * Make it comparable by GPA*/
    String Name;
    int gradYear;
    School Academy;
    Course[] schedule; // Contains no more than ten courses.
    public Student (String name, int gradYear, School Academy){
        Name = name;
        this.gradYear = gradYear;
        this.Academy = Academy;

    }
    public String getName(){
        return Name;

    }
    public int getGradYear(){
        return gradYear;
    }
    public School getAcademy(){
        return Academy;
    }

    public int numCourse(){
        int count = 0;
        for (int i = 0; i < schedule.length; i++){
            if (schedule[i] == null)
                return count;
            count++;
        }
    }
    // Calculates GPA as average of classes
    public double getGPA(){
        int sumofGrades = 0;
        for (int i = 0; i < numCourse(); i++){
            sumofGrades += schedule[i].gradeOf(this.Name);
        }

        double average = sumofGrades/numCourse();

        if (average >= 93)
            return 4.0;
        else if (average >= 90)
            return 3.7;
        else if (average >= 87)
            return 3.3;
        else if (average >= 83)
            return 3.0;
        else if (average >= 80)
            return 2.7;
        else if (average >= 77)
            return 2.3;
        else if (average >= 73)
            return 2.0;
        else if (average >= 70)
            return 1.7;
        else if (average >= 67)
            return 1.3;
        else if (average >= 63)
            return 1.0;
        else
            return 0.0;



    }
    // Returns compareTo value for the GPAs of the two students
    public int compareTo(Student someOtherKid){
        return (int)Math.abs(getGPA() - someOtherKid.getGPA());
    }
    /* Adds course and returns true if successful.
     * Returns false if: course would brings classes to more than * 10, or student is already enrolled. */
    public boolean addCourse(Course someCourse){
        if(numCourse() <= 9){
            schedule[numCourse()] = someCourse;
            return true;
        }
        return false;
    }
    /* Removes course and returns true if successful.
     * Returns false if: course was not on student’s schedule.
     */
    public boolean dropCourse(Course someCourse){
        for (int i = 0; i < numCourse(); i++){
            if (someCourse == schedule[i]){
                for (int j = i; j < numCourse()-1;j++){
                    schedule[i] = schedule[i+1];
                }
                return true;
            }
        }
        return false;
    }
}
