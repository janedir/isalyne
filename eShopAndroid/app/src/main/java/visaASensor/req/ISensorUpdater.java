package visaASensor.req;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaA
 * Component: VisaASensor
 *
 *
 * This interface is a part of the VisaASensor sensor. This is used by Cosmapek Monitor componentName
 * to monitors the component 'VisaASensor'. 
 */
public interface ISensorUpdater {
    boolean activateSensor(String name);

    boolean deactivateSensor(String name);
}