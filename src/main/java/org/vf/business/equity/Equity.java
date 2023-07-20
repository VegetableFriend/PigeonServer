package org.vf.business.equity;

public class Equity {
    private String name;

    private int type;

    private int price;

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
