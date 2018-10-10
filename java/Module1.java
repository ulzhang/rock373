class Plant {
    private String name;

    public Plant(){
        this.name = "plant";
    }

}

interface Carnivorous {
    public void eat();
}

// inheritance
class flyTrap extends Plant implements Carnivorous {
    private String name;
    private int bugsEaten;
    
    public flyTrap(){
        this.name = "plant";
        this.bugsEaten = 0;
    }

    // overloaded constructor
    public flyTrap(String name){
        this.name = name;
        this.bugsEaten = 0;
    }
    
    // overwritten method
    public void eat() {
        System.out.println("CHOMP CHOMP");
        this.bugsEaten += 1;
    }

    // getter
    public int getBugsEaten() {
        return this.bugsEaten;
    }

    // setter
    public void setBugsEaten(int bugs) {
        this.bugsEaten = bugs;
    }


}

class Tester {
    public static void main (String [] args) {
        Plant p1 = new Plant();
        flyTrap p3 = new flyTrap();

        System.out.println(p3.getBugsEaten());
        p3.setBugsEaten(5);
        System.out.println(p3.getBugsEaten());
        p3.eat();
        System.out.println(p3.getBugsEaten());
    }
}