# Microsoft-DEV277x-Object-Oriented-Programming-in-Java. Here is the Notes from the course
Module 1 | What is an Object
1. Introduction.  In programming, I need to work with 2 categories data types; primitives and objects. Building complex program =  managing complex & big data  => How do I organize my codes into objects that can interact with one another?

I need to know what's the difference between working with primitive and an object data?  

	- Primitives - the simplest form of data that the computer can store directly inside the memory. So, whenever I use primitive variable, it passes the copies of the value. = I create a separate variable that has the same value (a copy).  Value semantics = I have a the same value but there is no connection between the original variable and the copied variable. So, if any one change their value, the other are not affected

	- objects - the complex form of data that have some related data and functionalities to do different things with the data (fields and methods).  So just see the methods to know what I can do with the data. It  is a method of storing some related data (both primitives and other objects) and the methods who act on this data under a single data type. 

	- Variables store an address to the actual data inside the memory. It passes the copies of the data address around, not actual value because objects take very big memory space. There is a connection between the original variable and the copied variable because both store the same address to the same object. So, if any one change the data, the other will get affected too. pointer/reference semantics = I have an 'address' of the value. 

	- More and more complex programs needs more and more data. primitive variables can't handle it. So, I need ways to group related data and behavior like Strings, Scanners, Arrays, and ArrayLists. 

2. Arrays = static data structures , the most important built-in objects are those used for data structure => How to store large groups of data with arrays - 1 and 2 dimensional?
	- array = an object that groups together the same type of related data, under one name. Each data is ordered in sequence. Each piece of data is called an "element" and each element is given an index which is the address of where the element live inside the array. array can store any data type including objects and that can be other arrays. The length of array is fixed

	- How to use an Array? 
	- 1. create empty array and add elements later.  
	- 2. If I know the data in advance, I can create and store elements into the array at the same time. 

```
type[ ] name  = new type[ length/how many elements?]

OR

dataType[] name = {dataValue1, dataValue2, dataValue3};

int[] studentGrades = {98, 86, 90};
```

	- How to access the element?  Just go to the address. name [index] output the element. I can access each index in the array using for loop. 
	- How to modify/replace/add element?    name [index] = value; 
	- 
```
for (int i = 0; i < ArrayName.length; i++) {
    ArrayName[i] = input.nextInt();
}
```

	- Coding With Arrays. 
```
// The Length Field

arrayVariableName.length // returns the capacity of the array

// How to use Array Methods

import java.util.Arrays;

int[] b = new int[10]; 
Arrays.toString(b);
Arrays.myMethod(Array object)
System.out.println(Arrays.toString(a));

```


3. 2D Arrays = an array that stores other arrays. How to use? So I need to specify how many arrays I want to store and how long each of the array. outer array = rows, inner arrays=columns .  How to access the value?, I need to give 2 indices => name[row][column] = value; 1 loop to examine every element in a 1D array, I need 2 loops to examine each element in a 2D array. one loop for rows and the other loop for columns. It will  go all the elements within the first row, then all the elements within the second row etc...

```
// How to create an Array?

int[][] name = new int[3][5];

OR 

int[][] a = {{1,2} {3,4} {5,6}};

// How to modify/replace/add element?

name[1][3] = 20; 
```

4. ArrayLists = flexible data structure => How to use ArrayList? 
	- Array limitation; After I create the array, I cannot change the size of the array (static data structures). What if I need flexible data structure that can store and organize any data size (dynamic data sets)? What if I don't know the size of data in advance? 

	- Just like array but ArrayList has some added list functionalities that can easily increase and decrease the size of elements or reorder the elements.
	- How to create ArrayList with primitive data? => Store it as an object using Wrapper Classes, a simple object that has a primitive. So, the object of int is Integer,  char > Character, double > Double, boolean > Boolean.  

	- Using for loop with ArrayList. It's like using with array but I need to pay attention to the current size of the list. especially when I add or remove an element inside the for loop. 

```
ArrayList<Integer> myList = new ArrayList<Integer> ();
int sum = 0;
for (int i = 0; i < myList.size(); i++) {
    sum += myList.get(i);
}
```

```
// create an ArrayList  - I don't need to specify the data size

ArrayList<Object DataType> names = new ArrayList<Object DataType> ();

// Access/get out of elements using get() funtion.

names.get(index);

// add elements at the end of the array or at a specific index and the rest of the elements will adjust accordingly

names.add("Nur");
names.add(0, "Nur");

// Find the first index of a value

.indexOf("Nur");

// remove element

.remove(index)

// How to replace the value of an element and set a new one?

name.set(index, value)

// How to know the length of elements?
name.size();

// How to know if the value exist in the array?
.contains("Nur")
```
Project - Battleship
Assessment



Module 2 | Building Your Own Objects =  transition from procedural programming into OOP (use objects that interact with one another  in a large code base. )

