package Laboratory;

public class MyException {

    public static class  MyArraySizeException extends Exception{
        public  MyArraySizeException(String message){
            super(message);
        }
    }

    public static class  MyArrayDataException extends Exception{
        public  MyArrayDataException(String message){
            super(message);
        }
    }
}
