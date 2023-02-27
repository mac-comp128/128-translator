package comp128.translator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * The language detector should detect the language of a text.
 * It must be "trained" to learn the words that appear in each language.
 * After it is trained, detect will be called for each text.
 *
 * @author Shilad Sen
 */
public class LanguageDetector {
    /**
     * Wrapper over the WikAPIdia API.
     */
    private final WikipediaProvider wikAPIdia;

    //TODO: Add your instance variables here.


    /**
     * Constructs a new language detector.
     * @param wikAPIdia
     */
    public LanguageDetector(WikipediaProvider wikAPIdia) {
        this.wikAPIdia = wikAPIdia;

        //TODO: initialize any instance variables

    }

    /**
     * Learn the words used in each language.
     * Only needs to be called once each time your program is run.
     */
    public void train() {
        System.out.println("Starting training ...");
        List<String> languages = wikAPIdia.getLanguageCodes();
        for(String  lang : languages) {
            System.out.println("\t Training "+lang+":");

            //TODO: complete me


        }
        System.out.println("Training Done.");
    }

    /**
     * Detect the language associated with a text.
     * @param text
     * @return the detected language code
     */
    public String detect(String text) {
        String bestLang = null;
        //TODO: complete me

        return bestLang;
    }

    public static void main(String args[]) throws IOException {
        WikipediaProvider wrapper = new WikipediaProvider(Utils.ALL_LANGS);

        // Check that the wikipedia api is working properly...
        // Example showing how to find the translation of apple in the other installed languages
        LocalPage page = wrapper.getLocalPageByTitle(Utils.LANG_ENGLISH, "Apple");
        System.out.println("Apple in other languages:");
        List<LocalPage> otherLangs = wrapper.getInOtherLanguages(page);
        for (LocalPage page2 : otherLangs) {
            System.out.println("\t" + page2.getLanguageCode() + ": " + page2.getTitle());
        }

        // prepare the detector
        LanguageDetector detector = new LanguageDetector(wrapper);
        detector.train();

        // use the detector
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
        while (true) {
            System.out.println("Enter text to detect language, or 'stop'.");
            String text = in.readLine();
            if (text.trim().equalsIgnoreCase("stop")) {
                break;
            }
            System.out.println("language of text is " + detector.detect(text));
        }
    }
}
