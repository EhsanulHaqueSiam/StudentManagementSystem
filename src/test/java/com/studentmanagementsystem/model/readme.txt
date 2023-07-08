Below are the steps to run your JUnit tests in IntelliJ IDEA and Eclipse:

**For IntelliJ IDEA:**

1. Open your project in IntelliJ IDEA.

2. Go to the "Project" view on the left side and navigate to your test class.

3. Right-click on the test class and select "Run 'ClassName'". In this case, replace 'ClassName' with the name of your test class.

   Alternatively, you can also open the test class in the editor and right-click anywhere inside the class. Then, select "Run 'ClassName'" from the context menu.

**For Eclipse:**

1. Open your project in Eclipse.

2. Go to the "Package Explorer" view on the left side and navigate to your test class.

3. Right-click on the test class and select "Run As -> JUnit Test".

In both cases, the IDE will run your JUnit tests and display the results in a new tab. For each test, you'll be able to see whether it passed or failed, along with any error messages for failed tests.

Note: Make sure you have added the JUnit library to your project's classpath. If not, your IDE will not recognize the `@Test`, `@Before`, and other JUnit annotations, and you won't be able to run the tests. For JUnit 4, you can download the library from the [JUnit 4 GitHub repository](https://github.com/junit-team/junit4/wiki/Download-and-Install). For JUnit 5 (also known as Jupiter), you can download the library from the [JUnit 5 page](https://junit.org/junit5/).