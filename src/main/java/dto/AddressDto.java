package dto;


import java.util.Objects;

public class AddressDto {
    private Long id;
    private String zipCode;
    private String city;
    private String street;
    private String house;

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
        AddressDto that = (AddressDto) o;
        return Objects.equals(id, that.id) && Objects.equals(zipCode, that.zipCode)
                && Objects.equals(city, that.city) && Objects.equals(street, that.street)
                && Objects.equals(house, that.house);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, zipCode, city, street, house);
    }
}