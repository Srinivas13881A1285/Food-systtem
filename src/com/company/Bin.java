package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class Bin {
    private String location;
    private String description;
    private CannedFood[] stock;

    private static final int size = 10;
    private int stockIndex = -1;

    public Bin(String location, String description) {
        this.stock = new CannedFood[10];
        this.location = location;
        this.description = description;
    }

    public boolean addCannedFood(CannedFood cannedFood) {
        if (stockIndex >= size - 1){
            System.out.println("Already " + cannedFood.getDescription() + " Bin is full");
            return false;
        }

        stock[++stockIndex] = cannedFood;
        System.out.println("Stock size in " + cannedFood.getDescription() + " Bin now : " + (stockIndex + 1));
        return true;
    }

    public CannedFood getCannedFood() {
        if (stockIndex == -1){
            System.out.println("No stock in this bin");
            return null;
        }

        CannedFood nearestExpireDateFood = getNearestExpireDateFood(stock);

        if (nearestExpireDateFood != null) {
            int index = getIndex(nearestExpireDateFood);
            swap(index,stockIndex);
        }

        CannedFood food = stock[stockIndex];
        stock[stockIndex] = null;
        stockIndex--;
        System.out.println("Stock size in bin now : " + (stockIndex + 1));

        return food;
    }

    public void removeCannedFood(CannedFood cannedFood){
        int index = getIndex(cannedFood);
        swap(index,stockIndex);
        stock[stockIndex] = null;
        stockIndex--;
    }

    private void swap(int index, int stockIndex) {
        CannedFood temp;

        temp = stock[index];
        stock[index] = stock[stockIndex];
        stock[stockIndex] = temp;
    }

    private int getIndex(CannedFood nearestExpireDateFood) {
        int i;

        for (i = 0; i < stockIndex; i++) {
            if (nearestExpireDateFood.getId().equals(stock[i]))
                break;
        }
        return i;
    }

    private CannedFood getNearestExpireDateFood(CannedFood[] stock) {
        Comparator<CannedFood> yearComparator = (food1, food2) -> food1.getExpiryDate().getYear() - food2.getExpiryDate().getYear();
        Comparator<CannedFood> monthComparator = (food1, food2) -> food1.getExpiryDate().getMonth() - food2.getExpiryDate().getMonth();
        Comparator<CannedFood> dayComparator = (food1, food2) -> food1.getExpiryDate().getDay() - food2.getExpiryDate().getDay();


        Optional<CannedFood> max = Stream.of(stock).filter(food -> food != null).min(yearComparator.thenComparing(monthComparator.thenComparing(dayComparator)));
        if (max.isPresent())
            return max.get();
        else
            return null;
    }


    @Override
    public String toString() {
        return "Bin{" +
                "location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + Arrays.toString(stock) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bin bin = (Bin) o;
        return stockIndex == bin.stockIndex &&
                Objects.equals(location, bin.location) &&
                Objects.equals(description, bin.description) &&
                Arrays.equals(stock, bin.stock);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(location, description);
        result = 31 * result + Arrays.hashCode(stock);
        return result;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CannedFood[] getStock() {
        return stock;
    }

    public void setStock(CannedFood[] stock) {
        this.stock = stock;
    }
}
