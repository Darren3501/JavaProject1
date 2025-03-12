import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//Darren Mahin
//N01611733
//February 25, 2025

public class mahin_project1 
{
	/**
	 * Counts the number of times the word "candy" is found
	 * in list of food items (case insensitive).
	 * @param list
	 * @return number of items containing "candy"
	 */
	public static int countCandy(String[] list) 
	{
		//Declarations
		int candyCount = 0; 
		
		//for each string in list,
		//if string contains "candy",
		//increment candyCount
		
		for(String s : list)
		{
			if(s.toLowerCase().contains("candy")) //check for candy 
			{
				candyCount++; //increment candyCount
			}
		}
		
		return candyCount;
	}
	
	/**
	 * Finds items containing only one word (no spaces) in list of food items.
	 * @param list
	 * @return strings containing one word (no spaces)
	 */
	public static ArrayList<String> getOneWordFoodItems(String[] list)
	{
		//Declarations
		ArrayList<String> arr = new ArrayList<>(); 
		String temp = ""; 
		
		for(String s : list)
		{
			temp = s.trim(); //trim extra white spaces
			
			if(!temp.contains(" ")) //check if temp has no spaces
			{
				arr.add(temp); //if no spaces found, add temp to arr
			}
		}
		
		return arr;
	}
	
	/**
	 * Finds items containing multiple words (spaces) in list of food items.
	 * @param list
	 * @return strings containing multiple words
	 */
	public static ArrayList<String> getMultiWordFoodItems(String[] list)
	{
		//Declarations
		ArrayList<String> arr = new ArrayList<>();
		String temp = "";
		
		for(String s : list)
		{
			temp = s.trim(); //trim white spaces
			
			if(temp.contains(" ")) //check for spaces
			{
				arr.add(temp); //if space is found, add item to arr
			}
		}
		
		return arr;
	}
	
	/**
	 * Finds items that only occur once in a list of food items.
	 * @param list
	 * @return array list of unique items
	 */
	public static ArrayList<String> getUniqueFoodItems(String[] list)
	{
		//Declarations
		ArrayList<String> uniqueList = new ArrayList<>();
		
		//Nested for loops to compare each string in list
		//against the rest of the elements in the array,
		//if no duplicates found, add to list.
		
		for(int i = 0; i < list.length; i++)
		{
			list[i] = list[i].trim(); //trim white spaces
			boolean duplicate = false; //set flag to false for each i increment
			
			for(int j = 0; j < list.length; j++)
			{
				list[j] = list[j].trim(); //trim white spaces
				
				// if duplicate found and not at same index
				if(list[i].equalsIgnoreCase(list[j]) && i != j) 
				{
					duplicate = true; //flag duplicate
					break; //end j loop
				}
			}
			// if not a duplicate
			if(!duplicate) 
			{
				uniqueList.add(list[i]); //add string to list of unique items
			}
		}
	
		return uniqueList;
	}
	
	/**
	 * Finds items that occur more than once in a list of food items.
	 * @param list
	 * @return array list of non unique items
	 */
	public static ArrayList<String> getNonUniqueFoodItems(String[] list)
	{
		//Declarations
		ArrayList<String> nonUniqueList = new ArrayList<>();
		
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER); //sort array 
		
		//Nested for loops to compare each string against rest of array,
		//if duplicates found, add to nonUniqueList.
		
		for(int i = 0; i < list.length; i++)
		{
			list[i] = list[i].trim(); //trim white spaces
			boolean duplicate = false; //set flag to false for each i increment
			
			for(int j = i + 1; j < list.length; j++)
			{
				list[j] = list[j].trim(); //trim white spaces
				if(list[i].equalsIgnoreCase(list[j])) //if duplicate found
				{
					duplicate = true; //flag duplicate
					break; //end j loop
				}
			}
			if(duplicate) //if duplicate
			{
				nonUniqueList.add(list[i]); //add to list of nonUniqueItems
			}
		}
		
