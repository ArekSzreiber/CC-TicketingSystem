package com.codecool.ticketing.system.model;

public class UniversalMonthlyTicket extends Ticket{
    @Override
    public int daysValid() {
        return 30;
    }

    UniversalMonthlyTicket(){
        super();
    }

    @Override
    public boolean routeMatches(String route) {
        return true;
    }

}
