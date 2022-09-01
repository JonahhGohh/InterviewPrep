package LeetCode;

public class TimeBasedKeyValueStore {
    class TimeMap {
        HashMap<String, List<Pair>> hashMap;
        public TimeMap() {
            hashMap = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            Pair pair = new Pair(value, timestamp);
            List<Pair> lst = hashMap.get(key);

            if (lst == null) {
                List<Pair> newLst = new ArrayList<>();
                newLst.add(pair);
                hashMap.put(key, newLst);
            } else {
                lst.add(pair);
            }
        }

        public String get(String key, int timestamp) {
            List<Pair> lst = hashMap.get(key);
            if (lst == null) {
                return "";
            }
            return binarySearch(lst, timestamp);
        }

        String binarySearch(List<Pair> lst, int timestamp) {
            int start = 0;
            int end = lst.size() - 1;
            String res = "";
            while (start <= end) {
                int middle = (start + end) / 2;
                Pair pair = lst.get(middle);
                if (pair.timestamp == timestamp) return pair.value;
                if (pair.timestamp < timestamp) {
                    start = middle + 1;
                    res = pair.value;
                } else {
                    end = middle - 1;
                }
            }
            return res;
        }
    }

    class Pair {
        public String value;
        public int timestamp;

        public Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
}
