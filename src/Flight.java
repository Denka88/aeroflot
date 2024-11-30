import java.sql.Date;
import java.sql.Time;

public class Flight {
    
    private int flightNumber;
    private String route;
    private String points;
    private Time sendTime;
    private Date sendDate;
    private int emptyPlaces;

    public Flight() {
    }

    public Flight(int flightNumber, String route, String points, Time sendTime, Date sendDate, int emptyPlaces) {
        this.flightNumber = flightNumber;
        this.route = route;
        this.points = points;
        this.sendTime = sendTime;
        this.sendDate = sendDate;
        this.emptyPlaces = emptyPlaces;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public Time getSendTime() {
        return sendTime;
    }

    public void setSendTime(Time sendTime) {
        this.sendTime = sendTime;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public int getEmptyPlaces() {
        return emptyPlaces;
    }

    public void setEmptyPlaces(int emptyPlaces) {
        this.emptyPlaces = emptyPlaces;
    }
}
