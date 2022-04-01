package com.gk.lambda.why2;

import com.gk.lambda.why.Student;

/**
 * @author goodking
 * @data 2022-03-16 16:14
 */
public interface StudentFilter {
    boolean compare(Student student);
}
