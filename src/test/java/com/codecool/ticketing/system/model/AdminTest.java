package com.codecool.ticketing.system.model;

import com.codecool.ticketing.system.model.users.Admin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    @Test
    void testAddedRouteExists() {
        Admin admin = new Admin();

        admin.addRoute("Bus 1", 34);
        assertEquals(1, admin.countRoutes());
    }

    @Test
    void testAddRouteThatAlreadyExists(){
        Admin admin = new Admin();

        admin.addRoute("Bus 1", 34);
        admin.addRoute("Bus 1", 55);
        assertEquals(1, admin.countRoutes());
    }
}