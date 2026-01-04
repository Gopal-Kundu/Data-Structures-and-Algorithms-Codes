//https://leetcode.com/problems/insert-delete-getrandom-o1/description/
class RandomizedSet {

    HashMap<Integer,Integer> storedDataWithIndex;
    ArrayList<Integer> storedData;
    Random randomObj;
    public RandomizedSet() {
        storedDataWithIndex = new HashMap<>();
        storedData = new ArrayList<>();
        randomObj = new Random();
    }
    
    public boolean insert(int val) {
        if(storedDataWithIndex.containsKey(val)) return false;
        storedData.add(val);
        storedDataWithIndex.put(val, storedData.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(storedDataWithIndex.containsKey(val)){
           
           int indexToDelete = storedDataWithIndex.get(val);
       
           //Shifting the last element to indexToDelete Position.
           int lastValOfArray = storedData.get(storedData.size()-1);
           storedData.set(indexToDelete, lastValOfArray);
           storedDataWithIndex.put(lastValOfArray, indexToDelete);
           //Remove the last val of array.
           storedData.remove(storedData.size()-1);
           storedDataWithIndex.remove(val);
           return true;
        }
        else return false;
    }
    
    public int getRandom() {
        int randomIndex = randomObj.nextInt(storedData.size());
        return storedData.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */