package com.codecool.ticketing.system.model;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PublicTransport {
    private AbstractMap<String, Integer> routes = new HashMap<String, Integer>();

    public void addRoute(String name, int monthlyTicketCost) {
        routes.put(name, monthlyTicketCost);
    }

    public int countRoutes() {
        return routes.size();
    }

    public String getRoutesNames() {
        ArrayList<String> routesNames = new ArrayList<String>(routes.keySet());
        Collections.sort(routesNames);
        return routesNames.toString();
    }

    public String showRoutes(){
        ArrayList<String> routesNames = new ArrayList<String>(routes.keySet());
        Collections.sort(routesNames);
        StringBuilder output = new StringBuilder();
        for(String routeName : routesNames){
            output.append("name:").append(routeName).append(", cost:").append(routes.get(routeName)).append("\n");
        }
        return output.toString();
    }

}
