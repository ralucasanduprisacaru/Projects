package com.ralu.webviewssqlite;

import android.os.Parcel;
import android.os.Parcelable;

public class MyContact implements Parcelable {

    private String name, number;

    public MyContact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public static final Creator<MyContact> CREATOR = new Creator<MyContact>() {
        @Override
        public MyContact createFromParcel(Parcel in) {
            return new MyContact(in);
        }

        @Override
        public MyContact[] newArray(int size) {
            return new MyContact[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    protected MyContact(Parcel in) {
        // order matters
        name = in.readString();
        number = in.readString();
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(name);
        dest.writeString(number);
    }
}
