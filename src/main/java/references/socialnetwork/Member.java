package references.socialnetwork;

import records.SchoolRecordsController;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private List<Member> connections = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }

    public void connectMember(Member member){
        connections.add(member);
    }

    public String getName() {
        return name;
    }

    public List<Member> getConnections() {
        return connections;
    }

    private List<String> connectedNames(){
        List<String> result = new ArrayList<>();
        for ( Member one : connections) {
            result.add(one.getName());
        }
        return result;
    }

    @Override
    public String toString() {
        return name + ": " + connectedNames();
    }
}
