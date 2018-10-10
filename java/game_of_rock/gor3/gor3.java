import java.util.*;

public class gor3 {
    public static void main(String[] args) {
        boardMaker test = new boardMaker();
        test.printToString();
        boardMaker test1 = nextGeneration(test.getGrid(), test.getGridSize());
        boardMaker test2 = nextGeneration(test1.getGrid(), test1.getGridSize());
        boardMaker test3 = nextGeneration(test2.getGrid(), test2.getGridSize());

    }


        // Function to print next generation 
        static boardMaker nextGeneration(intObject grid[][], int gridSize) 
        { 
            intObject[][] future = new intObject[gridSize][gridSize]; 
            int M = gridSize;
            int N = gridSize;

            for (int i = 0; i < gridSize; i++) 
            { 
                for (int j = 0; j < gridSize; j++) 
                { 
                    future[i][j] = new intObject(0);
                } 
            }

            // M = grid height
            // N = grid width
      
            // Loop through every cell 
            for (int l = 1; l < M - 1; l++) 
            { 
                for (int m = 1; m < N - 1; m++) 
                { 
                    // finding no Of Neighbours that are alive 
                    int aliveNeighbours = 0; 
                    for (int i = -1; i <= 1; i++) 
                        for (int j = -1; j <= 1; j++) 
                            if (grid[l + i][m + j].getInt() == 1) {
                                aliveNeighbours += 1; 
                            }
                            
      
                    // The cell needs to be subtracted from 
                    // its neighbours as it was counted before 
                    if (grid[l][m].getInt() == 1) {
                        aliveNeighbours -= 1; 
                    }
      
                    // Implementing the Rules of Life 
      
                    // Cell is lonely and dies 
                    if ((grid[l][m].getInt() == 1) && (aliveNeighbours < 2)) 
                        future[l][m] = new intObject(0); 
      
                    // Cell dies due to over population 
                    else if ((grid[l][m].getInt() == 1) && (aliveNeighbours > 3)) 
                        future[l][m] = new intObject(0); 
      
                    // A new cell is born 
                    else if ((grid[l][m].getInt() == 0) && (aliveNeighbours == 3)) 
                        future[l][m] = new intObject(1); 
      
                    // Remains the same 
                    else
                        future[l][m] = new intObject(grid[l][m].getInt()); 
                } 
            } 
      
            System.out.println("Next Generation"); 
            for (int i = 0; i < gridSize; i++) 
            { 
                for (int j = 0; j < gridSize; j++) 
                { 
                    if (future[i][j].getInt() == 0) 
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
    private intObject[][] grid;

    public boardMaker () {
        this.gridSize = 10;
        this.grid = new intObject [this.gridSize][this.gridSize];
        
        for (int i = 0; i < this.gridSize; i++) 
        { 
            for (int j = 0; j < this.gridSize; j++) 
            { 
                this.grid[i][j] = new intObject();
            } 
        }
    }

    public boardMaker (intObject[][] newBoard, int gridSize ) {
        this.gridSize = 10;
        this.grid = newBoard;
    }

    public int getGridSize() {
        return this.gridSize;
    }

    public intObject[][] getGrid() {
        return this.grid;
    }

    public void printToString() {
        for (int i = 0; i < this.gridSize; i++) 
        { 
            for (int j = 0; j < this.gridSize; j++) 
            { 
                if (this.grid[i][j].getInt() == 0) 
                    System.out.print("."); 
                else
                    System.out.print("*"); 
            } 
            System.out.println(); 
        } 
    }
}

class intObject {
    private int binary;

    public intObject() {
        Random r = new Random();
        int randomInt = r.nextInt(2);
        this.binary = randomInt;
    }

    public intObject(int newInt) {
        this.binary = newInt;
    }

    public int getInt() {
        return this.binary;
    }

    public String toString() {
        return Integer.toString(this.binary);
    }
}