package org.studies.dsalgo.others;

import java.util.ArrayList;
import java.util.List;

public class BOMValidation {

    public static boolean isBomSorted(List<String> inputList) {
        int startCount = 1;
        int subCount = 1;
        boolean isValid = false;
        String previousInput = null;
        String previousSubInput = null;
        List<String> previousInputsList = new ArrayList<>();

        for (String input : inputList) {
            input = input.trim();
            isValid = true;
            if (previousInput == null) {
                if (input.equals(Integer.toString(startCount))) {
                    startCount++;
                    previousInput = input;
                } else {
                    isValid = false;
                }
                continue;
            }

            int lastIndexOfHyphen = previousInput.lastIndexOf("-");
            boolean previousInputEndsWithSuffix = previousInput.endsWith("C");
            boolean inputEndsWithSuffix = input.endsWith("C");

            if (input.startsWith(previousInput)
                    || (previousInputEndsWithSuffix
                    && input.startsWith(previousInput.substring(0, previousInput.length() - 1)))
            ) {
                boolean validateNextLevel = false;
                if (input.equals(previousInput)) {
                    validateNextLevel = true;
                } else if (input.equals(previousSubInput)) {
                    validateNextLevel = true;
                } else if (input.startsWith(previousSubInput + "-")) {
                    subCount = 1;
                }
                if (!validateNextLevel) {
                    if (previousInputEndsWithSuffix) {
                        String previousInputWithSuffix = previousInput.substring(0, previousInput.length() - 1);
                        if (input.equals(previousInputWithSuffix + "-" + subCount)
                                || input.equals(previousInputWithSuffix + "-" + subCount + "C")) {
                            previousSubInput = previousInputWithSuffix + "-" + subCount + "C";
                        }
                    } else if (input.equals(previousInput + "-" + subCount)
                            || input.equals(previousInput + "-" + subCount + "C")) {
                        previousSubInput = previousInput + "-" + subCount;
                        subCount++;
                    } else {
                        isValid = false;
                    }
                }
            } else {
                int previousInputSublistIndex = 0;
                if (lastIndexOfHyphen >= 0) {
                    if (previousInputEndsWithSuffix) {
                        String lastLevelString = previousInput.substring(lastIndexOfHyphen + 1, previousInput.length() - 1);
                        previousInputSublistIndex = lastLevelString.length() + 2;
                    } else {
                        String lastLevelString = previousInput.substring(lastIndexOfHyphen + 1);
                        previousInputSublistIndex = lastLevelString.length() + 1;
                    }
                }

                if (input.equals(previousInput.substring(0, previousInput.length() - previousInputSublistIndex) + "-" + subCount)
                        || input.equals(previousInput.substring(0, previousInput.length() - previousInputSublistIndex) + "-" + subCount + "C")) {
                    previousSubInput = previousInput.substring(0, previousInput.length() - previousInputSublistIndex) + "-" + subCount;
                    subCount++;
                } else {
                    if (input.equals(Integer.toString(startCount))
                            || input.equals(startCount + "C")) {
                        startCount++;
                    } else if (previousInputsList.contains(input)) {
                        int index = previousInputsList.indexOf(input);
                        previousInputsList = previousInputsList.subList(0, index);
                    } else {
                        int inputLastIndexOfHyphen = input.lastIndexOf("-");
                        String previousInputLastSubLevelString = "";
                        if (inputLastIndexOfHyphen >= 0) {
                            int inputLastSubLevel = 0;
                            String lastLevelString = null;
                            if (inputEndsWithSuffix) {
                                lastLevelString = input.substring(inputLastIndexOfHyphen + 1, input.length() - 1);
                            } else {
                                lastLevelString = input.substring(inputLastIndexOfHyphen + 1);
                            }
                            inputLastSubLevel = Integer.parseInt(lastLevelString) - 1;
                            previousInputLastSubLevelString = input.substring(0, inputLastIndexOfHyphen + 1) + inputLastSubLevel;

                            if (previousInputsList.contains(previousInputLastSubLevelString)) {
                                int index = previousInputsList.indexOf(previousInputLastSubLevelString);
                                previousInputsList = previousInputsList.subList(0, index);
                            } else if (previousInputsList.contains(previousInputLastSubLevelString + "C")) {
                                int index = previousInputsList.indexOf(previousInputLastSubLevelString + "C");
                                previousInputsList = previousInputsList.subList(0, index);
                            } else {
                                isValid = false;
                            }
                        } else {
                            isValid = false;
                        }
                    }
                    subCount = 1;
                }
            }
            if (inputEndsWithSuffix) {
                previousSubInput = previousSubInput + "C";
            }
            previousInput = input;
            previousInputsList.add(input);
            if (!isValid) {
                break;
            }
        }
        return isValid;
    }

}
