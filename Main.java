// This program is a game that helps people learn about food and water waste

// Imports 
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
* This program runs a game to teach people about food and water waste
*
* @authour Maryam Ali
* @version 1.0
* @since 2021-11-08
*/

class main{

// Declare global variables  
  public static double weeklyshowergallons;
  public static double showergallons;
  public static String usershower []; 
  public static String showerlength;
  public static String output = "";
  public static String output2 ="";
  public static String invalid = "\nIncorrect!";
  public static double leaks = 0;
  public static int foodsaved = 0;
  public static String [] showerinfo1;

/*
* This method takes a String of data and saves it to an array
* 
* @param a is the parameter to the array method 
* returns String [] this returns the String as an array
*/   
  public static String [] array (String a){
    showerinfo1 = a.split(",");
    return showerinfo1;
  }


/*
* This method performs the calculations for water usage
* 
* @param a is the first parameter to the calculate method
* @param b is the second parameter to the calculate method 
* returns double this returns the result of the calculations weeklyshowergallons
*/   
  public static double calculate (int a, int b){
    double SHOWER_FLOW = 2.5;
  // Calculate water usage       
    showergallons = SHOWER_FLOW * a;
    weeklyshowergallons = showergallons * b;
    return weeklyshowergallons;
  }

/*
* This method is an overloaded method for the method calculation.
* It adds 1 to the variable leaks  
*
* returns double this returns the value of the variable leaks
*/ 
  public static double calculate (){
// add 1 to leaks     
    leaks = leaks + 1;
    return leaks;
  }

/*
* This method performs executes the code for each decision the user makes 
* 
* @param a is the parameter to the Decisions method  
* returns String this returns either the invalid variable or the statement if its correct 
*/ 
  public static String Decisions (int a){
          // decision statement for a = 1
        if (a == 1){
          return invalid;
        }
  // decision statement for a = 2
        else if (a == 2 ){
          return invalid; 
        }
  // decision statement for a = 3
        else if (a == 3){
          return invalid;
        }
  // decision statement for a = 4
        else if (a == 4){
          foodsaved = foodsaved + 1;
          return "\nCorrect! You saved "+ foodsaved+"/3 foods!\nDid you know eggs are okay to be eaten up to 3 weeks past their sell-by-date.";
        }
        return invalid;
      }
/*
* This method returns the first element in the array 
* 
* @param array is the only parameter to the indexreturn method 
* returns String this returns showerlength 
*/   
  public static String indexreturn (String[]array){
    showerlength = array[0].trim();
    return showerlength;
  }

/*
* This method runs the activities for the water section of the game
* no param
* returns void
*/   
// Water Method
  public static void water (){
// Create Scanner         
        Scanner input = new Scanner (System.in);
// Declare String variables output and output2  
        //String output = "";
        //String output2 ="";
// Print what the user will learn with the activities
        System.out.println ("The average Canadian uses about 329L of water... Throughout this game you will learn tips on how to bring this number down!");
        
// Delay
        try {
              Thread.sleep(5000);
          } catch (InterruptedException e) {
              e.printStackTrace();   
          }   

// Clear Screen
        System.out.print("\033[H\033[2J"); 
        System.out.flush(); 
// declare and initiliaze int variable shower        
        int shower = 0;
// While loop to repeat if user input is invalid         
      while (shower != 1 && shower != 2 && shower != 3 && shower != 4 && shower != 5 && shower != 6 && shower !=7 && shower != 8 && shower != 9){ 
// Delay
        try {
                Thread.sleep(900);
            } catch (InterruptedException e) {
                e.printStackTrace();   
            }        
// Clear Screen
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
// Shower acitivity prints instructions and users options
        System.out.print ("How long is your shower normally?");
        System.out.println ("\nPick a range: ");
        System.out.println ("");
        System.out.println("1. 2 minutes");
        System.out.println("2. 4-6 minutes");
        System.out.println("3. 6-8 minutes");
        System.out.println("4. 8-10 minutes");
        System.out.println("5. 10-12 minutes");
        System.out.println("6. 12-14 minutes");
        System.out.println("7. 14-16 minutes");
        System.out.println("8. 16-18 minutes");
        System.out.println("9. 18-20 minutes");
        System.out.print("Enter the correct number for choice: ");
// get user        
        shower = input.nextInt();
      } 
// If statement for shower = 1      
      if (shower == 1){
// try catch for reading file         
        try{
// Create Scanner to read from file           
          Scanner fileInput = new Scanner (new File("waterdata.txt"));
// Save file line to output          
          output = fileInput.nextLine();
// Save output to array by splitting           
          //String showerinfo1 [] = output.split(",");
          array (output);
// Print results           
          System.out.print ("A shower that is "+showerinfo1[0].trim()+" long, in one year would fill up "+showerinfo1[1].trim()+ " and use up "+showerinfo1[2].trim()+" of water");
// Close scanner           
          fileInput.close();
        } catch (IOException e){
          System.out.print(e);
        }
      }
// Decision statement for shower = 2      
      else if (shower== 2) {
// try catch to read from file         
        try{
// Create two scanners to read file           
          Scanner fileInput = new Scanner (new File("waterdata.txt"));
          Scanner fileInput2 = new Scanner (new File("waterdata.txt"));
// Save the correct line to output           
          output = fileInput.nextLine();
          output = fileInput.nextLine();
// Save the correct line to output2          
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
// Save output and output2 to arrays by splitting           
          String showerinfo2 [] = output.split(",");
          String showerinfo22 [] = output2.split(",");
// Print results 
          System.out.print ("A shower that is "+showerinfo2[0].trim()+ " - " + showerinfo22[0].trim()+" long, in one year would fill up "+showerinfo2[1].trim()+" - "+ showerinfo22[1].trim()+ " and use up "+showerinfo2[2].trim()+" - "+ showerinfo22[2].trim()+" of water");
// Close both Scanners           
          fileInput.close();
          fileInput2.close();
        } catch (IOException e){
          System.out.print(e);
        } 
      }
// Decision statement for shower = 3      
      else if (shower== 3) {
// try catch to read files        
        try{
// Create two scanner objects           
          Scanner fileInput = new Scanner (new File("waterdata.txt"));
          Scanner fileInput2 = new Scanner (new File("waterdata.txt"));
// Save correct file line to output           
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
// Save correct file line to output2          
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
// Save output and output2 to arrays by splitting           
          String showerinfo3 [] = output.split(",");
          String showerinfo33 [] = output2.split(",");
// Print results 
          System.out.print ("A shower that is "+showerinfo3[0].trim()+ " - " + showerinfo33[0].trim()+" long, in one year would fill up "+showerinfo3[1].trim()+" - "+ showerinfo33[1].trim()+ " and use up "+showerinfo3[2].trim()+" - "+ showerinfo33[2].trim()+" of water");
// Close both scanners           
          fileInput.close();
          fileInput2.close();
        } catch (IOException e){
          System.out.print(e);
        } 
      }
// Decision statement for shower == 4      
      else if (shower== 4) {
// try catch to read file        
        try{
// Create two scanner objects           
          Scanner fileInput = new Scanner (new File("waterdata.txt"));
          Scanner fileInput2 = new Scanner (new File("waterdata.txt"));
// Save correct file line to output           
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
//Save correct file line to output2          
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
// Save output and output 2 to arrays by splitting           
          String showerinfo4 [] = output.split(",");
          String showerinfo44 [] = output2.split(",");
// Print results 
          System.out.print ("A shower that is "+showerinfo4[0].trim()+ " - " + showerinfo44[0].trim()+" long, in one year would fill up "+showerinfo4[1].trim()+" - "+ showerinfo44[1].trim()+ " and use up "+showerinfo4[2].trim()+" - "+ showerinfo44[2].trim()+" of water");
// Close Scanners 
          fileInput.close();
          fileInput2.close();
        } catch (IOException e){
          System.out.print(e);
        } 
      }    
// Decision statement for shower = 5 
      else if (shower== 5) {
// try catch to read file        
        try{
// Create scanners           
          Scanner fileInput = new Scanner (new File("waterdata.txt"));
          Scanner fileInput2 = new Scanner (new File("waterdata.txt"));
// Save correct file line to output           
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
// Save correct file line to output 2          
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
// Save output and output2 to arrays 
          String showerinfo5 [] = output.split(",");
          String showerinfo55 [] = output2.split(",");
// Print results 
          System.out.print ("A shower that is "+showerinfo5[0].trim()+ " - " + showerinfo55[0].trim()+" long, in one year would fill up "+showerinfo5[1].trim()+" - "+ showerinfo55[1].trim()+ " and use up "+showerinfo5[2].trim()+" - "+ showerinfo55[2].trim()+" of water");
// Close Scanners 
          fileInput.close();
          fileInput2.close();
        } catch (IOException e){
          System.out.print(e);
        }
      }
// Decision statement for shower = 6      
      else if (shower== 6) {
// try catch to read file         
        try{
// Create scanners           
          Scanner fileInput = new Scanner (new File("waterdata.txt"));
          Scanner fileInput2 = new Scanner (new File("waterdata.txt"));
// save correct file line to output           
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
// Save correct file line to output2          
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
// Save output and output2 to arrays           
          String showerinfo6 [] = output.split(",");
          String showerinfo66 [] = output2.split(",");
// Print results          
          System.out.print ("A shower that is "+showerinfo6[0].trim()+ " - " + showerinfo66[0].trim()+" long, in one year would fill up "+showerinfo6[1].trim()+ " and use up "+showerinfo6[2].trim()+" - "+ showerinfo66[2].trim()+" of water");
// Close scanners           
          fileInput.close();
          fileInput2.close();
        } catch (IOException e){
          System.out.print(e);
        }
      }
// Decision statements for shower = 7      
      else if (shower== 7) {
// try catch to read files         
        try{
          Scanner fileInput = new Scanner (new File("waterdata.txt"));
          Scanner fileInput2 = new Scanner (new File("waterdata.txt"));
// save correct file line to output           
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
// save correct file line to output2
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
// save output and output2 to arrays           
          String showerinfo7 [] = output.split(",");
          String showerinfo77 [] = output2.split(",");
// print results           
          System.out.print ("A shower that is "+showerinfo7[0].trim()+ " - " + showerinfo77[0].trim()+" long, in one year would fill up "+showerinfo7[1].trim()+" - "+ showerinfo77[1].trim()+ " and use up "+showerinfo7[2].trim()+" - "+ showerinfo77[2].trim()+" of water");
// close scanners           
          fileInput.close();
          fileInput2.close();
        } catch (IOException e){
          System.out.print(e);
        }
      } 
// decision statements for shower = 8      
      else if (shower== 8) {
// try catch to read from file        
        try{
// create two scanners           
          Scanner fileInput = new Scanner (new File("waterdata.txt"));
          Scanner fileInput2 = new Scanner (new File("waterdata.txt"));
// save correct line to output 
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
// save correct line to output2
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
// save output an output2 to arrays 
          String showerinfo8 [] = output.split(",");
          String showerinfo88 [] = output2.split(",");
// print results           
          System.out.print ("A shower that is "+showerinfo8[0].trim()+ " - " + showerinfo88[0].trim()+" long, in one year would fill up "+showerinfo8[1].trim()+ " and use up "+showerinfo8[2].trim()+" - "+ showerinfo88[2].trim()+" of water");
// close scanners           
          fileInput.close();
          fileInput2.close();
        } catch (IOException e){
          System.out.print(e);
        }
      }
// decision statement for shower = 9      
      else if (shower== 9) {
// try catch to read input from file         
        try{
// create scanners 
          Scanner fileInput = new Scanner (new File("waterdata.txt"));
          Scanner fileInput2 = new Scanner (new File("waterdata.txt"));
// save correct file line to output 
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
          output = fileInput.nextLine();
// save correct file line to output2
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
          output2 = fileInput2.nextLine();
// save output and output2 to arrays 
          String showerinfo9 [] = output.split(",");
          String showerinfo99 [] = output2.split(",");
// print results           
          System.out.print ("A shower that is "+showerinfo9[0].trim()+ " - " + showerinfo99[0].trim()+" long, in one year would fill up "+showerinfo9[1].trim()+ " and use up "+showerinfo9[2].trim()+" - "+ showerinfo99[2].trim()+" of water");
// close scanners 
          fileInput.close();
          fileInput2.close();
        } catch (IOException e){
          System.out.print(e);
        }
      }
// decision statament for everything else      
      else {
        System.out.print ("Invalid choice");
      }
// Delay
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();   
      }   
        
// Clear Screen
      System.out.print("\033[H\033[2J"); 
      System.out.flush();
      
// tip for saving water      
      System.out.print("Tip: Water-smart, low flow shower heads use 20% less water than others.");

// Delay
      try {
              Thread.sleep(6000);
          } catch (InterruptedException e) {
              e.printStackTrace();   
          }   

