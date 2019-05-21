package com.codecool.ticketing.system.model;

import java.time.LocalDate;

public abstract class Ticket {
    private LocalDate purchaseDate;

    public abstract int daysValid();

    Ticket() {
        this.purchaseDate = LocalDate.now();
    }


    public static Ticket newDailyTicket() {
        return new DailyTicket();
    }

    public static Ticket newMonthlyTicket() {
        return new UniversalMonthlyTicket();
    }

    public static Ticket newMonthlyTicket(String routeName) {
        return new IndividualMonthlyTicket(routeName);
    }

    public boolean isValid(LocalDate day){
        return day.isBefore(purchaseDate.plusDays(daysValid()));
    }

    public abstract boolean routeMatches(String route);
}
