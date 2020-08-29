package cl.blm.newmarketing.backend.model.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.Predicate;

import cl.blm.newmarketing.backend.model.GenericRepository;
import cl.blm.newmarketing.backend.model.entities.Seller;

/**
 *
 * @author Benjamin La Madrid <bg.lamadrid at gmail.com>
 */
@Repository
public interface SellersRepository
    extends GenericRepository<Seller, Integer> {

  @Query(value = "SELECT s FROM Seller s JOIN FETCH s.person", countQuery = "SELECT s FROM Seller s")
  Page<Seller> deepReadAll(Pageable pageable);

  @Query(value = "SELECT s FROM Seller s JOIN FETCH s.person", countQuery = "SELECT s FROM Seller s")
  Page<Seller> deepReadAll(Predicate filters, Pageable pageable);

}
