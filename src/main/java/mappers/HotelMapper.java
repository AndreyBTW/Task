package mappers;


import dto.AddressDto;
import dto.HotelDto;
import entities.Address;
import entities.Hotel;

public class HotelMapper {

    public static HotelDto toDto(Hotel hotel) {
        HotelDto dto = new HotelDto();
        dto.setId(hotel.getId());
        dto.setName(hotel.getName());
        dto.setAddress(toAddressDto(hotel.getAddress()));
        dto.setCategory(hotel.getCategory());
        dto.setNotes(hotel.getNotes());
        return dto;
    }

    public static Hotel toEntity(HotelDto dto) {
        Hotel hotel = new Hotel();
        hotel.setId(dto.getId());
        hotel.setName(dto.getName());
        hotel.setAddress(toAddressEntity(dto.getAddress()));
        hotel.setCategory(dto.getCategory());
        hotel.setNotes(dto.getNotes());
        return hotel;
    }

    private static AddressDto toAddressDto(Address address) {
        if (address == null) return null;

        AddressDto dto = new AddressDto();
        dto.setId(address.getId());
        dto.setZipCode(address.getZipCode());
        dto.setCity(address.getCity());
        dto.setStreet(address.getStreet());
        dto.setHouse(address.getHouse());
        return dto;
    }

    private static Address toAddressEntity(AddressDto dto) {
        if (dto == null) return null;

        Address address = new Address();
        address.setId(dto.getId());
        address.setZipCode(dto.getZipCode());
        address.setCity(dto.getCity());
        address.setStreet(dto.getStreet());
        address.setHouse(dto.getHouse());
        return address;
    }
}