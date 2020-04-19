//Probleem link: https://leetcode.com/problems/zigzag-iterator/
//Time complexity: O(1)
//Space complexity: O(m+n)

public class ZigzagIterator {

    List<Integer> list1;
    List<Integer> list2;
    boolean isList1;
    int cur1, cur2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list1 = v1;
        list2 = v2;
        cur1 = 0;
        cur2 = 0;
        isList1 = true;
    }

    public int next() {
        if(cur1 >= list1.size()) {
            return list2.get(cur2++);
        }
        if(cur2 >= list2.size()) {
            return list1.get(cur1++);
        }
        if(isList1) {
            isList1 = false;
            return list1.get(cur1++);
        }
        isList1 = true;
        return list2.get(cur2++);
    }

    public boolean hasNext() {
        return cur1<list1.size() || cur2<list2.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
