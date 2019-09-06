package com.xebia.jpaexcercises._10_one_to_one;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private long salary;
    @OneToOne
    @JoinColumn(name = "plot_id")
    private ParkingSpace parkingSpace;

    public Employee() {
    }

    public Employee(String name, long salary, ParkingSpace parkingSpace) {
        this.name = name;
        this.salary = salary;
        this.parkingSpace = parkingSpace;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getSalary() {
        return salary;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", parkingSpace=" + parkingSpace +
                '}';
    }
}
