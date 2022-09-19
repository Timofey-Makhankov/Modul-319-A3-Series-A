package ch.tbz.lib;

// Get from Class library (JDK)
import java.util.Scanner; // Gets a parser for input data

/**
 * Input Methods like the BASIC INPUT (or c's scanf()).
 *
 * Because Java has no simple console input, I added this functions to
 * my library.
 * Simply import
 * <code>import static eu.gressly.io.utility.Input.*</code>
 * and then use
 * <code>int x = inputInt("Please enter x: ");</code>
 *
 * @version 0.1 (Oct 8, 2014)
 * @author Philipp Gressly Freimann
 *         (philipp.gressly@santis.ch)
 */

public class Input {
    //
    private static Scanner sc = new Scanner(System.in);

    /**
     * @see setAskAgain();
     */
    private static boolean askAgain = true;


    /**
     * @see setAddQuestion()
     */
    private static String addQuestion = "";


    /**
     * @see setNumberFormatError()
     */
    private static String numberFormatErrorMessage = "Error entering a number!";


    /**
     * If askAgain is false, the user is asked only once.
     * Entering newlines do not ask the user again showing the "question".
     * default: true
     * @param askAgain
     */
    public static void setAskAgain(boolean askAgain) {
        Input.askAgain = askAgain;
    }


    /**
     * If the programmer only wants to ask for a "value" instead of a
     * "question", this text has to be set.
     * Typically: setAddQuestion("Please enter the value for %s : ");
     * "%s" is replaced by the programmers question afterwards.
     * @param addQuestion has to contain a %s, where the parameter name
     *        sohuld be replaced.
     */
    public static void setAddQuestion(String addQuestion) {
        if(addQuestion.indexOf("%s") < 0) {
            addQuestion = addQuestion + "%s";
        }

        Input.addQuestion = addQuestion;
    }


    /**
     * This message is shown to the user, if she/he does not enter a
     * number while using "intputInt()" or "inputDouble()".
     * @param errorMessage to show on NumberFormatExceptions.
     */
    public static void setNumberFormatError(String errorMessage) {
        Input.numberFormatErrorMessage = errorMessage;
    }

    // Helper function
    private static void quest(String question) {
        if(null == addQuestion || addQuestion.length() < 1) {
            System.out.println(question);
            return;
        }
        System.out.printf(addQuestion, question);
    }

    /**
     * Asks for a string value
     * @param frage
     * @return
     */
    public static String inputString(String frage) {
        String eingabe = "";
        if(! askAgain) {
            quest(frage);
        }
        while(eingabe.length() < 1) {
            if(askAgain) {
                quest(frage);
            }
            eingabe = sc.nextLine().trim();
        }
        return eingabe;
    }


    /**
     * Asks for a byte value
     * @param question
     * @return
     */
    public static byte inputByte(String question) {
        return (byte) inputNumber(question, byte.class);
    }

    /**
     * Asks for a short value
     * @param question
     * @return
     */
    public static short inputShort(String question) {
        return (short) inputNumber(question, short.class);
    }

    /**
     * Asks for a int value
     * @param question
     * @return
     */
    public static int inputInt(String question) {
        return (int) inputNumber(question, int.class);
    }

    /** Asks for a long value
     public static long inputLong(String question) {
     return (long) inputNumber(question, long.class);
     }

     /**
     * Asks for a float value
     * @param question
     * @return
     */
    public static float inputFloat(String question) {
        return (float) inputNumber(question, float.class);
    }

    /**
     * Asks for a double value
     * @param question
     * @return
     */
    public static double inputDouble(String question) {
        return (double) inputNumber(question, double.class);
    }



    /**
     * Input a single char.
     * Any further chars on the same line are ignored.
     */
    public static char inputChar(String question) {
        return inputString(question).trim().charAt(0);
    }


    /**
     * Returns true, if the users input does not start with the letter 'n'.
     * @param question any Question having "yes" or "no" as answer.
     * @return true if the users answer does not start with an "n" or "N".
     */
    public static boolean inputBoolean(String question) {
        return 'n' != inputString(question).trim().toLowerCase().charAt(0);
    }

    /**
     * Asks for a text
     * @return
     */
    private static String inputString() {
        String eingabe = "";
        while(eingabe.length() < 1) {
            eingabe = sc.nextLine().trim();
        }
        return eingabe;
    }

    /**
     * Scans any Number out of a object (see number class)
     * @param question
     * @param numberClass
     * @return
     */
    private static Number inputNumber(String question, Object numberClass) {
        String answer = "";
        if(! askAgain) {
            answer = inputString(question);
        }
        while (true) {
            try {
                if(askAgain) {
                    answer = inputString(question);
                }
                Number zahl = 0; // will be changed soon...
                if(numberClass == byte.class) {
                    zahl = Byte.parseByte(answer);
                }
                if(numberClass == short.class) {
                    zahl = Short.parseShort(answer);
                }
                if(numberClass == int.class) {
                    zahl = Integer.parseInt(answer);
                }
                if(numberClass == long.class) {
                    zahl = Long.parseLong(answer);
                }
                if(numberClass == float.class) {
                    zahl = Float.parseFloat(answer);
                }
                if(numberClass == double.class) {
                    zahl = Double.parseDouble(answer);
                }
                return zahl;
            } catch (Exception ex) {
                System.out.println(numberFormatErrorMessage);
                if(!askAgain) {
                    answer = inputString();
                }
            }
        }
    }

} // end of class Input