// Листинг 14.10
// Извлечено из главы 14

package com.objectmentor.utilities.getopts;

import java.text.ParseException;
import java.util.*;

public class Args {
private String schema;
private String[] args;
private boolean valid = true;
private Set<Character> unexpectedArguments = new TreeSet<Character>();
private Map<Character, Boolean> booleanArgs =
new HashMap<Character, Boolean>();
private Map<Character, String> stringArgs =