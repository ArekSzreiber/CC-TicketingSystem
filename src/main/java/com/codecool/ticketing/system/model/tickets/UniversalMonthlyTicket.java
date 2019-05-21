package com.codecool.ticketing.system.model.tickets;

public class UniversalMonthlyTicket extends Ticket{
    @Override
    public int daysValid() {
        return TicketType.MONTHLY_FOR_ROUTE.daysValid();
    }

    UniversalMonthlyTicket(){
        super();
    }

    @Override
    public boolean routeMatches(String route) {
        return true;
    }

}