  // Clear Screen
      System.out.print("\033[H\033[2J"); 
      System.out.flush();

// Intro to new activity 
      System.out.println ("Fix the Leaks!");
      System.out.println("The average household's leaks can add up to more than 10,000 gallons of water wasted every year.");

// Delay
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();   
      } 

// to fix input problem      
      input.nextLine();  

  // Clear Screen
      System.out.print("\033[H\033[2J"); 
      System.out.flush();

// Intro to nw activity 
      System.out.println("Follow the instructions to solve the problems and fix the leaks. There are 3 leaks to fix!");

// declare variables for next activity 
      String watertrivia1 = "";
      String watertrivia2 = "";
      String watertrivia3 = "";

// Delay
      try {
        Thread.sleep(7000);
      } catch (InterruptedException e) {
        e.printStackTrace();   
      }  
// Clear Screen
      System.out.print("\033[H\033[2J"); 
      System.out.flush();

// print instructions and options 
      System.out.println("Fix the leak in your garden hose by answering the question correctly!");
      System.out.println ("\nWhich fabric uses the least amount of water in it's production?");
      System.out.println("a) Cotton");
      System.out.println("b) Silk");
      System.out.println("c) Recycled PET polyester");
      System.out.print("Enter the the letter for your answer: ");
// get user input and save to variable       
      watertrivia1 = input.nextLine();
