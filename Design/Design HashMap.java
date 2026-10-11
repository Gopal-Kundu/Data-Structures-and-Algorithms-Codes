https://leetcode.com/problems/design-hashmap/description/

class Pair{
    int key;
    int value;
    Pair(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {
    private List<List<Pair>> buckets;
    public MyHashMap() {
        buckets = new ArrayList<>();
        for(int i = 0; i < 10000; i++)
            buckets.add(new LinkedList<>());
    }
    
    int hash(int key){
        return key%10000;
    }
    public void put(int key, int value) {
        int index = hash(key);
        for(Pair pair : buckets.get(index)){
            if(pair.key == key){
                pair.value = value;
                return;
            }
        }
        buckets.get(index).add(new Pair(key, value));
    }
    
    public int get(int key) {
        int index = hash(key);
        for(Pair pair : buckets.get(index)){
            if(pair.key == key){
                return pair.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);
        List<Pair> bucket = buckets.get(index);
        int size = bucket.size();
        for(int i = 0; i < size; i++){
            if(bucket.get(i).key == key){
                bucket.remove(i);
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */