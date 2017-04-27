package com.ambuj;

import org.springframework.boot.actuate.autoconfigure.ExportMetricWriter;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.boot.actuate.metrics.writer.Delta;
import org.springframework.boot.actuate.metrics.writer.GaugeWriter;
import org.springframework.boot.actuate.metrics.writer.MetricWriter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by Aj on 05-04-2017.
 */
public class FileGaugeWriter implements GaugeWriter {

    public void set(Metric<?> metric) {
        System.out.println("writing to file " + metric.toString());
    }
}
