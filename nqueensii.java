//Java Solution

class Solution {
    public int totalNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        
        Set<Integer> diagonal = new HashSet<>();
        Set<Integer> diagonal2 = new HashSet<>();
        Set<Integer> vertical = new HashSet<>();
        int[][] newBoard = new int[n][n];
        int index = 0;
        
        placeQueen(newBoard, index, diagonal, diagonal2, vertical, result);
        return result.size();
    }
    
    public void placeQueen(int[][] board, int i, Set<Integer> diagonal, Set<Integer> diagonal2, Set<Integer> vertical, List<List<String>> result) {
        if (i == board.length) {
            addToList(board, result);
            return;
        }
        
        for (int j = 0; j < board.length; j++) {
            if (!diagonal.contains(i + j) && !diagonal2.contains(j - i) && !vertical.contains(j)) {
                board[i][j] = 1;
                diagonal.add(i + j);
                diagonal2.add(j - i);
                vertical.add(j);
                
                placeQueen(board, i + 1, diagonal, diagonal2, vertical, result);
                
                board[i][j] = 0;
                diagonal.remove(i + j);
                diagonal2.remove(j - i);
                vertical.remove(j);
            }
        }
    }
    
    public void addToList(int[][] board, List<List<String>> result) {
        List<String> solution = new ArrayList<>();
        
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    sb.append('.');
                } else {
                    sb.append('Q');
                }
            }
            
            solution.add(sb.toString());
        }
        
        result.add(solution);
    }
}