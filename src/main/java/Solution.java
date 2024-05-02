import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestAwesome(String s) {
        Map<Integer, int[]> prefixMask = new HashMap<>();// [0] - last even index with this mask,[1] - odd
        int mask = 0;
        int maxLength = 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int num = ch - '0';
            mask ^= 1 << num;
            if (mask == 0 || (mask & (mask - 1)) == 0) {
                maxLength = i + 1;
            } else {
                int[] indexesMakingTheMaskZero = prefixMask.getOrDefault(mask, new int[] { -1, -1 });
                if (i % 2 == 0 && indexesMakingTheMaskZero[0] != -1) {
                    maxLength = Math.max(i - indexesMakingTheMaskZero[0], maxLength);
                } else if (i % 2 == 1 && indexesMakingTheMaskZero[1] != -1) {
                    maxLength = Math.max(i - indexesMakingTheMaskZero[1], maxLength);
                }
                for (int j = 0; j < 10; j++) {
                    int target = mask ^ (1 << j);
                    int[] indexes = prefixMask.getOrDefault(target, new int[] { -1, -1 });
                    if (i % 2 == 0 && indexes[1] != -1) {
                        maxLength = Math.max(i - indexes[1], maxLength);
                    } else if (i % 2 == 1 && indexes[0] != -1) {
                        maxLength = Math.max(i - indexes[0], maxLength);
                    }
                }
            }
            int[] existingMaskIndexes = prefixMask.getOrDefault(mask, new int[]{-1, -1});
            if(i % 2 == 0 && existingMaskIndexes[0] == -1){
                existingMaskIndexes[0] = i;
            }else if(i % 2 == 1 && existingMaskIndexes[1] == -1){
                existingMaskIndexes[1] = i;
            }
            prefixMask.put(mask, existingMaskIndexes);

        }
        return maxLength;
    }
}