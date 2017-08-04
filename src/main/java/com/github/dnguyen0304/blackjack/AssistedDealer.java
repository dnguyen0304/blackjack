package com.github.dnguyen0304.blackjack;

public class AssistedDealer implements Dealer {

    private Dealer dealer;
    private ShufflingMachine shufflingMachine;

    public AssistedDealer(Dealer dealer, ShufflingMachine shufflingMachine) {
        this.dealer = dealer;
        this.shufflingMachine = shufflingMachine;
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
        return this.dealer.draw();
    }

}