1. Introduction.  Why important? Objects group together related data of different type, under one new data type/category, So I can store all the related info in one variable. Make my code more organized and readable. When I break down complex  program into objects, it easy to manage large code base. 

2. How to build and use object? Model objects in the real world and their characteristics 

	- Divide into 3 Parts = state (what  it has?) + constructor + behavior (what it does with the info?) -  Acts as a blueprint that tells computer how to build objects for the program. 
	- State =  all the values stored in the object's fields create the state. Choose a category of objects for the program, Eg: Student. Define what are the most important aspects/characteristics of the object Eg: name, ID, GPA? Only keep Info that the object needs to use. 

```
// 1. Define the Object inside a class, in a separate file. 

public class Student {
    String name;
    int grad;
    int ID;
    double GPA;
    int abs;

    // This keyword to distinguish between the parameter and the field. // 
    public Student(String name, int grad, int ID, double GPA, int abs) {
        this.name = name;
        this.grad = grad;
        this.ID = ID;
        this.GPA = GPA;
        this.abs = abs;
    }

    public booelan isGraduating() {
        return (GPA > 2.0 && abs < 10 && grad == 12);
    }
}
```

	- Behavior = all the methods in the object to provide work for the client. How to decide what methods the object should have? Think, who are going to use this object? with the info that the object has, what they might want to do? Come up with the possible use cases for the object. Eg: toUpperCase() How to define:

```
// No static keyword because these methods are part of objects.
public returnType methodName(parameters) {  
statements;
}

methodName = verb + which field this method acts upon.

// If I create many objects of the same type, how do I access the fields of other objects inside the class definition? I might need to do some comparison between the objects like whose has the highest score. =>  take parameter of the object. then I can access the object's fields within my method. 

Bicycle bike1 = new Bicycle("Schwinn", "Cruiser");
Bicycle bike2 = new Bicycle("Giant", "Racer");
if (bike1.equals(bike2)) { // in this case would return false
bike2.listPrice = bike1.listPrice;
}
```

	- Constructors = To make the object ready to use by the client. A special method that is called by the new operator at the moment the new version of the object is created. It will set the initial state of the object to be used at the client class = Assign initial values to the fields by default or/and use parameters with the correct name. 
		- How to define: It's special because not like other methods, its name is the same as the class name 
		- and there is no return type like void as it always returns the object that the client can store inside a variable. 

```
public ClassName (parameters) {}

public class Bicycle { // simply declare important aspects of the object 
    String brand;
    String model;
    double price;
    boolean isSold;
    double salePrice;

    public Bicycle (String myBrand, String myModel, double myPrice) {
    this.brand = myBrand;
    this.model = myModel;
    this.price = myPrice;
    }
}

If users don't need to set the initial values for the fields when creating the object, write Default Constructors with no arguments, no parameters

public Bicycle() {
}

OR

I can create more than 1 constructor with overloading methods
first create a constructor that initializes all fields 
then, add other constructors, change some parameters into default value. 
depending what value user enter, Java will matches the right constructor. 

public Bicycle(String brand, String model, double listPrice) {
this(brand, model, 28, false, listPrice);
}

// this uses all default values for a new Bicycle
public Bicycle() {
this("", "", 0.0, 28, false, 0.0);
}
```

		Then, create object which has the same state and behavior but different values inside client class. unlimited copies. use new keyword to call the constructor inside the object class. 

```
// Client class creates new version of the object

referenceType name = new objectType();

public class StudentManager { 
    public static void main(String[] args) { 
        Student Anna = new Student("Ada Lovelace", 2017, 12345, 3.2, 4);
}
```

3. Encapsulation =  a way of hiding how the code works from an external user, they just need to know how to use code and get the benefits. Why important? 1) other people can use my code without the need to understand how each line of the code works vice versa => To speed up the development process. 2) hide parts of my object so user cannot interact with it. important to protect the object from being in bad states due to external errors.
	- How to use? Make everything private using private keyword instead of public, work both fields and methods.  Then add public things->  create accessor methods that simply return the value of the fields and cannot change object's state. And I can also create mutator methods that  can change object's state under certain condition.
	- 
```
// accessor methods for each of your fields
getFieldName()

public double getGpa() {  
    return gpa;
}

public void setName(String name) { 
    if (name.indexOf(" ") != -1) { 
        throw new IllegalArgumentException("names cannot contain spaces"); 
    } 
    this.name = name.toLowerCase(); 
}
```


4. What is Static = this variable or method is not part of an object, belong to the class definition like global variable for all the objects.  / or means static inside an object class, when the client creates different version of an object, the object does not inherit the static fields/methods. How using static in object class can be useful? 
	- static fields: All objects of the class share the same static field. Any object can see the values and update it
	- I can use static fields in constructor to monitor how many objects created by the client. 
	-  I can have the same values that affect all objects like global variable.  
	- How to use it in client code? Static fields belong to the class as a whole, so to use the static field, I need to use the class name not the object name. 


