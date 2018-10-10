import java.util.*;

public class kcz223_game_of_rock {
    public static void main(String[] args) {
        int numberOfIterations = 10;

        System.out.println("First Generation");
        boardMaker test = new boardMaker();
        test.printToString();
        test.printToDetail();
        // test.printToVeryDetail();
        for (int i = 0; i < numberOfIterations; i++) {
            System.out.println("");
            System.out.println("Next Generation");
            test = nextGeneration(test.getGrid(), test.getGridSize());
            test.printToString();
            test.printToDetail();
            // test.printToVeryDetail();
        }

    }

    // Function to print next generation
    static boardMaker nextGeneration(cellObject grid[][], int gridSize) {
        // 
        
        int lionSpread = 15;
        int cowSpread = 30;
        int grassSpread = 30;
        int fernSpread = 15;


        cellObject[][] future = new cellObject[gridSize][gridSize];
        int M = gridSize;
        int N = gridSize;

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                future[i][j] = new cellObject();
            }
        }

        // M = grid height
        // N = grid width

        // Loop through every cell
        for (int l = 0; l < gridSize; l++) {
            for (int m = 0; m < gridSize; m++) {
                // subtract 1 from year
                HashMap<String, Integer> cellDict = grid[l][m].getDict();
                String key = "Lion";
                if (cellDict.get(key) > 0) {
                    cellDict.put(key, cellDict.get(key) - 1);
                }
                key = "Cow";
                if (cellDict.get(key) > 0) {
                    cellDict.put(key, cellDict.get(key) - 1);
                }

                key = "Grass";
                if (cellDict.get(key) > 0) {
                    cellDict.put(key, cellDict.get(key) - 1);
                }

                key = "Fern";
                if (cellDict.get(key) > 0) {
                    cellDict.put(key, cellDict.get(key) - 1);
                }

                // eating interaction
                if (cellDict.get("Lion") > 0 && cellDict.get("Cow") > 0) {
                    // lion eats cow
                    cellDict.put("Cow", -1);
                }

                if (cellDict.get("Cow") > 0 && cellDict.get("Grass") > 0) {
                    // cow eats grass
                    cellDict.put("Grass", -1);
                }

                // reproduction interaction

                    // iterate through all surrouding cells
                    for (int i = -1; i <= 1; i++)
                        for (int j = -1; j <= 1; j++)
                            // tests for edge
                            try {
                                if (grid[l + i][m + j] == null) {
                                    // do nothing
                                } else if (grid[l + i][m + j] == grid[l][m]) {
                                    // do nothing
                                    // ignore self
                                } else {


                                    // if lion on last life
                                    if (cellDict.get("Lion") >= 1) {

                                        // sets random chance for reproduction
                                        Random r = new Random();
                                        int randomInt = r.nextInt(101);

                                        HashMap<String, Integer> spreadDict = grid[l + i][m + j].getDict();
                                        if (randomInt <= lionSpread) {

                                            // inserts a new lion if no lion
                                            if (spreadDict.get("Lion") <= 0) {
                                                spreadDict.put("Lion", 4);
                                            }
                                        } else {
                                            // do nothing
                                        }

                                        grid[l + i][m + j].setDict(spreadDict);

                                    }

                                    // if cow on last life
                                    if (cellDict.get("Cow") >= 1) {

                                        // sets random chance for reproduction
                                        Random r = new Random();
                                        int randomInt = r.nextInt(101);

                                        HashMap<String, Integer> spreadDict = grid[l + i][m + j].getDict();
                                        if (randomInt <= cowSpread) {

                                            // inserts a new lion if no lion
                                            if (spreadDict.get("Cow") <= 0) {
                                                spreadDict.put("Cow", 3);
                                            }
                                        } else {
                                            // do nothing
                                        }

                                        grid[l + i][m + j].setDict(spreadDict);

                                    }

                                    // if grass on last life
                                    if (cellDict.get("Grass") == 1) {

                                        // sets random chance for reproduction

                                        Random r = new Random();
                                        int randomInt = r.nextInt(101);

                                        HashMap<String, Integer> spreadDict = grid[l + i][m + j].getDict();
                                        if (randomInt <= grassSpread) {

                                            // inserts a new lion if no lion
                                            if (spreadDict.get("Grass") <= 0) {
                                                spreadDict.put("Grass", 2);
                                            }
                                        } else {
                                            // do nothing
                                        }

                                        grid[l + i][m + j].setDict(spreadDict);

                                    }

                                    // if fern on last life
                                    if (cellDict.get("Fern") == 1) {

                                        // sets random chance for reproduction

                                        Random r = new Random();
                                        int randomInt = r.nextInt(101);

                                        HashMap<String, Integer> spreadDict = grid[l + i][m + j].getDict();
                                        if (randomInt <= fernSpread) {

                                            // inserts a new lion if no lion
                                            if (spreadDict.get("Fern") <= 0) {
                                                spreadDict.put("Fern", 2);
                                            }
                                        } else {
                                            // do nothing
                                        }

                                        grid[l + i][m + j].setDict(spreadDict);

                                    }

                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                                // lol do nothing

                            }

                

                future[l][m] = new cellObject(cellDict);
            }
        }

        boardMaker returnBoard = new boardMaker(future, gridSize);
        return returnBoard;

    }

}

class boardMaker {
    private int gridSize = 7;
    private cellObject[][] grid;

    private int percLion = 40; // 40
    private int percCow = 30; // 30
    private int percFern = 20; // 20
    private int percGrass = 8; // 8

    // classic constructor
    // public boardMaker () {
    // this.gridSize = 10;
    // this.grid = new cellObject [this.gridSize][this.gridSize];

