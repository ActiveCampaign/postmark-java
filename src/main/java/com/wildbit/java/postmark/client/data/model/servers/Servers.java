package com.wildbit.java.postmark.client.data.model.servers;

import com.wildbit.java.postmark.client.data.model.server.Server;
import java.util.ArrayList;

/**
 * Servers POJO.
 */
public class Servers {

    private int totalCount;
    private ArrayList<Server> servers;

    // GETTERS AND SETTERS

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public ArrayList<Server> getServers() {
        return servers;
    }

    public void setServers(ArrayList<Server> servers) {
        this.servers = servers;
    }
}
