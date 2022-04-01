package com.gk.lambda.why2;

import com.gk.lambda.why.Student;

/**
 * @author goodking
 * @data 2022-03-16 16:15
 */
public class AgeFilter implements StudentFilter{
    @Override
    public boolean compare(Student student) {
        return student.getAge()>14;
    }
}
