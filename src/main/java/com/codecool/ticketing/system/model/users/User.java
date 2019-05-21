package com.codecool.ticketing.system.model.users;

import com.codecool.ticketing.system.model.tickets.DailyTicket;
import com.codecool.ticketing.system.model.tickets.NoTicketException;
import com.codecool.ticketing.system.model.tickets.Ticket;
import com.codecool.ticketing.system.model.tickets.TicketType;

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
            tickets.add(Ticket.buyTicket(TicketType.DAILY, null));
        } catch (NoTicketException e) {
            e.printStackTrace();
        }
    }

    public boolean hasValidDailyTicket() {
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
            tickets.add(Ticket.buyTicket(TicketType.MONTHLY, null));
        } catch (NoTicketException e) {
            e.printStackTrace();
        }
    }

    public void buyMonthlyTicket(String routeName) {
        try {
            tickets.add(Ticket.buyTicket(TicketType.MONTHLY_FOR_ROUTE, routeName));
        } catch (NoTicketException e) {
            e.printStackTrace();
        }
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

    public Ticket getNewestTicket() {
        try {
            return tickets.get(tickets.size() - 1);

        } catch (IndexOutOfBoundsException e) {
            return null;
        }

    }
}
