# -*-coding: utf-8-*-
"""
@author wzklhk
@date 2023/8/7
@packageName
@className Problem344EasyReverseStringTest
"""
from typing import List


# 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
#
#  不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
#
#
#
#  示例 1：
#
#
# 输入：s = ["h","e","l","l","o"]
# 输出：["o","l","l","e","h"]
#
#
#  示例 2：
#
#
# 输入：s = ["H","a","n","n","a","h"]
# 输出：["h","a","n","n","a","H"]
#
#
#
#  提示：
#
#
#  1 <= s.length <= 10⁵
#  s[i] 都是 ASCII 码表中的可打印字符
#
#
#  Related Topics 双指针 字符串 👍 795 👎 0
class Problem344EasyReverseStringTest(object):
    def reverseString(self, s: List):
        """
        :type s: List[str]
        :rtype: None Do not return anything, modify s in-place instead.
        """
        i = 0
        j = len(s) - 1

        while i < j:
            s[i], s[j] = s[j], s[i]

            i += 1
            j -= 1


if __name__ == '__main__':
    c = Problem344EasyReverseStringTest()

    s = 'hello'
    sl = []
    for i in s:
        sl.append(i)

    c.reverseString(sl)

    print(sl)
