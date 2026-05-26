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

    private EmployeeModel(EmployeeModelBuilder builder) {
        this.id = builder.id;
        this.userModel = builder.userModel;
        this.nationalId = builder.nationalId;
        this.phone = builder.phone;
        this.address = builder.address;
        this.urlImg = builder.urlImg;
        this.position = builder.position;
        this.salary = builder.salary;
        this.hireDate = builder.hireDate;
    }

    public static EmployeeModelBuilder builder() {
        return new EmployeeModelBuilder();
    }

    public static class EmployeeModelBuilder {
        public UUID id;
        public UserModel userModel;
        public String nationalId;
        public String phone;
        public String address;
        public String urlImg;
        public String position;
        public BigDecimal salary;
        public LocalDate hireDate;

        public EmployeeModelBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public EmployeeModelBuilder userModel(UserModel userModel) {
            this.userModel = userModel;
            return this;
        }

        public EmployeeModelBuilder nationalId(String nationalId) {
            this.nationalId = nationalId;
            return this;
        }

        public EmployeeModelBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public EmployeeModelBuilder address(String address) {
            this.address = address;
            return this;
        }

        public EmployeeModelBuilder urlImg(String urlImg) {
            this.urlImg = urlImg;
            return this;
        }

        public EmployeeModelBuilder position(String position) {
            this.position = position;
            return this;
        }

        public EmployeeModelBuilder salary(BigDecimal salary) {
            this.salary = salary;
            return this;
        }

        public EmployeeModelBuilder hireDate(LocalDate hireDate) {
            this.hireDate = hireDate;
            return this;
        }

        public EmployeeModel build() {
            return new EmployeeModel(this);
        }
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
        return this.hireDate;
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