package com.pfunes.spbt.EmployeeRestApi.exception;

import com.pfunes.spbt.EmployeeRestApi.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class Response {

    private int idStatus;

    private String message;

    private long timeStamp;

    private List<Employee> dataEmployees;


    public Response(){this.dataEmployees = new ArrayList<>();}

    public Response(int idStatus, String message, long timeStamp) {
        this();
        this.idStatus = idStatus;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public List<Employee> addEmployeeToList(Employee employee){
        dataEmployees.add(employee);
        return dataEmployees;
    }

    public List<Employee> getDataEmployees() {
        return dataEmployees;
    }

    public void setDataEmployees(List<Employee> dataEmployees) {
        this.dataEmployees = dataEmployees;
    }

    public int getId() {
        return idStatus;
    }

    public void setId(int idStatus) {
        this.idStatus = idStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
