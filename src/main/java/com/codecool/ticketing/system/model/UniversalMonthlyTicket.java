package com.codecool.ticketing.system.model;

import java.time.LocalDate;

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