// decision statment for watertrivia = c
      if (watertrivia1.equalsIgnoreCase("c")){
// add to leaks         
        calculate();        
        System.out.println("\nCorrect. You fixed the leaky faucet! " + leaks+"/3 leaks fixed.");
        System.out.println ("A drip every 2 seconds equals over 1,000 gallons of water down the drain each year.");
      }
// decision statement for watertrivia = a      
      else if (watertrivia1.equalsIgnoreCase("a")){
//   
        System.out.println("\nIncorrect. " + leaks+ "/3 leaks fixed.");
      }
// decision statement for watertrivia = b      
      else if (watertrivia1.equalsIgnoreCase("b")){
        System.out.println("\nIncorrect. " + leaks + "/3 leaks fixed.");
      }  
// decision statement for everything else      
      else {
        System.out.println ("\nIncorrect. "+ leaks+ "/3 leaks fixed.");
      }
     
// Delay
      try {
        Thread.sleep(7000);
      } catch (InterruptedException e) {
        e.printStackTrace();   
      }  
// Clear Screen
      System.out.print("\033[H\033[2J"); 
      System.out.flush();

// Display questions and options 
      System.out.println("Fix the leak in the bathroom faucet by answering the question correctly!");
      System.out.println ("\nHow much of the world's fresh water is available to drink?");
      System.out.println("a) 1%");
      System.out.println("b) 25%");
      System.out.println("c) 50%");
      System.out.println("d) 85%");
