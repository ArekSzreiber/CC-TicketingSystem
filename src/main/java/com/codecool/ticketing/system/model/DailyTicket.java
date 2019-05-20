package com.codecool.ticketing.system.model;

public class DailyTicket extends Ticket {

    @Override
    public int daysValid() {
        return 1;
    }

    DailyTicket(){
        super();
    }

    @Override
    public boolean routeMatches(String route) {
        return true;
    }
}
