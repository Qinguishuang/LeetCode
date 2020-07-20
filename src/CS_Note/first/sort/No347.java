package CS_Note.first.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 统计每个数的出现次数<num, count>
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : frequency.keySet()) {
            int freq = frequency.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && ans.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }
            if (buckets[i].size() <= (k - ans.size())) {
                ans.addAll(buckets[i]);
            } else {
                ans.addAll(buckets[i].subList(0, k - ans.size()));
            }
        }
        return ans;
    }
}
