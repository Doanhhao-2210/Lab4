public abstract class student {
    private String studentId;
    private String fullName;
    private int credits;
    private double avgScore;

    public student(String studentId, String fullName, int credits, double avgScore) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.credits = credits;
        this.avgScore = avgScore;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public int getCredits() {
        return credits;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public abstract boolean isGraduated();

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + fullName + ", Credits: " + credits + ", Average Score: " + avgScore;
    }
}
