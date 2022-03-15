package app;
import java.util.ArrayList;

/**
 *  This class provides methods that perform operations on a list of generic objects.
 *  The Objects are assumed to have an appropriate implementation of the equals method.
 */
public class ArrayListServices <T> {

   /**
    * This method takes an ArrayList as a parameter and returns a new ArrayList that 
    * does not contain any duplicate data. For example, if this list was passed in: 
    * [A, B, D, A, A, E, B], the method would return a list containing: [A, B, D, E]. 
    * The ordering of the data does not matter. 
    * Assume that the parameter is not null, but it may be an empty ArrayList, in which case 
    * your method returns a new, empty ArrayList.
    * Also note that the ArrayList that is returned must be a new ArrayList which is not the 
    * same as the ArrayList passed in. In other words, the parameter must not be changed by your method code.
    */

   //Implementation 
   /**
    * First, a new empty list is created and the first element of the inputList 
    * is added to the new list (resArr). The nested loops iterate through the 
    * inputList and the new List (resArr), while simultaneously checking if the current inputList 
    * element exists in resArr or not using the .contains() method. If it exists, the loop will break.
    * If not, the current inputList elememnt will be added to resArr. resArr list will be returned with 
    * no duplicate elements. This is only executed if the input list is not empty. If an empty list
    * is passed in, the same list is returned. 
    * 
    * @param inputList an Arraylist containing duplicate elements
    * @return resArr an Arraylist containing inputList elements without any duplicate elements
   **/
   public ArrayList<T> deDuplicate(ArrayList<T> inputList){
      ArrayList<T> resArr = new ArrayList<T>();
      
      if (inputList.size() != 0) {
         resArr.add(inputList.get(0)); 
         
         for (int i = 0; i < inputList.size(); i++) {
            for (int j = 0; j < resArr.size(); j++) {
               if (resArr.contains(inputList.get(i))) {
                  break;
               } 
               else {
                  resArr.add(inputList.get(i));
                  break; 
               }
            }
         }
      }

      return resArr;      
   }


   /**
    * This method takes two ArrayLists as parameters and returns a new ArrayList that 
    * contains the intersection of the data in the ArrayLists passed in. The intersection 
    * contains the elements that occur in both lists.
    * For example, if these lists were passed in: [A, B, D, A, A, E, B], [B, E, C], the method 
    * would return a list containing: [B, E]. The ordering of the data does not matter. Note that 
    * the result does not contain any duplicates.
    * Assume that the parameters are not null, but one or both may be an empty ArrayList, in which 
    * case your method returns a new, empty ArrayList.
    * Also note that the ArrayList that is returned must be a new ArrayList which is not the same as 
    * the ArrayList passed in. In other words, the parameter must not be changed by your method code.
    */

   //Implementation 
   /**
    * A new empty list (resArr) is created. The for loop traverses through the input listA
    * and using the .contains() method checks if the element exists is the second input 
    * listB, while also not already existing in resArr to avoid duplication in 
    * the final return list resArr. If both these conditions are true, the current element 
    * of listA is added to resArr. resArr is returned with the intersection of data in the 
    * two input lists. 
    * 
    * @param listA an Arraylist containing some data that may also be in listB
    * @param listB an Arraylist containing some data that may also be in listA
    * @return resArr an Arraylist with intersection of data in listA and listB
   **/
   public ArrayList<T> getSetIntersection(ArrayList<T> listA, ArrayList<T> listB){
      ArrayList<T> resArr = new ArrayList<T>(); 

      for (int i = 0; i < listA.size(); i++) {
         if (listB.contains(listA.get(i)) && !(resArr.contains(listA.get(i)))) {
            resArr.add(listA.get(i));
         }
      }

      return resArr;      
   }


   /**
    *  This method takes two ArrayLists as parameters and returns a new ArrayList that 
    * contains the set difference of the data in the ArrayLists passed in. The set difference 
    * contains the elements that occur only in one or the other list, but not in both.
    * For example, if these lists were passed in: [A, B, D, A, A, E, B], [B, E, C], the method 
    * would return a list containing: [A, C]. The ordering of the data does not matter. Note 
    * that the result does not contain any duplicates.
    * Assume that the parameters are not null, but one or both may be an empty ArrayList. In the 
    * case where one list is empty, your method returns a new ArrayList that contains all of the 
    * elements on the other list- with no duplicates. In the case where both lists are empty, your 
    * method returns a new, empty ArrayList.
    * Also note that the ArrayList that is returned must be a new ArrayList which is not the same 
    * as the ArrayList passed in. In other words, the parameter must not be changed by your method code.
    */

   //Implementation
   /**
    * A new empty list (resArr) is created. The first for loop traverses through listA and 
    * checks if the current element does not exist in the second listB, while also not 
    * not already existing in resArr to avoid duplication in the final return list resArr. If
    * both these conditions are true, the current element is added to the resArr. The second
    * for loop carries out the same operations, but traverses through list B and adds
    * the elements that don't exist in listA and resArr already to resArr. resArr is returned
    * with the difference of data in both the input lists. 
    * 
    * @param listA an Arraylist containing some data that may not be in listB
    * @param listB an Arraylist containing some data that may not be in listA
    * @return resArr an Arraylist with difference of data in listA and listB
   **/
   public ArrayList<T> getSetDifference(ArrayList<T> listA, ArrayList<T> listB){
      ArrayList<T> resArr = new ArrayList<T>();

      for (int i = 0; i < listA.size(); i++) {
         if (!(listB.contains(listA.get(i))) && !(resArr.contains(listA.get(i)))) {
            resArr.add(listA.get(i));
         }
      }

      for (int i = 0; i < listB.size(); i++) {
         if (!(listA.contains(listB.get(i))) && !(resArr.contains(listB.get(i)))) {
            resArr.add(listB.get(i));
         }
      }
      
      return resArr; 
   }
}