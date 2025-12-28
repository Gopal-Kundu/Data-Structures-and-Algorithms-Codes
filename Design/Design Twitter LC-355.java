//https://leetcode.com/problems/design-twitter/

class User {
    int userId;
    LinkedList<Tweet> tweets = new LinkedList<>();
    HashSet<Integer> followers = new HashSet<>();
    User(int id){
        this.userId = id;
    }
    void postTweet(Tweet tweet){
        tweets.addFirst(tweet);
    }
    void addFollower(int id){
        followers.add(id);
    }
    void removeFollower(int id){
        followers.remove(id);
    }
}

class Tweet implements Comparable<Tweet>{
    int id;
    int timeStamp;
    Tweet(int userId, int time){
        this.id = userId;
        this.timeStamp = time;
    }
    public int compareTo(Tweet tweet){
        return tweet.timeStamp - this.timeStamp;
    }
}

class Twitter {
    int time = 0;
    HashMap<Integer, User> userMap; 
    public Twitter() {
        userMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            userMap.put(userId, new User(userId));
        }
        time++;
        User currentUser = userMap.get(userId);
        Tweet tweet = new Tweet(tweetId, time);
        currentUser.postTweet(tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>();
        List<Integer> getFeed = new ArrayList<>();
        if(!userMap.containsKey(userId)) return getFeed;
        User currentUser = userMap.get(userId);
        int countTweet = 0;
        for(Tweet tweet : currentUser.tweets){
            countTweet++;
            if(countTweet <= 10)
                pq.offer(tweet);
        } //PQ now has tweet of current user

        for(int follower : currentUser.followers){   
            User currentFollower = userMap.get(follower);
            countTweet = 0; 
            for(Tweet tweet : currentFollower.tweets){
                countTweet++;
                if(countTweet <= 10)
                    pq.offer(tweet);           
            }
        }

        int count = 0;
        while(count < 10 && !pq.isEmpty()){
            Tweet tweet = pq.poll();
            getFeed.add(tweet.id);
            count++;
        }
        return getFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId))
            userMap.put(followerId, new User(followerId));
        if(!userMap.containsKey(followeeId))
            userMap.put(followeeId, new User(followeeId));
        User currentUser = userMap.get(followerId);
        currentUser.addFollower(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)) return;
        User currentUser = userMap.get(followerId);
        currentUser.removeFollower(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */