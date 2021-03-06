package eShop.zCosmapek_Configurations;

import cosmapek.interfaces.IExecution;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaC
 * Component: Conn_sensors_VisaCSensor
 *
 * Manages the Conn_sensors_VisaCSensor configuration.
 */
public class Conn_sensors_VisaCSensor implements IExecution,IInterfaceTags {
    private cosmapek.sensors.prov.IManager sens;
    private cosmapek.sensors.prov.ISensorUpdater sensISens;

    private conn_sensors_VisaCSensor.prov.IManager i_conn_sensors_VisaCSensor;
    private visaCSensor.prov.IManager i_visaCSensor;
    @Override
    public synchronized void execute() {
        sens = cosmapek.sensors.impl.ComponentFactory.createInstance();
        sensISens = (cosmapek.sensors.prov.ISensorUpdater) sens.getProvidedInterface(ISensorUpdaterTag);

        i_conn_sensors_VisaCSensor=conn_sensors_VisaCSensor.impl.ComponentFactory.createInstance();
        i_conn_sensors_VisaCSensor.setRequiredInterface(ISensorUpdaterTag, sensISens);

        i_visaCSensor = visaCSensor.impl.ComponentFactory.createInstance();
        i_visaCSensor.setRequiredInterface(ISensorUpdaterTag,
                i_conn_sensors_VisaCSensor.getProvidedInterface(ISensorUpdaterTag));
    }
}