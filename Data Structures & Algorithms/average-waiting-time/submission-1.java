class Solution {
    public double averageWaitingTime(int[][] customers) {
        long total = 0;
        long curr = 0;
        
        for (int[] c : customers) {
            if (curr > c[0]) {
                total += curr - c[0] + c[1];
                curr += c[1];
            } else {
                total += c[1];
                curr = c[0] + c[1];
            }
        }

        return (double) total / customers.length;
    }
}