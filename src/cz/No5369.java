package cz;

public class No5369 {
    public int numTeams(int[] rating) {
        if (rating == null || rating.length < 3)
            return 0;
        int ans = 0;
        for (int i = 1; i < rating.length-1; i++) {
            int lBig = 0, lSmall = 0, rBig = 0, rSmall = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    lSmall++;
                } else if (rating[j] > rating[i]) {
                    lBig++;
                }
            }
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[j] < rating[i]) {
                    rSmall++;
                } else if (rating[j] > rating[i]) {
                    rBig++;
                }
            }
            ans += (lBig * rSmall + lSmall * rBig);
        }
        return ans;
    }

    public static void main(String[] args) {
        No5369 n = new No5369();
        int[] arr = {1, 2, 3, 4};
        System.out.println(n.numTeams(arr));
    }
}
