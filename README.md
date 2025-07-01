# Final-Project
Project Description:
The Flashcard Study App is a Java-based console application designed to help users study and track their mastery of flashcards. It allows users to:

Add custom flashcards (question and answer pairs) to a study list.

Review flashcards one at a time and mark them as mastered.

View a list of all mastered flashcards.

Save progress to files for continued study in future sessions.

Instructions for Running the Program:

Ensure Java Development Kit (JDK) 8 or later is installed.

Compile the program with:
javac FinalProject.java Flashcard.java FlashcardManager.java

Run the program with:
java FinslProject (Note: class name has a typo)

Examples of Usage:

Add a Flashcard:
Select option 1 to enter a question and its corresponding answer.

Study Flashcards:
Select option 2 to review the next flashcard in the list.
Press Enter to reveal the answer, and mark whether you got it right.
Correct answers move the card to the mastered list.

View Mastered Cards:
Select option 3 to see questions you’ve already mastered.

Exit and Save:
Select option 4 to save both study and mastered flashcards to text files.

Known Limitations:

Mastered cards are stored in a fixed-size array of 100.

No search or filter functionality for flashcards.

Flashcards are only shown in the order they were added (no randomization or review history).

No way to move cards back from mastered to study list.

Future Improvements:

Replace fixed-size array with a dynamic structure like ArrayList.

Implement random card order and spaced repetition.

Allow editing and deleting flashcards.
