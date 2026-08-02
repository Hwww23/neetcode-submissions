class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> s = new Stack<>();
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        for (int[] car : cars) {
            double time = (double) (target - car[0]) / car[1];
            if (s.isEmpty() || time > s.peek()) {
                s.push(time);
            }
        }

        return s.size();
    }
}
