"""
Given an integer array nums and an integer k, return the number of pairs (i, j) where i < j such that |nums[i] - nums[j]| == k.

The value of |x| is defined as:

x if x >= 0.
-x if x < 0.
 

Example 1:

Input: nums = [1,2,2,1], k = 1
Output: 4
Explanation: The pairs with an absolute difference of 1 are:
- [1,2,2,1]
- [1,2,2,1]
- [1,2,2,1]
- [1,2,2,1]
Example 2:

Input: nums = [1,3], k = 3
Output: 0
Explanation: There are no pairs with an absolute difference of 3.
Example 3:

Input: nums = [3,2,1,5,4], k = 2
Output: 3
Explanation: The pairs with an absolute difference of 2 are:
- [3,2,1,5,4]
- [3,2,1,5,4]
- [3,2,1,5,4]
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
1 <= k <= 99
"""

from collections import Counter
class Solution:
    def countKDifference(self, nums: List[int], k: int) -> int:
        counter = Counter(nums) # Counting Algo
        return sum(f * counter[n+k] for n, f in counter.items() if n+k in counter)
    
    def countKDifference2(self, nums: List[int], k: int) -> int:
        count = [0]* (100 +99+1)
        c = 0
        for num in nums:
            count[num] += 1
        return sum(count[num+k] for num in nums)

    def countKDifferenceBF(self, nums: List[int], k: int) -> int:
        i, l = 0, len(nums)
        count = 0
        while i < l:
            j = i+1
            while j < l:
                count += int(abs(nums[i]-nums[j]) == k)
                j += 1
            i+=1
        return count