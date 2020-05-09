package de.scope.mdm.client.legalentity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LegalEntityMapper {

  @Mapping(target = "id", source = "entity.id")
  @Mapping(target = "name", source = "entity.name")
  @Mapping(target = "categoryId", source = "entity.categoryId")
  @Mapping(target = "categoryName", source = "entity.categoryName")
  @Mapping(target = "createdDate", source = "entity.createdDate")
  @Mapping(target = "modifiedDate", source = "entity.modifiedDate")
  LegalEntityDto entityToDto(LegalEntityEntity entity);

  @Mapping(target = "id", source = "dto.id")
  @Mapping(target = "name", source = "dto.name")
  @Mapping(target = "categoryId", source = "dto.categoryId")
  @Mapping(target = "categoryName", source = "dto.categoryName")
  @Mapping(target = "createdDate", source = "dto.createdDate")
  @Mapping(target = "modifiedDate", source = "dto.modifiedDate")
  LegalEntityEntity dtoToEntity(LegalEntityDto dto);
}

