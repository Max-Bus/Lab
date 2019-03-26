package PowerSchool;

public class Grade {
    /* Grades must be between 0 and 1000 (which represents a score of 100%. A grade of 957 * would represent a score of 95.7%) (inclusive) */
    int grade;
    /* Audited classes are not counted in a Student’s GPA or class rank. A Student may audit
     * a class even if other Students in the same class are not auditing. */
    boolean audit;
    /* Honors classes have a 5% boost to the grade. */
    boolean honors;
    /* The course for which this grade has been assigned. */
    Course course;
    /* If the grade provided is out of range, the closest in-range grade is entered. */
    public Grade (boolean honors, boolean audited, int grade, Course course){
        this.honors = honors;
        this.audit = audited;
        this.course = course;

        if (grade > 1000){
            this.grade = 1000;
        }
        else if (grade < 0){
            this.grade = 0;
        }
        else {
            this.grade = grade;
        }

    }
    /* Returns the grade. If this is an honors grade, the reported grade is raised by 5%,
     * properly rounded (so a score of 500 would become 525, maximum honors grade: 1050)
     **/
    public int gradeValue(){
        int honoredgrade = grade;
        if (honors()){
            honoredgrade = (int)(grade * 1.05 + 0.5);
        }

        return honoredgrade;
    }
    public boolean honors(){
        return honors;
    }
    public boolean audited(){
        return audit;
    }
}
