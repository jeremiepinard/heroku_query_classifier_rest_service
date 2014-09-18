package com.radialpoint.utils;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;

import com.radialpoint.queryclassifier.classifier.Classifier;

/**
 * Takes a query in and return if the query is personal or not
 * PersonalQueryClassifier('Ipsum lorem sanctum') => 0.7724062621078144
 *
 * Using a static variable and a synchronized method because mallet is not Thread-Safe. Wrapping the Classifier within a ThreadLocal is not enough to guarantee proper behavior.
 * @author davidl
 */
public abstract class PersonalQueryClassifierUtil {

    private static Classifier classifier = null;
    private static Classifier getClassifier() {
        if (classifier == null) {
            classifier = new Classifier();
            try {
                classifier.initializeWithBuiltInModel();
            } catch (ClassNotFoundException | IOException e) {
                throw new RuntimeException(e);
            }
        }
        return classifier;
    }

    public static synchronized double classify(final String in) {
        if (StringUtils.isBlank(in)) {
            return 0;
        }

        return getClassifier().classify(in);
    }

}
