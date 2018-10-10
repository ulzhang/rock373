import java.util.*;

public class gor1 {
    public static void main(String[] args) {
        boardMaker test = new boardMaker();
        test.printToString();

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
        this.gridSize = 3;
        this.amountIterate = 5;
        this.msIterate = 100;
        this.percLife = 50;
        this.grid = new intObject[this.gridSize][this.gridSize];
        
        for (int i = 0; i < this.gridSize; i++) 
        { 
            for (int j = 0; j < this.gridSize; j++) 
            { 
                this.grid[i][j] = new intObject();
            } 
        }
    }

    public void printToString() {
        for (int i = 0; i < this.gridSize; i++) 
        { 
            for (int j = 0; j < this.gridSize; j++) 
            { 
                // String lifeObject = this.grid[i][j].getName();
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
        System.out.println(randomInt);
        this.binary = randomInt;
    }

    public int getInt() {
        return this.binary;
    }

    public String toString() {
        return Integer.toString(this.binary);
    }
}