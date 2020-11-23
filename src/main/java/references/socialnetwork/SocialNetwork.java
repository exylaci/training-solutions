package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {
    List<Member> members = new ArrayList<>();

    public void addMember(String name){
        members.add(new Member(name));
    }

    public List<String> bidirectionalConnections(){
        List<String> result = new ArrayList<>();
        for ( Member one : members ) {
            for ( Member two : members ) {
                if ( one.getConnections().contains(two)) {
                    result.add( one.getName() + " - " + two.getName() );
                }
            }
        }
        return result;
    }

    public void connect(String name1, String name2){
        Member member1 = findByName(name1);
        Member member2 = findByName(name2);
        if ( member1!=null && member2!=null ){
            member1.connectMember(member2);
        }else{
            System.out.println("Nincs ilyen nevű tag.");
        }
    }

    private Member findByName(String name){
        for ( int i=0 ; i<members.size() ; ++i ){
            if ( members.get(i).getName().equals(name) ){
                return members.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return members.toString();
    }
}
