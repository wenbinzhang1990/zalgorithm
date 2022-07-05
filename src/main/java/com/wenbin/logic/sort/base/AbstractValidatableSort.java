package com.wenbin.logic.sort.base;

/**
 * Abstract validated sort
 */
public abstract class AbstractValidatableSort implements Sortable {

  public abstract void sort(int[] nums);

  /**
   * Validate
   */
  public void validate() {
    SortValidator sortValidator = new SortValidator();
    for (int[] num : sortValidator.CASE_SET) {
      sort(num);
      sortValidator.validate(num);
    }
  }
}
