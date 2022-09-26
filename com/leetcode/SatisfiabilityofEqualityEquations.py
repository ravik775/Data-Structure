'''
990. Satisfiability of Equality Equations
Medium

2808

42

Add to List

Share
You are given an array of strings equations that represent relationships between variables where each string equations[i] is of length 4 and takes one of two different forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (not necessarily different) that represent one-letter variable names.

Return true if it is possible to assign integers to variable names so as to satisfy all the given equations, or false otherwise.

 

Example 1:

Input: equations = ["a==b","b!=a"]
Output: false
Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.
There is no way to assign the variables to satisfy both equations.
Example 2:

Input: equations = ["b==a","a==b"]
Output: true
Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
'''


class Solution:
    def equationsPossible(self, equations: List[str]) -> bool: # O(n*k)
        flist = {}
        blist = {}
        index = 1;
        for eq in equations: # O(n)
            v1, v2 = eq[0], eq[-1]
            iv1, iv2 = flist.get(v1), flist.get(v2)
            if eq[1] == '=':   
                if iv1 and iv2:
                    if iv1 != iv2:
                        if iv1 > iv2:
                            iv1, iv2 = iv2, iv1
                        flist.update((e, iv1) for e in blist[iv2]) # O(K)
                        blist[iv1].extend(blist[iv2])
                        del blist[iv2]
                elif iv1:
                    flist[v2] = iv1
                    blist[iv1].append(v2)
                elif iv2:
                    flist[v1] = iv2
                    blist[iv2].append(v1)
                else:
                    flist[v2] = flist[v1] = index
                    blist[index] = [v1, v2]
                    index += 1
            else:
                if not iv1:
                    flist[v1] = index
                    blist[index] = [v1]
                    index+=1
                if not iv2:
                    flist[v2] = index
                    blist[index] = [v2]
                    index+=1
        del blist
        for eq in equations:
            if eq[1] == '!'and flist[eq[0]] == flist[eq[-1]]:
                return False
        return True
