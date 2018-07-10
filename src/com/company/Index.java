package com.company;

/**
 * Created by Loky on 10/07/2018.
 */
public class Index {
    private int currentIndex = 0;
    private int maxIndex;

    public Index(int[] array) {
        this.maxIndex = array.length-1;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public int getMaxIndex() {
        return maxIndex;
    }
}
