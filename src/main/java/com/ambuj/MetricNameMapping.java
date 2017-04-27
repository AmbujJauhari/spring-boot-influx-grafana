package com.ambuj;

/**
 * Created by Aj on 28-04-2017.
 */
public class MetricNameMapping {

    public static String valueOf(String metricName) {
        String newMetricName = metricName;
        if(metricName.contains(".")) {
            newMetricName = metricName.replace(".","");
        }

        return newMetricName;
    }

}
