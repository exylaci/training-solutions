package immutable.satellite;

import java.util.ArrayList;
import java.util.List;

public class SpaceAgency {
    private List<Satellite> satellites = new ArrayList<>();

    public void registerSatellite(Satellite satellite){
        if ( satellite==null ){
            throw new NullPointerException("Parameter must not be null!");
        }
        satellites.add(satellite);
    }

    public Satellite findSatelliteByRegisterIdent(String registerIdent){
        if( registerIdent==null || registerIdent=="" ){
            throw new NullPointerException("Parameter must not be null!");
        }
        for ( int i=0; i<satellites.size() ; ++i ){
            if ( satellites.get(i).getRegisterIdent().equals( registerIdent )){
                return satellites.get(i);
            }
        }
        throw new IllegalArgumentException("Satellite with the given registration cannot be found!" + registerIdent);
    }

    @Override
    public String toString() {
        return satellites.toString();
    }

    public static void main(String[] args) {
        SpaceAgency sa = new SpaceAgency();
        // When
        sa.registerSatellite((new Satellite(new CelestialCoordinates(12, 23, 45), "ASD345")));
        sa.registerSatellite((new Satellite(new CelestialCoordinates(22, 33, 44), "QWE789")));
        //Then
        System.out.println(sa.toString());

    }
}
