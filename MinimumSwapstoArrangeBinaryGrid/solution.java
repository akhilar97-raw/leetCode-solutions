package MinimumSwapstoArrangeBinaryGrid;

import java.util.Arrays;

public class solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
      
        // Store the rightmost position of 1 in each row
        // If a row has all zeros, it will remain -1
        int[] rightmostOnePosition = new int[n];
        Arrays.fill(rightmostOnePosition, -1);
      
        // Find the rightmost 1 in each row
        for (int row = 0; row < n; ++row) {
            for (int col = n - 1; col >= 0; --col) {
                if (grid[row][col] == 1) {
                    rightmostOnePosition[row] = col;
                    break;
                }
            }
        }
      
        int totalSwaps = 0;
      
        // For each row position, find a suitable row that can be placed there
        for (int targetRow = 0; targetRow < n; ++targetRow) {
            int foundRowIndex = -1;
          
            // Search for a row that can be placed at targetRow position
            // A row can be placed at position i if its rightmost 1 is at position <= i
            for (int candidateRow = targetRow; candidateRow < n; ++candidateRow) {
                if (rightmostOnePosition[candidateRow] <= targetRow) {
                    // Found a suitable row, count the swaps needed
                    totalSwaps += candidateRow - targetRow;
                    foundRowIndex = candidateRow;
                    break;
                }
            }
          
            // If no suitable row found, it's impossible to form upper triangular matrix
            if (foundRowIndex == -1) {
                return -1;
            }
          
            // Bubble the found row up to its target position
            // by swapping it with each row above it
            for (int currentPos = foundRowIndex; currentPos > targetRow; --currentPos) {
                int temp = rightmostOnePosition[currentPos];
                rightmostOnePosition[currentPos] = rightmostOnePosition[currentPos - 1];
                rightmostOnePosition[currentPos - 1] = temp;
            }
        }
      
        return totalSwaps;
    }
}

