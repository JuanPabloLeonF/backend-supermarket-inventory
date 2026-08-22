package dev.juanleon.supermarket_inventory.modules.reports.domain.models;



public class DataReportModel<M> {

    private String customerName;
    private String identificationCustomer;
    private M model;

    public DataReportModel() {
    }

    public DataReportModel(String customerName, String identificationCustomer, M model) {
        this.customerName = customerName;
        this.identificationCustomer = identificationCustomer;
        this.model = model;
    }

    public String getCustomerName() {
         return customerName;
     }

     public void setCustomerName(String customerName) {
         this.customerName = customerName;
     }

     public String getIdentificationCustomer() {
         return identificationCustomer;
     }

     public void setIdentificationCustomer(String identificationCustomer) {
         this.identificationCustomer = identificationCustomer;
     }

     public M getModel() {
         return model;
     }

    public void setModel(M model) {
        this.model = model;
    }
 }
