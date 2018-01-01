Note :
<input_file> must be kept at path : abhijit_bhandarkar_assign_3/airportSecurityState

Assuming you are in the directory abhijit_bhandarkar_assign_3/airportSecurityState:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
 
ant -buildfile src/build.xml run -Darg0=(input_file_name) -Darg1=(output_file_name) -Darg2=(debug level)

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date:10/20/2017]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

ArrayList is used to store the prohibited items. 
Time complexity for finding prohibited items : O(n)

String is used to store the output
Time complexity for inserting the string in String array : O(n)

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).


