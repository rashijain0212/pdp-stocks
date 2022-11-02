# PDP Stocks- Design

This is a design Readme for the stock project.

## Basic Design Structure

The project is using the MVC approach.

1. Model - Contains all the data-related logic that the user requires.

2. Controller - It controls the data flow into model object and updates the view whenever data
   changes. It keeps view and model separate.

3. View - The view renders the contents of a model. It specifies exactly how the model data should
   be presented.

## Contents of the Project

* src
  * portfolios
  * stockData
  * userInput
  * Controller.java
  * ControllerImpl.java
  * Json.java
  * Main.java
  * Model.java
  * ModelImpl.java
  * View.java
* test
  * ControllerImplTest.java
  * MockModelForAddPortfolioData.java
  * ModelImplTest.java
  * ViewTest.java

## Representation

Created interface for the model

```java
public interface Model {
}
```

Created interface for the controller

```java
public interface Controller {
}
```

Have a class for View

```java
public class View {
}  
```
