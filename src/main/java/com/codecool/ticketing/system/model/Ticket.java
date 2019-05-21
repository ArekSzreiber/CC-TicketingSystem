package com.codecool.ticketing.system.model;

import java.time.LocalDate;

public abstract class Ticket {
    private LocalDate purchaseDate;

    public abstract int daysValid();

    Ticket() {
        this.purchaseDate = LocalDate.now();
    }

    public static Ticket buyTicket(int daysValid) throws NoTicketException {
        switch (daysValid) {
            case 1:
                return new DailyTicket();
            case 30:
                return new UniversalMonthlyTicket();
            default:
                throw new NoTicketException();
        }
    }

    public static Ticket buyTicket(String routeName) {
        return new IndividualMonthlyTicket(routeName);
    }

    public boolean isValid(LocalDate day) {
        return day.isBefore(purchaseDate.plusDays(daysValid()));
    }

    public abstract boolean routeMatches(String route);
}