// Get user answer and save to variable       
      System.out.print("Enter the the letter for your answer: ");
      watertrivia2 = input.nextLine();

// Decision statement when watertivia2 = a
      if (watertrivia2.equalsIgnoreCase("a")){
        calculate();
        System.out.println("\nCorrect. You fixed the leaky faucet! " + leaks+"/3 leaks fixed.");
        System.out.println ("A drip every 2 seconds equals over 1,000 gallons of water down the drain each year.");
      }
// Decision statement when watertivia2 = b      
      else if (watertrivia2.equalsIgnoreCase("b")){
        System.out.println("\nIncorrect. " + leaks+ "/3 leaks fixed.");
      }
// Decision statement when watertivia2 = c      
      else if (watertrivia2.equalsIgnoreCase("c")){
        System.out.println("\nIncorrect. " + leaks + "/3 leaks fixed.");
      }
// Decision statement when watertivia2 = d      
      else if (watertrivia2.equalsIgnoreCase("d")){
        System.out.println("\nIncorrect. " + leaks + "/3 leaks fixed");
      }  
// Decision statement for everyting else       
      else {
        System.out.println ("\nIncorrect. "+ leaks+ "/3 leaks fixed.");
      }
     
// Delay
      try {
        Thread.sleep(7000);
      } catch (InterruptedException e) {
        e.printStackTrace();   
      }  
