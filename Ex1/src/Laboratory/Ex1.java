package Laboratory;

public class Ex1 {

    public static void checkSize(int maxColumns, int maxLines,String[][] array) throws MyException.MyArraySizeException{
        int whatLine = 0;
        if(array.length != maxLines){
            throw new MyException.MyArraySizeException("Amount of Lines are not " + maxLines);
        }
        for (String[] lineArray:array) {
            whatLine++;
            if(lineArray.length != maxColumns){
                throw new MyException.MyArraySizeException(String.format("Amount of Columns are not %d in %d line", maxColumns, whatLine));

            }
        }
    }

    public static int convertToInt(String data) throws NumberFormatException{
        int convertData;
        try {
            convertData = Integer.parseInt(data);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("It's not a digit");
        }

        return convertData;
    }

    public static int sumArray(String[][] array) throws MyException.MyArrayDataException{
        int sum = 0;
        for (int line = 0; line < array.length; line++){
            for (int column = 0; column < array[line].length; column++) {
                try {
                    sum += convertToInt(array[line][column]);
                } catch (NumberFormatException e) {
                    System.out.println("Sum is not complete = " + sum);
                    throw new MyException.MyArrayDataException(String.format("Data in [%d][%d] is not a digit",line + 1,column + 1));
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[][] mass = {{"1","2","3","3"}, {"1", "abc", "3", "3"}, {"1", "2", "3", "3"},{"1", "2", "3", "3"}};

        try {
            checkSize(4,4, mass);
        } catch (MyException.MyArraySizeException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(sumArray(mass));
        } catch (MyException.MyArrayDataException e) {
            e.printStackTrace();
        }

    }
}
