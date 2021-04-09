package comp128.translator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A program to extract entities from a possibly multilingual text.
 *
 * @author Shilad Sen, Bret Jackson
 */
public class EntityExtractor {
    private final WikipediaProvider wikAPIdia;
    private final LanguageDetector detector;

    /**
     * Creates a new entity extractor.
     * @param wikAPIdia
     * @param detector
     */
    public EntityExtractor(WikipediaProvider wikAPIdia, LanguageDetector detector) {
        this.wikAPIdia = wikAPIdia;
        this.detector = detector;
    }

    /**
     * Extracts entities from a text in some unknown language and prints translations if found using System.out.println
     * @param text The text to extract entities from
     * @param goalLanguageCode The target language to translate entities to.
     */
    public void extract(String text, String goalLanguageCode) {
        //TODO: complete me


    }


    public static void main(String args[]) throws IOException {
        //TODO complete me

    }
}
