package Assignment_4;

class Calculator<T> {

    private final T t1;
    private final T t2;

    public Calculator(T t1, T t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public Object operate() throws InvalidDataTypeException, ZeroDivisionException {

        if (t1 instanceof String && t2 instanceof String) return (t1 + (String) t2);
        else if (t1 instanceof Integer && t2 instanceof Integer){
            if( (Integer)t2 == 0) throw new ZeroDivisionException("Divisor can not be zero");
            return (Integer)t1 / (Integer)t2;
        }
        else throw new InvalidDataTypeException("Invalid Operand Datatype Type");
    }

    public boolean check(T t1, T t2) throws InvalidDataTypeException, TypeMismatchException {

        if (t1 == null || t2 == null) {
            throw new NullPointerException("One of the  argument is null");

        } else if (t1 instanceof String) {
            if (t2 instanceof String) return t1.equals(t2);
            else throw new TypeMismatchException("Both argument should be of String type");

        } else if (t1 instanceof Integer) {
            if (t2 instanceof Integer) return t1 == t2;
            else throw new TypeMismatchException("Both argument should be of String type");

        } else throw new InvalidDataTypeException("Invalid Operand Datatype Type");
    }
}