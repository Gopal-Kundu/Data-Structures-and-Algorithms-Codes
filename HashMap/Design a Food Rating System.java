//https://leetcode.com/problems/design-a-food-rating-system/

class foodRatingPair{
    String food;
    int rating;
    foodRatingPair(String food, int rating){
        this.food = food;
        this.rating = rating;
    }
}
class FoodRatings {
    HashMap<String, PriorityQueue<foodRatingPair>> map = new HashMap<>();
    HashMap<String, Integer> ratingMap = new HashMap<>();
    HashMap<String, String> foodCuisine = new HashMap<>();
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map = new HashMap<>();
        for(String cuisine : cuisines) map.put(cuisine, new PriorityQueue<>((a,b)->{
            if(a.rating == b.rating) return (a.food).compareTo(b.food);
            return Integer.compare(b.rating, a.rating);
        }));
        for(int i = 0; i < foods.length; i++){
            map.get(cuisines[i]).offer(new foodRatingPair(foods[i], ratings[i]));
            ratingMap.put(foods[i], ratings[i]);
            foodCuisine.put(foods[i], cuisines[i]);
        }
    }
    
    public void changeRating(String food, int newRating) {
        ratingMap.put(food, newRating);
        map.get(foodCuisine.get(food)).offer(new foodRatingPair(food, newRating));
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<foodRatingPair> pq = map.get(cuisine);
        while(!pq.isEmpty()){
            String food = pq.peek().food;
            int rating = pq.peek().rating;
            if(ratingMap.containsKey(food) && 
            ratingMap.get(food) == rating) return food;
            pq.poll(); 
        }
        return pq.peek().food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */