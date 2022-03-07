package edu.neu.madcourse.numad22sp_srikanthbanagadi;

public class Weather {
    private String day;

    public Weather(String day, String condition, String maxtemp, String mintemp, String icon) {
        this.day = day;
        this.condition = condition;
        this.maxTemperature = maxtemp;
        this.minTemperature = mintemp;
        this.icon = icon;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
    private String condition;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    private String maxTemperature;
    private String minTemperature;
    private String icon;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(String minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(String maxTemperature) {
        this.maxTemperature = maxTemperature;
    }
}
