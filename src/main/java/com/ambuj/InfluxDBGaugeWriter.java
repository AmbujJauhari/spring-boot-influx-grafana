package com.ambuj;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.boot.actuate.metrics.writer.GaugeWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Aj on 25-04-2017.
 */
public class InfluxDBGaugeWriter implements GaugeWriter {

    private static final int THRESHOLD_LIMIT = 50;
    InfluxDB influxDB;
    String dbName;
    BatchPoints batchPoints;

    public InfluxDBGaugeWriter() {
        influxDB = InfluxDBFactory.connect("http://localhost:8086", "root", "root");
        dbName = "SampleAppMetric";
        batchPoints = BatchPoints
                .database(dbName)
                .tag("componentName", "SampleApp")
                //.tag("async", "true")
                .retentionPolicy("autogen")
                .consistency(InfluxDB.ConsistencyLevel.ALL)
                .build();
    }

    @Override
    public void set(Metric<?> metric) {
        Point point = Point.measurement(MetricNameMapping.valueOf(metric.getName())).time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .addField("metricvalue", metric.getValue()).build();


        batchPoints.point(point);

        if (batchPoints.getPoints().size() > THRESHOLD_LIMIT) {
            influxDB.write(batchPoints);
            batchPoints.getPoints().clear();
        }
    }
}
