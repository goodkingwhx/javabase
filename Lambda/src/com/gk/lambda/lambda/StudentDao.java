package com.gk.lambda.lambda;

import com.gk.lambda.why.Student;

/**
 * @author goodking
 * @data 2022-03-16 17:03
 */
@FunctionalInterface
public interface StudentDao {
    void insert(Student student);
}
