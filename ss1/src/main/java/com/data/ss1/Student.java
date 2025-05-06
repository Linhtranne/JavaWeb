package com.data.ss1;

public class Student {
    private String name;
    private String className;
    private String vehicleType;
    private String licensePlate;

    public Student(String name, String className, String vehicleType, String licensePlate) {
        this.name = name;
        this.className = className;
        this.vehicleType = vehicleType;
        this.licensePlate = licensePlate;
    }

    // Getters
    public String getName() { return name; }
    public String getClassName() { return className; }
    public String getVehicleType() { return vehicleType; }
    public String getLicensePlate() { return licensePlate; }
}
