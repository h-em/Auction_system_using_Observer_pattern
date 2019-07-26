package trysomething;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.util.ArrayList;
import java.util.List;

public class Item implements Observable {
    private String nameOfTheItem;
    private List<AuctionParticipant> observerList;
    private Auction acceptedBid = null;
    private Double startingPrice;

    public Item(String nameOfTheItem) {
        this.nameOfTheItem = nameOfTheItem;
        observerList = new ArrayList<>();
    }

    @Override
    public void add(Observer observer) {
        observerList.add((AuctionParticipant) observer);
    }

    @Override
    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notyfy() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }

    public void acceptBid() {
        double max = 0;
        Auction maxBid = null;

        for (int i = 0; i < observerList.size(); i++) {
            if (max < observerList.get(i).getBid()) {
                max = observerList.get(i).getBid();
                maxBid = observerList.get(i);
            }

            if (maxBid != null) {
                this.acceptedBid = maxBid;
                //this.setChanged();
                this.notyfy();
            }
        }
    }

    public String getNameOfTheItem() {
        return nameOfTheItem;
    }

    public void setNameOfTheItem(String nameOfTheItem) {
        this.nameOfTheItem = nameOfTheItem;
    }

    public List<AuctionParticipant> getObserverList() {
        return observerList;
    }

    public void setObserverList(List<AuctionParticipant> observerList) {
        this.observerList = observerList;
    }

    public Auction getAcceptedBid() {
        return acceptedBid;
    }

    public void setAcceptedBid(Auction acceptedBid) {
        this.acceptedBid = acceptedBid;
    }

    public Double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(Double startingPrice) {
        this.startingPrice = startingPrice;
        this.notyfy();
    }
}
