# Project-5
First the General layout of the application was created using a gridPane. The label for hamming distance and the textfield were created 
next. After that the slider for the hamming distance was created. Using addListener, the function of updating the value in the textfield 
everytime the slider was moved was implemented. In addition, the slider was constrained to the ineger values 1 through 4. That was done
by truncating the value of the slider. After that, the class StationsHD was created. This class contains the methods needed to complete
the functions of the application. First, using the method, read, the stations were read from the file mesonet and stored in an arraylist
that can be retrived using the method getStaionsList. Back in the main class a comboBox list was created and the list of staitons was added
to that. After that a list view was created to show the stations that has the same hamming distance shown in the slider from the staiton
choosed from the comboBox. This was done by adding a button that has the funciton of showing the stations. After that, five labels and five
textfields were created to show how many stations have 0, 1, 2, 3 or 4 hamming distnace away from the station choosen form the comBox.
The method to calcualte the number of stations that have a certain hamming disntance from a specific staiton was implemented in the class
StationsHD. The function of showing the actual numbers in each respective box was added to a button titled Calculate HD. After that, 
the function of adding a new statoin to the comboBox was added to button titled "add Station". After this, the creation of the creative 
section started. a box to show the index of the station in the array List was created invoked by choosing a station from the arraylist.
In addtion, I added a section to show the asceii average ceiling and floor of the choosen station from the comboBox list. The method for that
was written in the class StationsHD.
