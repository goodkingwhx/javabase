package com.gk.lambda.why2;

import com.gk.lambda.why.Student;

/**
 * @author goodking
 * @data 2022-03-16 16:15
 */
public class ScoreFilter implements StudentFilter{
    @Override
    public boolean compare(Student student) {
        return student.getScore()>75;
    }
}
