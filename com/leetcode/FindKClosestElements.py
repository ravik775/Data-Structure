'''
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
'''
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        '''
        if len(arr) == k:
            return arr
        arr.sort(key=lambda e: (abs(e-x), e) )
        return sorted(arr[:k])
        '''

        if len(arr) == k:
            return arr
        
        #find closest element and init two pointers 
        left = 0
        right = len(arr) - k
        
        while left < right:
            mid = (left + right) // 2
            if (x - arr[mid]) > arr[mid + k] - x:
                left = mid + 1
            else:
                right = mid
        
        return arr[left:left+k]