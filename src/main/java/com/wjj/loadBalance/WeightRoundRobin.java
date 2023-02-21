package com.wjj.loadBalance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class WeightRoundRobin {

    public class Node{
        private String ip;
        private Integer weight;
        private Integer currentWeight;

        public Node(String ip,Integer weight){
            this.ip = ip;
            this.weight = weight;
            this.currentWeight = weight;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public Integer getCurrentWeight() {
            return currentWeight;
        }

        public void setCurrentWeight(Integer currentWeight) {
            this.currentWeight = currentWeight;
        }
    }

    List<Node> servers = Arrays.asList(
            new Node("192.168.1.1",1),
            new Node("192.168.1.2",2),
            new Node("192.168.1.3",3),
            new Node("192.168.1.4",4)
    );

    private Integer totalWeight;

    public  WeightRoundRobin(){
        this.totalWeight = servers.stream()
                .mapToInt(Node::getWeight)
                .reduce((a,b) -> a+b).getAsInt();
    }

    public String getServer(){
        Node node = servers.stream().max(Comparator.comparing(Node::getCurrentWeight)).get();
        node.setCurrentWeight(node.getCurrentWeight()-totalWeight);
        servers.forEach(servers -> servers.setCurrentWeight(servers.getCurrentWeight() + servers.getWeight()));
        return node.getIp();
    }

    public static void main(String[] args){
        WeightRoundRobin roundRobinTest = new WeightRoundRobin();
        for(int i = 0; i<10 ; i++){
            String server = roundRobinTest.getServer();
            System.out.println("select server:" + server);
        }
    }



}
