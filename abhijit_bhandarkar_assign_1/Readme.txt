Note :
<input_file> must be kept at path : abhijit_bhandarkar_assign_1/myArrayList

Assuming you are in the directory abhijit_bhandarkar_assign_1/myArrayList:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=FIRST -Darg1=(input_file_name) -Darg2=(output_file_name)

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

[Date: 09/15/2017]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

MyArrayList class has a array with initial size 50. When the input size exceeds capacity, the array size increases by 50%
Time complexity for inserting the number in the array in sorted manner : O(n)
Time complexity for removing the number from array : O(n)
Time complexity for adding all the number of the array : O(n)

Class Results uses an array of String.
Time complexity for inserting the number in String array : O(n)
-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

