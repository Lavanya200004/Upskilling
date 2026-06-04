# Module 3 - Core Java Exercises

This folder contains separate Java files for all 41 questions from `Module 3-Core Java.pdf`.

## How to Compile

Because the file names include exercise numbers, compile each file with `-d .`:

```powershell
javac -d . 01_HelloWorld.java
java HelloWorld
```

Example:

```powershell
javac -d . 02_SimpleCalculator.java
java SimpleCalculator
```

## Files 1-20

1. `01_HelloWorld.java`
2. `02_SimpleCalculator.java`
3. `03_EvenOrOddChecker.java`
4. `04_LeapYearChecker.java`
5. `05_MultiplicationTable.java`
6. `06_DataTypeDemonstration.java`
7. `07_TypeCastingExample.java`
8. `08_OperatorPrecedence.java`
9. `09_GradeCalculator.java`
10. `10_NumberGuessingGame.java`
11. `11_FactorialCalculator.java`
12. `12_MethodOverloading.java`
13. `13_RecursiveFibonacci.java`
14. `14_ArraySumAverage.java`
15. `15_StringReversal.java`
16. `16_PalindromeChecker.java`
17. `17_ClassAndObjectCreation.java`
18. `18_InheritanceExample.java`
19. `19_InterfaceImplementation.java`
20. `20_TryCatchExample.java`

## Files 21-41

21. `21_CustomException.java`
22. `22_FileWriting.java`
23. `23_FileReading.java`
24. `24_ArrayListExample.java`
25. `25_HashMapExample.java`
26. `26_ThreadCreation.java`
27. `27_LambdaExpressions.java`
28. `28_StreamAPI.java`
29. `29_Records.java`
30. `30_PatternMatchingSwitch.java`
31. `31_BasicJDBCConnection.java`
32. `32_JDBCInsertUpdate.java`
33. `33_JDBCTransactionHandling.java`
34. `34_JavaModules`
35. `35_TCPClientServerChat.java`
36. `36_HTTPClientAPI.java`
37. `37_JavapBytecode.java`
38. `38_DecompileClassFile.java`
39. `39_ReflectionInJava.java`
40. `40_VirtualThreads.java`
41. `41_ExecutorServiceCallable.java`

## Compile All Normal Files

```powershell
javac -d . *.java
```

## Special Notes

For question 34, compile modules from this folder:

```powershell
javac -d mods\com.utils 34_JavaModules\com.utils\module-info.java 34_JavaModules\com.utils\com\utils\MessageUtil.java
javac --module-path mods -d mods\com.greetings 34_JavaModules\com.greetings\module-info.java 34_JavaModules\com.greetings\com\greetings\GreetingApp.java
java --module-path mods -m com.greetings/com.greetings.GreetingApp
```

For question 35, open two terminals. Run the server first:

```powershell
java TcpChatServer
```

Then run the client:

```powershell
java TcpChatClient
```

For question 37:

```powershell
javap -c JavapBytecode
```

For questions 31-33, the code uses JDBC APIs and SQLite-style URLs. Running them needs a JDBC driver available on the classpath.
