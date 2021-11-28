package Assignment_4;

class CarpetLengthExceedException extends Exception {
    public CarpetLengthExceedException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return super.getMessage() + "\nError: CarpetLengthExceedException{\"Carpet length Exceeded\"}";
    }
}

class InvalidDataTypeException extends Exception{
    public InvalidDataTypeException (String message){
        super(message);
    }

    @Override
    public String toString() {
        return super.getMessage() + "\nError: InvalidDataTypeException{\"Can not accept this type\"}";
    }
}

class TileNotExistException extends Exception{
    public TileNotExistException (String message){
        super(message);
    }

    @Override
    public String toString() {
        return super.getMessage() + "\nError: TileNotExistException{\"Tile not exist at this length\"}";
    }
}

class TypeMismatchException extends Exception{
    public TypeMismatchException (String message){
        super(message);
    }

    @Override
    public String toString() {
        return super.getMessage() + "\nError: TypeMismatchException{\"Comparing Object type  not match\"}";
    }
}

class ZeroDivisionException extends Exception{
    public ZeroDivisionException (String message){
        super(message);
    }

    @Override
    public String toString() {
        return super.getMessage() + "\nError: ZeroDivisionException{\"Can not divide with zero\"}";
    }
}


