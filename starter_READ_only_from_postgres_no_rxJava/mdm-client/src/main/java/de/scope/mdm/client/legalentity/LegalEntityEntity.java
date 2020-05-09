package de.scope.mdm.client.legalentity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "legal_entity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LegalEntityEntity // todo:jako   extends AbstractAuditable<User, String>
{
    @Id
    private String id;

    private String name;

    private Integer categoryId;

    private String categoryName;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

}
