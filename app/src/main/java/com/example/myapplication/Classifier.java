package com.example.myapplication;

/**
 * Created by D067472 on 14.12.2017.
 */

import android.graphics.Bitmap;
import android.graphics.RectF;
import java.util.List;
import java.util.Locale;

/**
 * Generic interface for interacting with different recognition engines.
 */
public interface Classifier {
    /**
     * An immutable result returned by a Classifier describing what was recognized.
     */
    public class Recognition {

        /**
         * Display name for the recognition.
         */
        private final String title;

        /**
         * A sortable score for how good the recognition is relative to others. Higher should be better.
         */
        private final Float confidence;

        public Recognition(final String title, final Float confidence) {
            this.title = title;
            this.confidence = confidence;
        }


        public String getTitle() {
            return title;
        }

        public Float getConfidence() {
            return confidence;
        }


        @Override
        public String toString() {
            String resultString = "";

            if (title != null) {
                resultString += title + " ";
            }

            if (confidence != null) {
                resultString += String.format(Locale.UK,"(%.1f%%) ", confidence * 100.0f);
            }

            return resultString.trim();
        }
    }

    List<Recognition> recognizeImage(Bitmap bitmap);

    void enableStatLogging(final boolean debug);

    String getStatString();

    void close();
}
