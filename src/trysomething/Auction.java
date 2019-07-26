package trysomething;

public class Auction implements Observer {

    private String name;
    private Item item;
    private double bid;


    public Auction(String name){
        this.name = name;
    }
    @Override
    public void update() {
        System.out.println(item.getNameOfTheItem());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
        notify();
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double amount) {
        this.bid = amount;
        item.notyfy();
    }
}
