# Alphanumeric comparator

## General

It is implementation of `Comparator<String>` Java interface 
that allows the alphanumeric sort.

Alphanumeric sort is a way of sorting data or information based on alphanumeric characters, which includes both letters and numbers. 
In this sorting method, the characters are ordered based on not only the integer character values but also number values (for decimal characters).

Default comparator in Java sorts strings based on character values only.
Here, the numbers in string are compared as numbers. 

**Here numbers in string are numbers not characters...**

Example:

Let us consider a list: `[test3, test2, test4, test10, test1]`

Default sort returns: `[test1, test10, test2, test20, test3]`

Sort with alphanumeric comparator returns: `[test1, test2, test3, test10, test20]`


## Usage

Example usage:
```java
List<String> list = List.of("test10", "test1", "test2");
list.sort(new AlphanumericComparator());
```

## Installation

The compiled libraries are deployed to Maven Central.

Using maven:

```xml
<dependency>
    <groupId>io.github.kamilszewc</groupId>
    <artifactId>alphanumeric-comparator</artifactId>
    <version>1.3</version>
</dependency>
```

Using gradle:

```groovy
implementation 'io.github.kamilszewc:alphanumeric-comparator:1.3'
```
