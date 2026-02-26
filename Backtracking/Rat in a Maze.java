//https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> answer = new ArrayList<>();
        solve(maze, "", answer, 0, 0);
        Collections.sort(answer);
        return answer;
    }
    
    public void solve(int[][] maze, String temp, ArrayList<String> answer, int row, int col){
        if(row < 0 || col < 0 || row >= maze.length || col >= maze[0].length)
            return;
        
        if(maze[row][col] == 0) return;
    
        if(row == maze.length-1 && col == maze[0].length-1){
            answer.add(temp);
            temp = "";
            return;
        }
        
        maze[row][col] = 0;
        
        solve(maze, temp + "U", answer, row-1, col);
        solve(maze, temp + "D", answer, row+1, col);
        solve(maze, temp + "L", answer, row, col-1);
        solve(maze, temp + "R", answer, row, col+1);
        
        maze[row][col] = 1;
        
        return;
    }
}