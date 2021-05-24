package com.sda.gabrieltudosanu.hibernate3.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "seat_id")
    private Integer seatId;

    @Column(name = "row")
    private Integer row;

    @Column(name = "number")
    private Integer number;

    @ManyToMany(mappedBy = "seats")
    private Set<Reservation> reservations;

    public Seat(Integer row, Integer number) {
        this.row = row;
        this.number = number;
    }

    public Seat() {
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatId=" + seatId +
                ", row=" + row +
                ", number=" + number +
                '}';
    }
}
