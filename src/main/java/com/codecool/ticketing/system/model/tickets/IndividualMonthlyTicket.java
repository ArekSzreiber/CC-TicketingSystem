package com.codecool.ticketing.system.model.tickets;

public class IndividualMonthlyTicket extends Ticket {
    private String routeName;

    IndividualMonthlyTicket(String routeName) {
        super();
        this.routeName = routeName;
    }

    @Override
    public int daysValid() {
        return TicketType.MONTHLY.daysValid();

    }

    @Override
    public boolean routeMatches(String route) {
        return this.routeName.equals(route);
    }
}
