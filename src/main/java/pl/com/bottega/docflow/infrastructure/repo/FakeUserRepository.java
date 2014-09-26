package pl.com.bottega.docflow.infrastructure.repo;

import java.util.UUID;

import pl.com.bottega.docflow.domain.User;
import pl.com.bottega.docflow.domain.UserRepository;

//@Repository
public class FakeUserRepository implements UserRepository {

	public User load(UUID userId) {
		return new User(userId);
	}

}
