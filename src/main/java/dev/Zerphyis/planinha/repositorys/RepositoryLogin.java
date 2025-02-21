package dev.Zerphyis.planinha.repositorys;

import dev.Zerphyis.planinha.entity.login.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface RepositoryLogin extends JpaRepository<Login, UUID> {
    UserDetails findByName(String name);
}
