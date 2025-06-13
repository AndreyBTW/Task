package entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "addresses")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "zip_code", length = 20)
    private String zipCode;

    @NotNull(message = "City is required")
    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @NotNull(message = "Street is required")
    @Column(name = "street", nullable = false, length = 100)
    private String street;

    @NotNull(message = "House is required")
    @Column(name = "house", nullable = false, length = 20)
    private String house;

    // Конструкторы
    public Address() {}

    public Address(String city, String street, String house) {
        this.city = city;
        this.street = street;
        this.house = house;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(zipCode, address.zipCode)
                && Objects.equals(city, address.city) && Objects.equals(street, address.street)
                && Objects.equals(house, address.house);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, zipCode, city, street, house);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                '}';
    }
}