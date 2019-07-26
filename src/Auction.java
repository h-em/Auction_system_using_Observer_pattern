import javax.swing.*;
import java.util.*;


//observer
public abstract class Auction implements Comparable<Auction> {
    private String name;
    private double bid;
    private double currentBid;
    private Item item;

    public Auction(String name) {
        this.name = name;
    }

    public void update(Item itemWhoTriggred) {
        if (itemWhoTriggred.getBid() == 0) {
            System.out.println("Starting price for "
                    + itemWhoTriggred.getName()
                    + " is " + itemWhoTriggred.getStartingPrice()
                    + " eur.");
        } else {
            Map<Auction,Double> auctioneersBids = itemWhoTriggred.getAuctioneerBid();
            Auction curetAuctioneer = getFirstElement(auctioneersBids);
            if(curetAuctioneer != this) {
                System.out.println(curetAuctioneer.getName() + " bids " + itemWhoTriggred.getBid() + " eur." +
                        "(for " + this.getName() + ")");
            }
        }
    }

    public void makeAnOffer(double auctioneerOffer) {
        this.currentBid = auctioneerOffer;
        if(!item.updateBid(auctioneerOffer)){
            this.bid = item.getLastBid();
        }else{
            this.bid = auctioneerOffer;
        }
    }

    public void setItem(Item itemToAdd) {
        this.item = itemToAdd;
    }

    public void removeAuctionItem() {
        this.item = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(double currentBid) {
        this.currentBid = currentBid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Auction auction = (Auction) o;

        if (Double.compare(auction.bid, bid) != 0) return false;
        if (name != null ? !name.equals(auction.name) : auction.name != null) return false;
        return item != null ? item.equals(auction.item) : auction.item == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(bid);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (item != null ? item.hashCode() : 0);
        return result;
    }

    public int compareTo(Auction auctionToCompare) {
        return (int)(auctionToCompare.getBid() - this.getCurrentBid());
    }

    public Auction getFirstElement(Map<Auction,Double> auctioneersBids){
        Iterator iterator = auctioneersBids.entrySet().iterator();
        Map.Entry<Auction,Double> firstItem = (Map.Entry<Auction, Double>) iterator.next();
        return firstItem.getKey();
    }
}
