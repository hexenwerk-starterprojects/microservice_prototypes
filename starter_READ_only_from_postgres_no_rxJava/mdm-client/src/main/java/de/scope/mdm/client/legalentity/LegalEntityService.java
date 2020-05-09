package de.scope.mdm.client.legalentity;

import de.scope.mdm.client.response.ResponseListDto;

public interface LegalEntityService
{

    ResponseListDto<LegalEntityDto> getLegalEntitiesByCriterias(Integer pageId, Integer size, Integer categoryId, String name);

}
