package com.ralu.recyclerviewjava;

import android.os.Parcel;
import android.os.Parcelable;

public class Food implements Parcelable {
    String dishName;
    int price, calories;
    double rating;


    protected Food(Parcel in) {
        dishName = in.readString();
        price = in.readInt();
        calories = in.readInt();
        rating = in.readDouble();
    }

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    @Override
    public String toString() {
     return  "Food ( " + dishName + "\" + " +
             ", price " + price +
             ", calories " + calories +
             ", rating " + rating +
             ") ";
    }

    public Food(String dishName, int price, int calories, double rating) {
        this.dishName = dishName;
        this.price = price;
        this.calories = calories;
        this.rating = rating;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(dishName);
        dest.writeString(String.valueOf(price));
        dest.writeString(String.valueOf(calories));
        dest.writeString(String.valueOf(rating));

    }
}
