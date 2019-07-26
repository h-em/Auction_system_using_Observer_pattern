public class Main {

    public static void main(String[] args) {
        Item car = new Car("Mustang", 2000); //Subject

        Auction jon = new AuctionParticipant("Jon"); //observer
        Auction mike = new AuctionParticipant("Mike");//observer
        Auction marry = new AuctionParticipant("Marry");//observer

        car.addAuctioneer(jon);
        car.addAuctioneer(mike);
        car.addAuctioneer(marry);

        jon.setItem(car);
        mike.setItem(car);
        marry.setItem(car);

        car.notifyActioneers();

        jon.makeAnOffer(2500);
        mike.makeAnOffer(3500);
        mike.makeAnOffer(300);
        jon.makeAnOffer(4500);
        marry.makeAnOffer(39000);
        jon.makeAnOffer(33300);
        marry.makeAnOffer(933000);
        jon.makeAnOffer(994500);
        jon.makeAnOffer(994500);

    }
}
