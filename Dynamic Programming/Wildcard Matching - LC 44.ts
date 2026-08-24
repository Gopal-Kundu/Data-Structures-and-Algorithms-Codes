//https://leetcode.com/problems/wildcard-matching/description/

function isMatch(s: string, p: string): boolean {
    const n: number = s.length, m: number = p.length;
    //Define 2d Array
    let dp: (boolean | null)[][] = Array.from({ length: n },
        () => Array(m).fill(null));

    return solve(s, p, n - 1, m - 1, dp);
};

function solve(s: string, p: string, i: number, j: number, dp: (boolean | null)[][]): boolean {
    if (i < 0 && j < 0) return true;
    else if (i >= 0 && j < 0) return false;
    else if (i < 0 && j >= 0) {
        //p can be *, **, ****
        for (let k = 0; k <= j; k++) {
            if (p.charAt(k) !== "*")
                return false;
        }
        return true;
    }
    if (dp[i][j] != null) return dp[i][j];
    let ls: boolean = false;
    let rs: boolean = false;
    if (p.charAt(j) == "?" || s.charAt(i) == p.charAt(j)) {
        //Skip char of i.
        ls = solve(s, p, i - 1, j - 1, dp);
    } else if (p.charAt(j) == "*") {
        rs = solve(s, p, i, j - 1, dp) || solve(s, p, i - 1, j, dp);
    } else if (s.charAt(i) != p.charAt(j)) return false;

    return dp[i][j] = ls || rs;
}