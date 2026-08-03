class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int min = 0;

        int l = 0;
        int r = people.length - 1;

        while (l < r) {
            if (people[l] + people[r] <= limit) {
                l++;
            }

            r--;
            min++;
        }

        return l > r ? min : min + 1;
    }
}