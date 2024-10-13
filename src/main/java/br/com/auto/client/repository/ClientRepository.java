package br.com.auto.client.repository;

import br.com.auto.client.model.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    Optional<ClientEntity> findByDocument(String document);

    @Query("SELECT c FROM ClientEntity c WHERE " +
            "(:id IS NULL OR c.id = :id) AND " +
            "(:name IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
            "(:document IS NULL OR c.document = :document) AND " +
            "(:birthDate IS NULL OR c.birthDate = :birthDate)")
    List<ClientEntity> findClientsByFilters(Long id, String name, String document, LocalDate birthDate);
}

