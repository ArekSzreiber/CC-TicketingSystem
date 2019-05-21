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
        try {
            tickets.add(Ticket.buyTicket(1));
        } catch (NoTicketException e) {
            e.printStackTrace();
        }
    }

    public boolean hasDailyTicket() {
        for (Ticket ticket : tickets) {
            if (ticket instanceof DailyTicket) {
                if (ticket.isValid(LocalDate.now())) {
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
        try {
            tickets.add(Ticket.buyTicket(30));
        } catch (NoTicketException e) {
            e.printStackTrace();
        }
    }

    public void buyMonthlyTicket(String routeName) {
        tickets.add(Ticket.buyTicket(routeName));
    }

    public boolean hasValidTicket(LocalDate day) {
        for (Ticket ticket : tickets) {
            if (ticket.isValid(day) && ticket.routeMatches(currentRoute)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasValidTicket() {
        return hasValidTicket(LocalDate.now());
    }
}
