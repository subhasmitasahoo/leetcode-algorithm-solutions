//Problem link: https://leetcode.com/problems/time-based-key-value-store/
//Time complexity: O(logn)
//Space complexity: O(n)

class TimeMap {
    
    Map<String, TreeMap<Integer, String>> m;

    /** Initialize your data structure here. */
    public TimeMap() {
        m = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        m.computeIfAbsent(key, x->new TreeMap()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!m.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> t = m.get(key);
        Integer temp = t.floorKey(timestamp);
        return temp != null ? t.get(temp) : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
