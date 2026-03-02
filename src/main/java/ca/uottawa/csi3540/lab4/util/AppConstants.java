package ca.uottawa.csi3540.lab4.util;

public final class AppConstants {
    private AppConstants() {
    }

    public static final String SESSION_USERNAME = "username";
    public static final String SESSION_EXAM1_ANSWER = "exam1Answer";
    public static final String SESSION_EXAM2_ANSWER = "exam2Answer";
    public static final String SESSION_SCORE = "score";

    public static final String COOKIE_USERNAME = "lab4_username";

    public static final int EXAM1_CORRECT_ANSWER = 12; // 7 + 5
    public static final int EXAM2_CORRECT_ANSWER = 5;  // 9 - 4
    public static final int EXAM_TOTAL_QUESTIONS = 2;
}
