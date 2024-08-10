public class collegeStudent extends student {
    private double examScore;

    public collegeStudent(String studentId, String fullName, int credits, double avgScore, double examScore) {
        super(studentId, fullName, credits, avgScore);
        this.examScore = examScore;
    }

    public double getExamScore() {
        return examScore;
    }

    @Override
    public boolean isGraduated() {
        return getCredits() >= 100 && getAvgScore() >= 5 && examScore >= 5;
    }

    @Override
    public String toString() {
        return super.toString() + ", Exam Score: " + examScore;
    }
}
