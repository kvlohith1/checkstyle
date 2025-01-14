package com.google.checkstyle.test.chapter4formatting.rule4854fieldannotations;

import java.util.ArrayList;
import java.util.List;

public class InputFieldAnnotations {
  public @interface SomeAnnotation1 {}

  public @interface SomeAnnotation2 {}

  public @interface SomeAnnotation3 {
    int x();
  }

  /** testing. */
  @SomeAnnotation1
  @SomeAnnotation2
  String name = "Zops";

  /** testing. */
  @SomeAnnotation1 @SomeAnnotation2
  int age = 19;

  /** testing. */
  @SomeAnnotation1
  @SomeAnnotation2 String favLanguage = "Java";

  /** testing. */
  @SomeAnnotation1
  @SomeAnnotation3(x = 90) String favPet = "Dog";

  @SomeAnnotation1 @SomeAnnotation2 boolean test = false;

  @SuppressWarnings("all") @SomeAnnotation3(x = 0) float pi = 3.14f;

  @SomeAnnotation1 @SomeAnnotation3(x = 14)
  /** testing. */ // violation 'Javadoc comment is placed in the wrong location.'
  List<String> list = new ArrayList<>();

  @SuppressWarnings("all")
  @SomeAnnotation1
  /** testing. */ // violation 'Javadoc comment is placed in the wrong location.'
  InputFieldAnnotations obj = new InputFieldAnnotations();

  /** testing. */
  @SomeAnnotation1 @SomeAnnotation2
  // violation above 'Annotation 'SomeAnnotation2' should be alone on line.'
  void test1() {}

  @SomeAnnotation1 @SomeAnnotation2 void test2() {}
  // violation above 'Annotation 'SomeAnnotation2' should be alone on line.'

  @SomeAnnotation3(x = 78) void test3() {}
  // violation above 'Annotation 'SomeAnnotation3' should be alone on line.'
}
