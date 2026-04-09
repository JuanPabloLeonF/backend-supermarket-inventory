package dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.adapters.get;

import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;
import dev.juanleon.supermarket_inventory.users.domain.persistence.get.IGetUserPersistence;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.mappers.IMapperUserInfrastructure;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.repositories.IUserRepository;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions.EmailAlreadyExistsException;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions.NotFoundUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class GetUserAdapter implements IGetUserPersistence {

    private final IUserRepository iUserRepository;
    private final IMapperUserInfrastructure iMapperUserInfrastructure;

    @Override
    public List<UserModel> getAll() {
        return this.iMapperUserInfrastructure
                .toListModel(this.iUserRepository.findAll());
    }

    @Override
    public UserModel getById(UUID id) {
        return this.iUserRepository.findById(id)
                .map(this.iMapperUserInfrastructure::toModel)
                .orElseThrow(() -> new NotFoundUserException(id));
    }

    @Override
    public List<UserModel> getByName(String name) {
        return this.iMapperUserInfrastructure
                .toListModel(this.iUserRepository.findByName(name));
    }

    @Override
    public List<UserModel> getByLastName(String lastName) {
        return this.iMapperUserInfrastructure
                .toListModel(this.iUserRepository.findByLastName(lastName));
    }

    @Override
    public void checkEmailIfExist(String email) {
        this.iUserRepository.findByEmail(email)
                .ifPresent(entity -> {
                    throw new EmailAlreadyExistsException(entity.getEmail());
                });
    }
}
