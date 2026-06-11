package MaximumTotalSubarrayValue;
class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int mx = nums[0];
        int mn = nums[0];

        for (int num : nums) {
            mx = Math.max(mx, num);
            mn = Math.min(mn, num);
        }

        return 1L * k * (mx - mn);
    }
}