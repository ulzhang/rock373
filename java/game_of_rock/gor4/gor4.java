import java.util.*;

public class gor4 {
    public static void main(String[] args) {
        System.out.println("First Generation");
        boardMaker test = new boardMaker();
        test.printToString();
        // test.printToDetail();
        test.printToVeryDetail();
        for (int i = 0; i < 11; i++) {
            System.out.println("");
            System.out.println("Next Generation");
            test = nextGeneration(test.getGrid(), test.getGridSize());
            test.printToString();
            // test.printToDetail();
            test.printToVeryDetail();
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
                        // subtract 1 from year
                        HashMap<String, Integer> cellDict = grid[l][m].getDict();
                        String key = "Lion";
                        if (cellDict.get(key) > 0){
                            cellDict.put(key, cellDict.get(key) - 1);
                        }
                        key = "Cow";
                        if (cellDict.get(key) > 0){
                            cellDict.put(key, cellDict.get(key) - 1);
                        }

                        key = "Grass";
                        if (cellDict.get(key) > 0){
                            cellDict.put(key, cellDict.get(key) - 1);
                        }

                        key = "Fern";
                        if (cellDict.get(key) > 0){
                            cellDict.put(key, cellDict.get(key) - 1);
                        }

                        // eating interaction
                        if (cellDict.get("Lion") > 0 && cellDict.get("Cow") > 0){
                            // lion eats cow
                            cellDict.put("Cow", 0);
                        }

                        if (cellDict.get("Cow") > 0 && cellDict.get("Grass") > 0){
                            // cow eats grass
                            cellDict.put("Grass", 0);
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

    private int percLion = 40;
    private int percCow = 30;
    private int percFern = 20;
    private int percGrass = 8;

    // classic constructor
    // public boardMaker () {
    //     this.gridSize = 10;
    //     this.grid = new cellObject [this.gridSize][this.gridSize];
        
    //     for (int i = 0; i < this.gridSize; i++) 
    //     { 
    //         for (int j = 0; j < this.gridSize; j++) 
    //         { 
    //             this.grid[i][j] = new cellObject();
    //         } 
    //     }
    // }

    public boardMaker () {
        this.gridSize = 10;
        this.grid = new cellObject [this.gridSize][this.gridSize];
        
        for (int i = 0; i < this.gridSize; i++) 
        { 
            for (int j = 0; j < this.gridSize; j++) 
            { 
                boolean percLion = lifeBool(this.percLion);
                boolean percCow = lifeBool(this.percCow);
                boolean percFern = lifeBool(this.percFern);
                boolean percGrass = lifeBool(this.percGrass);
                this.grid[i][j] = new cellObject(percLion, percCow, percFern, percGrass);
            } 
        }
    }

    public boardMaker (cellObject[][] newBoard, int gridSize ) {
        this.gridSize = 10;
        this.grid = newBoard;
    }

    public boolean lifeBool(int percNoDec) {
        Random r = new Random();
        int randomInt = r.nextInt(101);
        if (randomInt <= percNoDec) {
            return true;
        }
        else {
            return false;
        }
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

    public void printToDetail() {
        for (int i = 0; i < this.gridSize; i++) 
        { 
            for (int j = 0; j < this.gridSize; j++) 
            { 
                this.grid[i][j].toDetailString(); 
                System.out.print(" "); 
            } 
            System.out.println(); 
        } 
    }

    public void printToVeryDetail() {
        for (int i = 0; i < this.gridSize; i++) 
        { 
            for (int j = 0; j < this.gridSize; j++) 
            { 
                this.grid[i][j].toVeryDetailString(); 
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

    public cellObject(boolean lion, boolean cow, boolean fern, boolean grass) {
        HashMap<String, Integer> myMap = new HashMap<String, Integer>() {{
            if (lion == true){
                put("Lion", 4);
            }
            else {
                put("Lion", 0);
            }
            
            if (cow == true){
            put("Cow", 3);
            }
            else {
                put("Cow", 0);
            }

            if (fern == true){
            put("Fern", 2);
            }
            else {
                put("Fern", 0);
            }

            if (grass == true){
            put("Grass", 2);
            }
            else {
                put("Grass", 0);
            }
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
            return ("L" + (dictionary.get("Lion")));
            //return ("L" + (4 - dictionary.get("Lion")));
        }
        else if (dictionary.get("Cow") != 0){
            return ("C" + (dictionary.get("Cow")));
            // return ("C" + (3 - dictionary.get("Cow")));
        }
        else if (dictionary.get("Grass") != 0){
            return ("G" + (dictionary.get("Grass")));
            // return ("G" + (2 - dictionary.get("Grass")));
        }
        else if (dictionary.get("Fern") != 0){
            return ("F" + (dictionary.get("Fern")));
            // return ("F" + (2 - dictionary.get("Fern")));
        }
        else {
            
            return "XX";
        }
    }

    public void toDetailString() {
        if (dictionary.get("Lion") > 0){
            System.out.print ("L");
        }
        else {
            System.out.print  ("X");
        }

        if (dictionary.get("Cow") > 0){
            System.out.print  ("C");
        }
        else {
            System.out.print  ("X");
        }

        if (dictionary.get("Grass") > 0){
            System.out.print  ("G");
        }
        else {
            System.out.print  ("X");
        }

        if (dictionary.get("Fern") > 0){
            System.out.print  ("F");
        }
        else {
            System.out.print  ("X");
        }
    }

    public void toVeryDetailString() {
        if (dictionary.get("Lion") != 0){
            System.out.print ("L" + (dictionary.get("Lion")));
            // System.out.print ("L" + (4 - dictionary.get("Lion")));
        }
        else {           
            System.out.print("XX");
        }
         if (dictionary.get("Cow") != 0){
            System.out.print ("C" + (dictionary.get("Cow")));
            //System.out.print ("C" + (3 - dictionary.get("Cow")));
        }
        else {           
            System.out.print("XX");
        }
         if (dictionary.get("Grass") != 0){
            System.out.print ("G" + ( dictionary.get("Grass")));
            //System.out.print ("G" + (2 - dictionary.get("Grass")));
        }
        else {           
            System.out.print("XX");
        }
         if (dictionary.get("Fern") != 0){
            System.out.print ("F" + (2 - dictionary.get("Fern")));
            //System.out.print ("F" + (2 - dictionary.get("Fern")));
        }
        else {           
            System.out.print("XX");
        }
    }
}