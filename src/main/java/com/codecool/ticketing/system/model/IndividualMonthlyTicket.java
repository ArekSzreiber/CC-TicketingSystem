package com.codecool.ticketing.system.model;

public class IndividualMonthlyTicket extends Ticket {
    String routeName;

    public IndividualMonthlyTicket(String routeName) {
        super();
        this.routeName = routeName;
    }

    @Override
    public int daysValid() {
        return 30;
    }

    @Override
    public boolean routeMatches(String route) {
        return this.routeName.equals(route);
    }
}
