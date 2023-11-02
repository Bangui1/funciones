package edu.austral.ingsis.math.composite;

import java.util.List;

public interface Function {

    double resolution();
    String print();

    List<String> listVariables();
}
