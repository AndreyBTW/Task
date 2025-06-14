package rest;

import dao.AddressDao;
import dto.AddressDto;
import entities.Address;
import mappers.AddressMapper;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/addresses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AddressResource {

    @Inject
    private AddressDao addressDao;

    @POST
    public Response createAddress(
            @Valid AddressDto addressDto,
            @Context UriInfo uriInfo) {

        Address address = AddressMapper.toEntity(addressDto);
        addressDao.create(address);

        URI uri = uriInfo.getAbsolutePathBuilder()
                .path(String.valueOf(address.getId()))
                .build();

        return Response.created(uri).build();
    }

    @GET
    @Path("/{id}")
    public Response getAddressById(@PathParam("id") Long id) {
        Optional<Address> address = addressDao.findById(id);

        if (address.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(AddressMapper.toDto(address.get())).build();
    }

    @GET
    public Response getAllAddresses() {
        List<Address> addresses = addressDao.findAll();
        List<AddressDto> result = addresses.stream()
                .map(AddressMapper::toDto)
                .collect(Collectors.toList());

        return Response.ok(result).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateAddress(
            @PathParam("id") Long id,
            @Valid AddressDto addressDto) {

        Optional<Address> existing = addressDao.findById(id);
        if (existing.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Address address = AddressMapper.toEntity(addressDto);
        address.setId(id);
        addressDao.update(address);

        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAddress(@PathParam("id") Long id) {
        addressDao.delete(id);
        return Response.noContent().build();
    }
}