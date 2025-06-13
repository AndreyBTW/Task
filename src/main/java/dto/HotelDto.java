package dto;


import entities.HotelCategory;

import java.util.Objects;

public class HotelDto {
    private Long id;
    private String name;
    private AddressDto address;
    private HotelCategory category;
    private String notes;

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

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
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
        HotelDto hotelDto = (HotelDto) o;
        return Objects.equals(id, hotelDto.id) && Objects.equals(name, hotelDto.name)
                && Objects.equals(address, hotelDto.address) && category == hotelDto.category
                && Objects.equals(notes, hotelDto.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, category, notes);
    }
}