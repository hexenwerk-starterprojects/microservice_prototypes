package de.scope.mdm.client.legalentity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDateTime;

public class LegalEntityDto
{

    private SimpleStringProperty id = new SimpleStringProperty("");

    private SimpleStringProperty name = new SimpleStringProperty("");

    private SimpleIntegerProperty categoryId = new SimpleIntegerProperty(-1);

    private SimpleStringProperty categoryName = new SimpleStringProperty("");

    // TODO:jako turn into JavaFx simple property
    private LocalDateTime createdDate;

    // TODO:jako turn into JavaFx simple property
    private LocalDateTime modifiedDate;

    public LegalEntityDto()
    {
    }

    public LegalEntityDto(String id, String name, Integer categoryId, String categoryName, LocalDateTime createdDate, LocalDateTime modifiedDate)
    {
        setId(id);
        setName(name);
        setCategoryId(categoryId);
        setCategoryName(categoryName);
        setModifiedDate(modifiedDate);
        setCreatedDate(createdDate);
    }

    public String getId()
    {
        return id.get();
    }

    public void setId(String id)
    {
        this.id.set(id);
    }

    public String getName()
    {
        return name.get();
    }

    public void setName(String name)
    {
        this.name.set(name);
    }

    public int getCategoryId()
    {
        return categoryId.get();
    }

    public void setCategoryId(int categoryId)
    {
        this.categoryId.set(categoryId);
    }

    public String getCategoryName()
    {
        return categoryName.get();
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName.set(categoryName);
    }

    public LocalDateTime getCreatedDate()
    {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate)
    {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate()
    {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate)
    {
        this.modifiedDate = modifiedDate;
    }
}
