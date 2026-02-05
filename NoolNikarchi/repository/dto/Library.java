package com.zsgs.NoolNikarchi.repository.dto;

public class Library {
    private Integer id;
    private String name;
    private String incharge;
    private Integer capacity;
    private StorageStructure storageStructure;
    private String address;
    private String phoneNo;
    private String wifiPassword;
    private String emailId;
    private Long openingTime;
    private Long closingTime;
    private Integer noAvailableDays;

    public Integer getNoAvailableDays() {
        return noAvailableDays;
    }

    public void setNoAvailableDays(Integer noAvailableDays) {
        this.noAvailableDays = noAvailableDays;
    }

    public Long getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(Long closingTime) {
        this.closingTime = closingTime;
    }

    public Long getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Long openingTime) {
        this.openingTime = openingTime;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getWifiPassword() {
        return wifiPassword;
    }

    public void setWifiPassword(String wifiPassword) {
        this.wifiPassword = wifiPassword;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StorageStructure getStorageStructure() {
        return storageStructure;
    }

    public void setStorageStructure(StorageStructure storageStructure) {
        this.storageStructure = storageStructure;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getIncharge() {
        return incharge;
    }

    public void setIncharge(String incharge) {
        this.incharge = incharge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