// Clear Screen
      System.out.print("\033[H\033[2J"); 
      System.out.flush();

// Display user questions and options       
      System.out.println("Fix the leaky pipe by answering the question correctly!");
      System.out.println("\nWhich of the following uses the most water?");
      System.out.println("a) Washing the car");
      System.out.println("b) Doing a load of laundry");
      System.out.println("c) Taking a bath/shower");
// get user input and save to variable       
      System.out.print ("Enter the the letter for your answer: ");
      watertrivia3 = input.nextLine();
// decision statement for watertrivia3 = c
      if (watertrivia3.equalsIgnoreCase("c")){
        System.out.println("\nCorrect!");
        calculate();
        System.out.println("\nYou fixed the leaky hose! " +leaks+"/3 leaks fixed!");
        System.out.println("Check your water meter before and after going two hours without using water. If it changes, there's a leak.");
      }
// decision statement for watertrivia3 = a
      else if (watertrivia3.equalsIgnoreCase("a")){
        System.out.println("\nIncorrect. " +leaks+"/3 leaks fixed.");
      }
// decision statement for watertrivia3 = b      
      else if (watertrivia3.equalsIgnoreCase("b")){
        System.out.println("\nIncorrect. "+ leaks +"/3 leaks fixed.");
      }
// decision statement for everything else       
      else {
        System.out.println ("Incorrect. "+leaks+"/3 leaks fixed.");
      }
      
// Delay
      try {
        Thread.sleep(7000);
      } catch (InterruptedException e) {
        e.printStackTrace();   
      }  
// Clear Screen
      System.out.print("\033[H\033[2J"); 
      System.out.flush();

// Decision statement for leak counter = 3
      if (leaks == 3){
        System.out.println ("You fixed "+leaks+"/3 leaks! You have unlocked a tip!");
        System.out.println ("Use your dishwasher: Dishwashers use 1/2 the energy and 1/3rd of the water as handwashing."); 
      } 
// Decision statement for when not enough leaks fixed       
      else {
        System.out.println ("You didn't fix enough leaks to unlock a tip :(");
      }

// Delay
      try {
        Thread.sleep(6000);
      } catch (InterruptedException e) {
        e.printStackTrace();   
      }  
// Clear Screen
      System.out.print("\033[H\033[2J"); 
      System.out.flush();
// Declare variables and constants for next activity  
      int showertime = 0;
      int showerfrequency =0;
      String useroutput = "";
