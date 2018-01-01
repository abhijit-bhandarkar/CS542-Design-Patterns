# DESIGN PATTERNS : Assignment 5 : Visitor Pattern

## Suyog Nerkar
## BU Id: B00638541
## Email: snerkar1@binghamton.edu

## Abhijit Bhandarkar
## BU Id: B00659257
## Email: abhanda4@binghamton.edu

-----------------------------------------------------------------------

Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------

## To compile:
ant -buildfile src/build.xml all

-----------------------------------------------------------------------

## To run by specifying arguments from command line
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0="Input File"
                                 -Darg1="Output File"
                                 -Darg2="Debug Level"

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf firstName_secondName_assign_number.tar.gz firstName_secondName_assign_number

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date : Nov 22, 2017]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

Working instructions:

  Use ant with proper debug level as an arg:

    - 0: No output should be printed from the application to stdout.
         However, it doesn't affect what's getting written to the output file.
         But wrong input error is logged as it is essential.
    - 1: Execution level logger, Full node to node debug provided.
    - 2: Printing the results only.
    - 3: Open for future modifications
    - 4: Print to stdout every time a constructor is called

  Data structure used to build a tree of words is Binary Search Tree :

      A BST is implemented and the words are stored as nodes of the tree

      - Avg case time complexity to insert a single word is O(log(n)).
        Worst case time complexity to insert a single word is O(n).
        Best case time complexity to insert a single word is 1.

  - Ant would need full file paths to provide the proper results.

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).
- StackOverflow for errors and issues.
- Referred the integers BST builder algorithm from the web and implemented the
  algorithm to incorporate strings in it with nodes storing words.