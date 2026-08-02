class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> s = new Stack<>();
        double[][] time = new double[position.length][2];
        for (int i = 0; i < position.length; i++) {
            time[i][0] = position[i];
            time[i][1] = (double) (target - position[i]) / speed[i];
        }
        Arrays.sort(time, (a, b) -> Double.compare(b[0], a[0]));

        for (double[] t : time) {
            if (s.isEmpty() || !s.isEmpty() && t[1] > s.peek()) {
                s.push(t[1]);
            }
        }

        return s.size();
    }
}
