package com.codecool.ticketing.system.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testBuyingDailyTicket() {
        User user = new Passenger();

        assertEquals(0, user.countTickets());

        user.buyDailyTicket();

        assertEquals(1, user.countTickets());
    }

    @Test
    void testDailyTicketIsValidAfterPurchase() {
        User user = new Passenger();

        user.buyDailyTicket();

        assertTrue(user.hasDailyTicket());
    }

    @Test
    void dailyTicketIsNotValidAfterOneDay() {
        User user = new Passenger();
        user.buyDailyTicket();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        assertTrue(user.hasValidTicket());
        assertFalse(user.hasValidTicket(tomorrow));
    }

    @Test
    void testBuyingUniversalMonthlyTicket() {
        User user = new Passenger();

        assertEquals(0, user.countTickets());

        user.buyMonthlyTicket();

        assertEquals(1, user.countTickets());
    }

    @Test
    void MonthlyTicketIsValidAfterOneWeek() {
        User user = new Passenger();

        user.buyMonthlyTicket();

        assertTrue(user.hasValidTicket(LocalDate.now().plusDays(7)));
    }

    @Test
    void MonthlyTicketIsValidAfter29Days() {
        User user = new Passenger();

        user.buyMonthlyTicket();

        assertTrue(user.hasValidTicket(LocalDate.now().plusDays(29)));
    }

    @Test
    void MonthlyTicketIsNotValidAfter30Days() {
        User user = new Passenger();

        user.buyMonthlyTicket();

        assertFalse(user.hasValidTicket(LocalDate.now().plusDays(30)));
    }

    @Test
    void testBuyingIndividualMonthlyTicket() {
        User user = new Passenger();

        assertEquals(0, user.countTickets());
        final String routeName = "Metro 1";
        user.buyMonthlyTicket(routeName);
        user.setCurrentRoute(routeName);

        assertEquals(1, user.countTickets());
    }

    @Test
    void MonthlyTicketForRouteIsValidAfterPurchase() {
        User user = new Passenger();
        final String routeName = "Metro 1";
        user.buyMonthlyTicket(routeName);
        user.setCurrentRoute(routeName);

        assertTrue(user.hasValidTicket());
    }

    @Test
    void MonthlyTicketForRouteIsValidAfterOneWeekForProperRoute() {
        User user = new Passenger();
        final String routeName = "Metro 1";

        user.buyMonthlyTicket(routeName);
        user.setCurrentRoute(routeName);

        assertTrue(user.hasValidTicket(LocalDate.now().plusWeeks(1)));
    }

    @Test
    void MonthlyTicketForRouteIsValidAfter29DaysForProperRoute() {
        User user = new Passenger();
        final String routeName = "Metro 1";

        user.buyMonthlyTicket(routeName);
        user.setCurrentRoute(routeName);

        assertTrue(user.hasValidTicket(LocalDate.now().plusDays(29)));
    }

    @Test
    void MonthlyTicketForRouteIsNotValidAfter30DaysForProperRoute() {
        User user = new Passenger();
        final String routeName = "Metro 1";

        user.buyMonthlyTicket(routeName);
        user.setCurrentRoute(routeName);

        assertFalse(user.hasValidTicket(LocalDate.now().plusDays(30)));
    }

    @Test
    void MonthlyTicketForRouteIsNotValidForWrongRoute() {
        User user = new Passenger();

        user.buyMonthlyTicket("Metro 1");
        user.setCurrentRoute("Bus 333");

        assertFalse(user.hasValidTicket());
    }

    @Test
    void MonthlyTicketForRouteIsNotValidForWrongRouteAfterOneWeek() {
        User user = new Passenger();

        user.buyMonthlyTicket("Metro 1");
        user.setCurrentRoute("Bus 333");

        assertFalse(user.hasValidTicket(LocalDate.now().plusWeeks(1)));
    }




}