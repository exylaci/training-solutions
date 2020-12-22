package iofilestest;

public class Cheese {
    private final String name;
    private final double laktacitLevel;

    public Cheese(String name, double laktacitLevel) {
        if ( name==null||name.isBlank()||laktacitLevel<0) throw new IllegalArgumentException("Invalid data!");
        this.name = name;
        this.laktacitLevel = laktacitLevel;
    }

    public String getName() {
        return name;
    }

    public double getLaktacitLevel() {
        return laktacitLevel;
    }


    @Override
    public boolean equals(Object obj) {
        if ( this==null && obj==null     ) return true;
        if ( this==null || obj==null) return false;
        if (this.hashCode()==obj.hashCode()) return true;
        if( obj instanceof Cheese && this.name.equals(((Cheese)obj).getName())) return true;
        return false;
    }
}