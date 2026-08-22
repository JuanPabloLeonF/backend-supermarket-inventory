package dev.juanleon.supermarket_inventory.modules.providers.domain.models;

import java.time.LocalDate;
import java.util.UUID;

public class ProviderModel {

    private UUID id;
    private String fullName;
    private String identification;
    private String email;
    private String cellPhone;
    private String direction;
    private String city;
    private Boolean activate;
    private LocalDate createdAt;

    public ProviderModel(){}

    public ProviderModel(UUID id, String fullName, String identification, String email, String cellPhone, String direction, String city, Boolean activate, LocalDate createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.identification = identification;
        this.email = email;
        this.cellPhone = cellPhone;
        this.direction = direction;
        this.city = city;
        this.activate = activate;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getActivate() {
        return activate;
    }

    public void setActivate(Boolean activate) {
        this.activate = activate;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "ProviderModel{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", identification='" + identification + '\'' +
                ", email='" + email + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", direction='" + direction + '\'' +
                ", city='" + city + '\'' +
                ", activate=" + activate +
                ", createdAt=" + createdAt +
                '}';
    }
}
