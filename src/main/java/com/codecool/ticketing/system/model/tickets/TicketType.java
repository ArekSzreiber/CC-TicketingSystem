package com.codecool.ticketing.system.model.tickets;

public enum TicketType {
    DAILY(1),
    MONTHLY(30),
    MONTHLY_FOR_ROUTE(30);

    private int daysValid;

    TicketType(int daysValid){
        this.daysValid = daysValid;
    }

    public int daysValid(){
        return this.daysValid;
    }
}
