package org.study.cluster.stats;

import java.io.Serializable;

public interface StatsMessages {

    class StatsJob implements Serializable {
        private final String text;

        public StatsJob(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    class StatsResult implements Serializable {
        private final double meanWordLength;

        public StatsResult(double meanWordLength) {
            this.meanWordLength = meanWordLength;
        }

        public double getMeanWordLength() {
            return meanWordLength;
        }

        @Override
        public String toString() {
            return "meanWordLength: " + meanWordLength;
        }
    }

    class JobFailed implements Serializable {
        private final String reason;

        public JobFailed(String reason) {
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }

        @Override
        public String toString() {
            return "JobFailed(" + reason + ")";
        }
    }
}
