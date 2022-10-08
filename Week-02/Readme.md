# Value & Reference

## Primitives

Primitives are passed by value.  
There are 8 primitives in java: `boolean`, `byte`, `char`, `short`, `int`, `long`, `float`, `double`.

```java
int number = 5;
int anotherNumber = 10;

anotherNumber = number;
// number, anotherNumber = 5 - Pass by value;

number = 10;
// number = 10, anotherNumber = 5;
```

## Pass by Reference

Non primitives variables are passed by reference instead of value. So after they equalized they literally points to the same array in the memory therefore mutating one effect other as well.

```java
int[] numbers = {1, 2};
// numbersCopy points to numbers array
int[] numbersCopy = numbers;
// first item in both arrays are changed to 0
numbers[0] = 0;
// again first item in both arrays are changed, to 1 this time.
numbersCopy[0] = 1;

```

# Encapsulation

Instead of directly reaching or manipulating the data inside of the class, with encapsulation the objective is hiding the inner logic of the class from the outer scopes. I really don't know it enough, bot to defend or to attack that approach but it is how OOP world works i guess.  
  
I will never ever use underscore before the variable though, it looks gross...

```java
private String element;

public String getElement() {
    return element;
}

public void setElement(String element) {
    this.element = element;
}
```

# Inheritance  
  
You know the example, birds are `animals`, tortoises are `animals`, all the animals are `living creatures`, everything consist of `atoms` and you who read this is the `most lovely person ever!` etc. A class can inherit the other and it carries others fields and methods to itself, probably will extend them too with other new lovely fields and methods because why not? 

```java
public class Shaman extends Player {
    // A new field
    private String element;

    // Constructor
    public Shaman(int id, String name, int power, String element) {
        // Inherited fields
        super(id, name, power);
        // A new field in here again!!
        this.element = element;
    }
}
```
  
# Conclusion

I love basics, it feels awesome to work on basics again. Sad fact is i love it because it is my comfort zone.