package com.codecool.ticketing.system.model.tickets;

public class NoTicketException extends Throwable{
    @Override
    public String getMessage() {
        return "No such kind of Ticket";
    }
}
