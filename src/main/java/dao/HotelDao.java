package dao;

import entities.Hotel;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Stateless
public class HotelDao {

    @PersistenceContext(unitName = "hotelPU")
    private EntityManager em;

    public Hotel create(Hotel hotel) {
        em.persist(hotel);
        return hotel;
    }

    public void delete(Long id) {
        Hotel hotel = em.find(Hotel.class, id);
        if (hotel != null) {
            em.remove(hotel);
        }
    }

    public Optional<Hotel> findById(Long id) {
        return Optional.ofNullable(em.find(Hotel.class, id));
    }

    public List<Hotel> findAll(int page, int size) {
        TypedQuery<Hotel> query = em.createQuery(
                "SELECT h FROM Hotel h ORDER BY h.name ASC", Hotel.class);

        query.setFirstResult(page * size);
        query.setMaxResults(size);
        return query.getResultList();
    }

    public long countAll() {
        return em.createQuery("SELECT COUNT(h) FROM Hotel h", Long.class)
                .getSingleResult();
    }
}