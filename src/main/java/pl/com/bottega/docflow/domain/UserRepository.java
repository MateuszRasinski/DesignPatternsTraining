package pl.com.bottega.docflow.domain;

import java.util.UUID;

public interface UserRepository {

	User load(UUID creatorId);

}