// Display instructions and question 
      System.out.println ("Check you shower habits!");
      System.out.println ("\nHow long are your showers in minutes?");
      System.out.println ("Type in a number for your answer; example if it's 5 minutes long type 5.");
// get user input and save to variable       
      showertime = input.nextInt();
// User question and instruction 
      System.out.println ("\n How many times a week do you shower?");
      System.out.println ("Type in a number for your answer; example if you shower 3 times a week type in 3.");
// get user input and save to variable       
      showerfrequency = input.nextInt();

// For reading int before string       
      input.nextLine();
// call calculate method to perform calculations        
      calculate(showertime, showerfrequency);
// try catch to write to a file
      try {
// Create FileWriter object 
        FileWriter writer = new FileWriter ("usershower.txt", true);
// Combine PrintWriter and FileWriter         
        PrintWriter Output = new PrintWriter (writer );
// Format and output statement to file         
        Output.println (showertime + ","+ showerfrequency);
//  Close writers        
        Output.close(); 
      } catch (IOException e){
        System.out.print (e);
      }
 // try catch to read from a file      
      try {
        Scanner FileInput1 = new Scanner (new File("usershower.txt"));
        useroutput = FileInput1.nextLine();
        FileInput1.close(); 
      } catch (IOException e){
        System.out.print (e);
      }
// save line from file to array      
      String [] usershower = useroutput.split(","); 

// delay 
      try {
          Thread.sleep(3000);
      } catch (InterruptedException e) {
          e.printStackTrace();   
      }  
// Clear Screen
      System.out.print("\033[H\033[2J"); 
      System.out.flush();
// output results
      System.out.println ("Your showers are around "+ indexreturn(usershower) +" minutes long. You take them "+ usershower[1].trim()+" times a week. This uses up "+ weeklyshowergallons+ " gallons of water a week!");

// delay 
      try {
          Thread.sleep(9000);
        } catch (InterruptedException e) {
          e.printStackTrace();   
      }  
// Clear Screen
      System.out.print("\033[H\033[2J"); 
      System.out.flush();

  
// Ending water section 
      System.out.println ("You have completed the water section!");
  } // end water method  


/*
* This method runs the activities for the food section of the game
* 
* no param
* returns void
*/  
// food method    
  public static void food (){
// create scanner object     
    Scanner input = new Scanner (System.in);
// into to section     
    System.out.println ("Did you know food waste wastes everything. Water, energy, and Earth’s resources."); 
    System.out.println ("In this game you will learn strategies to keep your food fresh, and out of the trash.");
// delay 
    try {
        Thread.sleep(7000);
      } catch (InterruptedException e) {
        e.printStackTrace();   
      }  
// Clear Screen
      System.out.print("\033[H\033[2J"); 
      System.out.flush();

// declare variables for first activity 
      int food1 = 0;
      int food2 = 0;
      int food3 = 0;
      String output3 = "";
      String output4 = "";
      String output5 = ""; 
// display first activity instructions and options       
      System.out.println ("Thrown Out Food");
      System.out.println ("\nSelect 3 things you've thrown out within the last week ");
      System.out.println ("1. eggs");
      System.out.println ("2. bread ");
      System.out.println ("3. milk");
      System.out.println ("4. beef");
      System.out.println ("5. chicken");
      System.out.println ("6. pork");
      System.out.println ("7. fish");
      System.out.println ("8. fruits");
      System.out.println ("9. vegetables");
// get users 3 choices and save to variables       
      System.out.print ("Pleae enter the number for your first answer: ");
      food1 = input.nextInt();
      System.out.print ("\nPleae enter the number for your second answer: ");
      food2 = input.nextInt();
      System.out.print ("\nPleae enter the number for your third answer: ");
      food3 = input.nextInt();
// try catch to read from file       
      try{
// create 3 scanner objects         
        Scanner fileInput3 = new Scanner (new File ("fooddata.txt"));
        Scanner fileInput4 = new Scanner (new File ("fooddata.txt"));
        Scanner fileInput5 = new Scanner (new File ("fooddata.txt"));
// save first line to output3 and save to array         
        output3 = fileInput3.nextLine(); 
        String foodlist1 [] = output3.split(",");
// save second line to output4 and save to array         
        output4 = fileInput4.nextLine();
        output4 = fileInput4.nextLine();
        String foodlist2 [] = output4.split(",");
// save last line to output5 and save to array        
        output5 = fileInput5.nextLine();
        output5 = fileInput5.nextLine();
        output5 = fileInput5.nextLine();
        String foodlist3 [] = output5.split(",");
// close scanners         
        fileInput3.close();
        fileInput4.close();
        fileInput5.close();
// get index numbers for lists         
        int index1 = food1 - 1;
        int index2 = food2 - 1;
        int index3 = food3 - 1; 
// print results for 3 choices         
        System.out.println ("\nThrowing away "+foodlist1[index1].trim()+" for a year is like wasting "+foodlist2[index1].trim()+" of water, which is around "+ foodlist3[index1].trim()+" gallons of water");
        System.out.println ("\nThrowing away "+foodlist1[index2].trim()+" for a year is like wasting "+foodlist2[index2].trim()+" of water, which is around "+ foodlist3[index2].trim()+" gallons of water");
        System.out.println ("\nThrowing away "+foodlist1[index3].trim()+" for a year is like wasting "+foodlist2[index3].trim()+" of water, which is around "+ foodlist3[index3].trim()+" gallons of water");
      } catch (IOException e){
        System.out.print(e);
      }

// Delay
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();   
      }   
