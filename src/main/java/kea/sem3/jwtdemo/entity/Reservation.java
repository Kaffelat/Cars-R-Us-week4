package kea.sem3.jwtdemo.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Reservation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int reservationId;

    @CreationTimestamp
    private LocalDateTime reservationDate;

    private LocalDate rentalDate;

    @ManyToOne
    Car car;

    @ManyToOne
    Member member;

    public Reservation() {
    }

    public Reservation(LocalDate rentalDate, Car car, Member member) {
        this.rentalDate = rentalDate;
        this.car = car;
        this.member = member;
        car.addReservation(this);
        member.addReservation(this);
        //Mangler stadig shit
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
