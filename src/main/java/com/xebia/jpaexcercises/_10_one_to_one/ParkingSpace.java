package com.xebia.jpaexcercises._10_one_to_one;

import javax.persistence.*;

@Entity
@Table(name = "parking_lot")
public class ParkingSpace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int lotNo;

    @OneToOne(mappedBy = "parkingSpace")
    Employee employee;

    public ParkingSpace() {
    }

    public ParkingSpace(int lotNo) {
        this.lotNo = lotNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLotNo() {
        return lotNo;
    }

    public void setLotNo(int lotNo) {
        this.lotNo = lotNo;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "ParkingSpace{" +
                "id=" + id +
                ", lotNo=" + lotNo +
                '}';
    }
}
