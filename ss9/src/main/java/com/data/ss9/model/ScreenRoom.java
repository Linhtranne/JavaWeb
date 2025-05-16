package com.data.ss9.model;

import lombok.*;

@NoArgsConstructor

@AllArgsConstructor
public class ScreenRoom {
    private Long id;
    private String screenRoomName;
    private Integer totalSeat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScreenRoomName() {
        return screenRoomName;
    }

    public void setScreenRoomName(String screenRoomName) {
        this.screenRoomName = screenRoomName;
    }

    public Integer getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(Integer totalSeat) {
        this.totalSeat = totalSeat;
    }
}


