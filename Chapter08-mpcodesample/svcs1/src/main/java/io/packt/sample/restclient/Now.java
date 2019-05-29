package io.packt.sample.restclient;

/**
 * Data object returned by WorldClockApi and TimeService
 */
public class Now {
    String currentDateTime;
    String utcOffset;
    boolean isDayLightSavingsTime;
    String dayOfTheWeek;
    String timeZoneName;

    public String getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(String currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    public String getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(String utcOffset) {
        this.utcOffset = utcOffset;
    }

    public boolean isDayLightSavingsTime() {
        return isDayLightSavingsTime;
    }

    public void setDayLightSavingsTime(boolean dayLightSavingsTime) {
        isDayLightSavingsTime = dayLightSavingsTime;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public String getTimeZoneName() {
        return timeZoneName;
    }

    public void setTimeZoneName(String timeZoneName) {
        this.timeZoneName = timeZoneName;
    }

    @Override
    public String toString() {
        return "Now{" +
                "currentDateTime='" + currentDateTime + '\'' +
                ", utcOffset='" + utcOffset + '\'' +
                ", isDayLightSavingsTime=" + isDayLightSavingsTime +
                ", dayOfTheWeek='" + dayOfTheWeek + '\'' +
                ", timeZoneName='" + timeZoneName + '\'' +
                '}';
    }
}
