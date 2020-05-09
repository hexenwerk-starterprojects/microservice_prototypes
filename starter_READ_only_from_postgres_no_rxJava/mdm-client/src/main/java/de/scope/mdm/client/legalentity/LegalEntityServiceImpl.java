package de.scope.mdm.client.legalentity;

import de.scope.mdm.client.response.ResponseListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LegalEntityServiceImpl implements LegalEntityService
{

    private final LegalEntityRepository repository;

    private final LegalEntityMapper mapper;

    static Example<LegalEntityEntity> buildQueryExample(Integer categoryId, String name)
    {
        LegalEntityEntity entity = new LegalEntityEntity();
        entity.setCategoryId(categoryId);
        entity.setName(name);

        ExampleMatcher matcher = ExampleMatcher.matchingAll().
                withMatcher("name", ExampleMatcher.GenericPropertyMatcher.of(StringMatcher.STARTING).ignoreCase())
                .withMatcher("categoryId", ExampleMatcher.GenericPropertyMatcher.of(StringMatcher.EXACT))
                .withIgnoreNullValues();
        return Example.of(entity, matcher);

    }

    @Override
    public ResponseListDto<LegalEntityDto> getLegalEntitiesByCriterias(Integer pageId, Integer size, Integer categoryId, String name)
    {
        Example<LegalEntityEntity> legalEntityEntityExample = buildQueryExample(categoryId, name);
        Pageable pageable = PageRequest.of(pageId, size, Sort.by("name").ascending());
        Page<LegalEntityEntity> legalEntityEntityPage = repository.findAll(legalEntityEntityExample, pageable);
        long totalElements = legalEntityEntityPage.getTotalElements();
        List<LegalEntityDto> legalEntityDtos = legalEntityEntityPage.stream().map(mapper::entityToDto).collect(Collectors.toList());
        return new ResponseListDto<>(totalElements, legalEntityDtos);
    }
}

