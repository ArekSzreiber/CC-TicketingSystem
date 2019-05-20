package com.codecool.ticketing.system.model;

public class Admin extends User{
    private PublicTransport publicTransport;

    Admin(){
        this.publicTransport = new PublicTransport();
    }

    public void addRoute(String routeName, int monthlyTicketCost) {
        publicTransport.addRoute(routeName, monthlyTicketCost);
    }

    public int countRoutes() {
        return publicTransport.countRoutes();
    }
}