// Clear Screen
      System.out.print("\033[H\033[2J"); 
      System.out.flush();

// declare and initialize food counter 
      int foodsaved = 0;
// display question and options  
      System.out.println ("Storing Food");
      System.out.println ("Food lasts longer when stored in the right spot in your fridge.");
      System.out.println ("\nChoose the right spot to store your food and keep it from going bad");
      System.out.println ("\nWhere would you store apples? ");
      System.out.println ("1. Freezer");
      System.out.println ("2. On the counter");
      System.out.println ("3. Cisper drawer in the fridge");
      System.out.println ("4. Fridge shelves");
// get user input and save to variable       
      System.out.print ("Enter the number for your answer: ");
      int fridge1 = input.nextInt();
// decision statement for fridge1 = 1      
      if (fridge1 == 1){
        System.out.println("\nIncorrect!");
      }
// decision statement for fridge1 = 2      
      else if(fridge1 == 2){
        System.out.println("\nIncorrect!");
      }
// decision statement for fridge1 = 3
      else if (fridge1 == 3){
        foodsaved = foodsaved + 1;
        System.out.println ("\nCorrect! You saved "+ foodsaved+"/3 foods!");
        System.out.println("Apples ripen 6-10 times faster at room temperature. Store them in the fridge and they’ll be at their best for 6 weeks.");
      }
// decision statement for fridge1 = 4      
      else if (fridge1 == 4){
        System.out.println ("\nIncorrect!");
      }
// decision statement for everything else 
      else {
        System.out.println ("\nIncorrect!");
      }

// Delay
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();   
      }   
// Clear Screen
      System.out.print("\033[H\033[2J"); 
      System.out.flush();
  
// Display question and options
      System.out.println ("\nWhere would you store eggs? ");
      System.out.println ("1. Freezer");
      System.out.println ("2. On the counter");
      System.out.println ("3. Cisper drawer in the fridge");
      System.out.println ("4. Fridge shelves");
// get user input and save to variable      
      System.out.print ("Enter the number for your answer: ");
      int fridge2 = input.nextInt();

// Call Decisions method to execute the correct code
      Decisions(fridge2);

// display question and options
      System.out.println ("\nWhere would you store lettuce? ");
      System.out.println ("1. Freezer");
      System.out.println ("2. On the counter");
      System.out.println ("3. Cisper drawer in the fridge");
      System.out.println ("4. Fridge shelves");
