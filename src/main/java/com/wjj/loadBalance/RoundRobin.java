package com.wjj.loadBalance;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobin {

    public static class Server {

        private int serverId;

        private String name;

        private int weight;

        public Server(int serverId, String name){
            this.serverId = serverId;
            this.name = name;
        }

        public Server(int serverId,String name,int weight){
            this.serverId = serverId;
            this.name = name;
            this.weight = weight;
        }
    }

    private static AtomicInteger NEXT_SERVER_COUNTER = new AtomicInteger(0);

    private static int select(int modulo){
        for(;;){
            int current = NEXT_SERVER_COUNTER.get();
            int next = (current + 1) % modulo;
            boolean compareAndSet = NEXT_SERVER_COUNTER.compareAndSet(current,next);
            if(compareAndSet){
                return next;
            }
        }
    }

    public static Server selectServer(List<Server> serverList){
        return serverList.get(select(serverList.size()));
    }

    public static void main(String[] args){
        List<Server> serverList = new ArrayList<>();
        serverList.add(new Server(1,"服务器1"));
        serverList.add(new Server(2,"服务器2"));
        serverList.add(new Server(3,"服务器3"));
        for(int i=0 ; i<10; i++){
            Server selectedServer = selectServer(serverList);
            System.out.format("第%d次请求，选择服务器%s\n", i + 1, selectedServer.toString());
        }
    }

}
