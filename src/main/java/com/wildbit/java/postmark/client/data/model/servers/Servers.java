package com.wildbit.java.postmark.client.data.model.servers;

import com.wildbit.java.postmark.client.data.model.server.Server;
import java.util.ArrayList;

/**
 * Created by bash on 11/1/17.
 */
public class Servers {

    private int totalCount;
    private ArrayList<Server> servers;

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
