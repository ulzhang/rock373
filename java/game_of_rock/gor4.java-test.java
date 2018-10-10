import java.util.*;

public class gor4 {
    public static void main(String[] args) {
        System.out.println("First Generation");
        boardMaker test = new boardMaker();
        test.printToString();
        System.out.println("");
            System.out.println("Next Generation");
        for (int i = 0; i < 11; i++) {
            
            test = nextGeneration(test.getGrid(), test.getGridSize());
            test.printToString();
            System.out.println("");
            System.out.println("Next Generation");
            }


    }

            // Function to print next generation 
            static boardMaker nextGeneration(cellObject grid[][], int gridSize) 
            { 
                cellObject[][] future = new cellObject[gridSize][gridSize]; 
                int M = gridSize;
                int N = gridSize;
    
                for (int i = 0; i < gridSize; i++) 
                { 
                    for (int j = 0; j < gridSize; j++) 
                    { 
                        future[i][j] = new cellObject();
                    } 
                }
    
                // M = grid height
                // N = grid width
          
                // Loop through every cell 
                for (int l = 0; l < gridSize; l++) 
                { 
                    for (int m = 0; m < gridSize; m++) 
                    { 

                        HashMap<String, Integer> cellDict = grid[l][m].getDict();
                        String key = "Lion";
                        if (cellDict.get(key) > 0){
                            cellDict.put(key, cellDict.get(key) - 1);
                        }
                        else {
                            key = "Cow";
                            if (cellDict.get(key) > 0){
                                cellDict.put(key, cellDict.get(key) - 1);
                            }
                            else {
                                key = "Grass";
                                if (cellDict.get(key) > 0){
                                    cellDict.put(key, cellDict.get(key) - 1);
                                }
                                else {
                                    key = "Fern";
                                    if (cellDict.get(key) > 0){
                                        cellDict.put(key, cellDict.get(key) - 1);
                                    }
                                }
                            }
                        }

                        future[l][m] = new cellObject(cellDict);
                    } 
                } 
    
                boardMaker returnBoard = new boardMaker(future, gridSize);
                return returnBoard;
                
            } 

}

class boardMaker {
    private int gridSize;
    private cellObject[][] grid;

    public boardMaker () {
        this.gridSize = 10;
        this.grid = new cellObject [this.gridSize][this.gridSize];
        
        for (int i = 0; i < this.gridSize; i++) 
        { 
            for (int j = 0; j < this.gridSize; j++) 
            { 
                this.grid[i][j] = new cellObject();
            } 
        }
    }

    public boardMaker (cellObject[][] newBoard, int gridSize ) {
        this.gridSize = 10;
        this.grid = newBoard;
    }

    public int getGridSize() {
        return this.gridSize;
    }

    public cellObject[][] getGrid() {
        return this.grid;
    }

    public void printToString() {
        for (int i = 0; i < this.gridSize; i++) 
        { 
            for (int j = 0; j < this.gridSize; j++) 
            { 
                System.out.print(this.grid[i][j]); 
                System.out.print(" "); 
            } 
            System.out.println(); 
        } 
    }
}

class cellObject {
    private HashMap <String, Integer> dictionary;
    private String name;
    // Map<String, Integer/null> dictionary = new HashMap<String, String>();
    // dictionary.put("lifeForm", "age");
    // String age = dictionary.get("lifeForm");

    public cellObject() {
        HashMap<String, Integer> myMap = new HashMap<String, Integer>() {{
            put("Lion", 4);
            put("Cow", 3);
            put("Fern", 2);
            put("Grass", 2);
        }};

        this.dictionary = myMap;
    }

    public cellObject(HashMap<String, Integer> cellDict) {
        String key = "Lion";
        if (cellDict.get(key) <= 0){
            cellDict.put(key, 0);
        }

        key = "Cow";
        if (cellDict.get(key) <= 0){
            cellDict.put(key, 0);
        }

        key = "Grass";
        if (cellDict.get(key) <= 0){
            cellDict.put(key, 0);
        }

        key = "Fern";
        if (cellDict.get(key) <= 0){
            cellDict.put(key, 0);
        }
        
        this.dictionary = cellDict;
    }

    public HashMap<String, Integer> getDict() {
        return this.dictionary;
    }

    public Integer getValue(String life) {
        return dictionary.get(life);
    }

    public String toString() {
        if (dictionary.get("Lion") != 0){
            return ("L" + dictionary.get("Lion"));
        }
        else if (dictionary.get("Cow") != 0){
            return ("C" + dictionary.get("Cow"));
        }
        else if (dictionary.get("Grass") != 0){
            return ("G" + dictionary.get("Grass"));
        }
        else if (dictionary.get("Fern") != 0){
            return ("F" + dictionary.get("Fern"));
        }
        else {
            
            return "XX";
        }
    }
}