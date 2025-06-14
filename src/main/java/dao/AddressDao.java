package dao;

import entities.Address;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

@Stateless
public class AddressDao {

    @PersistenceContext
    private EntityManager em;

    public void create(Address address) {
        em.persist(address);
    }

    public void update(Address address) {
        em.merge(address);
    }

    public void delete(Long id) {
        Address address = em.find(Address.class, id);
        if (address != null) {
            em.remove(address);
        }
    }

    public Optional<Address> findById(Long id) {
        return Optional.ofNullable(em.find(Address.class, id));
    }

    public List<Address> findAll() {
        return em.createQuery("SELECT a FROM Address a", Address.class)
                .getResultList();
    }
}