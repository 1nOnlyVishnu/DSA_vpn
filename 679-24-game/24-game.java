import java.util.ArrayList;
import java.util.List;

class Solution {

    // Use a small epsilon for floating point comparison
    double epsilon = 1e-6;

    public boolean judgePoint24(int[] cards) {
        double[] nums = new double[cards.length];
        for (int i = 0; i < cards.length; i++) {
            nums[i] = 1.0 * cards[i];
        }
        return solve(nums);
    }

    public boolean solve(double[] cards) {
        if (cards.length == 1) {
            return Math.abs(cards[0] - 24) < epsilon;
        }

        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards.length; j++) {
                if (i == j)
                    continue;

                List<Double> temp = new ArrayList<>();
                for (int k = 0; k < cards.length; k++) {
                    if (k != i && k != j) {
                        temp.add(cards[k]);
                    }
                }

                double a = cards[i];
                double b = cards[j];

                List<Double> possibleValues = new ArrayList<>();
                possibleValues.add(a + b);
                possibleValues.add(a - b);
                possibleValues.add(b - a);
                possibleValues.add(a * b);
                if (Math.abs(b) > epsilon) {
                    possibleValues.add(a / b);
                }
                if (Math.abs(a) > epsilon) {
                    possibleValues.add(b / a);
                }

                for (double val : possibleValues) {
                    temp.add(val);
                    double[] next = new double[temp.size()];
                    for (int k = 0; k < temp.size(); k++) {
                        next[k] = temp.get(k);
                    }
                    if (solve(next)) {
                        return true;
                    }
                    temp.remove(temp.size() - 1);
                }
            }
        }

        return false;
    }
}
