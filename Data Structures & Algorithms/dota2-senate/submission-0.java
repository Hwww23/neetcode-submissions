class Solution {
    public String predictPartyVictory(String senate) {
        int radiant = 0;
        int dire = 0;

        for (char c : senate.toCharArray()) {
            if (c == 'R') {
                radiant++;
            } else {
                dire++;
            }
        }

        int rv = 0;
        int dv = 0;

        char[] arr = senate.toCharArray();

        while (radiant > 0 && dire > 0) {
            for (int i = 0; i < arr.length; i++) {
                char c = arr[i];

                if (c == 'R') {
                    if (dv > 0) {
                        dv--;
                        radiant--;
                        arr[i] = '.';
                    } else {
                        rv++;
                    }
                } else if (c == 'D') {
                    if (rv > 0) {
                        rv--;
                        dire--;
                        arr[i] = '.';
                    } else {
                        dv++;
                    }
                }
            }
        }

        return radiant > 0 ? "Radiant" : "Dire";
    }
}