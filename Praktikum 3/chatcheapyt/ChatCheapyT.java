import java.util.Scanner;
import java.util.Random;

public class ChatCheapyT{

  private static String handleSilence(String input){
    if (input.isBlank())
      return "Dann sage ich aber auch nichts!";
    else
      return null;
  }

  private static String handleTooLong(String input){
    if(input.length() > 50){
      return "Das ist mir zuviel zu lesen! Bitte kürzen Sie Ihre Anfrage!";
    }
    return null;
  }

  private static String handleExam(String input){
    if (input.equals("Was kommt in der Klausur dran?")){
      return "Die Klausur orientiert sich an den Praktika!";
    }
    return null;
  }

  private static String handleQuestion(String input){
    if(input.endsWith("?")){
      return "Tut mir leid, aber die ChatCheapyT-Server sind gerade ausgelastet! Schließen Sie bitte ein ChatCheapyT-Pro-Abo ab!";
    }
    return null;
  }

  private static String handleExclamation(String input){
    if(input.contains("!") && input.toLowerCase().contains("bitte")){
      return "Als Antwort habe ich ein YouTube-Video generiert: https://youtu.be/dQw4w9WgXcQ";
    } else if(input.contains("!")){
      return "Wie ist das Zauberwort?";
    }
    return null;
  }

  private static String handleChatGPT(String input){
    if(input.contains("ChatGPT")){
      return input.replace("ChatGPT", "ChatCheapyT");
    }
    return null;
  }

  private static String handleScream(String input){
    int capitalizedCount = (int) input.chars().filter(Character::isUpperCase).count();

    if ((2*capitalizedCount) >= input.length()){
      return "Bitte schreien Sie mich nicht an!";
    }
    return null;
  }

  private static String handleReverse(String input){
    if(input.toLowerCase().startsWith("umdrehen:")){
      input = input.replaceAll("(?i)umdrehen:", "");
      StringBuffer reversed = new StringBuffer(input).reverse();
      return reversed.toString();
    }
    return null;
  }

  private static String handleAdd(String input) {
    if (!input.toLowerCase().startsWith("addiere")) {
        return null;
    }
    input = input.replaceAll("(?i)Addiere", "");
    String[] parts = input.trim().split("\\s+");
    if (parts.length < 2) {
        return null;
    }
    double sum = 0.0;
    StringBuilder result = new StringBuilder();
    for (String part : parts) {
        double number;
        if (part.toLowerCase().equals("e")) {
            number = Math.E;
        } else if (part.toLowerCase().equals("pi")) {
            number = Math.PI;
        } else {
            try {
                number = Double.parseDouble(part);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        sum += number;
        result.append(number).append(" plus ");
    }
    if (result.length() > 0) {
        result.setLength(result.length() - 5); // Remove the last " plus "
        result.append(" ist gleich ").append(sum).append("! Take that, ChatGPT!");
        return result.toString();
    }
    return null;
  }


  private static String handleJoke(String input){
    if (input.equals("JokeGPT")){
      String[] jokes = {
        "Was ist der Unterschied zwischen einem Schneemann und einem Schneehaufen? - Die Karotten-Nase.",
        "Wie nennt man einen Bumerang, der nicht zurückkommt? - Stock.",
        "Ein Mann kommt in eine Bar und bestellt H2O. Ein anderer Mann sagt: Ich hätte auch gerne H2O. Der zweite Mann stirbt.",
        "Ein Skelett geht in eine Bar und sagt: Ich hätte gerne ein Bier und einen Mopp.",
        "Woran erkennt man, dass ein Elefant im Kühlschrank war? An den Fußabdrücken in der Butter.",
        "Wie nennt man einen Taucher ohne Harpune? - Harmlos.",
        "Was ist ein Pirat ohne Schatz? - Arbeitslos.",
        "Ein Mann betritt eine Bar mit seinem Papagei. Der Barkeeper sagt: Wow, was für ein tolles Tier! Kann es sprechen? Der Papagei antwortet: Ja, natürlich kann ich sprechen. Kannst du fliegen?",
        "Was ist weiß und fliegt durch die Luft? - Ein Brief mit Heimweh.",
        "Was ist schwarz-weiß und steht in der Ecke? - Ein freches Klavier."
      };
      return jokes[new Random().nextInt(jokes.length)];
    }
    return null;
  }

  public static String handleDiceroll(String input) {
    if (input.toLowerCase().equals("dice")) { //default outcome für "dice"
        int randomNumber = new Random().nextInt(6) + 1;
        return Integer.toString(randomNumber);
    }

    if (input.toLowerCase().startsWith("dice ")) {
        input = input.substring(5).trim();
        String[] parts = input.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String part : parts) {
            try {
                int diceSides = Integer.parseInt(part);
                if (diceSides > 0) {
                    int randomNumber = new Random().nextInt(diceSides) + 1;
                    result.append(randomNumber).append(" ");
                }
            } catch (NumberFormatException e) {
                return null;
            }
        }
        if (result.length() > 0) {
            return result.toString().trim();
        }
    }
    return null;
  }

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    String prompt = null;

    do {

      System.out.print("Prompt: ");
      prompt = input.nextLine(); 

      String answer = handleSilence(prompt);

      if (answer == null)
        answer = handleTooLong(prompt);

      if (answer == null)
        answer = handleExam(prompt);

      if (answer == null)
        answer = handleQuestion(prompt);
      
      if (answer == null)
        answer = handleChatGPT(prompt);

      if (answer == null)
        answer = handleReverse(prompt);

      if (answer == null)
        answer = handleAdd(prompt);

      if (answer == null)
        answer = handleExclamation(prompt);

      if (answer == null)
        answer = handleJoke(prompt);
      
      if (answer == null)
        answer = handleScream(prompt);

      if (answer == null)
        answer = handleDiceroll(prompt);

      if (prompt.equalsIgnoreCase("bye"))
        continue;

      if (answer != null)        
        System.out.println("ChatCheapyT: " + answer);

      else
        System.out.println("ChatCheapyT: Ich verstehe Sie leider nicht!");


    } while (!prompt.equalsIgnoreCase("bye"));

    System.out.println("Bye!");

    input.close();
  }
}

