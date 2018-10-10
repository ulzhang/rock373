import java.util.*;

public class gor2 {
    public static void main(String[] args) {
        boardMaker test = new boardMaker();
        test.printToString();
        boardMaker test1 = nextGeneration(test.getGrid(), test.getGridSize());
        boardMaker test2 = nextGeneration(test1.getGrid(), test1.getGridSize());
        boardMaker test3 = nextGeneration(test2.getGrid(), test2.getGridSize());

    }


        // Function to print next generation 
        static boardMaker nextGeneration(int grid[][], int gridSize) 
        { 
            int[][] future = new int[gridSize][gridSize]; 
            int M = gridSize;
            int N = gridSize;
      
            // Loop through every cell 
            for (int l = 1; l < M - 1; l++) 
            { 
                for (int m = 1; m < N - 1; m++) 
                { 
                    // finding no Of Neighbours that are alive 
                    int aliveNeighbours = 0; 
                    for (int i = -1; i <= 1; i++) 
                        for (int j = -1; j <= 1; j++) 
                            aliveNeighbours += grid[l + i][m + j]; 
      
                    // The cell needs to be subtracted from 
                    // its neighbours as it was counted before 
                    aliveNeighbours -= grid[l][m]; 
      
                    // Implementing the Rules of Life 
      
                    // Cell is lonely and dies 
                    if ((grid[l][m] == 1) && (aliveNeighbours < 2)) 
                        future[l][m] = 0; 
      
                    // Cell dies due to over population 
                    else if ((grid[l][m] == 1) && (aliveNeighbours > 3)) 
                        future[l][m] = 0; 
      
                    // A new cell is born 
                    else if ((grid[l][m] == 0) && (aliveNeighbours == 3)) 
                        future[l][m] = 1; 
      
                    // Remains the same 
                    else
                        future[l][m] = grid[l][m]; 
                } 
            } 
      
            System.out.println("Next Generation"); 
            for (int i = 0; i < M; i++) 
            { 
                for (int j = 0; j < N; j++) 
                { 
                    if (future[i][j] == 0) 
                        System.out.print("."); 
                    else
                        System.out.print("*"); 
                } 
                System.out.println(); 
            } 

            boardMaker returnBoard = new boardMaker(future, gridSize);
            return returnBoard;
            
        } 
}

class boardMaker {
    private int gridSize;
    private int amountIterate;
    private int msIterate;

    private int percLife;

    // private lifeObject[][] grid;
    private int[][] grid;

    public boardMaker () {
        this.gridSize = 10;
        this.grid = new int[this.gridSize][this.gridSize];
        
        for (int i = 0; i < this.gridSize; i++) 
        { 
            for (int j = 0; j < this.gridSize; j++) 
            { 
                Random r = new Random();
                int randomInt = r.nextInt(2);
                this.grid[i][j]  = randomInt;
            } 
        }

        // // Intiliazing the grid. 
        // int[][] grid = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
        //     { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 }, 
        //     { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, 
        //     { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
        //     { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
        //     { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 }, 
        //     { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 }, 
        //     { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 }, 
        //     { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, 
        //     { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } 
        // }; 

        this.grid = grid;
    }

    public boardMaker (int[][] newBoard, int gridSize ) {
        this.gridSize = 10;
        this.grid = newBoard;
    }

    public int getGridSize() {
        return this.gridSize;
    }

    public int[][] getGrid() {
        return this.grid;
    }

    public void printToString() {
        for (int i = 0; i < this.gridSize; i++) 
        { 
            for (int j = 0; j < this.gridSize; j++) 
            { 
                if (this.grid[i][j] == 0) 
                    System.out.print("."); 
                else
                    System.out.print("*"); 
            } 
            System.out.println(); 
        } 
    }
}