public class CorrectInputException extends IllegalAccessException {
    private String value;
    public String getValue(){
        return value;
    }
    public CorrectInputException(String massage){
        super(massage);
    }
}
