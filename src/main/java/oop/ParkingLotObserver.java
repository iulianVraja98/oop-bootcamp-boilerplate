package oop;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ParkingLotObserver implements PropertyChangeListener {
    private String news;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.setNews((String) evt.getNewValue());
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
}
