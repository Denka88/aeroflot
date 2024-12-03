import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

public class Flight {
    
    private int flightNumber;
    private String route;
    private String boardingPoints;
    private LocalTime sendTime;
    private Date sendDate;
    private int emptyPlaces;

    public Flight() {
    }

    public Flight(int flightNumber, String route, String boardingPoints, LocalTime sendTime, Date sendDate, int emptyPlaces) {
        this.flightNumber = flightNumber;
        this.route = route;
        this.boardingPoints = boardingPoints;
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

    public String getBoardingPoints() {
        return boardingPoints;
    }

    public void setBoardingPoints(String boardingPoints) {
        this.boardingPoints = boardingPoints;
    }

    public LocalTime getSendTime() {
        return sendTime;
    }

    public void setSendTime(LocalTime sendTime) {
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

    public void setSendDate(java.util.Date date) {

    }
}
