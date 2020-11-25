package immutable.satellite;

import java.util.stream.Stream;

public class Satellite {
    private CelestialCoordinates destinationCoordinates;
    private String registerIdent;

    public Satellite(CelestialCoordinates destinationCoordinates, String registerIdent) {
        if ( registerIdent==null || registerIdent.isBlank() ){
            throw new IllegalArgumentException("Register ident must not be empty!");
        }

        this.destinationCoordinates = destinationCoordinates;
        this.registerIdent = registerIdent;
    }

    public void modifyDestination(CelestialCoordinates diff){
        destinationCoordinates = new CelestialCoordinates(
            destinationCoordinates.getX()+diff.getX(),
                destinationCoordinates.getY()+diff.getY(),
                destinationCoordinates.getZ()+diff.getZ());
    }

    public CelestialCoordinates getDestinationCoordinates() {
        return destinationCoordinates;
    }

    public String getRegisterIdent() {
        return registerIdent;
    }

    @Override
    public String toString() {
        return registerIdent +": " +destinationCoordinates;
    }
}