    // for (int i = 0; i < this.gridSize; i++)
    // {
    // for (int j = 0; j < this.gridSize; j++)
    // {
    // this.grid[i][j] = new cellObject();
    // }
    // }
    // }

    public boardMaker() {

        // default grid size 7
        this.gridSize = 7;
        this.grid = new cellObject[this.gridSize][this.gridSize];

        for (int i = 0; i < this.gridSize; i++) {
            for (int j = 0; j < this.gridSize; j++) {
                boolean percLion = lifeBool(this.percLion);
                boolean percCow = lifeBool(this.percCow);
                boolean percFern = lifeBool(this.percFern);
                boolean percGrass = lifeBool(this.percGrass);
                this.grid[i][j] = new cellObject(percLion, percCow, percFern, percGrass);
            }
        }
    }

    public boardMaker(cellObject[][] newBoard, int gridSize) {
        this.gridSize = gridSize;
        this.grid = newBoard;
    }

    public boolean lifeBool(int percNoDec) {
        Random r = new Random();
        int randomInt = r.nextInt(101);
        if (randomInt <= percNoDec) {
            return true;
        } else {
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
        for (int i = 0; i < this.gridSize; i++) {
            for (int j = 0; j < this.gridSize; j++) {
                System.out.print(this.grid[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void printToDetail() {
        for (int i = 0; i < this.gridSize; i++) {
            for (int j = 0; j < this.gridSize; j++) {
                this.grid[i][j].toDetailString();
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void printToVeryDetail() {
        for (int i = 0; i < this.gridSize; i++) {
            for (int j = 0; j < this.gridSize; j++) {
                this.grid[i][j].toVeryDetailString();
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

class cellObject {
    private HashMap<String, Integer> dictionary;
    private String name;
    // Map<String, Integer/null> dictionary = new HashMap<String, String>();
    // dictionary.put("lifeForm", "age");
    // String age = dictionary.get("lifeForm");

    public cellObject() {
        HashMap<String, Integer> myMap = new HashMap<String, Integer>() {
            {
                put("Lion", 4);
                put("Cow", 3);
                put("Fern", 2);
                put("Grass", 2);
            }
        };

        this.dictionary = myMap;
    }

    public cellObject(boolean lion, boolean cow, boolean fern, boolean grass) {
        HashMap<String, Integer> myMap = new HashMap<String, Integer>() {
            {
                if (lion == true) {
                    put("Lion", 4);
                } else {
                    put("Lion", 0);
                }

                if (cow == true) {
                    put("Cow", 3);
                } else {
                    put("Cow", 0);
                }

                if (fern == true) {
                    put("Fern", 2);
                } else {
                    put("Fern", 0);
                }

                if (grass == true) {
                    put("Grass", 2);
                } else {
                    put("Grass", 0);
                }
            }
        };

        this.dictionary = myMap;
    }

    public cellObject(HashMap<String, Integer> cellDict) {
        String key = "Lion";
        if (cellDict.get(key) <= 0) {
            cellDict.put(key, 0);
        }

        key = "Cow";
        if (cellDict.get(key) <= 0) {
            cellDict.put(key, 0);
        }

        key = "Grass";
        if (cellDict.get(key) <= 0) {
            cellDict.put(key, 0);
        }

        key = "Fern";
        if (cellDict.get(key) <= 0) {
            cellDict.put(key, 0);
        }

        this.dictionary = cellDict;
    }

    public HashMap<String, Integer> getDict() {
        return this.dictionary;
    }

    public void setDict(HashMap<String, Integer> newDict) {
        this.dictionary = newDict;
    }

    public Integer getValue(String life) {
        return dictionary.get(life);
    }

    public String toString() {
        if (dictionary.get("Lion") != 0) {
            return ("L" + (dictionary.get("Lion")));
            // return ("L" + (4 - dictionary.get("Lion")));
        } else if (dictionary.get("Cow") != 0) {
            return ("C" + (dictionary.get("Cow")));
            // return ("C" + (3 - dictionary.get("Cow")));
        } else if (dictionary.get("Grass") != 0) {
            return ("G" + (dictionary.get("Grass")));
            // return ("G" + (2 - dictionary.get("Grass")));
        } else if (dictionary.get("Fern") != 0) {
            return ("F" + (dictionary.get("Fern")));
            // return ("F" + (2 - dictionary.get("Fern")));
        } else {

            return "**";
        }
    }

    public void toDetailString() {
        if (dictionary.get("Lion") > 0) {
            System.out.print("L");
        } else {
            System.out.print("*");
        }

        if (dictionary.get("Cow") > 0) {
            System.out.print("C");
        } else {
            System.out.print("*");
        }

        if (dictionary.get("Grass") > 0) {
            System.out.print("G");
        } else {
            System.out.print("*");
        }

        if (dictionary.get("Fern") > 0) {
            System.out.print("F");
        } else {
            System.out.print("*");
        }
    }

    public void toVeryDetailString() {
        if (dictionary.get("Lion") != 0) {
            System.out.print("L" + (dictionary.get("Lion")));
            // System.out.print ("L" + (4 - dictionary.get("Lion")));
        } else {
            System.out.print("**");
        }
        if (dictionary.get("Cow") != 0) {
            System.out.print("C" + (dictionary.get("Cow")));
            // System.out.print ("C" + (3 - dictionary.get("Cow")));
        } else {
            System.out.print("**");
        }
        if (dictionary.get("Grass") != 0) {
            System.out.print("G" + (dictionary.get("Grass")));
            // System.out.print ("G" + (2 - dictionary.get("Grass")));
        } else {
            System.out.print("**");
        }
        if (dictionary.get("Fern") != 0) {
            System.out.print("F" + (dictionary.get("Fern")));
            // System.out.print ("F" + (2 - dictionary.get("Fern")));
        } else {
            System.out.print("**");
        }
    }
}