package cz.hexenwerk.sandbox.mdmservice.client.legalentity;

import cz.hexenwerk.sandbox.mdmservice.client.response.ResponseListDto;

public interface LegalEntityService
{

    ResponseListDto<LegalEntityDto> getLegalEntitiesByCriterias(Integer pageId, Integer size, Integer categoryId, String name);

}
