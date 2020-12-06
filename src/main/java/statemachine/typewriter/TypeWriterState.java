package statemachine.typewriter;

public enum TypeWriterState {
    UPPERCASE {
        @Override
        public TypeWriterState next() {
            return LOWERCASE;
        }
    },
    LOWERCASE {
        @Override
        public TypeWriterState next() {
            return UPPERCASE;
        }
    };

    public abstract TypeWriterState next();
}
