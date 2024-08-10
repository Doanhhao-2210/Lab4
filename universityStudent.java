public class universityStudent extends student {
    private String thesisTitle;
    private double thesisScore;

    public universityStudent(String studentId, String fullName, int credits, double avgScore, String thesisTitle, double thesisScore) {
        super(studentId, fullName, credits, avgScore);
        this.thesisTitle = thesisTitle;
        this.thesisScore = thesisScore;
    }

    public String getThesisTitle() {
        return thesisTitle;
    }

    public double getThesisScore() {
        return thesisScore;
    }

    @Override
    public boolean isGraduated() {
        return getCredits() >= 150 && getAvgScore() >= 5 && thesisScore >= 5;
    }

    @Override
    public String toString() {
        return super.toString() + ", Thesis Title: " + thesisTitle + ", Thesis Score: " + thesisScore;
    }
}
