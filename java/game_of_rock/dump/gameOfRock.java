// import java.util.Arrays;

// public class gameOfRock {
//     public static void main(String[] args) {
//         boardMaker test = new boardMaker();
//         test.printToString();



//     }
// }

// class boardMaker {
//     private int gridSize;
//     private int amountIterate;
//     private int msIterate;

//     // private lifeObject[][] grid;
//     private int[][] grid;

//     public boardMaker () {
//         this.gridSize = 5;
//         this.amountIterate = 5;
//         this.msIterate = 100;
//         // this.grid = new lifeObject[this.gridSize][this.gridSize];
//         this.grid = new int[this.gridSize][this.gridSize];
//     }

//     public boardMaker (int gridSize, int amountIterate, int msIterate) {
//         this.gridSize = gridSize;
//         this.amountIterate = amountIterate;
//         this.msIterate = msIterate;
//         // this.grid = new lifeObject[this.gridSize][this.gridSize];
//         this.grid = new int[this.gridSize][this.gridSize];
//     }

//     public void printToString() {
//         for (int i = 0; i < this.gridSize; i++) 
//         { 
//             for (int j = 0; j < this.gridSize; j++) 
//             { 
//                 // String lifeObject = this.grid[i][j].getName();
//                 if (lifeObject == 0) 
//                     System.out.print("."); 
//                 else
//                     System.out.print("*"); 
//             } 
//             System.out.println(); 
//         } 
//     }
// }

// class lifeObject {  
//     private String charName;

//     public lifeObject () {
//         this.charName = "A";
//     }

//     public String getName() {
//         return this.charName;
//     }
// }