package rest;


import dao.HotelDao;
import dto.HotelDto;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.Consumes;
import entities.Hotel;
import dao.AddressDao;
import mappers.HotelMapper;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RolesAllowed("hotel-admin")
@Path("/hotels")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HotelResource {

    @Inject
    private HotelDao hotelDao;

    @Inject
    private AddressDao addressDao;

    @POST
    public Response createHotel(@Valid HotelDto hotelDto, @Context UriInfo uriInfo) {
        // Преобразуем DTO в сущность
        Hotel hotel = HotelMapper.toEntity(hotelDto);

        // Сохраняем адрес если он новый
        if (hotelDto.getAddress().getId() == null) {
            addressDao.create(hotel.getAddress());
        }

        hotelDao.create(hotel);

        // Формируем URI созданного ресурса
        URI uri = uriInfo.getAbsolutePathBuilder()
                .path(String.valueOf(hotel.getId()))
                .build();

        return Response.created(uri).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteHotel(@PathParam("id") Long id) {
        hotelDao.delete(id);
        return Response.noContent().build();
    }

    @GET
    public Response getHotels(
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("size") @DefaultValue("10") int size) {

        List<Hotel> hotels = hotelDao.findAll(page, size);

        // Преобразуем сущности в DTO
        List<HotelDto> result = hotels.stream()
                .map(HotelMapper::toDto)
                .collect(Collectors.toList());

        // Добавляем информацию о пагинации
        long totalCount = hotelDao.countAll();
        int totalPages = (int) Math.ceil((double) totalCount / size);

        return Response.ok(result)
                .header("X-Total-Count", totalCount)
                .header("X-Total-Pages", totalPages)
                .build();
    }
}