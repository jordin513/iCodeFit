package sample;
public class testNutritionStatsDriver {
    // by default, all test values will be based on US metrics (pounds, feet, etc.). A conversion method is provided
    // to convert to SI units

    /* test case values for nutrition stats screen */

    public static double getUserCurrWeight() {
        return UserCurrWeight;
    }

    public static void setUserCurrWeight(double userCurrWeight) {
        UserCurrWeight = userCurrWeight;
    }

    public static double getUserGoalWeight() {
        return UserGoalWeight;
    }

    public static void setUserGoalWeight(double userGoalWeight) {
        UserGoalWeight = userGoalWeight;
    }

    public static String getUserLastWorkout() {
        return UserLastWorkout;
    }

    public static void setUserLastWorkout(String userLastWorkout) {
        UserLastWorkout = userLastWorkout;
    }

    private static double UserCurrWeight = 212.15;
    private static double UserGoalWeight = 150.12;
    private static String UserLastWorkout = "Seated Incline Bicep Curls";

}
