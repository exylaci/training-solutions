package statemachine.seatheater;

public enum SeatHeaterState {


    OFF { public SeatHeaterState next(){return THREE;}},
    THREE { public SeatHeaterState next(){return TWO;}},
    TWO { public SeatHeaterState next(){return ONE;}},
    ONE{public SeatHeaterState next(){return OFF;}};

    public abstract SeatHeaterState next();
}
