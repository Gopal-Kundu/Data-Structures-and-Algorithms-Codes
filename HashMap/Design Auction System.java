//https://leetcode.com/problems/design-auction-system/

class UserWithId implements Comparable<UserWithId>{
    int userId = 0;
    int bitAmount = 0;
    public UserWithId(int user, int amount){
        userId = user;
        bitAmount = amount;
    }
    public int compareTo(UserWithId obj){
        if (this.bitAmount != obj.bitAmount)
            return obj.bitAmount - this.bitAmount;
        return obj.userId - this.userId;
    }
}
class AuctionSystem {
    HashMap<Integer, Map<Integer, Integer>> itemsWithUserIdsMap;
    HashMap<Integer, TreeSet<UserWithId>> itemsWithUserIdsSet;
    public AuctionSystem() {
        itemsWithUserIdsSet = new HashMap<>();
        itemsWithUserIdsMap = new HashMap<>();
    }
    
    public void addBid(int userId, int itemId, int bidAmount) {
        if(!itemsWithUserIdsMap.containsKey(itemId)){
            itemsWithUserIdsSet.put(itemId, new TreeSet<>());
            itemsWithUserIdsMap.put(itemId, new HashMap<>());
            itemsWithUserIdsSet.get(itemId).add(new UserWithId(userId, bidAmount));
            itemsWithUserIdsMap.get(itemId).put(userId, bidAmount);
            return;
        }

        if(!itemsWithUserIdsMap.get(itemId).containsKey(userId)){
            itemsWithUserIdsMap.get(itemId).put(userId, bidAmount);
            itemsWithUserIdsSet.get(itemId).add(new UserWithId(userId, bidAmount));
            return;
        }

        int amount = itemsWithUserIdsMap.get(itemId).get(userId); 
        itemsWithUserIdsSet.get(itemId).remove(new UserWithId(userId, amount));

        itemsWithUserIdsSet.get(itemId).add(new UserWithId(userId, bidAmount));
        itemsWithUserIdsMap.get(itemId).put(userId, bidAmount);
    }
    
    public void updateBid(int userId, int itemId, int newAmount) {
        addBid(userId, itemId, newAmount);
    }
    
    public void removeBid(int userId, int itemId) {
        int amount = itemsWithUserIdsMap.get(itemId).get(userId); 
        itemsWithUserIdsSet.get(itemId).remove(new UserWithId(userId, amount));
    }
    
    public int getHighestBidder(int itemId) {
        if(!itemsWithUserIdsMap.containsKey(itemId)) return -1;
        int idx = 0;
        int userId = -1;
        for(UserWithId user : itemsWithUserIdsSet.get(itemId)){
            if(idx == 1) break;
            idx++;
            userId = user.userId;
        }
        return userId;
    }
}
