package cosmapek.variability.core;

import cosmapek.variability.core.fm2.IFeatureModel;
import cosmapek.variability.core.fm2.IFeatureModelAnalyzer;
import cosmapek.variability.core.fm2.io.IFeatureModelReader;
import cosmapek.variability.core.fm2.io.xml.XmlFeatureModelReader;

import cosmapek.variability.prov.IManager;
import cosmapek.variability.req.IComponentManager;
import cosmapek.variability.req.IConnectorManager;
import cosmapek.variability.req.IFeatureManager;
import cosmapek.variability.req.ISensorManager;

import java.io.File;
import java.net.URI;
import java.util.LinkedList;

/**
 * @author Junior Cupe Casquina
 */
public class Variability {
    private IManager manager = null;

    private String variabilityPath = "";
    private IFeatureModelReader fmReader;//important
    private IFeatureModel fm;
    private IFeatureModelAnalyzer analyzerFm;//important

    private IComponentManager compM;
    private IConnectorManager connectM;
    private IFeatureManager featureM;
    private ISensorManager sensorM;

    public Variability(IManager manager) {
        this.manager = manager;
    }

    private void getManagers() {
        compM = (IComponentManager) manager.getRequiredInterface("IComponentManager");
        connectM = (IConnectorManager) manager.getRequiredInterface("IConnectorManager");
        featureM = (IFeatureManager) manager.getRequiredInterface("IFeatureManager");
        sensorM = (ISensorManager) manager.getRequiredInterface("ISensorManager");
    }

    public synchronized void setVariabilityPath(String variabilityPath) {
        getManagers();
        this.variabilityPath = variabilityPath;
        this.fmReader = new XmlFeatureModelReader(manager);
    }

    public synchronized void read() {
        getManagers();
        //File input = new File(URI.create(getVariabilityPath()));
        File input = new File(getVariabilityPath());
        fmReader.readFromFile(input);
        fm = fmReader.getFeatureModel();
        analyzerFm = fm.getAnalyser();
    }

    public synchronized LinkedList<String> getASolutionWithout(LinkedList<String> failedFeatures) {
        getManagers();
        LinkedList<String> sol = analyzerFm.getASolutionWithout(failedFeatures);
        updateRuntimeRegistry(sol);
        return sol;
    }

    private void updateRuntimeRegistry(LinkedList<String> sol) {

        compM.updateRuntimeRegistry(sol);
        connectM.updateRuntimeRegistry(sol);
        featureM.updateRuntimeRegistry(sol);
        sensorM.updateRuntimeRegistry(sol);//just need this

    }

    private String getVariabilityPath() {
        return variabilityPath;
    }
}
