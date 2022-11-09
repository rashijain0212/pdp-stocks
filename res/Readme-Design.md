# PDP Stocks- Design

## Introduction

This Stocks project in Java is using MVC approach.

* Model: It is an object to carry the data that can also contain the logic to update controller if
  data is changed.
* View: It is used to visualize the data that the model contains.
* Controller: It works on both the model and view. It is used to manage the flow of application,
  i.e. data flow in the model object and to update the view whenever data is changed.

## Authors

Aniruth Ramesh

Rashi Jain

## About Readme

This Readme comprise the design strategy used in the project.

## Design

We have a Model Interface, and we have a class which implements the Interface.

```
public interface Model {}
public ModelImpl implements Model{}
```

We have a Controller Interface and a class implementing the interface.

```
public interface Controller {}
public controllerImpl implements Controller{}
```

Even though its text-based interface, instead of having all the text in controller itself, we have a
separate class,

```
public class View {}
```

The model uses a helper class Which has two methods as defined below,

```
public class Json {
    List<String> jsonFormatFromHashMap() {}
    HashMap<String, List<List<String>>> jsonParser(String json) {}
}
```

This class is a custom Json Parser class used by the model to convert a string in Json Format to
HashMap of String and List of List of String(Our representation of Portfolios ) and vice versa.