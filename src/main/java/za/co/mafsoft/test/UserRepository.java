package za.co.mafsoft.test;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import za.co.mafsoft.test.entity.User;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
}
