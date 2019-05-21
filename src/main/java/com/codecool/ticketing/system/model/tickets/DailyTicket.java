package com.codecool.ticketing.system.model.tickets;

public class DailyTicket extends Ticket {

    @Override
    public int daysValid() {
        return TicketType.DAILY.daysValid();
    }

    DailyTicket() {
        super();
    }

    @Override
    public boolean routeMatches(String route) {
        return true;
    }
}
