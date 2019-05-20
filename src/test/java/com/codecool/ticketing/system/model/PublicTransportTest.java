package com.codecool.ticketing.system.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class PublicTransportTest {


    @Test
    void testAddingRoutes() {
        PublicTransport publicTransport = new PublicTransport();
        publicTransport.addRoute("Bus 523", 22);
        publicTransport.addRoute("Bus 155", 33);
        publicTransport.addRoute("Bus 23", 44);
        publicTransport.addRoute("Bus 444", 55);
        publicTransport.addRoute("Metro 1", 66);
        publicTransport.addRoute("Metro 2", 77);

        assertEquals(6, publicTransport.countRoutes());
    }


    @Test
    void testFindingAllRoutes() {
        PublicTransport publicTransport = new PublicTransport();
        publicTransport.addRoute("Bus 523", 22);
        publicTransport.addRoute("Bus 155", 33);
        publicTransport.addRoute("Bus 23", 44);
        publicTransport.addRoute("Bus 444", 55);
        publicTransport.addRoute("Metro 1", 66);
        publicTransport.addRoute("Metro 2", 77);


        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Bus 155");
        expected.add("Bus 23");
        expected.add("Bus 444");
        expected.add("Bus 523");
        expected.add("Metro 1");
        expected.add("Metro 2");
        Collections.sort(expected);

        String actual = publicTransport.getRoutesNames();

        assertEquals(expected.toString(), actual);

    }

    @Test
    void showAllRoutes() {
        PublicTransport publicTransport = new PublicTransport();
        publicTransport.addRoute("Bus 523", 22);
        publicTransport.addRoute("Bus 155", 33);
        publicTransport.addRoute("Bus 23", 44);

        String expected
                = "name:Bus 155, cost:33\n"
                + "name:Bus 23, cost:44\n"
                + "name:Bus 523, cost:22\n";
        assertEquals(expected, publicTransport.showRoutes());
    }
}