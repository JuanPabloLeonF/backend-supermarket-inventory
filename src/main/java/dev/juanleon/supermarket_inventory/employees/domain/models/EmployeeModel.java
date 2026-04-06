package dev.juanleon.supermarket_inventory.employees.domain.models;

import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class EmployeeModel {

    private UUID id;
    private UserModel userModel;
    private String nationalId;
    private String phone;
    private String address;
    private String urlImg;
    private String position;
    private BigDecimal salary;
    private LocalDate hireDate;

    public EmployeeModel() {
    }

    public EmployeeModel(UUID id, UserModel userModel, String nationalId, String phone, String address, String urlImg, String position, BigDecimal salary, LocalDate hireDate) {
        this.id = id;
        this.userModel = userModel;
        this.nationalId = nationalId;
        this.phone = phone;
        this.address = address;
        this.urlImg = urlImg;
        this.position = position;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public EmployeeModel(UserModel userModel, String nationalId, String phone, String address, String position, String urlImg, BigDecimal salary, LocalDate hireDate) {
        this.userModel = userModel;
        this.nationalId = nationalId;
        this.phone = phone;
        this.address = address;
        this.position = position;
        this.urlImg = urlImg;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "EmployeeModel{" +
                "id=" + id +
                ", userModel=" + userModel +
                ", nationalId='" + nationalId + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", urlImg='" + urlImg + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", hireDate=" + hireDate +
                '}';
    }
}