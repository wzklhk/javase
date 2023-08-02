# -*-coding: utf-8-*-
"""
@author wzklhk
@date 2023/8/2
@packageName 
@className Problem141EasyHasCycleTest
"""
from com.example.leetcode.structure.ListNode import ListNode


class Problem141EasyHasCycleTest(object):
    def hasCycle(self, head: ListNode) -> bool:
        """
        :type head: ListNode
        :rtype: bool
        """
        s = set()
        while head is not None:
            if head in s:
                return True
            s.add(head)
            head = head.next
        return False


if __name__ == '__main__':
    l = [1, 2, 3, 4, 5]
    head = ListNode(0)
    p = head
    for i in l:
        p.next = ListNode(i)
        p = p.next

    # p.next = head

    c = Problem141EasyHasCycleTest()
    r = c.hasCycle(head)
    print(r)
