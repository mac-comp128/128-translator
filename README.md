Comp 128 - HW2: Language Detection
===
In this homework assignment you will develop a program that analyzes text written in another language and detects the language of new passages of text. Along the way, you'll get a chance to practice with Java's Maps. Otherwise known as HashMaps, hashtables, or dictionaries.
 
Identifying Languages
---

For your task, you'll write a class that detects the language of a text. 

In a nutshell, the Language Detector generates scores that indicate how often the words in a particular text appear in reference texts from a variety of languages.
For example, assume you're scoring the text "Aw human sowels is born free" against the language Scots.
You will sample 500 random Scots Wikipedia articles and find:
 *  "Aw" has count 12
 *  "human" has count 19
 *  "is" has count 2408
 *  "born" has count 67
 *  "free" has count 11
 
Thus, the total score for Scots is (12 + 19 + 2408 + 67 + 11) = 2517. 
Your program will repeat this computation in all the given languages.

It should then normalize the scores by dividing the total scores by the number of words (including repeated words) found for each language. Normalization makes for a fairer comparison since some languages might have longer wikipedia articles with more words.

Finally it chooses the language with the highest normalized score as the detected language.

Note that this is a fairly naive method of detecting what language a text is in, both in terms of how we treat language (as a "bag-of-words" rather than at the level of sentences or paragraphs), and in terms of our reliance on random Wikipedia articles being good representations of the language they're purportedly written in (Scots Wikipedia, in fact, [is particularly suspect](https://www.theguardian.com/uk-news/2020/aug/26/shock-an-aw-us-teenager-wrote-huge-slice-of-scots-wikipedia)!). The first problem can be solved with more sophisticated methods that you may see in a Natural Language Processing class (some that are simple extension of what you'll do here like [this](https://dl.acm.org/doi/10.5555/2390470.2390475), and some that rely on more modern techniques like [this](https://aclanthology.org/2021.eacl-srw.6/)). Nevertheless, you'll find that sometimes extraordinarly naive techniques can be surprisingly effective, particularly for languages that are very different!

Assignment Details
---

Take a look at LanguageDetector.java. You'll complete your work in this class.
The major methods, `train()`, `detect()`, and `main()` had been declared for you, but currently they don't do anything useful.

### `train()` Method
A LanguageDetector must be trained once to identify words in each language. 
The train method essentially "precomputes" the counts for each word in each language to speed up language detection.

The train method needs to do the following:

* For each language:
    * Extract the page text from 500 random pages.
    * Split each page text into words (look for a helper method in Utils).
    * Count how many times every unique word occurs across all 500 pages.
	* Count how many total words (including repeated words) were read.

**Hint: The Utils class has some helpful constants and a method to split words. You should also explore the methods in the WikipediaProvider class**

You'll need to create instance variables to capture the data (counts for each word for each language and the total number of words read for each language).

### `detect(text)` Method

Given a particular text, the detect method does the following: 
* Split the text into words.
* Retrieve the number of times each word occurs in the 500 random pages for each language from the training data.
* Sum up those counts for each language and normalize them.

Choose the language with the highest count as the detected language. 

Test your program by Google-ing texts in each language. As you are testing, it will speed up your program to use fewer random pages, although it will also make it more likely that the language is not detected.
Your program should do a pretty good job, but it may get a few languages confused - for example Nordic languages (like Danish, Swedish, Icelandic, etc.) are similar enough that even more sophisticated methods [have trouble distinguishing between them](https://aclanthology.org/2021.vardial-1.8/)!

#### Attribution
This assignment was originally developed by Shilad Sen using the WikiBrain library. It was updated
by Bret Jackson to use the Wikipedia API instead to work around dependency issues with Wikibrain and Java 11.

It was modified Spring 2023 to remove the translation portion to make a shorter assignment.

This README was edited in Fall 2023 by Suhas Arehalli primarily to draw connections to NLP work on language ID and mention to the Scots Wikipedia incident.
