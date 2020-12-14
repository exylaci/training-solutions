package week08.d01;

public class Cella {
    private Door[] doors = new  Door[100];

    public Door[] onThe100ThDais(){
        clearing();
        for(int i=0;i<100;++i){
            for(int j=i;j<100;j+=i+1){
                if (doors[j]==Door.CLOSE){
                    doors[j]=Door.OPEN;
                }else{
                    doors[j]=Door.CLOSE;
                }
            }
        }
        return doors;
    }

    private void clearing() {
        for ( int i=0;i<100;++i){
            doors[i]=Door.CLOSE;
        }
    }

    public static void main(String[] args) {
        Cella c = new Cella();
        Door[] d = c.onThe100ThDais();
        for (int i=0;i<100;++i){
            System.out.println(i+1 +" "+ d[i]);
        }
    }
}
