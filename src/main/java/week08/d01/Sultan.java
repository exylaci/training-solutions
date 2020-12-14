package week08.d01;

public class Sultan {
    public static final int NUMBER_OF_DAIS_AND_CELLS = 100;
    private Door[] doors = new  Door[NUMBER_OF_DAIS_AND_CELLS];

    public Door[] onThe100ThDais(){
        initialising();
        for(int i = 0; i< NUMBER_OF_DAIS_AND_CELLS; ++i){
            for(int j=i;j<NUMBER_OF_DAIS_AND_CELLS;j+=i+1){
                changeLock(j);
            }
        }
        return doors;
    }

    private void changeLock(int j) {
        if (doors[j]==Door.CLOSE){
            doors[j]=Door.OPEN;
        }else{
            doors[j]=Door.CLOSE;
        }
    }

    private void initialising() {
        for ( int i=0;i<NUMBER_OF_DAIS_AND_CELLS;++i){
            doors[i]=Door.CLOSE;
        }
    }

    public static void main(String[] args) {
        Sultan c = new Sultan();
        Door[] d = c.onThe100ThDais();
        for (int i=0;i<NUMBER_OF_DAIS_AND_CELLS;++i){
            if ( d[i]==Door.OPEN)
                System.out.println(i+1 +" "+ d[i]);
        }
    }
}
