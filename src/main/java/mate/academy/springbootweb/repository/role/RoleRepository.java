package mate.academy.springbootweb.repository.role;

import java.util.Optional;
import mate.academy.springbootweb.model.Role;
import mate.academy.springbootweb.model.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