// get user input and save to variable       
      System.out.print ("Enter the number for your answer: ");
      int fridge3 = input.nextInt();

// decision statement for fridge3 = 1
      if (fridge3 == 1){
        System.out.println ("\nIncorrect");
      }
// decision statement for fridge3 = 1
      else if (fridge3 == 2 ){
        System.out.println ("\nIncorrect!");
      }
// decision statement for fridge3 = 1
      else if (fridge3 == 3){
        foodsaved = foodsaved + 1;
        System.out.println ("\nCorrect! You saved "+foodsaved+"/3 foods!");
        System.out.println ("Salad greens are at their best for up to 5 days longer when properly stored in a hard-sided container lined with paper towels.");
      }
// decision statement for fridge3 = 1
      else if (fridge3 == 4){
        System.out.println ("\nIncorrect!");
      }
// decision statement for everything else       
      else {
        System.out.println ("\nIncorrect!");
      }

// Delay
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();   
      }   
// Clear Screen
      System.out.print("\033[H\033[2J"); 
      System.out.flush();
// decision statement for when food counter = 3 
      if (foodsaved == 3){
        System.out.println ("You saved all the food! You have unlocked a tip!");
        System.out.println ("\nThe Freezer is your friend: Freezing foods to 0 °F inactivates");
        System.out.print("any microbes — bacteria, yeasts and molds — present in food. This means frozen foods remain safe indefinitely!");
      }
// decision statement for when food counter doesn't equal 3
      else {
        System.out.println ("You didn't save enough food to unlock a tip :(");
      }

// Delay
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();   
      }   
// Clear Screen
      System.out.print("\033[H\033[2J"); 
      System.out.flush();

// end section
      System.out.println ("By extending the life of food, you’re ensuring that the");
      System.out.print("water, labor, and energy put into it, was worth it."); 
      System.out.println ("\nYou have completed the food section!"); 
  }// ending bracket for food method  


// Main Method Program
    public static void main(String[] args) {
    Scanner input = new Scanner (System.in);  
  // Clear Screen
      System.out.print("\033[H\033[2J"); 
      System.out.flush(); 
// welcome to game   
      System.out.println ("Welcome to the sustainability game! We are gonna learn about sustainability and how to reduce food and water waste.");

      System.out.println("");
// start game       
      boolean game = true;
// game loop       
      while (game == true){
        int gamechoice = 0;
// loop to repeat if input is invalid         
        while (gamechoice != 1 && gamechoice != 2){
          System.out.println ("\nPick an option to try: ");
          System.out.println ("1. Water waste");
          System.out.println ("2. Food Waste");
// get user choice and save to variable           
          System.out.print("Enter the correct number for your choice: ");
          gamechoice = input.nextInt();
        }
// decision statement for section 1        
        if (gamechoice == 1){
// Delay
          try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();   
            }   
// Clear Screen
          System.out.print("\033[H\033[2J"); 
          System.out.flush(); 
          
// call on water method           
          water();
        }
// decision statement for section 2        
        else if (gamechoice == 2) {
// Delay
          try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();   
            }   
// Clear Screen
          System.out.print("\033[H\033[2J"); 
          System.out.flush();

// call on food method           
          food();
        }
// Delay
        try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();   
            }   

// to fix input problem         
        input.nextLine();

// Clear Screen
        System.out.print("\033[H\033[2J"); 
        System.out.flush(); 
      
// To continue game       
        System.out.println ("Would you like to continue the game?");
        System.out.print ("Type y for yes and type n for no: ");
// save answer to variable         
        String endgame = input.nextLine();
// decision statement for y
        if (endgame.equalsIgnoreCase ("y")){
          game = true;
        }
// decision statement to end game 
        else if(endgame.equalsIgnoreCase ("n")){
// Delay
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();   
          }   
// Clear Screen
          System.out.print("\033[H\033[2J"); 
          System.out.flush(); 
          System.out.println ("Goodbye!");
          game = false;
          break;
        }
    }

  }
}// ending bracket 
