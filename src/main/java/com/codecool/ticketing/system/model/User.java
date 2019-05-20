package com.codecool.ticketing.system.model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public abstract class User {
    private List<Ticket> tickets = new LinkedList<>();
    private String currentRoute;

    public void setCurrentRoute(String currentRoute) {
        this.currentRoute = currentRoute;
    }

    public void buyDailyTicket() {
        tickets.add(Ticket.newDailyTicket());
    }

    public boolean hasDailyTicket() {
        for (Ticket ticket : tickets) {
            if (ticket instanceof DailyTicket) {
                if (ticket.isValid()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int countTickets() {
        return tickets.size();
    }

    public void buyMonthlyTicket() {
        tickets.add(Ticket.newMonthlyTicket());
    }

    public void buyMonthlyTicket(String routeName) {
        tickets.add(Ticket.newMonthlyTicket(routeName));
    }

    public boolean hasValidTicket(LocalDate day) {
        for (Ticket ticket : tickets) {
            if (ticket.isValid(day)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasValidTicket() {
        for (Ticket ticket : tickets) {
            if (ticket.isValid() && ticket.routeMatches(currentRoute)) {
                return true;
            }
        }
        return false;
    }
}
