package com.codecool.ticketing.system.model.tickets;

import java.time.LocalDate;

public abstract class Ticket {
    private LocalDate purchaseDate;

    public abstract int daysValid();

    Ticket() {
        this.purchaseDate = LocalDate.now();
    }

    public static Ticket buyTicket(TicketType ticketType, String routeName) throws NoTicketException {
        switch (ticketType) {
            case DAILY:
                return new DailyTicket();
            case MONTHLY:
                return new UniversalMonthlyTicket();
            case MONTHLY_FOR_ROUTE:
                return new IndividualMonthlyTicket(routeName);
            default:
                throw new NoTicketException();
        }
    }

    public boolean isValid(LocalDate day) {
        return day.isBefore(purchaseDate.plusDays(daysValid()));
    }

    public abstract boolean routeMatches(String route);
}
