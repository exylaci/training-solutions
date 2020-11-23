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
}
