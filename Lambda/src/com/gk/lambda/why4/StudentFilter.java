package com.gk.lambda.why4;

import com.gk.lambda.why.Student;

/**
 * @author goodking
 * @data 2022-03-16 16:21
 */
public interface StudentFilter {
    boolean compare(Student student);
}
