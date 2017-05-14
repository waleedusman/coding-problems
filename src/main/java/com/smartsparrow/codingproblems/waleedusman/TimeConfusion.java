package com.smartsparrow.codingproblems.waleedusman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.google.common.base.Preconditions.checkNotNull;

public class TimeConfusion {
    private static final int MAX_MINUTES = 720;

    public List<String> run(int numTestCases, List<String> testCases) {
        checkInput(numTestCases, testCases);
        List<String> result = new ArrayList<>();
        for (String testCase : testCases) {
            String[] watchTime = testCase.split(" ");
            int timeOne = convertToMinutes(watchTime[0]);
            int timeTwo = convertToMinutes(watchTime[1]);
            int timeThree = convertToMinutes(watchTime[2]);

            boolean timeOneIsMiddle = isMiddle(timeOne, timeTwo, timeThree);
            boolean timeTwoIsMiddle = isMiddle(timeTwo, timeOne, timeThree);
            boolean timeThreeIsMiddle = isMiddle(timeThree, timeOne, timeTwo);

            if (timeOneIsMiddle && !timeTwoIsMiddle && !timeThreeIsMiddle) {
                result.add("The correct time is " + watchTime[0] + ".");
            } else if (!timeOneIsMiddle && timeTwoIsMiddle && !timeThreeIsMiddle) {
                result.add("The correct time is " + watchTime[1] + ".");
            } else if (!timeOneIsMiddle && !timeTwoIsMiddle && timeThreeIsMiddle) {
                result.add("The correct time is " + watchTime[2] + ".");
            } else {
                result.add("Look at the sun.");
            }
        }

        return result;
    }

    // Convert "H:M" into minutes
    private int convertToMinutes(String hourMinutes) {
        String[] tokens = hourMinutes.split(":");
        int hour = Integer.parseInt(tokens[0]);
        int minutes = Integer.parseInt(tokens[1]);
        if ((hour <= 0) || (hour > 12)) {
            throw new IllegalArgumentException("Incorrect value entered for hour, must be: 0 < H < 12");
        }
        if ((minutes < 0) || (minutes > 59)) {
            throw new IllegalArgumentException("Incorrect value entered for minute, must be: 0 <= M < 60");
        }

        if (hour == 12) {
            if (minutes == 0) {
                return MAX_MINUTES;
            } else {
                return minutes;
            }
        } else {
            return (hour * 60) + minutes;
        }
    }

    // calc 'left' and 'right' distance of middle from two different values
    private boolean isMiddle(int middle, int time1, int time2) {
        int[] distanceFromTime1 = leftRightDistance(middle, time1);
        int[] distanceFromTime2 = leftRightDistance(middle, time2);
        return Arrays.equals(distanceFromTime1, distanceFromTime2);
    }

    private int[] leftRightDistance(int middle, int time) {
        int[] distanceFromTime = new int[2];
        if (middle < time) {
            distanceFromTime[0] = time - middle;
            distanceFromTime[1] = middle + (MAX_MINUTES - time);
        } else if (middle > time) {
            distanceFromTime[0] = (MAX_MINUTES - middle) +  time;
            distanceFromTime[1] = middle - time;
        } else {
            distanceFromTime[0] = 0;
            distanceFromTime[1] = 0;
        }
        Arrays.sort(distanceFromTime);
        return distanceFromTime;
    }

    private void checkInput(int numTestCases, List<String> testCases) {
        checkNotNull(testCases);
        if (numTestCases != testCases.size()) {
            throw new IllegalArgumentException("Insufficient test cases provided, must be: " + numTestCases);
        }
        if (!testCases.stream().allMatch(s -> s.matches("\\d+:\\d+ \\d+:\\d+ \\d+:\\d+"))) {
            throw new IllegalArgumentException("Test case must be of the format; H:M H:M H:M - where both H and M can be parsed as integers");
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter total number of test cases: ");
        String totalNumberOfTestCases = new Scanner(System.in).nextLine();
        int numCases = Integer.parseInt(totalNumberOfTestCases);
        List<String> cases = new ArrayList<>();
        try {
            for (int i = 1; i <= numCases; i++) {
                System.out.println("Enter case " + i);
                cases.add(new Scanner(System.in).nextLine());
            }
        } catch (Exception ex) {
            throw new IllegalArgumentException("Error capturing input from user: " + ex.getMessage());
        }

        new TimeConfusion().run(numCases, cases).stream().forEachOrdered(System.out::println);
    }
}
