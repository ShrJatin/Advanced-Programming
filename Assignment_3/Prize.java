package Assignment_3;

class Prize {
    private final String prize;
    private final int money;

    Prize(String prize, int money) {
        this.prize = prize;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public String getPrize() {
        return prize;
    }


    @Override
    public boolean equals(Object v) {
        boolean retVal = false;

        if (v instanceof Prize) {
            Prize ptr = (Prize) v;
            retVal = ptr.prize.equals(this.prize);
        }

        return retVal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.prize != null ? this.prize.hashCode() : 0);
        return hash;
    }
}
