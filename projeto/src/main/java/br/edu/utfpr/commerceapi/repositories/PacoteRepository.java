import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.utfpr.commerceapi.models.Pacote;

@Repository
public interface PacoteRepository 
        extends JpaRepository<Pacote, UUID> {
    
}
