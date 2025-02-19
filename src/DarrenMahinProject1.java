import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DarrenMahinProject1 {
	
	public static int countCandy(String[] list) {
		int candyCount = 0;
		
		for(String s : list)
		{
			if(s.toLowerCase().contains("candy"))
			{
				candyCount++;
			}
		}
		return candyCount;
	}
	
	public static ArrayList<String> getOneWordFoodItems(String[] list)
	{
		ArrayList<String> arr = new ArrayList<>();
		String temp = "";
		
		
		for(String s : list)
		{
			temp = s.trim(); //trim extra white spaces
			
			if(!temp.contains(" "))
			{
				arr.add(temp);
			}//end if
		
		}//end for
		
		return arr;
	}
	
	public static ArrayList<String> getMultiWordFoodItems(String[] list)
	{
		ArrayList<String> arr = new ArrayList<>();
		String temp = "";
		
		for(String s : list)
		{
			temp = s.trim();
			
			if(temp.contains(" "))
			{
				arr.add(temp);
			}
		}
		
		return arr;
	}
	
	public static ArrayList<String> getUniqueFoodItems(String[] list)
	{
		ArrayList<String> uniqueList = new ArrayList<>();
		
		for(int i = 0; i < list.length; i++)
		{
			list[i] = list[i].trim();
			boolean duplicate = false;
			
			for(int j = 0; j < list.length; j++)
			{
				list[j] = list[j].trim();
				if(list[i].equalsIgnoreCase(list[j]) && i != j)
				{
					duplicate = true;
					break;
				}
			}
			if(!duplicate)
			{
				uniqueList.add(list[i]);
			}
		}
		
		
		return uniqueList;
	}
	
	public static ArrayList<String> getNonUniqueFoodItems(String[] list)
	{
		ArrayList<String> nonUniqueList = new ArrayList<>();
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for(int i = 0; i < list.length; i++)
		{
			list[i] = list[i].trim();
			boolean duplicate = false;
			
			for(int j = i + 1; j < list.length; j++)
			{
				list[j] = list[j].trim();
				if(list[i].equalsIgnoreCase(list[j]))
				{
					duplicate = true;
					break;
				}
			}
			if(duplicate)
			{
				nonUniqueList.add(list[i]);
			}
		}
		
		return nonUniqueList;
	}
	
	public static String getMostFrequentFoodItem(String[] list)
	{
		System.out.println("This is a testttttt");
		return null;
	}
	
	public static String getLeastFrequentFoodItem(String[] list)
	{
		
		int lowestFrequency = Integer.MAX_VALUE;
		String least = "";
		
		for(int i = 0; i < list.length; i++)
		{
			int frequency = 0;
			for(int j = 0; j < list.length; j++)
			{
				if(list[i].toLowerCase().equals(list[j].toLowerCase()))
				{
					frequency++;
					System.out.println(list[i]);
				}
			}
			
			if(frequency < lowestFrequency)
			{
				lowestFrequency = frequency;
				least = list[i];
			}
		}
		
		return least;
	}
	
	/**
	 * This method counts how many food items in the food list array
	 * contain "mustard" and then prints each item
	 * @param list
	 * @return
	 */
	public static int countMustardsInList(String[] list)
	{
		int mustardCount = 0;
		
		
		for(String s : list) //for each string in food list
		{
			if(s.toLowerCase().contains("mustard")) //check for word containing mustard
			{
				mustardCount++; 
				System.out.println(s.trim().toLowerCase()); //print word in lower case, trimming white spaces
			}
		}
		return mustardCount;
	}
	/**
	 * This method gets a list of food items from the user,
	 * then stores them in an array of strings.
	 * @param scn
	 * @return
	 */
	public static String[] getNewList(Scanner scn)
	{
		//Declarations
		String[] foodList = {""};
		
		System.out.println("Enter food items: "); //prompt user
		String input = scn.nextLine(); //get food items
		
		foodList = input.split(","); //separate each string between commas
		
		return foodList;
	}
	/**
	 * Prompts user with interactive menu of methods, each performing specific string operations
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
		int answer = -1; //initialize answer
		int mustardCount = 0;
		ArrayList<String> oneWord = new ArrayList<>();
		ArrayList<String> multiWord = new ArrayList<>();
		ArrayList<String> unique = new ArrayList<>();
		ArrayList<String> nonUnique = new ArrayList<>();
		String least = "";
		
		
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
			
			if(answer == 1) //user enters 1
			{
				System.out.println("Number of Candy: " + countCandy(foodItems)); //call countCandy
			}
			
			else if(answer == 2) //user enters 2
			{
				oneWord = getOneWordFoodItems(foodItems); //catch returned array list 
				
				for(String s : oneWord)
					System.out.println(s); //call getOneWordFoodItems
			}
			
			else if(answer == 3) //user enters 3 
			{
				multiWord = getMultiWordFoodItems(foodItems);
				
				for(String s : multiWord)
				{
					System.out.println(s);
				}
			}
			
			else if(answer == 4) //user enters 4
			{
				unique = (getUniqueFoodItems(foodItems)); //catch getUniqueFoodItems return
				
				for(String s : unique)
				{
					System.out.println(s.toLowerCase());
				}
			}
			
			else if(answer == 5) //user enters 5
			{
				nonUnique = getNonUniqueFoodItems(foodItems); //catch getNonUniqueFoodItems return
				
				for(String s : nonUnique)
				{
					System.out.println(s.toLowerCase());
				}
			}
			
			else if(answer == 6) //user enters 6
			{
				getMostFrequentFoodItem(foodItems); //call getMostFrequentFoodItem
			}
			
			else if(answer == 7) //user enters 7
			{ 
				System.out.println(getLeastFrequentFoodItem(foodItems)); //call getLeastFrequentFoodItem
			}
			
			else if(answer == 8) //user enters 8 
			{
				mustardCount = countMustardsInList(foodItems);
				if(mustardCount == 0)
				{
					System.out.println("No mustards found");
				}
			}
			
			else if(answer == 9) //user enters 9
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
		}//end while
	
	}//end main

}//end class