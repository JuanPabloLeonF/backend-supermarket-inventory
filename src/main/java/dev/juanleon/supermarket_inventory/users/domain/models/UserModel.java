package dev.juanleon.supermarket_inventory.users.domain.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserModel {

    private UUID id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String rol;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private UserModel(UserModelBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
        this.rol = builder.rol;
        this.isActive = builder.isActive;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }

    public static UserModelBuilder builder() {
        return new UserModelBuilder();
    }

    public static class UserModelBuilder {
        public UUID id;
        public String name;
        public String lastName;
        public String email;
        public String password;
        public String rol;
        public Boolean isActive;
        public LocalDateTime createdAt;
        public LocalDateTime updatedAt;

        public UserModelBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public UserModelBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserModelBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserModelBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserModelBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserModelBuilder rol(String rol) {
            this.rol = rol;
            return this;
        }

        public UserModelBuilder isActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public UserModelBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public UserModelBuilder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public UserModel build() {
            return new UserModel(this);
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", rol='" + rol + '\'' +
                ", isActive=" + isActive +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
