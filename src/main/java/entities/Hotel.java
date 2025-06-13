package entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "hotels")
public class Hotel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name is required")
    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @NotNull(message = "Address is required")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", length = 20)
    private HotelCategory category;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    // Конструкторы
    public Hotel() {}

    public Hotel(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public HotelCategory getCategory() {
        return category;
    }

    public void setCategory(HotelCategory category) {
        this.category = category;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(id, hotel.id) && Objects.equals(name, hotel.name)
                && Objects.equals(address, hotel.address) && category == hotel.category
                && Objects.equals(notes, hotel.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, category, notes);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", category=" + category +
                ", notes='" + notes + '\'' +
                '}';
    }
}
