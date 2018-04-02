package com.wildbit.java.postmark.client.data.model.servers;

import com.wildbit.java.postmark.client.data.model.server.Server;
import java.util.List;

/**
 * Servers object.
 */
public class Servers {

    private int totalCount;
    private List<Server> servers;

    // GETTERS AND SETTERS

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<Server> getServers() {
        return servers;
    }

    public void setServers(List<Server> servers) {
        this.servers = servers;
    }
}