```
public class Bicycle { 
    private static int bikeCount; 

    public Bicycle() { 
        bikeCount++; // stores the count of how many Bicycle objects have been created 
    } 
}



public static void main(String[]args) {
    Bicycle bike1 = new Bicycle(); 
    Bicycle bike2 = new Bicycle(); 
    int bikeCount = Bicycle.bikeCount;

}

```
Project - FracCalc
Assessment

Module 3 | Object Inheritance =  How to write code more effectively and efficiently 
1. Introduction:   Why important? Right now there is no relation between the objects that I created, all objects are standalone. Before building the objects. First, I need to plan the structure of my code,  Create an object ecosystem.  - using the concepts of inheritance, interfaces and abstract classes to relate objects to one another. 
		what is Inheritance? = a way to build specific objects on top of general-purpose objects, inherit & reuse the general attribute and behaviors but add specific ones as needed. Why important? This way I can avoid writing duplicate code and use the same code for multiple purposes. So I can  write less code, maintain and update the code base easily from one place.  

2. So, how to use Inheritance in code?
	1. List all objects that interact in the same environment
	2. List down what each of them has and what it does
	3. Relate between objects: Identify shared attributes/behaviors between objects and see patterns 
	4. Organize shared behaviors like a family tree diagram from the most generic object (main category) to more and more specific objects (sub categories). Like school members ->  staff and students -> breakdown staff into admin worker and teachers -> break down students into seniority; first year student and final year student.  So, all objects have something in common. 2 kind of relationships, which one the object has? :  is-a relationship = an object is the subcategory of other object, so I can extend it. Eg: teacher is a staff. works bottom up in hierarchy. AND has-a relationship = an object is an attribute of other object, so I can include it as part of the field. 
	5. As a result, I will have superclass/parent class and subclass/child class 
	6. Build the objects from top down ; use extends keyword to inherit everything from the parent class. the exact copies.
	7. How to adjust what the child class inherit? I can completely override super class's behavior with different behavior inside the child class. Just create a new method with the same name but different functionality. What if I want to override super class's behavior but also build on top of that? call the super class version of the method inside the child class using super keyword. then, add my code. with super keyword I can reuse superclass code inside the child class and add code on top of that. So any change made to super class is reflected to the child class.  

```
public class Name extends superclass {
}

public class Turkey extends Bird { 
    public void fly() { 
        super.fly(); 
        sink(); 
    } 
}

// The subclass constructor must call the superclass constructor at the first line, with the required parameter using super() for the inheritance to work.

public class Student extends SchoolMember {
    public Student (int id) {
        super(id);
    }
}
```

```
super.getSalary()

OR

super.id 
```

3. Polymorphism = How polymorphism comes into play as you add more levels of inheritance? One method can produce different output based on where they are in the hierarchy
	- Normally when I create a new object in the client class, I use the object class itself as the referenceType. But now as I know that the object class has the upper class. I can use the upper class as referenceType. to group objects under the same data type in the client class, create array. 
4. Abstract classes, Abstract methods & Interfaces = Why important? Overcome Inheritance Limitation => The inheritance tree might have an upper class that is too generic such that its not clear how its behavior is related to the child class or the object does not exist in the real world. So, how can I still strongly relate the superclass to the child class? 

	=> define the super class as abstract with abstract methods, simply exist to do inheritance (no object will be created in the client class because no such object in the real world like there is no animal but we have cat, lion etc...) 
```
abstract class =  contain abstract methods, no constructor as we don't need to create object for abstract class. 

public abstract class Animal {
    abstract boolean consumeFood() ;

    public String move() {
    }
}
```

	- abstract methods (empty methods with only header to tell all child classes what to do, but how they want to implement it, up to them. A contract to make sure all the related child classes implement certain type of behavior) What's the point share codes that the child class never use, so better share with them only the abstract methods. Abstract class can have normal methods too
	- Inheritance is just a simple relationship between parent class and child class. How do I create more relationships and relate with more than 1 objects? => Use interfaces. a way to relate objects based on specific behavior. = a contract contains a list of method headers/ type of behaviors that guarantee behaviors across unrelated classes. Any classes using the interfaces, must implement these methods with specified input and output. Because interface relates object based on type of behavior (method that produce the same type of output), any objects can implement the interface even if they don't share the same parent class.  

```
// How to create interface?  

public interface Flying { 
public int wings(parameterType parameterName,); 
public boolean takeOff(); 
public boolean land(); 
}

// How to use interface => use the keyword implements and I can use as many interfaces as I need. 

public class Falcon implements Flying {
}

OR 

public class Bee extends Insect implements Flying, Hibernating, Stinging (
)

```

Project - Company Structure
Assessment



Module 4 | Capstone Project
Project Description: Final Project - Animal Kingdom
