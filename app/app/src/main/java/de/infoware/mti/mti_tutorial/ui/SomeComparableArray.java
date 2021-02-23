package de.infoware.mti.mti_tutorial.ui;

public class SomeComparableArray implements Comparable{
    private int someValue = 0;

    public SomeComparableArray() {
        this.someValue = someValue;
    }

    public String getButtonTitle() {
        return "The Button Title";
    }

    public void setSomeValue(int someValue) {
        this.someValue = someValue;
    }


    public int getSomeValue() {
        return someValue;
    }

    @Override
    public int compareTo(Object o) {
        SomeComparableArray other = (SomeComparableArray) o;
        return 0;
    }
}