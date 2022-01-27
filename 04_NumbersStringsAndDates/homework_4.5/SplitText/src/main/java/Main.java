public class Main {

  public static void main(String[] args) {
    String text = "Qatar's government said the incident began after a newborn baby girl was found in a plastic bag in a rubbish bin at Hamad International Airport's departures lounge on 2 October. The discovery triggered an immediate search for the parents, including on 10 planes in the vicinity.\n" +
            "\n" +
            "Several women on board a Sydney-bound Qatar Airways flight said they were ordered to disembark, taken to ambulances on the tarmac, and told to remove their underwear for an examination.\n" +
            "\n" +
            "The women said they were given no information by officials and that they did not have an opportunity to provide informed consent.\n" +
            "\n" +
            "Australian Prime Minister Scott Morrison described the incident as \"appalling\" and \"unacceptable\".\n" +
            "\n" +
            "His Qatari counterpart, Sheikh Khalid bin Khalifa Al Thani, said standard procedures were violated and expressed his \"sincerest apology for what some female travellers went through.";
    System.out.println(splitTextInToWords(text));

  }

  public static String splitTextInToWords(String text) {
    //TODO реализуйте метод
    String newText = "";
    if (text.trim().length() != 0)
    {
      text = text.replaceAll("\\W+\\s"," ");
       text = text.replace("-", " ");
       text = text.replace(".", "");
       text = text.replaceAll("\\d+", "");

      String[] words = text.split(" ");
      for (int i = 0; i < words.length; i++) {
        if (!words[i].equals(""))
        newText = newText + words[i].strip() + "\n";
      }
    }
    return newText.strip();


  }


}