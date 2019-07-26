import java.util.*;

//subject
public abstract class Item {
    private String name;
    private double startingPrice;
    private double bid = 0;
    private double lastBid = 0;
    private List<Auction> auctioneerList;
    private Map<Auction,Double> auctioneerBid;

    public Item(String name,double startingPrice){
        this.name = name;
        this.startingPrice = startingPrice;
        auctioneerList = new ArrayList<>();
        auctioneerBid = new TreeMap<>();
    }

    public void notifyActioneers(){
        for(Auction auctioneer : auctioneerList){
            auctioneer.update(this);
        }
    }

    public boolean updateBid(double bid){
        if (bid > this.bid) {
            this.bid = bid;
            lastBid = bid;
            addActioneersBids(bid);
            notifyActioneers();
            return true;
        }
        return false;
    }

    public void addActioneersBids(double bid){
        for (Auction auction : auctioneerList){
            if(auction.getCurrentBid() == bid) {
                auctioneerBid.put(auction, bid);
                break;
            }
        }
        System.out.println();
    }

    public void addAuctioneer(Auction auctioneer){
        auctioneerList.add(auctioneer);
    }

    public void removeAuctioneer(Auction auctioneer){
        auctioneerList.remove(auctioneer);
    }

    public void setBid(int bid){
        this.bid = bid;
        lastBid = bid;
        notifyActioneers();
    }

    public double getBid(){
        return bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Auction> getAuctioneerList() {
        return auctioneerList;
    }

    public void setAuctioneerList(List<Auction> auctioneerList) {
        this.auctioneerList = auctioneerList;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public Map<Auction, Double> getAuctioneerBid() {
        return auctioneerBid;
    }

    public void setAuctioneerBid(Map<Auction, Double> auctioneerBid) {
        this.auctioneerBid = auctioneerBid;
    }

    public double getLastBid() {
        return lastBid;
    }

    public void setLastBid(double lastBid) {
        this.lastBid = lastBid;
    }


}
