package br.edu.utfpr.commerceapi.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.utfpr.commerceapi.models.Reserva;

@Repository
public interface ReservaRepository 
        extends JpaRepository<Reserva, UUID> {
    
}
