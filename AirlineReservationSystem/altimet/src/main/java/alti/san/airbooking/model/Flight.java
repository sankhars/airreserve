package alti.san.airbooking.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * The type Flight.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "flight")
public class Flight {

    @XmlElement
    @Id
    @Column(name = "flight_no")
    private String flightNumber;

    @XmlElement
    @Column(name = "ticket_price")
    private int price;

    @XmlElement
    @Column(name = "dest_sourcecity")
    private String sourcecity;

    @XmlElement
    @Column(name = "dest_to")
    private String destination;

    @XmlElement
    @Column(name = "departure_time")
    private String departureTime;

    @XmlElement
    @Column(name = "arrival_time")
    private String arrivalTime;

    @XmlElement
    @Column
    private String duration;

    @XmlElement
    @Embedded
    private Plane airlinename;

    @ManyToMany(mappedBy = "flights")
    private List<Reservation> reservations;

    @XmlElement
    @Column(name = "seats_left")
    private int seatsLeft;

    //    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@passengers")
    @XmlElement
    @Transient
    private List<PassengerLtdInfo> passengers;

    /**
     * Instantiates a new Flight.
     */
    public Flight() {
    }

    /**
     * Instantiates a new Flight.
     *
     * @param flightNumber  the flight number
     * @param price         the price
     * @param sourcecity          the sourcecity
     * @param destination            the destination
     * @param departureTime the departure time
     * @param arrivalTime   the arrival time
     * @param duration   the duration
     * @param seatsLeft     the seats left
     * @param airlinename         the airlinename
     */
    public Flight(String flightNumber, int price, String sourcecity, String destination, String departureTime, String arrivalTime,
                  String duration, int seatsLeft, Plane airlinename) {
        this.flightNumber = flightNumber;
        this.price = price;
        this.sourcecity = sourcecity;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
        this.seatsLeft = seatsLeft;
        this.airlinename = airlinename;
    }

    /**
     * Gets flight number.
     *
     * @return the flight number
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Sets flight number.
     *
     * @param flightNumber the flight number
     */
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Gets sourcecity.
     *
     * @return the sourcecity
     */
    public String getFrom() {
        return sourcecity;
    }

    /**
     * Sets sourcecity.
     *
     * @param sourcecity the sourcecity
     */
    public void setFrom(String sourcecity) {
        this.sourcecity = sourcecity;
    }

    /**
     * Gets destination.
     *
     * @return the destination
     */
    public String getdestination() {
        return destination;
    }

    /**
     * Sets destination.
     *
     * @param destination the destination
     */
    public void setTo(String destination) {
        this.destination = destination;
    }

    /**
     * Gets departure time.
     *
     * @return the departure time
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * Sets departure time.
     *
     * @param departureTime the departure time
     */
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * Gets arrival time.
     *
     * @return the arrival time
     */
    public String getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Sets arrival time.
     *
     * @param arrivalTime the arrival time
     */
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * Gets duration.
     *
     * @return the duration
     */
    public String getDescription() {
        return duration;
    }

    /**
     * Sets duration.
     *
     * @param duration the duration
     */
    public void setDescription(String duration) {
        this.duration = duration;
    }

    /**
     * Gets airlinename.
     *
     * @return the airlinename
     */
    public Plane getPlane() {
        return airlinename;
    }

    /**
     * Sets airlinename.
     *
     * @param airlinename the airlinename
     */
    public void setPlane(Plane airlinename) {
        this.airlinename = airlinename;
    }

    /**
     * Gets reservations.
     *
     * @return the reservations
     */
    @JsonIgnore
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Sets reservations.
     *
     * @param reservations the reservations
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    /**
     * Gets seats left.
     *
     * @return the seats left
     */
    public int getSeatsLeft() {
        return seatsLeft;
    }

    /**
     * Sets seats left.
     *
     * @param seatsLeft the seats left
     */
    public void setSeatsLeft(int seatsLeft) {
        this.seatsLeft = seatsLeft;
    }

    /**
     * Increment seats left by one.
     */
    public void incrementSeatsLeftByOne() {
        seatsLeft += 1;
    }

    /**
     * Decrement seats left by one boolean.
     *
     * @return the boolean
     */
    public boolean decrementSeatsLeftByOne() {

        return --seatsLeft == -1;
    }

    /**
     * Gets passengers.
     *
     * @return the passengers
     */
    public List<PassengerLtdInfo> getPassengers() {
        return passengers;
    }

    /**
     * Sets passengers.
     *
     * @param passengers the passengers
     */
    public void setPassengers(List<PassengerLtdInfo> passengers) {
        this.passengers = passengers;
    }


}