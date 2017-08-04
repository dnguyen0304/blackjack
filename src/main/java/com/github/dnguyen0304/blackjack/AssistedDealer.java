package com.github.dnguyen0304.blackjack;

public class AssistedDealer implements Dealer {

    private Dealer dealer;
    private ShufflingMachine shuffler;

    public AssistedDealer(Dealer dealer, ShufflingMachine shuffler) {
        this.dealer = dealer;
        this.shuffler = shuffler;
    }

    @Override
    public String getName() {
        return this.dealer.getName();
    }

    @Override
    public int getChipTotal() {
        return this.dealer.getChipTotal();
    }

    @Override
    public void setChipTotal(int chipTotal) {
        this.dealer.setChipTotal(chipTotal);
    }

    @Override
    public BlackjackCard draw() {
        // TODO Auto-generated method stub
        return null;
    }

}
