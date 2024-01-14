'''
1005. Maximize Sum Of Array After K Negations
Given an integer array nums and an integer k, modify the array in the following way:

choose an index i and replace nums[i] with -nums[i].
You should apply this process exactly k times. You may choose the same index i multiple times.

Return the largest possible sum of the array after modifying it in this way.

 

Example 1:

Input: nums = [4,2,3], k = 1
Output: 5
Explanation: Choose index 1 and nums becomes [4,-2,3].
Example 2:

Input: nums = [3,-1,0,2], k = 3
Output: 6
Explanation: Choose indices (1, 2, 2) and nums becomes [3,1,0,2].
Example 3:

Input: nums = [2,-3,-1,5,-4], k = 2
Output: 13
Explanation: Choose indices (1, 4) and nums becomes [2,3,-1,5,4].

'''


class Solution:
    def largestSumAfterKNegations(self, nums: List[int], k: int) -> int:
        heapq.heapify(nums)
        while nums[0] < 0 and k:
            heapq.heappushpop(nums, -nums[0])
            k-=1
        k=k%2
        if k:
            nums[0] = -nums[0]
        return sum(nums)


    def largestSumAfterKNegations2(self, nums: List[int], k: int) -> int:
        nums.sort()
        i = 0
        while k and i < len(nums) and nums[i] < 0:
                nums[i] = -nums[i]
                k-=1
                i+=1
        k=k%2
        if k:
            if i >= len(nums) or ( i > 0 and nums[i] > nums[i-1]):
                i-=1
            nums[i] = -nums[i]
        return sum(nums)
        