		return nonUniqueList;
	}
	
	/**
	 * Finds the item that occurs the most in a list of food items.
	 * @param list
	 * @return most frequently occurring string
	 */
	public static String getMostFrequentFoodItem(String[] list)
	{
		//Declarations
		String mostFreq = ""; //stores most frequent item
		int[] count = new int[list.length]; //array to count occurences 
		int maxFreq = 0; //track highest frequency
		int recentIndex = -1; //track most recent occurence in case of tie
		
		//Nested for loops to compare each string in list
		//against rest of elements in array.
		
		for(int i = 0; i < list.length; i++)
		{
			list[i] = list[i].trim(); //trim white spaces
			count[i] = 1; //reset count for each item
			
			for(int j = 0; j < list.length; j++)
			{
				list[j] = list[j].trim(); //trim white spaces
				
				// if duplicates found and not at same index
				if(list[i].equalsIgnoreCase(list[j]) && i != j) 
				{
					count[i]++; //increment count for item
				}
			}
			// Update most frequent item if a new maximum frequency is found
            // If frequencies are the same, use the item that appeared last in the list
			if(count[i] > maxFreq || count[i] == maxFreq && i > recentIndex) 
			{
				maxFreq = count[i]; //update max frequency
				mostFreq = list[i]; //update most frequent item
				recentIndex = i; //update most recent occurence index
			}
		}
		
		return mostFreq;
	}
	
	/**
	 * Finds the item that occurs the least in a list of food items.
	 * @param list
	 * @return least frequently occurring string
	 */
	public static String getLeastFrequentFoodItem(String[] list)
	{
		//Declarations
		String leastFreq = ""; //store least frequent item
		int[] count = new int[list.length]; //array to count occurences 
		int prevMin = Integer.MAX_VALUE; //track lowest frequency 
		int firstIndex = -1; //track first occurence 
		
		//Nested for loops to compare each string in list
		//against rest of elements in array.
		
		for(int i = 0; i < list.length; i++)
		{
			list[i] = list[i].trim(); //trim white spaces
			count[i] = 1; //reset count for each item
			for(int j = 0; j < list.length; j++)
			{
				list[j] = list[j].trim(); //trim white spaces
				// if duplicates found and not at same index
				if(list[i].equalsIgnoreCase(list[j]) && i != j)
				{
					count[i]++; //increment count
				}
			}
			
			// Update least frequent item if a new minimum frequency is found.
            // If frequencies are the same, use the item that appeared first in the list.
			if(count[i] < prevMin || count[i] == prevMin && i < firstIndex)
			{
				leastFreq = list[i]; //update least frequent 
				prevMin = count[i]; //update minimum frequency 
				firstIndex = i; //update first index
			}
		}
		
		return leastFreq;
	}
	
	/**
	 * Counts how many times the word "mustard" is found in a list of 
	 * food items (case insensitive).
	 * @param list
	 * @return The number of times mustard is found.
	 */
	public static int countMustardsInList(String[] list)
	{
		//Declarations
		int mustardCount = 0;
		
		// for each string in food list
		for(String s : list) 
		{
			// check for word containing mustard
			if(s.toLowerCase().contains("mustard")) 
			{
				mustardCount++; //increment mustardCount
				System.out.println(s.trim().toLowerCase()); 
			}
		}
		return mustardCount;
	}
	/**
	 * Gets list of food items from user and splits string after each comma.
	 * @param scn
	 * @return list of food items.
	 */
	public static String[] getNewList(Scanner scn)
	{
		//Declarations
		String[] foodList = {""};
		
		System.out.println("Enter food items: "); //prompt user
		String input = scn.nextLine(); //get food items from user
		
		foodList = input.split(","); //split string at each comma
		
		return foodList;
	}
	
	/**
	 * Prompts user with interactive menu of possible method calls, 
	 * each performing specific string operations
	 */
	public static void printMenu()
	{
		System.out.println("What do you want to do?");
		System.out.println("1 = Count Candy");
		System.out.println("2 = Get One Word Food Items");
		System.out.println("3 = Get Multi-Word Food Items");
		System.out.println("4 = Get Unique Food Items");
		System.out.println("5 = Get Non-Unique Food Items");
		System.out.println("6 = Get Most Frequent Food Item");
		System.out.println("7 = Get Least Frequent Food Item");
		System.out.println("8 = Count Mustards");
		System.out.println("9 = Enter New List");
		System.out.println("0 = Quit");
	}
		
	public static void main(String[] args) 
	{
		//TODO: complete method
		
		//Declarations
		Scanner scn = new Scanner(System.in);
		String foodItems[] = getNewList(scn);
		int answer = -1; 
		int mustardCount = 0;
		ArrayList<String> oneWord = new ArrayList<>(); //catches oneWord return
		ArrayList<String> multiWord = new ArrayList<>(); //catches multiWord return
		ArrayList<String> unique = new ArrayList<>(); //catches unique return
		ArrayList<String> nonUnique = new ArrayList<>(); //catches nonUnique return
		String mostFreq = ""; //catches most frequent item return
		
		
		//Prompt user 
		while(answer != 0)
		{
			System.out.println();
			
			if(answer != 9)
			{
				printMenu(); //prompt user with interactive menu
			}
			answer = scn.nextInt(); //get user input
			
			System.out.println();
			
			if(answer == 1) //countCandy 
			{
				System.out.println("Number of Candy: " + countCandy(foodItems)); //call countCandy
			}
			
			else if(answer == 2) //getOneWordFoodItems 
			{
				oneWord = getOneWordFoodItems(foodItems); //catch one worded items 
				
				for(String s : oneWord)
					System.out.println(s); 
			}
			
			else if(answer == 3) //getMultiWordFoodItems
			{
				multiWord = getMultiWordFoodItems(foodItems); //catch multi worded items
				
				for(String s : multiWord)
				{
					System.out.println(s);
				}
			}
			
			else if(answer == 4) //getUniqueFoodItems
			{
				unique = (getUniqueFoodItems(foodItems)); //catch unique food items
				
				for(String s : unique)
				{
					System.out.println(s.toLowerCase());
				}
			}
			
			else if(answer == 5) //getNonUniqueFoodItems
			{
				nonUnique = getNonUniqueFoodItems(foodItems); //catch non unique items
				
				for(String s : nonUnique)
				{
					System.out.println(s.toLowerCase());
				}
			}
			
			else if(answer == 6) //getMostFrequentFoodItem
			{
				mostFreq = getMostFrequentFoodItem(foodItems); //catch most frequent items
				System.out.println(mostFreq.toLowerCase());
			}
			
			else if(answer == 7) //getLeastFrequentFoodItem
			{ 
				System.out.println(getLeastFrequentFoodItem(foodItems)); //catch least frequent items
			}
			
			else if(answer == 8) //countMustardsInList
			{
				mustardCount = countMustardsInList(foodItems); //catch number of mustards
				if(mustardCount == 0)
				{
					System.out.println("No mustards found");
				}
			}
			
			else if(answer == 9) //getNewList
			{
				scn.nextLine(); 
				foodItems = getNewList(scn); //update food items list
				answer = -1; //reset answer to avoid loop
			}
			
			System.out.println();
			
			if(answer != 0 && answer != 9)
			{
				System.out.println("Would you like to select another option? 1 for yes, 0 for no"); //ask user if they want to keep going
				answer = scn.nextInt(); //get input from user
			}
		
			System.out.println();
		}
	
	}

}