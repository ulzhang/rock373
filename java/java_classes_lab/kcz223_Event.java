public class kcz223_Event implements kcz223_Sellable {
    private String name;
    private int days;
    private int pricePerDay;

    public kcz223_Event(String addName, int addDay, int pricePerDay) {
        this.name = addName;
        this.days = addDay;
        this.pricePerDay = pricePerDay;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.pricePerDay * this.days;
    }
}