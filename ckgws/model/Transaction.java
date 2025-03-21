package model;

public class Transaction {
    private int shopId;
    private String date;
    private double weightIn;
    private double weightOut;

    public Transaction(int shopId, String date, double weightIn, double weightOut) {
        this.shopId = shopId;
        this.date = date;
        this.weightIn = weightIn;
        this.weightOut = weightOut;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getWeightIn() {
        return weightIn;
    }

    public void setWeightIn(double weightIn) {
        this.weightIn = weightIn;
    }

    public double getWeightOut() {
        return weightOut;
    }

    public void setWeightOut(double weightOut) {
        this.weightOut = weightOut;
    }
}
