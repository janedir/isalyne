package unicamp.buscame.configuration.prov;

import unicamp.buscame.util.representation.CompanyOperationHourList;

public interface IConfigurationManager {

    CompanyOperationHourList getOperationHourList(String companyId);

}